package com.hrdatabank.mtproject.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * The Class CandidateAdminRelation.
 */
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="candidate_admin_relation")
@EqualsAndHashCode(callSuper = false)
public class CandidateAdminRelation implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The candidate admin relation PK. */
	@EmbeddedId
	private CandidateAdminRelationPK candidateAdminRelationPK;

	/** The candidate. */
	@ManyToOne
	@JoinColumn(name = "idCandidate", referencedColumnName = "id_user", insertable = false, updatable = false)
	private Candidate candidate;

	/** The admin. */
	@ManyToOne
	@JoinColumn(name = "idAdmin", referencedColumnName = "id_user", insertable = false, updatable = false)
	private Admin admin;

	/** The memos. */
	@OneToMany(mappedBy = "candidateAdminRelation")
	private List<Memo> memos;

}
