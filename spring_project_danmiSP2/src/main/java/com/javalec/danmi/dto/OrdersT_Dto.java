package com.javalec.danmi.dto;

public class OrdersT_Dto {
	private String ocode;
	private String ccode;
	private int ocount;
	private int ocprice;
	private int ocdiscount;
	private int ocbprice;
	private int oprice;
	private String ocondition;
	
	public OrdersT_Dto(String ocode, String ccode, int ocount, int ocprice, int ocdiscount, int ocbprice, int oprice,
			String ocondition) {
		super();
		this.ocode = ocode;
		this.ccode = ccode;
		this.ocount = ocount;
		this.ocprice = ocprice;
		this.ocdiscount = ocdiscount;
		this.ocbprice = ocbprice;
		this.oprice = oprice;
		this.ocondition = ocondition;
	}
	public OrdersT_Dto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getOcode() {
		return ocode;
	}
	public void setOcode(String ocode) {
		this.ocode = ocode;
	}
	public String getCcode() {
		return ccode;
	}
	public void setCcode(String ccode) {
		this.ccode = ccode;
	}
	public int getOcount() {
		return ocount;
	}
	public void setOcount(int ocount) {
		this.ocount = ocount;
	}
	public int getOcprice() {
		return ocprice;
	}
	public void setOcprice(int ocprice) {
		this.ocprice = ocprice;
	}
	public int getOcdiscount() {
		return ocdiscount;
	}
	public void setOcdiscount(int ocdiscount) {
		this.ocdiscount = ocdiscount;
	}
	public int getOcbprice() {
		return ocbprice;
	}
	public void setOcbprice(int ocbprice) {
		this.ocbprice = ocbprice;
	}
	public int getOprice() {
		return oprice;
	}
	public void setOprice(int oprice) {
		this.oprice = oprice;
	}
	public String getOcondition() {
		return ocondition;
	}
	public void setOcondition(String ocondition) {
		this.ocondition = ocondition;
	}
	@Override
	public String toString() {
		return "OrdersT_Dto [ocode=" + ocode + ", ccode=" + ccode + ", ocount=" + ocount + ", ocprice=" + ocprice
				+ ", ocdiscount=" + ocdiscount + ", ocbprice=" + ocbprice + ", oprice=" + oprice + ", ocondition="
				+ ocondition + "]";
	}
	
	
}
