package com.hrdatabank.mtproject.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * The Class UserInformation.
 */
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "user_information")
public class UserInformation implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id user. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_user")
	protected int idUser;

	/** The user name. */
	protected String userName;

	/** The user name Katakana. */
	protected String userNameKatakana;

	/** The email. */
	private String email;

	/** The password. */
	private String password;

	/** The profile picture. */
	private String profilePicture;

	/** The roles. */
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@CollectionTable(name = "user_roles")
	@JoinTable(name = "userRoles", joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id_user"), inverseJoinColumns = @JoinColumn(name = "idRole", referencedColumnName = "id"))
	private List<Role> roles;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: UserInformation.java
	 * 
	 *         Instantiates a new user information.
	 * @param userInformation
	 *            the user information
	 */
	public UserInformation(UserInformation userInformation) {
		super();
		this.idUser = userInformation.idUser;
		this.userName = userInformation.userName;
		this.password = userInformation.password;
		this.email = userInformation.email;

	}

}