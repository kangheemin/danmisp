package com.javalec.danmi.dto;

import java.sql.Date;

public class Orders_Dto {
	private String	ocode;
	private Date odate;
	private String cid;
	
	public Orders_Dto(String ocode, Date odate, String cid) {
		super();
		this.ocode = ocode;
		this.odate = odate;
		this.cid = cid;
	}

	public Orders_Dto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getOcode() {
		return ocode;
	}

	public void setOcode(String ocode) {
		this.ocode = ocode;
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

	@Override
	public String toString() {
		return "Orders [ocode=" + ocode + ", odate=" + odate + ", cid=" + cid + "]";
	}
	
	
}
