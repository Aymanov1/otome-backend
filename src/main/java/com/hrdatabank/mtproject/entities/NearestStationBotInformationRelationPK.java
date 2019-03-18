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

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NearestStationBotInformationRelationPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idNearestStation;
	private int idBotInformation;
	@Temporal(TemporalType.TIMESTAMP)
	private Date searchDate;

}
