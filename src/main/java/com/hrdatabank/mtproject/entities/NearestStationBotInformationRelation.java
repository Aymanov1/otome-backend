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

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name="nearest_station_bot_information_relation")
public class NearestStationBotInformationRelation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NearestStationBotInformationRelationPK nearestStationBotInformationRelationPK;

	@ManyToOne
	@JoinColumn(name = "idBotInformation", referencedColumnName = "idBotInformation", insertable = false, updatable = false)
	@JsonIgnoreProperties({ "nearestStationBotInformationRelations" })
	private BotInformation botInformation;

	@ManyToOne
	@JoinColumn(name = "idNearestStation", referencedColumnName = "idNearestStation", insertable = false, updatable = false)
	@JsonIgnoreProperties({ "nearestStationBotInformationRelations" })
	private NearestStation nearestStation;
}
