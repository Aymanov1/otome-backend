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

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public WebSecurity(UserDetailsServiceImpl userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("helloooooo");
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
				.antMatchers("/crawler/**").permitAll()
				.anyRequest().authenticated().and().addFilter(new JWTAuthenticationFilter(authenticationManager()))
				.addFilter(new JWTAuthorizationFilter(authenticationManager())).sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// this disables session creation on Spring Security

	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		configuration.setAllowedMethods(Arrays.asList("HEAD", "OPTIONS", "GET", "PUT", "POST", "DELETE", "PATCH"));
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}
