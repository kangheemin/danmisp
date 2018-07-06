package com.jjh.spring.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jjh.spring.common.PageManager;
import com.jjh.spring.dao.JSPMemberIDao;
import com.jjh.spring.dto.JSPMember;

/**
 * Servlet implementation class BoardFrontController
 */

@Controller
public class MemberContorller {

	private static final Logger logger = LoggerFactory.getLogger(MemberContorller.class);

	@Autowired
	private SqlSession sqlSession;

	@RequestMapping("/MemberList")
	public String memberList(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		// 멤버 폴더 위치
		String joinroot = (String) session.getAttribute("joinroot");

		JSPMemberIDao dao = sqlSession.getMapper(JSPMemberIDao.class);
		// 로그인이 되어 있는 id를 가져온다. 로그인이 되어 있지 않다면 id는 GUEST
		String id = (String) session.getAttribute("id");
		if (id == null) {
			id = "GUEST";
		}
		// 화면에 보여질 게시글의 개수를 지정(임의로 설정)
		int perPage = 5; // 화면에 보여질 글 갯수
		int perBlock = 5; // 화면 하단에 보여질 페이지 블럭의 페이지 갯수

		int rowCount = 0;
		rowCount = dao.selectAll().size(); // 전체 데이터의 갯수를 저장하는 변수
		// 현재 보고자 하는 페이지를 지정
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		// 보고자 하는 페이지의 블럭을 지정
		int currentPage = Integer.parseInt(pageNum);
		String blockNum = request.getParameter("blockNum");
		if (blockNum == null) {
			blockNum = "1";
		}
		int currentBlock = Integer.parseInt(blockNum);

		// 페이지 관리 객체를 생성
		PageManager pm = new PageManager(perPage, perBlock);
		// 페이지 관리 객체 환경설정
		pm.setRowCount(rowCount, currentPage, currentBlock);
		// 테이블에 표시할 번호를 지정 - 거꾸로
		int number = pm.number;
		List<JSPMember> list = dao.selectAll().subList(pm.startRow - 1, pm.endRow);

		// 수정, 댓글, 삭제 후 현재 위치로 돌아오게 하기 위해 현 위치값을 세션에 저장
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("currentBlock", currentBlock);
		model.addAttribute("list", list);
		model.addAttribute("number", number);
		model.addAttribute("id", id);
		model.addAttribute("pageCount", pm.pageCount);
		model.addAttribute("pagenation", pm.getPagenation("MemberList"));

		return joinroot + "MemberList";
	}

	@RequestMapping("/MemberJoin")
	public String memberJoin(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		// 멤버 폴더 위치
		String joinroot = (String) session.getAttribute("joinroot");
		JSPMemberIDao dao = sqlSession.getMapper(JSPMemberIDao.class);

		return joinroot + "MemberJoin";
	}

	@RequestMapping("/JoinProc")
	public String joinProc(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		// 멤버 폴더 위치
		String joinroot = (String) session.getAttribute("joinroot");
		JSPMemberIDao dao = sqlSession.getMapper(JSPMemberIDao.class);

		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String age = request.getParameter("age");
		String job = request.getParameter("job");
		String[] hobbys = request.getParameterValues("hobby");

		// 페이지를 어느쪽으로 갈지 정하기 위한 변수지정
		int res = 0;
		if(hobbys == null) {
			model.addAttribute("res", res);
			return joinroot + "JoinProc"; 
		}
		
		String hobby = "";
		for (String x : hobbys) {
			hobby += x + " ";
		}
		hobby = hobby.trim();

		// 리퀘스트 객체가 널값이 아니라면 res = 1, 널값이 있다면 res = 0
		if ((id != null && !id.equals("")) && (pass != null && !pass.equals("")) && (email != null && !email.equals(""))
				&& (tel != null && !tel.equals("")) && (age != null && !age.equals(""))
				&& (job != null && !job.equals("")) && (hobby != null && !hobby.equals(""))) {
			dao.insert(id, pass, email, tel, age, job, hobby);
			res = 1;
		}
		model.addAttribute("res", res);
		System.out.println(id + pass + email + tel + age + job + hobby);

		return joinroot + "JoinProc";
	}

	@RequestMapping("/MemberInfo")
	public String memberInfo(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		// 멤버 폴더 위치
		String joinroot = (String) session.getAttribute("joinroot");
		JSPMemberIDao dao = sqlSession.getMapper(JSPMemberIDao.class);

		// 멤버 정보 가져오기
		String id = request.getParameter("id");
		JSPMember dto = dao.select(id);

		model.addAttribute("dto", dto);

		return joinroot + "MemberInfo";
	}

	@RequestMapping("/MemberUpdateForm")
	public String memberUpdateForm(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		// 멤버 폴더 위치
		String joinroot = (String) session.getAttribute("joinroot");
		JSPMemberIDao dao = sqlSession.getMapper(JSPMemberIDao.class);

		// 멤버 정보 가져오기
		String id = request.getParameter("id");
		JSPMember dto = dao.select(id);

		model.addAttribute("dto", dto);

		return joinroot + "MemberUpdateForm";
	}

	@RequestMapping("/MemberUpdateProc")
	public String memberUpdateProc(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		// 멤버 폴더 위치
		String joinroot = (String) session.getAttribute("joinroot");
		JSPMemberIDao dao = sqlSession.getMapper(JSPMemberIDao.class);

		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String job = request.getParameter("job");
		String hobby = request.getParameter("hobby");
		String pass = request.getParameter("pass");
		String passOrigin = dao.select(id).getPass();

		// 페이지를 어느쪽으로 갈지 정하기 위한 변수지정
		int res = 0;
		// 입력한 패스워드와 패스워드 데이터가 다르다면 res = 1
		// 패스워드가 동일하고 리퀘스트 객체가 널값이 아니라면 업데이트하고 res = 2
		// 널값이 있다면 res = 0
		if (!pass.equals(passOrigin)) {
			res = 1;
		} else if ((email != null && !email.equals("")) && (tel != null && !tel.equals(""))
				&& (job != null && !job.equals("")) && (hobby != null && !hobby.equals(""))) {
			dao.update(email, tel, job, hobby, id);
			res = 2;
		}

		model.addAttribute("res", res);

		return joinroot + "MemberUpdateProc";
	}

	@RequestMapping("/MemberDeleteForm")
	public String memberDeleteForm(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		// 멤버 폴더 위치
		String joinroot = (String) session.getAttribute("joinroot");
		JSPMemberIDao dao = sqlSession.getMapper(JSPMemberIDao.class);

		// 멤버 정보 가져오기
		String id = request.getParameter("id");
		JSPMember dto = dao.select(id);

		model.addAttribute("dto", dto);

		return joinroot + "MemberDeleteForm";
	}

	@RequestMapping("/MemberDeleteProc")
	public String memberDeleteProc(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		// 멤버 폴더 위치
		String joinroot = (String) session.getAttribute("joinroot");
		JSPMemberIDao dao = sqlSession.getMapper(JSPMemberIDao.class);

		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String passOrigin = dao.select(id).getPass();

		// 페이지를 어느쪽으로 갈지 정하기 위한 변수지정
		int res = 0;
		// 입력한 패스워드와 패스워드 데이터가 다르다면 res = 1
		// 패스워드가 동일하고 리퀘스트 객체가 널값이 아니라면 업데이트하고 res = 2
		// 널값이 있다면 res = 0
		if (!pass.equals(passOrigin)) {
			res = 0;
		} else {
			dao.delete(id);
			res = 1;
		}

		model.addAttribute("res", res);

		return joinroot + "MemberDeleteProc";
	}
	
	@RequestMapping("/LoginProc")
	public String LoginProc(HttpServletRequest request, Model model) {
		JSPMemberIDao dao = sqlSession.getMapper(JSPMemberIDao.class);
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		// 로그인 정보가 저장되어 있는 데이터 정보와 일치 하는지 확인
		int res = dao.login(id, pass);
		
		model.addAttribute("res", res);
		model.addAttribute("id", id);
		
		return "LoginProc";
	}

	@RequestMapping("/Logout")
	public String logout(HttpServletRequest request, Model model) {
				
		return "Logout";
	}
}
