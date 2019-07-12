package com.hrdatabank.mtproject.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class Staff.
 */
@Entity

/**
 * Copyright (c) 2019 by HRDatabank. All rights reserved.
 *
 * @author Aymanov
 * 
 * Using JRE: 1.8
 * 
 * Project Name: otome-backend
 * 
 * Class Name: Staff.java
 * 
 * Instantiates a new staff.
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
 * Class Name: Staff.java
 * 
 * Instantiates a new staff.
 * @param staffName the staff name
 * @param position the position
 * @param superStaff the super staff
 * @param manageCompany the manage company
 * @param manageStaff the manage staff
 * @param company the company
 * @param staffShopRelations the staff shop relations
 */
@AllArgsConstructor

/* (non-Javadoc)
 * @see com.hrdatabank.mtproject.entities.UserInformation#toString()
 */
@Data

/* (non-Javadoc)
 * @see com.hrdatabank.mtproject.entities.UserInformation#hashCode()
 */
@EqualsAndHashCode(callSuper = false)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Staff extends UserInformation implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The staff name. */
	private String staffName;

	/** The position. */
	private String position;

	/** The super staff. */
	@Column(columnDefinition = "boolean default false", nullable = false)
	private boolean superStaff; // super admin staff

	/** The manage company. */
	@Column(columnDefinition = "boolean default false", nullable = false)
	private boolean manageCompany; // staff can add and edit company if true

	/** The manage staff. */
	@Column(columnDefinition = "boolean default false", nullable = false)
	private boolean manageStaff; // staff can add and edit staffs if true

	/** The company. */
	@ManyToOne
	@JoinColumn(name = "idCompany", referencedColumnName = "id_company")
	@JsonIgnoreProperties({ "staffs", "staff", "shop", "shops", "shopCandidateRelation", "shopCandidateRelations",
			"jobCandidateRelation", "jobCandidateRelations", "candidate", "jobs", "staffs", "job" })
	private Company company;

	/** The staff shop relations. */
	@OneToMany(mappedBy = "staff", fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "staff", "shop", "shops", "shopCandidateRelation", "shopCandidateRelations",
			"jobCandidateRelation", "jobCandidateRelations", "candidate", "jobs", "staffs", "job" })
	private List<StaffShopRelation> staffShopRelations;

}
