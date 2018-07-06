package com.javalec.danmi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.javalec.danmi.dao.ClothesIDao;
import com.javalec.danmi.common.PageManager;
import com.javalec.danmi.common.RentCarParsing;
import com.javalec.danmi.dto.Clothes_Dto;
import com.jjh.spring.dao.RentReserveIDao;
//import com.jjh.spring.dto.RentCar;
import com.jjh.spring.dto.RentReserve;
import com.jjh.spring.dto.ReserveView;

/**
 * Servlet implementation class BoardFrontController
 */

@Controller
public class ClothesController {

	private static final Logger logger = LoggerFactory.getLogger(ClothesController.class);

	@Autowired
	private SqlSession sqlSession;

	@RequestMapping("/Main")
	public String main(HttpServletRequest request, Model model) {

		return "/Main";
	}

	@RequestMapping("/ClothesReserveMain")
	public String carReserveMain(HttpServletRequest request, Model model) {
		ClothesIDao dao = sqlSession.getMapper(ClothesIDao.class);

		int num = dao.selectAll().size();
		// 마지막으로 입력된 데이터 정보 3개 가져오기
		List<Clothes_Dto> list = dao.selectAll().subList(num - 3, num);
		
		model.addAttribute("list", list);

		return "/Main.jsp?center=CarReserveMain";
	}

	@RequestMapping("/BatchForm")
	public String batchForm(HttpServletRequest request, Model model) {

		return "/Main.jsp?center=BatchForm";
	}

	@RequestMapping("/Login")
	public String login(HttpServletRequest request, Model model) {

		return "/Main.jsp?center=Login";
	}

	@RequestMapping("/BatchProc")
	public String batchProc(HttpServletRequest request, Model model) {
		ClothesIDao dao = sqlSession.getMapper(ClothesIDao.class);
		// insert하기 위한 내용 가져오기
		String content = request.getParameter("content");
		// "#"을 기준으로 내용 쪼개기
		String[] contents = content.split("#");
		RentCar car = null;
		for (String x : contents) {
			if (x == null) {
				continue;
			}
			try {
				// 쪼개진 내용을 car객체에 담기
				car = RentCarParsing.parsing(x);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		dao.insert(car.getName(), car.getCategory(), car.getPrice(), car.getUsepeople(), car.getCompany(), car.getImg(),
				car.getInfo());

		return "Main.jsp?center=BatchProc";
	}

	@RequestMapping("/ReserveView")
	public String reserveView(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		ClothesOrdersIDao dao = sqlSession.getMapper(ClothesOrdersIDao.class);

		String memid = (String) session.getAttribute("id");
		// 로그인이 되어 있지 않다면 바로 넘어가라
		if (memid == null || memid.equals("GUEST")) {
			model.addAttribute("memid", memid);

			return "Main.jsp?center=ReserveView";
		}
		// 로그인된 아이디로 예약된 정보 가져오기
		List<OrdersView> list = dao.selectAllView(memid);
		Date d1 = new Date();
		Date d2 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		d2 = sdf.parse(sdf.format(d2));
		String feeString = "";
		int a, b;
		for (OrdersView x : list) {
			feeString = "";
			d1 = sdf.parse(x.getRday());
			x.setRes(d1.compareTo(d2));
			feeString += "차량대여료:" + (a = x.getPrice() * x.getQty() * x.getDday());
			feeString += "/옵션대:"
					+ (b = (x.getInsurance() * 10000 * x.getDday() * x.getQty()) + (x.getWifi() * 10000 * x.getQty())
							+ (x.getNavigation() * 0) + (x.getBabyseat() * 5000 * x.getQty()));
			feeString += "  [ 총계: " + (a + b) + " ]";
			x.setFee(feeString);
		}

		model.addAttribute("memid", memid);
		model.addAttribute("list", list);

		return "Main.jsp?center=ReserveView";
	}

	@RequestMapping("/Adjust")
	public String adjust(HttpServletRequest request, Model model) {
		ClothesOrdersIDao dao = sqlSession.getMapper(ClothesOrdersIDao.class);

		int regno = Integer.parseInt(request.getParameter("regno"));
		String img = request.getParameter("img");
		// 수정할 정보 가져오기
		RentReserve dto = dao.selectRegno(regno);

		model.addAttribute("img", img);
		model.addAttribute("dto", dto);

		return "Main.jsp?center=Adjust";
	}

	@RequestMapping("/AdjustProc")
	public String adjustProc(HttpServletRequest request, Model model) {
		ClothesOrdersIDao dao = sqlSession.getMapper(ClothesOrdersIDao.class);

		String rday = request.getParameter("rday");
		String dday = request.getParameter("dday");
		String qty = request.getParameter("qty");
		String insurance = request.getParameter("insurance");
		String wifi = request.getParameter("wifi");
		String navigation = request.getParameter("navigation");
		String babyseat = request.getParameter("babyseat");
		String memid = request.getParameter("memid");
		String regno = request.getParameter("regno");
		String no = request.getParameter("no");

		dao.update(no, rday, dday, qty, insurance, wifi, navigation, babyseat, memid, regno);

		return "Main.jsp?center=AdjustProc";
	}

	@RequestMapping("/Delete")
	public String delete(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();

		int regno = Integer.parseInt(request.getParameter("regno"));
		session.setAttribute("deleteNum", regno);

		return "Main.jsp?center=Delete";
	}

	@RequestMapping("/DeleteConfirm")
	public String deleteConfirm(HttpServletRequest request, Model model) {
		ClothesOrdersIDao dao = sqlSession.getMapper(ClothesOrdersIDao.class);
		HttpSession session = request.getSession();

		int regno = (int) session.getAttribute("deleteNum");
		dao.delete(regno);

		return "DeleteConfirm";
	}

	@RequestMapping("/CarReserveInfo")
	public String carReserveInfo(HttpServletRequest request, Model model) {
		ClothesIDao dao = sqlSession.getMapper(ClothesIDao.class);
		HttpSession session = request.getSession();

		int no = Integer.parseInt(request.getParameter("no"));
		String fromPage = request.getParameter("fromPage");
		String temp = request.getParameter("category");
		String section = "";
		RentCar dto = dao.selectNo(no);
		int category = dto.getCategory();
		section = (category == 1) ? "소형" : (category == 2) ? "중형" : "대형";

		model.addAttribute("section", section);
		model.addAttribute("dto", dto);

		return "Main.jsp?center=CarReserveInfo";
	}

	@RequestMapping("/CarCategoryList")
	public String carCategoryList(HttpServletRequest request, Model model) {
		ClothesIDao dao = sqlSession.getMapper(ClothesIDao.class);
		HttpSession session = request.getSession();

		// 보고자 하는 자동차가 소형인지 중형인지 대형인지 확인
		int category = Integer.parseInt(request.getParameter("category"));
		List<RentCar> list = dao.selectCategory(category);
		String type = "";
		if (category == 1) {
			type = "소형";
		}
		if (category == 2) {
			type = "중형";
		}
		if (category == 3) {
			type = "대형";
		}
		int perPage = 6; // (1) 화면에 보여질 글 갯수
		int perBlock = 5;
		int rowCount = list.size();
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
		PageManager pm = new PageManager(perPage, perBlock);
		pm.setRowCount(rowCount, currentPage, currentBlock);
		pm.setCategory(category + "");
		list = list.subList(pm.startRow - 1, pm.endRow);

		model.addAttribute("list", list);
		model.addAttribute("type", type);
		model.addAttribute("rowCount", rowCount);
		session.setAttribute("currentPage", currentPage);
		session.setAttribute("currentBlock", currentBlock);
		model.addAttribute("pagenation", pm.getPagenation("CarCategoryList"));

		return "Main.jsp?center=CarCategoryList";
	}

	@RequestMapping("/CarAllList")
	public String carAllList(HttpServletRequest request, Model model) {
		ClothesIDao dao = sqlSession.getMapper(ClothesIDao.class);
		HttpSession session = request.getSession();

		// 자동차 정보 모두 가져오기
		List<RentCar> list = dao.selectAll();
		int perPage = 6; // (1) 화면에 보여질 글 갯수
		int perBlock = 5;
		int rowCount = list.size();
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
		PageManager pm = new PageManager(perPage, perBlock);
		pm.setRowCount(rowCount, currentPage, currentBlock);
		list = list.subList(pm.startRow - 1, pm.endRow);

		session.setAttribute("currentPage", currentPage);
		session.setAttribute("currentBlock", currentBlock);
		model.addAttribute("pageCount", pm.pageCount);
		model.addAttribute("list", list);
		model.addAttribute("pagenation", pm.getPagenation("CarAllList"));

		return "Main.jsp?center=CarAllList";
	}

	@RequestMapping("/CarOptionSelect")
	public String carOptionSelect(HttpServletRequest request, Model model) {
		ClothesIDao dao = sqlSession.getMapper(ClothesIDao.class);

		String code = request.getParameter("ccode");
		int qty = Integer.parseInt(request.getParameter("qty"));
		Clothes_Dto dto = dao.selectNo(code);

		model.addAttribute("dto", dto);
		model.addAttribute("qty", qty);

		return "CarOptionSelect";
	}

	@RequestMapping("/CarReserveResult")
	public String carReserveResult(HttpServletRequest request, Model model) throws ParseException {
		ClothesOrdersIDao dao = sqlSession.getMapper(ClothesOrdersIDao.class);
		ClothesIDao rdao = sqlSession.getMapper(ClothesIDao.class);
		HttpSession session = request.getSession();

		String id = (String) session.getAttribute("id");

		int res = 0;
		// 로그인이 되어 있지 않다면 페이지 바로 넘기기
		if (id == null || id.equals("GUEST")) {
			model.addAttribute("res", res);
			return "Main.jsp?center=CarReserveResult";
		}

		RentReserve rbean = new RentReserve();
		rbean.setDday(Integer.parseInt(request.getParameter("dday")));
		rbean.setRday(request.getParameter("rday"));
		rbean.setInsurance(Integer.parseInt(request.getParameter("insurance")));
		rbean.setWifi(Integer.parseInt(request.getParameter("wifi")));
		rbean.setNavigation(Integer.parseInt(request.getParameter("navigation")));
		rbean.setBabyseat(Integer.parseInt(request.getParameter("babyseat")));
		rbean.setNo(Integer.parseInt(request.getParameter("no")));
		rbean.setQty(Integer.parseInt(request.getParameter("qty")));

		String option = "";
		int optionFee = 0;
		int rentalFee = 0;
		RentCar rentCar = rdao.selectNo(rbean.getNo());
		rentalFee = rbean.getDday() * rentCar.getPrice() * rbean.getQty();
		if (rbean.getInsurance() == 1) {
			option += "보험료:" + (rbean.getDday() * 10000) * rbean.getQty();
			optionFee += rbean.getDday() * 10000 * rbean.getQty();
		} else {
			option += "보험료:" + (0);
		}

		if (rbean.getWifi() == 1) {
			option += " 와이파이:" + (10000 * rbean.getQty());
			optionFee += 10000 * rbean.getQty();
		} else {
			option += " 와이파이:" + (0);
		}

		if (rbean.getNavigation() == 1) {
			option += " 네이게이션:" + "무료";
		} else {
			option += " 네이게이션:" + "미적용";
		}

		if (rbean.getBabyseat() == 1) {
			option += " 베이비시트:" + (5000 * rbean.getQty());
			optionFee += 5000 * rbean.getQty();
		} else {
			option += " 베이비시트:" + "미적용";
		}

		Date d1 = new Date();
		Date d2 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		d1 = sdf.parse(rbean.getRday());
		d2 = sdf.parse(sdf.format(d2));

		res = d1.compareTo(d2);
		model.addAttribute("res", res);
		if (id == null || id.equals("GUEST")) {
			return "Main.jsp?center=CarReserveResult";
		}
		rbean.setMemid(id);
		dao.insert(rbean.getNo(), rbean.getQty(), rbean.getDday(), rbean.getRday(), rbean.getInsurance(),
				rbean.getWifi(), rbean.getNavigation(), rbean.getBabyseat(), rbean.getMemid());
		List<RentReserve> list = dao.selectAll();
		RentReserve dto = list.get(list.size() - 1);
		int regno = dto.getRegno();
		rbean.setRegno(regno);

		model.addAttribute("retalFee", rentalFee);
		model.addAttribute("optionFee", optionFee);
		model.addAttribute("option", option);
		model.addAttribute("rbean", rbean);
		model.addAttribute("rentCar", rentCar);
		model.addAttribute("toString", rbean.toString());
		model.addAttribute("toString2", rentCar.toString());

		return "Main.jsp?center=CarReserveResult";
	}

}
