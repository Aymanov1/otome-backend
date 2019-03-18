package com.hrdatabank.mtproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hrdatabank.mtproject.entities.UserInformation;
import com.hrdatabank.mtproject.repositories.UserRepository;

/**
 * The Class UserService.
 */
@Service
public class UserService {

	/** The user repository. */
	@Autowired
	private UserRepository userRepository;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: UserService.java
	 * 
	 *         Sets the user repository.
	 * @param userRepository
	 *            the new user repository
	 */
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
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
	 *         Class Name: UserService.java
	 * 
	 *         List all users.
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @return the page
	 */
	public Page<UserInformation> listAllUsers(int page, int size) {
		return userRepository.findAll(PageRequest.of(page, size));
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
	 *         Class Name: UserService.java
	 * 
	 *         Gets the user by id.
	 * @param id
	 *            the id
	 * @return the user by id
	 */
	public Optional<UserInformation> getUserById(int id) {
		return userRepository.findById(id);
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
	 *         Class Name: UserService.java
	 * 
	 *         Save user.
	 * @param user
	 *            the user
	 * @return the user information
	 */
	public UserInformation saveUser(UserInformation user) {
		return userRepository.save(user);
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
	 *         Class Name: UserService.java
	 * 
	 *         this method Delete user.
	 * @param idSalon
	 *            the id salon
	 */
	public void deleteUser(int idSalon) {
		userRepository.deleteById(idSalon);
	}

}
