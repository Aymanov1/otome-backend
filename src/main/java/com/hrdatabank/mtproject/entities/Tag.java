package com.hrdatabank.mtproject.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class Tag.
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
 * Class Name: Tag.java
 * 
 * Instantiates a new tag.
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
 * Class Name: Tag.java
 * 
 * Instantiates a new tag.
 * @param idTag the id tag
 * @param tagText the tag text
 * @param tagDate the tag date
 * @param jobTagRelations the job tag relations
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
public class Tag implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id tag. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idTag;

	/** The memo text. */
	private String tagText;

	/** The tag date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date tagDate;

	/** The job candidate relations. */
	@OneToMany(mappedBy = "tag", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({ "tag" })
	private List<JobTagRelation> jobTagRelations;

}
