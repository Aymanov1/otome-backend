package com.hrdatabank.mtproject.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class LineStation.
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
 * Class Name: LineStation.java
 * 
 * Instantiates a new line station.
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
 * Class Name: LineStation.java
 * 
 * Instantiates a new line station.
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
@Data

/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@EqualsAndHashCode(callSuper = false)
@Table(name = "line_station")
public class LineStation implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id line station. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idLineStation;

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
