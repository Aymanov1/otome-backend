package com.hrdatabank.mtproject.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class LineBotAdmin.
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
 * Class Name: LineBotAdmin.java
 * 
 * Instantiates a new line bot admin.
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
 * Class Name: LineBotAdmin.java
 * 
 * Instantiates a new line bot admin.
 * @param idLineBotAdmin the id line bot admin
 * @param userIdLine the user id line
 * @param channelToken the channel token
 * @param searchAlgorithm the search algorithm
 * @param affiliateType the affiliate type
 * @param hiddenAffiliateType the hidden affiliate type
 * @param admins the admins
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
@Table(name = "line_bot_admin")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class LineBotAdmin implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id line bot admin. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idLineBotAdmin;

	/** The user id line. */
	private String userIdLine;

	/** The channel token. */
	private String channelToken;

	/**
	 * line baito, baitoru, j-sen
	 * 
	 * baito.line.me
	 *
	 * baitoru
	 *
	 * j-sen
	 */
	private String searchAlgorithm;

	/** The affiliate type. */
	private String affiliateType;

	/** The hidden affiliate type. */
	private String hiddenAffiliateType;

	/** The admins. */
	@OneToMany(mappedBy = "lineBotAdmin")
	private List<Admin> admins;

}
