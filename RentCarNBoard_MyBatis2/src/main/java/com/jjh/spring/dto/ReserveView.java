package com.jjh.spring.dto;

import java.sql.SQLException;

public class ReserveView {
	private String img;
	private String name;
	private int qty;
	private String rday;
	private int dday;
	private int price;
	private int insurance;
	private int wifi;
	private int navigation;
	private int babyseat;
	private String memid;
	private int regno;
	private int res;
	private String fee;

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}

	public int getRegno() {
		return regno;
	}

	public void setRegno(int regno) {
		this.regno = regno;
	}

	public String getImg() {
		return img;
	}

	public String getName() {
		return name;
	}

	public int getQty() {
		return qty;
	}

	public String getRday() {
		return rday;
	}

	public int getDday() {
		return dday;
	}

	public int getPrice() {
		return price;
	}

	public int getInsurance() {
		return insurance;
	}

	public int getWifi() {
		return wifi;
	}

	public int getNavigation() {
		return navigation;
	}

	public int getBabyseat() {
		return babyseat;
	}

	public String getMemid() {
		return memid;
	}

	@Override
	public String toString() {
		return "예약정보 [img=" + img + ", name=" + name + ", qty=" + qty + ", rday=" + rday + ", dday=" + dday + ", price="
				+ price + ", insurance=" + insurance + ", wifi=" + wifi + ", navigation=" + navigation + ", babyseat="
				+ babyseat + ", memid=" + memid + "]";
	}
}