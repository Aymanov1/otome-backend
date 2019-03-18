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

/**
 * The Class LineStation.
 */
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
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
