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
@Table(name = "job_tag_relation")
public class JobTagRelation implements Serializable {

	/**
	 * 
	 */
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
