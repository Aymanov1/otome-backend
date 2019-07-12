package com.hrdatabank.mtproject.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class StaffShopRelation.
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
 * Class Name: StaffShopRelation.java
 * 
 * Instantiates a new staff shop relation.
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
 * Class Name: StaffShopRelation.java
 * 
 * Instantiates a new staff shop relation.
 * @param staffShopRelationPK the staff shop relation PK
 * @param manageProgress the manage progress
 * @param manageJob the manage job
 * @param manageShop the manage shop
 * @param manageAuthority the manage authority
 * @param authorizedShop the authorized shop
 * @param staff the staff
 * @param shop the shop
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
@Table(name = "staff_shop_relation")
public class StaffShopRelation implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The staff shop relation PK. */
	@EmbeddedId
	private StaffShopRelationPK staffShopRelationPK;

	/** The manage progress. */
	@Column(columnDefinition = "boolean default false", nullable = false)
	private boolean manageProgress; // staff can add and edit progress if true

	/** The manage job. */
	@Column(columnDefinition = "boolean default false", nullable = false)
	private boolean manageJob; // staff can add and edit jobs if true

	/** The manage shop. */
	@Column(columnDefinition = "boolean default false", nullable = false)
	private boolean manageShop; // staff can add and edit shops if true

	/** The manage authority. */
	@Column(columnDefinition = "boolean default false", nullable = false)
	private boolean manageAuthority; // staff can add and edit authorities if true

	/** The authorized shop. */
	@Column(columnDefinition = "boolean default false", nullable = false)
	private boolean authorizedShop; // staff have all authorizations for the related shop

	/** The staff. */
	@ManyToOne
	@JoinColumn(name = "idStaff", referencedColumnName = "id_user", insertable = false, updatable = false)
	@JsonIgnoreProperties({ "staffShopRelations" })
	private Staff staff;

	/** The shop. */
	@ManyToOne
	@JoinColumn(name = "idShop", referencedColumnName = "id_shop", insertable = false, updatable = false)
	@JsonIgnoreProperties({ "shopCandidateRelations, staffShopRelations, jobCandidateRelations", "candidate", "jobs",
			"staffs" })
	private Shop shop;

}
