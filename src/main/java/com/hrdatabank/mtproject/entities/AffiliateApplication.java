package com.hrdatabank.mtproject.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "affiliate_application")
public class AffiliateApplication implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The id AffiliateApplication. */
	@Id
	@SequenceGenerator(name = "affiliateapplicationidentifier", sequenceName = "AFFILAPPLICATION_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "affiliateapplicationidentifier")
	private int idAffiliateApplication;
	/** The program Name. */
	private String programName;
	/** The affilPayment. */
	private String affilPayment;
	/** The referrer. */
	private String referrer;
	/** The device. */
	private String device;
	/** The click Date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date clickDate;
	/** The order Date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;
	/** The approval Date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date approvalDate;

}
