package com.hrdatabank.mtproject.model;

// TODO: Auto-generated Javadoc
/**
 * The Class PaymentCycleDto.
 */
public class PaymentCycleDto {

	/** The request month. */
	private String requestMonth;
	
	/** The count. */
	private long count;
	
	/** The unconfirmed request amount. */
	private double unconfirmedRequestAmount;
	
	/** The confirmed request amount. */
	private double confirmedRequestAmount;

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: PaymentCycleDto.java
	 * 
	 * Instantiates a new payment cycle dto.
	 * @param requestMonth the request month
	 * @param count the count
	 * @param unconfirmedRequestAmount the unconfirmed request amount
	 * @param confirmedRequestAmount the confirmed request amount
	 */
	public PaymentCycleDto(String requestMonth, long count, double unconfirmedRequestAmount,
			double confirmedRequestAmount) {
		super();
		this.requestMonth = requestMonth;
		this.count = count;
		this.unconfirmedRequestAmount = unconfirmedRequestAmount;
		this.confirmedRequestAmount = confirmedRequestAmount;
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: PaymentCycleDto.java
	 * 
	 * Gets the request month.
	 * @return the request month
	 */
	public String getRequestMonth() {
		return requestMonth;
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: PaymentCycleDto.java
	 * 
	 * Sets the request month.
	 * @param requestMonth the new request month
	 */
	public void setRequestMonth(String requestMonth) {
		this.requestMonth = requestMonth;
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: PaymentCycleDto.java
	 * 
	 * Gets the count.
	 * @return the count
	 */
	public long getCount() {
		return count;
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: PaymentCycleDto.java
	 * 
	 * Sets the count.
	 * @param count the new count
	 */
	public void setCount(long count) {
		this.count = count;
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: PaymentCycleDto.java
	 * 
	 * Gets the unconfirmed request amount.
	 * @return the unconfirmed request amount
	 */
	public double getUnconfirmedRequestAmount() {
		return unconfirmedRequestAmount;
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: PaymentCycleDto.java
	 * 
	 * Sets the unconfirmed request amount.
	 * @param unconfirmedRequestAmount the new unconfirmed request amount
	 */
	public void setUnconfirmedRequestAmount(double unconfirmedRequestAmount) {
		this.unconfirmedRequestAmount = unconfirmedRequestAmount;
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: PaymentCycleDto.java
	 * 
	 * Gets the confirmed request amount.
	 * @return the confirmed request amount
	 */
	public double getConfirmedRequestAmount() {
		return confirmedRequestAmount;
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: PaymentCycleDto.java
	 * 
	 * Sets the confirmed request amount.
	 * @param confirmedRequestAmount the new confirmed request amount
	 */
	public void setConfirmedRequestAmount(double confirmedRequestAmount) {
		this.confirmedRequestAmount = confirmedRequestAmount;
	}

}
