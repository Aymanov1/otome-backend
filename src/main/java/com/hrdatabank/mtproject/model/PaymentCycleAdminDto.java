package com.hrdatabank.mtproject.model;

public class PaymentCycleAdminDto {

	private String companyName;
	private String shopName;
	private String requestMonth;
	private long count;
	private double unconfirmedRequestAmount;
	private double confirmedRequestAmount;
	private int paymentCycle;

	public PaymentCycleAdminDto(String companyName, String requestMonth, long count, double unconfirmedRequestAmount,
			double confirmedRequestAmount, int paymentCycle) {
		super();
		this.companyName = companyName;
		this.requestMonth = requestMonth;
		this.count = count;
		this.unconfirmedRequestAmount = unconfirmedRequestAmount;
		this.confirmedRequestAmount = confirmedRequestAmount;
		this.paymentCycle = paymentCycle;
	}	

	public PaymentCycleAdminDto(String shopName, long count, double unconfirmedRequestAmount,
			double confirmedRequestAmount) {
		super();
		this.shopName = shopName;
		this.count = count;
		this.unconfirmedRequestAmount = unconfirmedRequestAmount;
		this.confirmedRequestAmount = confirmedRequestAmount;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getRequestMonth() {
		return requestMonth;
	}

	public void setRequestMonth(String requestMonth) {
		this.requestMonth = requestMonth;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public double getUnconfirmedRequestAmount() {
		return unconfirmedRequestAmount;
	}

	public void setUnconfirmedRequestAmount(double unconfirmedRequestAmount) {
		this.unconfirmedRequestAmount = unconfirmedRequestAmount;
	}

	public double getConfirmedRequestAmount() {
		return confirmedRequestAmount;
	}

	public void setConfirmedRequestAmount(double confirmedRequestAmount) {
		this.confirmedRequestAmount = confirmedRequestAmount;
	}

	public int getPaymentCycle() {
		return paymentCycle;
	}

	public void setPaymentCycle(int paymentCycle) {
		this.paymentCycle = paymentCycle;
	}

}
