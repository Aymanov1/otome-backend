package com.hrdatabank.mtproject.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class CompanyObject.
 *
 * @author Wala Ben Amor
 * 
 *         Object of Company Class having only id and name of the Company
 */

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Builder

/**
 * Copyright (c) 2019 by HRDatabank. All rights reserved.
 *
 * @author Aymanov
 * 
 * Using JRE: 1.8
 * 
 * Project Name: otome-backend
 * 
 * Class Name: CompanyObject.java
 * 
 * Instantiates a new company object.
 */
@NoArgsConstructor

/**
 * Copyright (c) 2019 by HRDatabank. All rights reserved.
 *
 * @author Aymanov
 * 
 * Using JRE: 1.8
 * 
 * Project Name: otome-backend
 * 
 * Class Name: CompanyObject.java
 * 
 * Instantiates a new company object.
 * @param idCompany the id company
 * @param nameCompany the name company
 * @param description the description
 * @param phoneNumber the phone number
 * @param addressCompany the address company
 * @param emailCompany the email company
 * @param logoCompany the logo company
 * @param paymentCycle the payment cycle
 * @param companyFax the company fax
 * @param responsiblePerson the responsible person
 * @param companyContractPeriod the company contract period
 * @param traningPeriod the traning period
 * @param educationHistory the education history
 */
@AllArgsConstructor

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data

/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
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

	/** The payment cycle. */
	private int paymentCycle;
	
	/** The company fax. */
	private String companyFax;
	
	/** The responsible person. */
	private String responsiblePerson;
	
	/** The company contract period. */
	private String companyContractPeriod;
	
	/** The traning period. */
	private String traningPeriod;
	
	/** The education history. */
	private String educationHistory;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
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

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: CompanyObject.java
	 * 
	 * Instantiates a new company object.
	 * @param idCompany the id company
	 * @param nameCompany the name company
	 * @param description the description
	 * @param phoneNumber the phone number
	 * @param addressCompany the address company
	 * @param emailCompany the email company
	 * @param logoCompany the logo company
	 * @param paymentCycle the payment cycle
	 */
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
