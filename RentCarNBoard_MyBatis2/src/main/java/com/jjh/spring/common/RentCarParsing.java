package com.jjh.spring.common;

import com.jjh.spring.dto.RentCar;

public class RentCarParsing {
	public static RentCar parsing(String target) throws Exception{
		//"0/SONATA/3/50000/4/현대/sonata.jpg/참좋은차다"
		String[] tokens = target.split("/");
		RentCar car = new RentCar();
		String errormsg="";
		try {
			car.setNo(0);
			car.setName(tokens[0]);
			errormsg="카테고리번호는 1,2,3이어야 한다.";
			car.setCategory(Integer.parseInt(tokens[1]));
			errormsg="차량대여료 부분 숫자이어야 합니다.";
			car.setPrice(Integer.parseInt(tokens[2]));
			errormsg="탑승자수 부분 숫자이어야 합니다.";
			car.setUsepeople(Integer.parseInt(tokens[3]));
			car.setCompany(tokens[4]);
			car.setImg(tokens[5]);
			car.setInfo(tokens[6]);
		} catch (Exception e) {
			System.err.println(errormsg);
			e.printStackTrace();
		}
		return car;
	}

	public static void main(String[] args) throws Exception {
		String target = "SONATA/3/50000/4/현대/sonata.jpg/참좋은차다";
		RentCar x = RentCarParsing.parsing(target);
		System.out.println(x);
		// 또다른 방식 공통모듈(common tool) Parsing4Batch의 활용 
		String[] setters = new String[] { 
				"setName", "setCategory", "setPrice", "setUsepeople", "setCompany", "setImg",
				"setInfo" };
		Parsing4Batch parser = new Parsing4Batch(RentCar.class, "/");
		RentCar y	 =(RentCar)parser.parsing(target, setters);
		System.out.println(y);
	}
}