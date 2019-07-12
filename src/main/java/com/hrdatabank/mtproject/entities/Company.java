package com.hrdatabank.mtproject.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class Company.
 */
@Entity

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
 * Class Name: Company.java
 * 
 * Instantiates a new company.
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
 * Class Name: Company.java
 * 
 * Instantiates a new company.
 * @param idCompany the id company
 * @param nameCompany the name company
 * @param loginId the login id
 * @param password the password
 * @param authorizedKey the authorized key
 * @param token the token
 * @param logoCompany the logo company
 * @param description the description
 * @param phoneNumber the phone number
 * @param addressCompany the address company
 * @param emailCompany the email company
 * @param interviewType the interview type
 * @param emailRequirementStatus the email requirement status
 * @param atsStatus the ats status
 * @param shops the shops
 * @param staffs the staffs
 * @param superAdmin the super admin
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
public class Company implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id company. */
	@Id
	@SequenceGenerator(name = "identifier", initialValue = 1, sequenceName = "COMPANY_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "identifier")
	@Column(name = "id_company")
	private int idCompany;

	/** The name company. */
	@Column(name = "name_company")
	private String nameCompany;

	/** The login id. */
	@Column(name = "login_id")
	private String loginId;

	/** The password. */
	private String password;

	/** The authorized key. */
	@Column(name = "authorized_key")
	private String authorizedKey;

	/** The token. */
	private String token;

	/** The logo company. */
	@Column(name = "logo_company")
	private String logoCompany;

	/** The description. */
	private String description;

	/** The phone number. */
	@Column(name = "phone_number")
	private String phoneNumber;

	/** The address company. */
	@Column(name = "address_company")
	private String addressCompany;

	/** The email company. */
	@Column(name = "email_company")
	private String emailCompany;

	/** The interview type. */
	@Column(name = "interview_type")
	private String interviewType;

	/** The email requirement status. */
	@Column(name = "email_requirement_status")
	private String emailRequirementStatus;

	/** The ats status. */
	@Column(name = "ats_status")
	private String atsStatus;

	/** The shops. */
	@OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({ "company" })
	@JsonIgnore
	private List<Shop> shops;

	/** The staffs. */
	@OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Staff> staffs;

	/** The super admin. */
	@OneToOne
	@JoinColumn(name = "id_super_admin", referencedColumnName = "id_user")
	@JsonIgnoreProperties({ "company", "staffShopRelations" })
	private Staff superAdmin;

	/** The payment cycle. */
	@Column(name = "payment_cycle", columnDefinition = "int default 0")
	private int paymentCycle;
	
	/** ********************** Fake attributes **. */

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author wmhamdi
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: Company.java
	 *
	 */
	@Column(name = "company_fax")
	private String companyFax;
	
	/** The responsible person. */
	@Column(name = "responsible_person")
	private String responsiblePerson;
	
	/** The company contract period. */
	@Column(name = "company_contract_period")
	private String companyContractPeriod;
	
	/** The traning period. */
	@Column(name = "traning_period")
	private String traningPeriod;
	
	/** The education history. */
	@Column(name = "education_history")
	private String educationHistory;
	/************/
}
