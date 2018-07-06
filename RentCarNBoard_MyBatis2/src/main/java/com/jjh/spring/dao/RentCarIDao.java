package com.jjh.spring.dao;

import java.util.ArrayList;

import com.jjh.spring.dto.RentCar;

public interface RentCarIDao {

	public void insert(String name, int category, int price, int usepeople, String company, String img, String info);
	
	public void delete(String no);
	
	public void update(String name, String category, String price, String usepeople, String company, String img, String info, String no);
	
	public ArrayList<RentCar> selectAll();
	
	public RentCar selectNo(int no);
	
	public ArrayList<RentCar> selectCategory(int category);

}
