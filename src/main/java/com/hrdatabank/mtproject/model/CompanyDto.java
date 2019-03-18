package com.hrdatabank.mtproject.model;

/**
 * The Class CandidateDto.
 */
public class CompanyDto {

	/** The id company. */
	private int idCompany;

	/** The Company Name. */
	private String companyName;

	public CompanyDto(int idCompany, String companyName) {
		super();
		this.idCompany = idCompany;
		this.companyName = companyName;
	}

	public int getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(int idCompany) {
		this.idCompany = idCompany;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
