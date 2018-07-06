package com.jjh.spring.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
import com.jjh.spring.dao.JSPBoardIDao;
import com.jjh.spring.dto.JSPBoard;

/**
 * Servlet implementation class BoardFrontController
 */

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private SqlSession sqlSession;

	@RequestMapping("/BoardList")
	public String boardList(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		// 게시판 폴더 위치
		String root = (String) session.getAttribute("root");

		int perPage = 10;
		int perBlock = 10;

		JSPBoardIDao dao = sqlSession.getMapper(JSPBoardIDao.class);
		int allCount = dao.selectAll().size();
		// List<JSPBoard> list = dao.selectAll();
		int rowCount = allCount;
		String pageNum = request.getParameter("pageNum");

		if (pageNum == null) {
			pageNum = "1";
		}

		int currentPage = Integer.parseInt(pageNum);
		String blockNum = request.getParameter("blockNum");
		if (blockNum == null) {
			blockNum = "1";
		}

		int currentBlock = Integer.parseInt(blockNum);
		// 페이지 관리 객체를 생성 - new PageManager((1), (2))
		PageManager pm = new PageManager(perPage, perBlock);
		// 페이지 관리 객체 환경설정 - pm.setRowCount((3),(4),(5))
		pm.setRowCount(rowCount, currentPage, currentBlock);
		// 테이블에 표시할 번호를 지정 - 거꾸로 줄력해 나갈것임.
		int number = pm.number;

		List<JSPBoard> list = dao.selectAll().subList(pm.startRow - 1, pm.endRow);

		model.addAttribute("list", list);
		model.addAttribute("number", number);
		// 수정, 댓글, 삭제 후 현재 위치로 돌아오게 하기 위해 현 위치값을 세션에 저장
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("currentBlock", currentBlock);
		model.addAttribute("pageCount", pm.pageCount);
		model.addAttribute("pagenation", pm.getPagenation("BoardList"));

		return root + "BoardList";
	}

	@RequestMapping("/BoardWriteForm")
	public String boardWriteForm(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		// 게시판 폴더 위치
		String root = (String) session.getAttribute("root");

		return root + "BoardWriteForm";
	}

	@RequestMapping("/BoardWriteProc")
	public String boardWriteProc(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		// 게시판 폴더 위치
		String root = (String) session.getAttribute("root");
		JSPBoardIDao dao = sqlSession.getMapper(JSPBoardIDao.class);

		// insert를 위한 정보 받아오기
		JSPBoard dto = new JSPBoard();
		String writer = request.getParameter("writer");
		String subject = request.getParameter("subject");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String content = request.getParameter("content");

		int res = 0;

		// 빈 공란인지 아닌지 확인.
		// 빈공란이 아니라면 insert
		if ((writer != null && !writer.equals("")) && (subject != null && !subject.equals(""))
				&& (content != null && !content.equals("")) && (password != null && !password.equals(""))) {
			dao.insert(writer, email, subject, password, content);
			res = 1;

		}
		model.addAttribute("res", res);

		return root + "BoardWriteProc";
	}

	@RequestMapping("/BoardInfo")
	public String boardInfo(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		// 게시판 폴더 위치
		String root = (String) session.getAttribute("root");
		JSPBoardIDao dao = sqlSession.getMapper(JSPBoardIDao.class);

		// 자료정보를 가져오기 위한 값
		int num = Integer.parseInt(request.getParameter("num"));
		int no = Integer.parseInt(request.getParameter("no"));
		int backPage = Integer.parseInt(session.getAttribute("currentPage") + "");
		int backBlock = Integer.parseInt(session.getAttribute("currentBlock") + "");

		// 조회수 올려주기
		dao.upHit(num);
		// 정보 가져오기
		JSPBoard dto = dao.select(num);

		model.addAttribute("contentView", dto);
		model.addAttribute("no", no);
		model.addAttribute("backPage", backPage);
		model.addAttribute("backBlock", backBlock);

		return root + "BoardInfo";
	}

	@RequestMapping("/BoardReWriteForm")
	public String boardReWriteForm(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		// 게시판 폴더 위치
		String root = (String) session.getAttribute("root");
		JSPBoardIDao dao = sqlSession.getMapper(JSPBoardIDao.class);

		int num = Integer.parseInt(request.getParameter("num"));
		// 정보가져오기
		JSPBoard dto = dao.select(num);

		model.addAttribute("dto", dto);

		return root + "BoardReWriteForm";
	}

	@RequestMapping("/BoardReWriteProc")
	public String boardReWriteProc(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		// 게시판 폴더 위치
		String root = (String) session.getAttribute("root");
		JSPBoardIDao dao = sqlSession.getMapper(JSPBoardIDao.class);
		
		// 댓글 작성 정보 가져오기
		String writer = request.getParameter("writer");
		String subject = request.getParameter("subject");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		int ref = Integer.parseInt(request.getParameter("ref"));
		int re_step = Integer.parseInt(request.getParameter("re_step"));
		int re_level = Integer.parseInt(request.getParameter("re_level"));

		// 댓글이 보여지는 위치를 지정
		dao.updateLevel(ref, re_level);
		// 댓글 정보 insert
		dao.insert2(writer, email, subject, password, ref, re_step, re_level, content);

		return root + "BoardReWriteProc";
	}

	@RequestMapping("/BoardUpdateForm")
	public String boardUpdateForm(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		// 게시판 폴더 위치
		String root = (String) session.getAttribute("root");
		JSPBoardIDao dao = sqlSession.getMapper(JSPBoardIDao.class);

		int num = Integer.parseInt(request.getParameter("num"));
		// 정보 가져오기
		JSPBoard dto = dao.select(num);

		model.addAttribute("dto", dto);

		return root + "BoardUpdateForm";
	}

	@RequestMapping("/BoardUpdateProc")
	public String boardUpdateProc(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		// 게시판 폴더 위치
		String root = (String) session.getAttribute("root");
		JSPBoardIDao dao = sqlSession.getMapper(JSPBoardIDao.class);

		int num = Integer.parseInt(request.getParameter("num"));
		// 정보가져오기
		JSPBoard dto = dao.select(num);
		String pass = request.getParameter("password");
		String password = dto.getPassword();

		String subject = request.getParameter("subject");
		String content = request.getParameter("content");

		int res = 0;

		// 정보 수정을 위한 비밀번호 확인(입력한 패스워드, 저장되어있는 패스워드)
		if (pass.equals(password)) {
			dao.update(subject, content, num);
			res = 1;
		}
		model.addAttribute("res", res);

		return root + "BoardUpdateProc";
	}

	@RequestMapping("/BoardDeleteForm")
	public String boardDeleteForm(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		// 게시판 폴더 위치
		String root = (String) session.getAttribute("root");
		JSPBoardIDao dao = sqlSession.getMapper(JSPBoardIDao.class);

		int num = Integer.parseInt(request.getParameter("num"));

		model.addAttribute("num", num);

		return root + "BoardDeleteForm";
	}

	@RequestMapping("/BoardDeleteProc")
	public String boardDeleteProc(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String root = (String) session.getAttribute("root");
		JSPBoardIDao dao = sqlSession.getMapper(JSPBoardIDao.class);

		int num = Integer.parseInt(request.getParameter("num"));

		String xpwd = request.getParameter("xpwd");

		JSPBoard dto = dao.select(num);

		int res = 0;
		// 게시글 삭제를 위해 비밀번호 확인 (비밀번호가 다르다면 삭제할수 없다)
		if (dto.getPassword().equals(xpwd)) {
			dao.delete(num);
			res = 1;
		}

		model.addAttribute("res", res);

		return root + "BoardDeleteProc";
	}
}
