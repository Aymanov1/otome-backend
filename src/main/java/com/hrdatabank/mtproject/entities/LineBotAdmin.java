package com.hrdatabank.mtproject.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * The Class LineBotAdmin.
 */
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "line_bot_admin")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class LineBotAdmin implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id line bot admin. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idLineBotAdmin;

	/** The user id line. */
	private String userIdLine;

	/** The channel token. */
	private String channelToken;

	/**
	 * line baito, baitoru, j-sen
	 * 
	 * baito.line.me
	 *
	 * baitoru
	 *
	 * j-sen
	 */
	private String searchAlgorithm;

	private String affiliateType;

	private String hiddenAffiliateType;

	/** The admins. */
	@OneToMany(mappedBy = "lineBotAdmin")
	private List<Admin> admins;

}
