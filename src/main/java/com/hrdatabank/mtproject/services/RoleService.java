package com.hrdatabank.mtproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrdatabank.mtproject.entities.Role;
import com.hrdatabank.mtproject.repositories.RoleRepository;

/**
 * The Class RoleService.
 */
@Service
public class RoleService {

	/** The role repository. */
	@Autowired
	private RoleRepository roleRepository;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: RoleService.java
	 * 
	 *         Sets the role repository.
	 * @param roleRepository
	 *            the new role repository
	 */
	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: RoleService.java
	 * 
	 *         List all roles.
	 * @return the iterable
	 */
	public Iterable<Role> listAllRoles() {
		return roleRepository.findAll();
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: RoleService.java
	 * 
	 *         Gets the role by id.
	 * @param id
	 *            the id
	 * @return the role by id
	 */
	public Optional<Role> getRoleById(long id) {
		return roleRepository.findById(id);
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: RoleService.java
	 * 
	 *         Save role.
	 * @param role
	 *            the role
	 * @return the role
	 */
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: RoleService.java
	 * 
	 *         Find role by name.
	 * @param nameRole
	 *            the name role
	 * @return the role
	 */
	public Role findRoleByName(String nameRole) {
		return roleRepository.findRoleByName(nameRole);
	}

}
