package com.hrdatabank.mtproject.model;

// TODO: Auto-generated Javadoc
/**
 * The Class PaymentCycleAdminDto.
 */
public class PaymentCycleAdminDto {

	/** The company name. */
	private String companyName;
	
	/** The shop name. */
	private String shopName;
	
	/** The request month. */
	private String requestMonth;
	
	/** The count. */
	private long count;
	
	/** The unconfirmed request amount. */
	private double unconfirmedRequestAmount;
	
	/** The confirmed request amount. */
	private double confirmedRequestAmount;
	
	/** The payment cycle. */
	private int paymentCycle;

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: PaymentCycleAdminDto.java
	 * 
	 * Instantiates a new payment cycle admin dto.
	 * @param companyName the company name
	 * @param requestMonth the request month
	 * @param count the count
	 * @param unconfirmedRequestAmount the unconfirmed request amount
	 * @param confirmedRequestAmount the confirmed request amount
	 * @param paymentCycle the payment cycle
	 */
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

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: PaymentCycleAdminDto.java
	 * 
	 * Instantiates a new payment cycle admin dto.
	 * @param shopName the shop name
	 * @param count the count
	 * @param unconfirmedRequestAmount the unconfirmed request amount
	 * @param confirmedRequestAmount the confirmed request amount
	 */
	public PaymentCycleAdminDto(String shopName, long count, double unconfirmedRequestAmount,
			double confirmedRequestAmount) {
		super();
		this.shopName = shopName;
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
	 * Class Name: PaymentCycleAdminDto.java
	 * 
	 * Gets the company name.
	 * @return the company name
	 */
	public String getCompanyName() {
		return companyName;
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
	 * Class Name: PaymentCycleAdminDto.java
	 * 
	 * Sets the company name.
	 * @param companyName the new company name
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
	 * Class Name: PaymentCycleAdminDto.java
	 * 
	 * Gets the shop name.
	 * @return the shop name
	 */
	public String getShopName() {
		return shopName;
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
	 * Class Name: PaymentCycleAdminDto.java
	 * 
	 * Sets the shop name.
	 * @param shopName the new shop name
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
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
	 * Class Name: PaymentCycleAdminDto.java
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
	 * Class Name: PaymentCycleAdminDto.java
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
	 * Class Name: PaymentCycleAdminDto.java
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
	 * Class Name: PaymentCycleAdminDto.java
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
	 * Class Name: PaymentCycleAdminDto.java
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
	 * Class Name: PaymentCycleAdminDto.java
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
	 * Class Name: PaymentCycleAdminDto.java
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
	 * Class Name: PaymentCycleAdminDto.java
	 * 
	 * Sets the confirmed request amount.
	 * @param confirmedRequestAmount the new confirmed request amount
	 */
	public void setConfirmedRequestAmount(double confirmedRequestAmount) {
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
	 * Class Name: PaymentCycleAdminDto.java
	 * 
	 * Gets the payment cycle.
	 * @return the payment cycle
	 */
	public int getPaymentCycle() {
		return paymentCycle;
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
	 * Class Name: PaymentCycleAdminDto.java
	 * 
	 * Sets the payment cycle.
	 * @param paymentCycle the new payment cycle
	 */
	public void setPaymentCycle(int paymentCycle) {
		this.paymentCycle = paymentCycle;
	}

}
