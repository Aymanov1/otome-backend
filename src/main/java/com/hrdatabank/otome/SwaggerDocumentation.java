package com.hrdatabank.otome;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The Class SwaggerDocumentation.
 */
@EnableSwagger2
@Configuration
public class SwaggerDocumentation {

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: SwaggerDocumentation.java
	 * 
	 * Product api.
	 * @return the docket
	 */
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.hrdatabank.controllers")).paths(regex("/*.*")).build()
				.apiInfo(metaInfo());
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
	 * Class Name: SwaggerDocumentation.java
	 * 
	 * Meta info.
	 * @return the api info
	 */
	private ApiInfo metaInfo() {

		ApiInfo apiInfo = new ApiInfo("Otome Bot Documentation API", "", "1.0", "Terms of Service",
				new Contact("Otome", "https://www.otomeBot.com", "about.hrdatabank.com"), "Apache License Version 2.0",
				"https://www.apache.org/licesen.html");

		return apiInfo;
	}

}
