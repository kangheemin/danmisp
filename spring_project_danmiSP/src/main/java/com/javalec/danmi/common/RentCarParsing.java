package com.javalec.danmi.common;

import com.javalec.danmi.dto.Clothes_Dto;


public class RentCarParsing {
	public static Clothes_Dto parsing(String target) throws Exception{
		//"0/SONATA/3/50000/4/현대/sonata.jpg/참좋은차다"
		String[] tokens = target.split("/");
		Clothes_Dto ct = new Clothes_Dto();
		String errormsg="";
		try {
			ct.setNo(0);
			ct.setName(tokens[0]);
			errormsg="카테고리번호는 1,2,3이어야 한다.";
			ct.setCategory(Integer.parseInt(tokens[1]));
			errormsg="차량대여료 부분 숫자이어야 합니다.";
			ct.setPrice(Integer.parseInt(tokens[2]));
			errormsg="탑승자수 부분 숫자이어야 합니다.";
			ct.setUsepeople(Integer.parseInt(tokens[3]));
			ct.setCompany(tokens[4]);
			ct.setImg(tokens[5]);
			ct.setInfo(tokens[6]);
		} catch (Exception e) {
			System.err.println(errormsg);
			e.printStackTrace();
		}
		return ct;
	}

	public static void main(String[] args) throws Exception {
		String target = "SONATA/3/50000/4/현대/sonata.jpg/참좋은차다";
		Clothes_Dto x = RentCarParsing.parsing(target);
		System.out.println(x);
		// 또다른 방식 공통모듈(common tool) Parsing4Batch의 활용 
		String[] setters = new String[] { 
				"setName", "setCategory", "setPrice", "setUsepeople", "setCompany", "setImg",
				"setInfo" };
		Parsing4Batch parser = new Parsing4Batch(Clothes_Dto.class, "/");
		Clothes_Dto y	 =(Clothes_Dto)parser.parsing(target, setters);
		System.out.println(y);
	}
}