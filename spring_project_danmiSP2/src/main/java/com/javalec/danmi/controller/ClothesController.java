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
import com.javalec.danmi.dto.Clothes_Dto;


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

		return "/ClothesReserveMain";
	}

	@RequestMapping("/ClothesOptionSelect")
	public String carOptionSelect(HttpServletRequest request, Model model) {
		ClothesIDao dao = sqlSession.getMapper(ClothesIDao.class);

		String code = request.getParameter("ccode");
		Clothes_Dto dto = dao.selectNo(code);

		model.addAttribute("dto", dto);

		return "/ClothesOptionSelect";
	}

}
