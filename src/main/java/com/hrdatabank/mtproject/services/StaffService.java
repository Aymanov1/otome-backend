package com.hrdatabank.mtproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hrdatabank.mtproject.entities.Staff;
import com.hrdatabank.mtproject.model.ConnectedStaff;
import com.hrdatabank.mtproject.repositories.StaffRepository;

/**
 * The Class StaffService.
 */
@Service
public class StaffService {

	/** The staff repository. */
	@Autowired
	private StaffRepository staffRepository;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffService.java
	 * 
	 *         Sets the staff repository.
	 * @param staffRepository
	 *            the new staff repository
	 */
	public void setStaffRepository(StaffRepository staffRepository) {
		this.staffRepository = staffRepository;
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
	 *         Class Name: StaffService.java
	 * 
	 *         List all staffs.
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @return the page
	 */
	public Page<Staff> listAllStaffs(int page, int size) {
		return staffRepository.findAll(PageRequest.of(page, size));
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
	 *         Class Name: StaffService.java
	 * 
	 *         Gets the staff by id.
	 * @param id
	 *            the id
	 * @return the staff by id
	 */
	public Optional<Staff> getStaffById(long id) {
		return staffRepository.findById(id);
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
	 *         Class Name: StaffService.java
	 * 
	 *         Save staff.
	 * @param staff
	 *            the staff
	 * @return the staff
	 */
	public Staff saveStaff(Staff staff) {
		return staffRepository.saveAndFlush(staff);
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
	 *         Class Name: StaffService.java
	 * 
	 *         this method Delete staff.
	 * @param idSalon
	 *            the id salon
	 */
	public void deleteStaff(long idSalon) {
		staffRepository.deleteById(idSalon);
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
	 *         Class Name: StaffService.java
	 * 
	 *         Find staff by email.
	 * @param email
	 *            the email
	 * @return the staff
	 */
	public Staff findStaffByEmail(String email) {
		return staffRepository.findStaffByEmail(email);
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
	 *         Class Name: StaffService.java
	 * 
	 *         Find connected staff by email.
	 * @param email
	 *            the email
	 * @return the connected staff
	 */
	public ConnectedStaff findConnectedStaffByEmail(String email) {
		return staffRepository.findConnectedStaffByEmail(email);
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
	 *         Class Name: StaffService.java
	 * 
	 *         Gets the staffs not having yet relations with sops paginated.
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @param keyword
	 *            the keyword
	 * @return the staffs not having yet relations with sops paginated
	 */
	public Page<Staff> getStaffsNotHavingYetRelationsWithSopsPaginated(int page, int size, String keyword) {
		return staffRepository.getStaffsNotHavingYetRelationsWithSopsPaginated(PageRequest.of(page, size), keyword);
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
	 *         Class Name: StaffService.java
	 * 
	 *         Gets the all staffs by keyword paginated.
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @param keyword
	 *            the keyword
	 * @return the all staffs by keyword paginated
	 */
	public Page<Staff> getAllStaffsByKeywordPaginated(int page, int size, String keyword) {
		return staffRepository.getAllStaffsByKeywordPaginated(PageRequest.of(page, size), keyword);
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Wala Ben Amor
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffService.java
	 * 
	 *         Gets the all staffs by keyword paginated.
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @param keyword
	 *            the keyword * @param idCompany the idCompany
	 * @return the all staffs by keyword paginated
	 */

	public Page<Staff> getAllStaffListByIdCompanyPaginated(int page, int size, String keyword, int idCompany) {
		return staffRepository.getAllStaffListByIdCompanyPaginated(PageRequest.of(page, size), keyword, idCompany);
	}

}
