package com.hrdatabank.mtproject.entities;

import java.io.Serializable;

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
 * The Class NearestStationBotInformationRelation.
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
 * Class Name: NearestStationBotInformationRelation.java
 * 
 * Instantiates a new nearest station bot information relation.
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
 * Class Name: NearestStationBotInformationRelation.java
 * 
 * Instantiates a new nearest station bot information relation.
 * @param nearestStationBotInformationRelationPK the nearest station bot information relation PK
 * @param botInformation the bot information
 * @param nearestStation the nearest station
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
@Table(name="nearest_station_bot_information_relation")
public class NearestStationBotInformationRelation implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The nearest station bot information relation PK. */
	@EmbeddedId
	private NearestStationBotInformationRelationPK nearestStationBotInformationRelationPK;

	/** The bot information. */
	@ManyToOne
	@JoinColumn(name = "idBotInformation", referencedColumnName = "idBotInformation", insertable = false, updatable = false)
	@JsonIgnoreProperties({ "nearestStationBotInformationRelations" })
	private BotInformation botInformation;

	/** The nearest station. */
	@ManyToOne
	@JoinColumn(name = "idNearestStation", referencedColumnName = "idNearestStation", insertable = false, updatable = false)
	@JsonIgnoreProperties({ "nearestStationBotInformationRelations" })
	private NearestStation nearestStation;
}
