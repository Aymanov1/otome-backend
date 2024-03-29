package com.hrdatabank.mtproject.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * UserRole.
 *
 * @author vladimir.stankovic
 * 
 *         Aug 18, 2019
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
 * Class Name: UserRole.java
 * 
 * Instantiates a new user role.
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
 * Class Name: UserRole.java
 * 
 * Instantiates a new user role.
 * @param id the id
 * @param role the role
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
@Table(name = "USER_ROLE")
public class UserRole {

	/**
	 * The Class Id.
	 */
	@Embeddable
	public static class Id implements Serializable {

		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1322120000551624359L;

		/** The user id. */
		@Column(name = "APP_USER_ID")
		protected Long userId;

		/** The role. */
		@Enumerated(EnumType.STRING)
		@Column(name = "ROLE")
		protected Role2 role;

		/**
		 * Copyright (c) 2018 by HRDatabank. All rights reserved.
		 *
		 * @author Hanios
		 * 
		 *         Using JRE: 1.8
		 * 
		 *         Project Name: Module-core-hr
		 * 
		 *         Class Name: UserRole.java
		 * 
		 *         Instantiates a new id.
		 */
		public Id() {
		}

		/**
		 * Copyright (c) 2018 by HRDatabank. All rights reserved.
		 *
		 * @author Hanios
		 * 
		 *         Using JRE: 1.8
		 * 
		 *         Project Name: Module-core-hr
		 * 
		 *         Class Name: UserRole.java
		 * 
		 *         Instantiates a new id.
		 * @param userId
		 *            the user id
		 * @param role
		 *            the role
		 */
		public Id(Long userId, Role2 role) {
			this.userId = userId;
			this.role = role;
		}
	}

	/** The id. */
	@EmbeddedId
	@Builder.Default
	Id id = new Id();

	/** The role. */
	@Enumerated(EnumType.STRING)
	@Column(name = "ROLE", insertable = false, updatable = false)
	protected Role2 role;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: UserRole.java
	 * 
	 *         Gets the role.
	 * @return the role
	 */
	public Role2 getRole() {
		return role;
	}
}
