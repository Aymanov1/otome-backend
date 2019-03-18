package com.hrdatabank.otome.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class LineStationOtome.
 */
@Entity

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data

/**
 * Instantiates a new line station otome.
 */
@NoArgsConstructor

/**
 * Instantiates a new line station otome.
 *
 * @param idLineStation the id line station
 * @param lineCD the line CD
 * @param lineNameJapanese the line name japanese
 * @param lineNameKatakana the line name katakana
 * @param lineNameHiragana the line name hiragana
 * @param lineColorCode the line color code
 * @param lineColor the line color
 * @param lineType the line type
 * @param longitude the longitude
 * @param latitude the latitude
 * @param lineZoom the line zoom
 */
@AllArgsConstructor

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Builder
public class LineStationOtome implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id line station. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idLineStation;

	/** The line CD. */
	private int lineCD;

	/** The line name japanese. */
	private String lineNameJapanese;

	/** The line name katakana. */
	private String lineNameKatakana;

	/** The line name hiragana. */
	private String lineNameHiragana;

	/** The line color code. */
	private String lineColorCode;

	/** The line color. */
	private String lineColor;

	/** The line type. */
	private int lineType;

	/** The longitude. */
	@Column(precision = 10, scale = 2)
	private Double longitude;

	/** The latitude. */
	@Column(precision = 10, scale = 2)
	private Double latitude;

	/** The line zoom. */
	private int lineZoom;

}
