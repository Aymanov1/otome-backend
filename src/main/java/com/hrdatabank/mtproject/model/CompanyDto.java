package com.hrdatabank.mtproject.model;

// TODO: Auto-generated Javadoc
/**
 * The Class CandidateDto.
 */
public class CompanyDto {

	/** The id company. */
	private int idCompany;

	/** The Company Name. */
	private String companyName;

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: CompanyDto.java
	 * 
	 * Instantiates a new company dto.
	 * @param idCompany the id company
	 * @param companyName the company name
	 */
	public CompanyDto(int idCompany, String companyName) {
		super();
		this.idCompany = idCompany;
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
	 * Class Name: CompanyDto.java
	 * 
	 * Gets the id company.
	 * @return the id company
	 */
	public int getIdCompany() {
		return idCompany;
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
	 * Class Name: CompanyDto.java
	 * 
	 * Sets the id company.
	 * @param idCompany the new id company
	 */
	public void setIdCompany(int idCompany) {
		this.idCompany = idCompany;
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
	 * Class Name: CompanyDto.java
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
	 * Class Name: CompanyDto.java
	 * 
	 * Sets the company name.
	 * @param companyName the new company name
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
