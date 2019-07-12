package com.hrdatabank.otome.security;

import static com.hrdatabank.otome.security.SecurityConstants.API_DOC;
import static com.hrdatabank.otome.security.SecurityConstants.SIGN_UP_URL;
import static com.hrdatabank.otome.security.SecurityConstants.SWAGGER;
import static com.hrdatabank.otome.security.SecurityConstants.SWAGGER_JSON;
import static com.hrdatabank.otome.security.SecurityConstants.SWAGGER_RESOURCES;
import static com.hrdatabank.otome.security.SecurityConstants.WEBJARS;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * The Class WebSecurity.
 */
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	/** The user details service. */
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	/** The b crypt password encoder. */
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: WebSecurity.java
	 * 
	 * Instantiates a new web security.
	 * @param userDetailsService the user details service
	 * @param bCryptPasswordEncoder the b crypt password encoder
	 */
	public WebSecurity(UserDetailsServiceImpl userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/**
		 * works fine with permit all
		 */
		http.cors().and().csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll()
				.antMatchers(HttpMethod.GET, SWAGGER).permitAll()
				.antMatchers(API_DOC, SWAGGER_RESOURCES, SWAGGER, WEBJARS, SWAGGER_JSON).permitAll()
				.antMatchers("/actuator/**").permitAll()
				.antMatchers("/sftp/**").permitAll()
				.antMatchers("/test/**").permitAll()
				.antMatchers("/fetch/**").permitAll()
				.antMatchers("/api/jobOtomes/search/**").permitAll()
				.anyRequest().authenticated()
				.and().addFilter(new JWTAuthenticationFilter(authenticationManager()))
				.addFilter(new JWTAuthorizationFilter(authenticationManager())).sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// this disables session creation on Spring Security

	}

	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
	 */
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
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
	 * Class Name: WebSecurity.java
	 * 
	 * Cors configuration source.
	 * @return the cors configuration source
	 */
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		configuration.setAllowedMethods(Arrays.asList("HEAD", "OPTIONS", "GET", "PUT", "POST", "DELETE", "PATCH"));
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}
