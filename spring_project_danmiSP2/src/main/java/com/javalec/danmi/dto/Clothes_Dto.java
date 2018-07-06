package com.javalec.danmi.dto;

public class Clothes_Dto {

	private String ccode;
	private String cname;
	private String ccategory;
	private String mimg;
	private String simg;
	private int cprice;
	private int cdiscount;
	private int cbprice;
	private int cnum;
	private int total;
	private int point;
	private String img1;
	private String img2;
	private String img3;
	
	public String getCcode() {
		return ccode;
	}
	public void setCcode(String ccode) {
		this.ccode = ccode;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCcategory() {
		return ccategory;
	}
	public void setCcategory(String ccategory) {
		this.ccategory = ccategory;
	}
	public String getMimg() {
		return mimg;
	}
	public void setMimg(String mimg) {
		this.mimg = mimg;
	}
	public String getSimg() {
		return simg;
	}
	public void setSimg(String simg) {
		this.simg = simg;
	}
	public int getCprice() {
		return cprice;
	}
	public void setCprice(int cprice) {
		this.cprice = cprice;
	}
	public int getCdiscount() {
		return cdiscount;
	}
	public void setCdiscount(int cdiscount) {
		this.cdiscount = cdiscount;
	}
	public int getCbprice() {
		return cbprice;
	}
	public void setCbprice(int cbprice) {
		this.cbprice = cbprice;
	}
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	@Override
	public String toString() {
		return "Clothes_Dto [ccode=" + ccode + ", cname=" + cname + ", ccategory=" + ccategory + ", mimg=" + mimg
				+ ", simg=" + simg + ", cprice=" + cprice + ", cdiscount=" + cdiscount + ", cbprice=" + cbprice
				+ ", cnum=" + cnum + ", total=" + total + ", point=" + point + ", img1=" + img1 + ", img2=" + img2
				+ ", img3=" + img3 + "]";
	}
	public Clothes_Dto(String ccode, String cname, String ccategory, String mimg, String simg, int cprice,
			int cdiscount, int cbprice, int cnum, int total, int point, String img1, String img2, String img3) {
		super();
		this.ccode = ccode;
		this.cname = cname;
		this.ccategory = ccategory;
		this.mimg = mimg;
		this.simg = simg;
		this.cprice = cprice;
		this.cdiscount = cdiscount;
		this.cbprice = cbprice;
		this.cnum = cnum;
		this.total = total;
		this.point = point;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
	}
	public Clothes_Dto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
