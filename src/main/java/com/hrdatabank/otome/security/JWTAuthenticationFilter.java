package com.hrdatabank.otome.security;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static com.hrdatabank.otome.security.SecurityConstants.EXPIRATION_TIME;
import static com.hrdatabank.otome.security.SecurityConstants.HEADER_STRING;
import static com.hrdatabank.otome.security.SecurityConstants.SECRET;
import static com.hrdatabank.otome.security.SecurityConstants.TOKEN_PREFIX;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrdatabank.otome.domain.ApplicationUser;

/**
 * The Class JWTAuthenticationFilter.
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	/** The authentication manager. */
	private AuthenticationManager authenticationManager;

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JWTAuthenticationFilter.java
	 * 
	 * Instantiates a new JWT authentication filter.
	 * @param authenticationManager the authentication manager
	 */
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter#attemptAuthentication(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) {
		try {
			ApplicationUser creds = new ObjectMapper().readValue(req.getInputStream(), ApplicationUser.class);

			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(creds.getUsername(),
					creds.getPassword(), new ArrayList<>()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter#successfulAuthentication(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain, org.springframework.security.core.Authentication)
	 */
	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {

		String token = JWT.create().withSubject(((User) auth.getPrincipal()).getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME)).sign(HMAC512(SECRET.getBytes()));

		res.addHeader("Access-Control-Expose-Headers", "authorization");
		res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
		res.addHeader("Content-Type", "application/json");
		res.addHeader("Access-Control-Allow-Methods", "DELETE,POST, GET, PUT, OPTIONS");
		PrintWriter tokenwriter = res.getWriter();
		tokenwriter.write("{ \"token\": \""+ TOKEN_PREFIX + token+"\", \"username\":\""+((User) auth.getPrincipal()).getUsername()+"\"}");
		
	}
}
