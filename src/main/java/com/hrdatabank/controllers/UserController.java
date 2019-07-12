package com.hrdatabank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrdatabank.otome.domain.ApplicationUser;
import com.hrdatabank.otome.repositories.ApplicationUserRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * The Class UserController.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/users")
public class UserController {

	/** The application user repository. */
	@Autowired
	private ApplicationUserRepository applicationUserRepository;

	/** The b crypt password encoder. */
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	/**
	 * Instantiates a new user controller.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: UserController.java
	 * 
	 * Instantiates a new user controller.
	 * @param applicationUserRepository            the application user repository
	 * @param bCryptPasswordEncoder            the b crypt password encoder
	 */
	public UserController(ApplicationUserRepository applicationUserRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.applicationUserRepository = applicationUserRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	/**
	 * Sign up.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: UserController.java
	 * 
	 * this method Sign up.
	 * @param user            the user
	 */
	@ApiOperation(value = "sign Up")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success/ OK response"),
			@ApiResponse(code = 401, message = "Unauthorized Action"),
			@ApiResponse(code = 403, message = "Forbidden Action"),
			@ApiResponse(code = 500, message = "Internal Server ERROR ") })
	@PostMapping("/sign-up")
	public void signUp(@RequestBody ApplicationUser user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		applicationUserRepository.saveAndFlush(user);
	}
}