package com.hrdatabank.otome.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class Shop.
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
 * Class Name: Shop.java
 * 
 * Instantiates a new shop.
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
 * Class Name: Shop.java
 * 
 * Instantiates a new shop.
 * @param idShop the id shop
 * @param idShopCSV the id shop CSV
 * @param nameShop the name shop
 * @param addressShop the address shop
 * @param descriptionShop the description shop
 * @param category the category
 * @param openTime the open time
 * @param logoShop the logo shop
 * @param userIdLine the user id line
 * @param channelToken the channel token
 * @param emailShop the email shop
 * @param phoneNumber the phone number
 * @param applyPhoneNumber the apply phone number
 * @param reference the reference
 * @param requirement the requirement
 * @param interviewVenue the interview venue
 * @param possiblePhoneTime the possible phone time
 * @param longitude the longitude
 * @param latitude the latitude
 * @param transportationAllowance the transportation allowance
 * @param company the company
 * @param jobs the jobs
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
public class Shop implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id shop. */
	@Id
	@SequenceGenerator(name = "identifier", initialValue = 1, sequenceName = "SHOP_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "identifier")
	private int idShop;

	/** The id shop CSV. */
	private String idShopCSV;

	/** The name shop. */
	private String nameShop;

	/** The address shop. */
	private String addressShop;

	/** The description shop. */
	private String descriptionShop;

	/** The category. */
	private String category;

	/** The open time. */
	private String openTime;

	/** The logo shop. */
	private String logoShop;

	/** The user id line. */
	private String userIdLine;

	/** The channel token. */
	private String channelToken;

	/** The email shop. */
	private String emailShop;

	/** The phone number. */
	private String phoneNumber;

	/** The apply phone number. */
	private String applyPhoneNumber;

	/** The reference. */
	private String reference;

	/** The requirement. */
	private String requirement;

	/** The interview venue. */
	private String interviewVenue;

	/** The possible phone time. */
	private String possiblePhoneTime;

	/** The longitude. */
	@Column(precision = 10, scale = 2)
	private Double longitude;

	/** The latitude. */
	@Column(precision = 10, scale = 2)
	private Double latitude;

	/** The transportation allowance. */
	@Column(name="transportation_allowance",columnDefinition = "boolean default false", nullable = false)
	private boolean transportationAllowance;

	/** The company. */
	@ManyToOne
	@JoinColumn(name = "idCompany", referencedColumnName = "idCompany")
	@JsonIgnoreProperties({ "shops" })
	private Company company;

	/** The jobs. */
	@OneToMany(mappedBy = "shop", cascade = CascadeType.REMOVE)
	private List<Job> jobs;


}
