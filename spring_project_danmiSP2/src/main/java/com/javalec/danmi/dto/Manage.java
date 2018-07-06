package com.javalec.danmi.dto;

public class Manage {
	private String mid;
	private String mpass;
	private String mname;
	private String mtel;
	public Manage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Manage(String mid, String mpass, String mname, String mtel) {
		super();
		this.mid = mid;
		this.mpass = mpass;
		this.mname = mname;
		this.mtel = mtel;
	}
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpass() {
		return mpass;
	}
	public void setMpass(String mpass) {
		this.mpass = mpass;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMtel() {
		return mtel;
	}
	public void setMtel(String mtel) {
		this.mtel = mtel;
	}
	@Override
	public String toString() {
		return "Manage [mid=" + mid + ", mpass=" + mpass + ", mname=" + mname + ", mtel=" + mtel + "]";
	}
	
	
}