package com.hrdatabank.otome.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import com.hrdatabank.mtproject.entities.UserInformation;
import com.hrdatabank.otome.domain.ConfigCrawler;

/**
 * The Class RepositoryConfig. I recently had the same problem and it's because
 * that's how spring-boot-starter-data-rest works by default. See my SO question
 * -> While using Spring Data Rest after migrating an app to Spring Boot, I have
 * observed that entity properties with @Id are no longer marshalled to JSON
 * 
 * To customize how it behaves, you can extend RepositoryRestConfigurerAdapter
 * to expose IDs for specific classes.
 * 
 * 
 */
@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter#
	 * configureRepositoryRestConfiguration(org.springframework.data.rest.core.
	 * config.RepositoryRestConfiguration)
	 */
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(UserInformation.class,ConfigCrawler.class);
	}
}