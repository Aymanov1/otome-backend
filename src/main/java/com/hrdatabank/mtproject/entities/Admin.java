package com.hrdatabank.mtproject.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * The Class Admin.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Admin extends UserInformation implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The line bot admin. */
	@ManyToOne
	@JoinColumn(name = "idLineBotAdmin", referencedColumnName = "idLineBotAdmin")
	@JsonIgnoreProperties({ "admins" })
	private LineBotAdmin lineBotAdmin;

	/** The candidate admin relations. */
	@OneToMany(mappedBy = "admin")
	@JsonIgnoreProperties({ "admin", "memos", "candidate" })
	private List<CandidateAdminRelation> candidateAdminRelations;

	/** The notifications. */
	@OneToMany(mappedBy = "admin")
	@JsonIgnore
	private List<Notification> notifications;

	/** The alerts. */
	@OneToMany(mappedBy = "personInCharge")
	@JsonIgnore
	private List<Alert> alerts;

}
