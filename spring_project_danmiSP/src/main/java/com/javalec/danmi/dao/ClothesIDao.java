package com.javalec.danmi.dao;

import java.util.ArrayList;

import com.javalec.danmi.dto.Clothes_Dto;


public interface ClothesIDao {

	public void insert(String cname, String ccategory, String mimg,String simg, int cprice,
						int cdiscount, int cbprice, int cnum, int total, int point, 
						String img1, String img2, String img3);
						
	public void delete(String ccode);
	
	public void update(String cname, String ccategory, String mimg,String simg, String cprice,
			String cdiscount, String cbprice, String cnum, String total, String point, 
						String img1, String img2, String img3, String ccode);
	public ArrayList<Clothes_Dto> selectAll();
	public Clothes_Dto selectNo(String ccode);
	public ArrayList<Clothes_Dto> selectCategory(String ccategoty);

}
