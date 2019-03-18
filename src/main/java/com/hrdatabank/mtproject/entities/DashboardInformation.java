package com.hrdatabank.mtproject.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name = "dashboard_information")
public class DashboardInformation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idDashboardInformation;

	@Column(columnDefinition = "int default 0")
	private int idCandidate;

	@Column(columnDefinition = "int default 0")
	private int idJob;

	private String category;
	private String status;
	private String time;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfSet;

}
