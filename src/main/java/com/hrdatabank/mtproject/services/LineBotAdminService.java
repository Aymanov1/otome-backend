package com.hrdatabank.mtproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrdatabank.mtproject.entities.LineBotAdmin;
import com.hrdatabank.mtproject.repositories.LineBotAdminRepository;

/**
 * The Class LineBotAdminService.
 */
@Service
public class LineBotAdminService {

	/** The line bot admin repository. */
	@Autowired
	LineBotAdminRepository lineBotAdminRepository;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: LineBotAdminService.java
	 * 
	 *         Gets the line bot admin by ID.
	 * @param idLineBotAdmin
	 *            the id line bot admin
	 * @return the line bot admin by ID
	 */
	public Optional<LineBotAdmin> getLineBotAdminByID(long idLineBotAdmin) {

		return lineBotAdminRepository.findById(idLineBotAdmin);
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
	 *         Class Name: LineBotAdminService.java
	 * 
	 *         Save line bot admin.
	 * @param lineBotAdmin
	 *            the line bot admin
	 * @return the line bot admin
	 */
	public LineBotAdmin saveLineBotAdmin(LineBotAdmin lineBotAdmin) {
		return lineBotAdminRepository.save(lineBotAdmin);
	}

}
