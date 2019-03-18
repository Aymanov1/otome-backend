package com.hrdatabank.mtproject.model;

public class PaymentCycleDto {

	private String requestMonth;
	private long count;
	private double unconfirmedRequestAmount;
	private double confirmedRequestAmount;

	public PaymentCycleDto(String requestMonth, long count, double unconfirmedRequestAmount,
			double confirmedRequestAmount) {
		super();
		this.requestMonth = requestMonth;
		this.count = count;
		this.unconfirmedRequestAmount = unconfirmedRequestAmount;
		this.confirmedRequestAmount = confirmedRequestAmount;
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

}
