package com.hrdatabank.mtproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hrdatabank.mtproject.entities.Admin;
import com.hrdatabank.mtproject.repositories.AdminRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminService.
 */
@Service
public class AdminService {

	/** The admin repository. */
	@Autowired
	private AdminRepository adminRepository;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: AdminService.java
	 * 
	 *         Sets the admin repository.
	 * @param adminRepository
	 *            the new admin repository
	 */
	public void setAdminRepository(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
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
	 *         Class Name: AdminService.java
	 * 
	 *         List all admins.
	 * @return the iterable
	 */
	public Iterable<Admin> listAllAdmins() {
		return adminRepository.findAll();
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
	 *         Class Name: AdminService.java
	 * 
	 *         Gets the admin by id.
	 * @param id
	 *            the id
	 * @return the admin by id
	 */
	public Optional<Admin> getAdminById(int id) {
		return adminRepository.findById(id);
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
	 *         Class Name: AdminService.java
	 * 
	 *         this method Delete admin.
	 * @param admin the admin
	 */
	public void deleteAdmin(Admin admin) {
		adminRepository.delete(admin);
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
	 *         Class Name: AdminService.java
	 * 
	 *         Save admin.
	 * @param admin
	 *            the admin
	 * @return the admin
	 */
	public Admin saveAdmin(Admin admin) {
		return adminRepository.saveAndFlush(admin);
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
	 *         Class Name: AdminService.java
	 * 
	 *         Find admin by email.
	 * @param emailAdmin
	 *            the email admin
	 * @return the admin
	 */
	public Admin findAdminByEmail(String emailAdmin) {
		return adminRepository.findAdminByEmail(emailAdmin);
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
	 *         Class Name: AdminService.java
	 * 
	 *         Find admin by name.
	 * @param nameAdmin
	 *            the name admin
	 * @return the admin
	 */
	public Admin findAdminByName(String nameAdmin) {
		return adminRepository.findAdminByName(nameAdmin);
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
	 *         Class Name: AdminService.java
	 * 
	 *         Find all admins by keyword paginated.
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @param keyword
	 *            the keyword
	 * @return the page
	 */
	public Page<Admin> findAllAdminsByKeywordPaginated(int page, int size, String keyword) {
		return adminRepository.findAllAdminsByKeywordPaginated(PageRequest.of(page, size), keyword);
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: AdminService.java
	 * 
	 * Gets the all admins.
	 * @return the all admins
	 */
	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}

}
