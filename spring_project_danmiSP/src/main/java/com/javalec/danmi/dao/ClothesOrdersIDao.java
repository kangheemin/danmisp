package com.javalec.danmi.dao;

import java.util.ArrayList;

import com.jjh.spring.dto.RentReserve;
import com.jjh.spring.dto.ReserveView;

public interface ClothesOrdersIDao {

	public ArrayList<RentReserve> selectAll();

	public RentReserve selectRegno(int regno);

	public ArrayList<RentReserve> selectRday(String rday);

	public ArrayList<RentReserve> selectMemid(String memid);

	public void insert(int no, int qty, int dday, String rday, int insurance, int wifi,
			int navigation, int babyseat, String memid);

	public void delete(int regno);

	public void update(String no, String rday, String dday, String qty, String insurance, String wifi,
			String navigation, String babyseat, String memid, String regno);
	
	public ArrayList<OrdersView> selectAllView(String memid);
}
