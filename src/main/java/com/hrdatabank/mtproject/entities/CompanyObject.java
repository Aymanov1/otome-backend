package com.hrdatabank.mtproject.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * The Class CompanyObject.
 *
 * @author Wala Ben Amor
 * 
 *         Object of Company Class having only id and name of the Company
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

@EqualsAndHashCode(callSuper = false)
public class CompanyObject {

	/** The id company. */
	private int idCompany;

	/** The name company. */
	private String nameCompany;

	/** The description. */
	private String description;

	/** The phone number. */
	private String phoneNumber;

	/** The address company. */
	private String addressCompany;

	/** The email company. */
	private String emailCompany;

	/** The logo company. */
	private String logoCompany;

	private int paymentCycle;
	private String companyFax;
	private String responsiblePerson;
	private String companyContractPeriod;
	private String traningPeriod;
	private String educationHistory;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: CompanyObject.java
	 * 
	 *         Instantiates a new company object.
	 * @param idCompany
	 *            the id company
	 * @param nameCompany
	 *            the name company
	 * @param description
	 *            the description
	 * @param phoneNumber
	 *            the phone number
	 * @param addressCompany
	 *            the address company
	 * @param emailCompany
	 *            the email company
	 * @param logoCompany
	 *            the logo company
	 */
	public CompanyObject(int idCompany, String nameCompany, String description, String phoneNumber,
			String addressCompany, String emailCompany, String logoCompany) {
		super();
		this.idCompany = idCompany;
		this.nameCompany = nameCompany;
		this.description = description;
		this.phoneNumber = phoneNumber;
		this.addressCompany = addressCompany;
		this.emailCompany = emailCompany;
		this.logoCompany = logoCompany;
	}

	public CompanyObject(int idCompany, String nameCompany, String description, String phoneNumber,
			String addressCompany, String emailCompany, String logoCompany, int paymentCycle) {
		super();
		this.idCompany = idCompany;
		this.nameCompany = nameCompany;
		this.description = description;
		this.phoneNumber = phoneNumber;
		this.addressCompany = addressCompany;
		this.emailCompany = emailCompany;
		this.logoCompany = logoCompany;
		this.paymentCycle = paymentCycle;
	}

}
