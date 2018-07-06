package com.javalec.danmi.common;

import com.javalec.danmi.dto.Clothes_Dto;


public class RentCarParsing {
	public static Clothes_Dto parsing(String target) throws Exception{
		//"0/SONATA/3/50000/4/현대/sonata.jpg/참좋은차다"
		String[] tokens = target.split("/");
		Clothes_Dto ct = new Clothes_Dto();
		String errormsg="";
		try {
			ct.setCcode(target);
			ct.setCname(tokens[0]);
			ct.setCcategory(tokens[1]);
			ct.setMimg(tokens[2]);
			ct.setSimg(tokens[3]);
			errormsg="금액 부분 숫자이어야 합니다.";
			ct.setCprice(Integer.parseInt(tokens[4]));
			errormsg="할인금액 부분 숫자이어야 합니다.";
			ct.setCdiscount(Integer.parseInt(tokens[5]));
			errormsg="배송금액 부분 숫자이어야 합니다.";
			ct.setCbprice(Integer.parseInt(tokens[6]));
			errormsg="옷번호 부분 숫자이어야 합니다.";
			ct.setCnum(Integer.parseInt(tokens[7]));
			errormsg="수량 부분 숫자이어야 합니다.";
			ct.setTotal(Integer.parseInt(tokens[8]));
			errormsg="포인트 부분 숫자이어야 합니다.";
			ct.setPoint(Integer.parseInt(tokens[9]));
			ct.setImg1(tokens[10]);
			ct.setImg2(tokens[11]);
			ct.setImg3(tokens[12]);
					
		} catch (Exception e) {
			System.err.println(errormsg);
			e.printStackTrace();
		}
		return ct;
	}

	public static void main(String[] args) throws Exception {
		String target = "반팔티/티셔츠/MSX2TR1106PK.jpg/ /8000/0/2000/1/1000/80/ / / /";
		Clothes_Dto x = RentCarParsing.parsing(target);
		System.out.println(x);
		// 또다른 방식 공통모듈(common tool) Parsing4Batch의 활용 
		String[] setters = new String[] { 
				"setCname", "setCcategory", "setMimg", 
				"setSimg", "setCprice", "setCdiscount",
				"setCbprice","setCnum", "setTotal", 
				"setPoint", "setImg1", "setImg2", 
				"setImg3" };
		Parsing4Batch parser = new Parsing4Batch(Clothes_Dto.class, "/");
		Clothes_Dto y	 =(Clothes_Dto)parser.parsing(target, setters);
		System.out.println(y);
	}
}