package com.hrdatabank.mtproject.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class NearestStationBotInformationRelationPK.
 */
@Embeddable

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
 * Class Name: NearestStationBotInformationRelationPK.java
 * 
 * Instantiates a new nearest station bot information relation PK.
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
 * Class Name: NearestStationBotInformationRelationPK.java
 * 
 * Instantiates a new nearest station bot information relation PK.
 * @param idNearestStation the id nearest station
 * @param idBotInformation the id bot information
 * @param searchDate the search date
 */
@AllArgsConstructor

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data
public class NearestStationBotInformationRelationPK implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id nearest station. */
	private int idNearestStation;
	
	/** The id bot information. */
	private int idBotInformation;
	
	/** The search date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date searchDate;

}
