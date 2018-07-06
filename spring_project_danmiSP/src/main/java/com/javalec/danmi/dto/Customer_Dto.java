package com.javalec.danmi.dto;

import java.sql.Date;

public class Customer_Dto {
	private String cid;
	private String cpass;
	private String cname;
	private String ctel;
	private String cadd;
	private String csex;
	private String cage;
	private Date cbirth;
	private String cemail;
	private String ccategory;
	private String csms;
	private String cems;
	public Customer_Dto(String cid, String cpass, String cname, String ctel, String cadd, String csex, String cage,
			Date cbirth, String cemail, String ccategory, String csms, String cems) {
		super();
		this.cid = cid;
		this.cpass = cpass;
		this.cname = cname;
		this.ctel = ctel;
		this.cadd = cadd;
		this.csex = csex;
		this.cage = cage;
		this.cbirth = cbirth;
		this.cemail = cemail;
		this.ccategory = ccategory;
		this.csms = csms;
		this.cems = cems;
	}
	public Customer_Dto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer_Dto [cid=" + cid + ", cpass=" + cpass + ", cname=" + cname + ", ctel=" + ctel + ", cadd="
				+ cadd + ", csex=" + csex + ", cage=" + cage + ", cbirth=" + cbirth + ", cemail=" + cemail
				+ ", ccategory=" + ccategory + ", csms=" + csms + ", cems=" + cems + "]";
	}
	

}
