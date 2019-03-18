package com.hrdatabank.otome.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class NearestStationOtome.
 */
@Entity

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */
@Data

/**
 * Instantiates a new nearest station otome.
 */
@NoArgsConstructor

/**
 * Instantiates a new nearest station otome.
 *
 * @param idNearestStation
 *            the id nearest station
 * @param idNearestStationCD
 *            the id nearest station CD
 * @param japaneseStation
 *            the japanese station
 * @param japaneseKatakanaStation
 *            the japanese katakana station
 * @param japaneseHiraganaStation
 *            the japanese hiragana station
 * @param japaneseRomajiStation
 *            the japanese romaji station
 * @param addressStation
 *            the address station
 * @param longitudeStation
 *            the longitude station
 * @param latitudeStation
 *            the latitude station
 * @param openYmd
 *            the open ymd
 * @param closeYmd
 *            the close ymd
 * @param nearestStationDetail
 *            the nearest station detail
 * @param prefectureCd
 *            the prefecture cd
 * @param lineStationOtome
 *            the line station otome
 */
@AllArgsConstructor

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */
@Builder
public class NearestStationOtome implements Serializable {

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

	/** The prefecture cd *. */
	private String prefectureCd;

	/** The line station. */
	@OneToOne
	@JoinColumn(name = "idLineStation", referencedColumnName = "idLineStation")
	private LineStationOtome lineStationOtome;

}
