package com.javalec.danmi.dto;

import java.sql.Date;
import java.sql.SQLException;

public class OrdersView {
	private String mimg;
	private String cname;
	private int cprice;
	private Date odate;
	private String cid;
	private String ocode;
	
	public String getMimg() {
		return mimg;
	}
	public void setMimg(String mimg) {
		this.mimg = mimg;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCprice() {
		return cprice;
	}
	public void setCprice(int cprice) {
		this.cprice = cprice;
	}
	public Date getOdate() {
		return odate;
	}
	public void setOdate(Date odate) {
		this.odate = odate;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getOcode() {
		return ocode;
	}
	public void setOcode(String ocode) {
		this.ocode = ocode;
	}
	
	@Override
	public String toString() {
		return "OrdersView [mimg=" + mimg + ", cname=" + cname + ", cprice=" + cprice + ", odate=" + odate + ", cid="
				+ cid + ", ocode=" + ocode + "]";
	}
	
}