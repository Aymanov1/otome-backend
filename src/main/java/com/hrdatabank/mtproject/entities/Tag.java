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

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Tag implements Serializable {

	/**
	 * 
	 */
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
