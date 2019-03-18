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

/**
 * The Class NearestStation.
 */
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

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

	/** The prefecture cd **/
	private String prefectureCd;

	/** The line station. */
	@OneToOne
	@JoinColumn(name = "idLineStation", referencedColumnName = "idLineStation")
	private LineStation lineStation;

	@OneToMany(mappedBy = "nearestStation")
	@JsonIgnoreProperties({ "nearestStation" })
	private List<NearestStationBotInformationRelation> nearestStationBotInformationRelations;

}
