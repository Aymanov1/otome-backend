package com.hrdatabank.mtproject.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * The Class Memo.
 */
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Memo implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id memo. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idMemo;

	/** The memo text. */
	private String memoText;

	/** The memo date. */
	private Date memoDate;

	/** The candidate admin relation. */
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "idCandidate", referencedColumnName = "idCandidate"),
			@JoinColumn(name = "idAdmin", referencedColumnName = "idAdmin") })
	@JsonIgnoreProperties({ "memos" })
	CandidateAdminRelation candidateAdminRelation;

}
