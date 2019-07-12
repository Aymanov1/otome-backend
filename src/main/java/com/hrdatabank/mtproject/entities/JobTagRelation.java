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

// TODO: Auto-generated Javadoc
/**
 * The Class JobTagRelation.
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
 * Class Name: JobTagRelation.java
 * 
 * Instantiates a new job tag relation.
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
 * Class Name: JobTagRelation.java
 * 
 * Instantiates a new job tag relation.
 * @param jobTagRelationPK the job tag relation PK
 * @param job the job
 * @param tag the tag
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
@Table(name = "job_tag_relation")
public class JobTagRelation implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The job tag relation PK. */
	@EmbeddedId
	private JobTagRelationPK jobTagRelationPK;

	/** The job. */
	@ManyToOne
	@JoinColumn(name = "idJob", referencedColumnName = "idJob", insertable = false, updatable = false)
	@JsonIgnoreProperties({ "jobCandidateRelations", "shopCandidateRelations", "jobTagRelations" })
	private Job job;

	/** The tag. */
	@ManyToOne
	@JoinColumn(name = "idTag", referencedColumnName = "idTag", insertable = false, updatable = false)
	@JsonIgnoreProperties({ "jobTagRelations" })
	private Tag tag;

}
