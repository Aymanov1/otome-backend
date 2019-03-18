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

/**
 * The Class Company.
 */
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Company implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id company. */
	@Id
	@SequenceGenerator(name = "identifier", initialValue = 1, sequenceName = "COMPANY_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "identifier")
	private int idCompany;

	/** The name company. */
	private String nameCompany;

	/** The login id. */
	private String loginId;

	/** The password. */
	private String password;

	/** The authorized key. */
	private String authorizedKey;

	/** The token. */
	private String token;

	/** The logo company. */
	private String logoCompany;

	/** The description. */
	private String description;

	/** The phone number. */
	private String phoneNumber;

	/** The address company. */
	private String addressCompany;

	/** The email company. */
	private String emailCompany;

	/** The interview type. */
	private String interviewType;

	/** The email requirement status. */
	private String emailRequirementStatus;

	/** The ats status. */
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
	@JoinColumn(name = "idSuperAdmin", referencedColumnName = "id_user")
	@JsonIgnoreProperties({ "company", "staffShopRelations" })
	private Staff superAdmin;

	@Column(columnDefinition = "int default 0")
	private int paymentCycle;
	/************************ Fake attributes ***/

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
	private String companyFax;
	private String responsiblePerson;
	private String companyContractPeriod;
	private String traningPeriod;
	private String educationHistory;

}
