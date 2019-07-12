package com.hrdatabank.mtproject.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class NearestStation.
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
 * Class Name: NearestStation.java
 * 
 * Instantiates a new nearest station.
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
 * Class Name: NearestStation.java
 * 
 * Instantiates a new nearest station.
 * @param idNearestStation the id nearest station
 * @param idNearestStationCD the id nearest station CD
 * @param japaneseStation the japanese station
 * @param japaneseKatakanaStation the japanese katakana station
 * @param japaneseHiraganaStation the japanese hiragana station
 * @param japaneseRomajiStation the japanese romaji station
 * @param addressStation the address station
 * @param longitudeStation the longitude station
 * @param latitudeStation the latitude station
 * @param openYmd the open ymd
 * @param closeYmd the close ymd
 * @param nearestStationDetail the nearest station detail
 * @param prefectureCd the prefecture cd
 * @param lineStation the line station
 * @param nearestStationBotInformationRelations the nearest station bot information relations
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
@Table(name = "nearest_station")
public class NearestStation implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id nearest station. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idNearestStation;

	/** The id nearest station CD. */
	private int idNearestStationCD;

	/** The japanese station. */
	private String japaneseStation;

	/** The japanese katakana station. */
	private String japaneseKatakanaStation;

	/** The japanese hiragana station. */
	private String japaneseHiraganaStation;

	/** The japanese romaji station. */
	private String japaneseRomajiStation;

	/** The address station. */
	private String addressStation;

	/** The longitude station. */
	@Column(precision = 10, scale = 2)
	private Double longitudeStation;

	/** The latitude station. */
	@Column(precision = 10, scale = 2)
	private Double latitudeStation;

	/** The open ymd. */
	private String openYmd;

	/** The close ymd. */
	private String closeYmd;

	/** The nearest station detail. */
	private String nearestStationDetail;

	/**  The prefecture cd *. */
	private String prefectureCd;

	/** The line station. */
	@OneToOne
	@JoinColumn(name = "idLineStation", referencedColumnName = "idLineStation")
	private LineStation lineStation;

	/** The nearest station bot information relations. */
	@OneToMany(mappedBy = "nearestStation")
	@JsonIgnoreProperties({ "nearestStation" })
	private List<NearestStationBotInformationRelation> nearestStationBotInformationRelations;

}
