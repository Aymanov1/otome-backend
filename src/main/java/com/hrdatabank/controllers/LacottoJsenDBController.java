package com.hrdatabank.controllers;

import java.text.ParseException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hrdatabank.otome.services.JobService;

/**
 * The Class LacottoJsenDBController.
 */
@Controller
@RequestMapping("/fetch")
public class LacottoJsenDBController {

	/** The job service. */
	@Autowired
	private JobService jobService;

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: LacottoJsenDBController.java
	 * 
	 * Find all lacotto jsen jobs.
	 * @param affiliateType the affiliate type
	 * @param injectionDate the injection date
	 * @param numPage the num page
	 * @param size the size
	 * @return the response entity
	 * @throws ParseException the parse exception
	 */
	@GetMapping(value = "/jobs")
	public ResponseEntity<?> findAllLacottoJsenJobs(@RequestParam String affiliateType,
			@RequestParam String injectionDate, @RequestParam(name = "numPage", defaultValue = "0") int numPage,
			@RequestParam(name = "size", defaultValue = "10") int size) throws ParseException {
		if (affiliateType.equalsIgnoreCase("j-sen") || affiliateType.equalsIgnoreCase("jsen")
				|| affiliateType.equalsIgnoreCase("lacotto")) {
			return ResponseEntity.ok(jobService.findAllJobsByAffiliateInjectionDate(affiliateType,
					LocalDate.parse(injectionDate), PageRequest.of(numPage, size)));
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
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
	 * Class Name: LacottoJsenDBController.java
	 * 
	 * Count all lacotto jsen jobs.
	 * @param affiliateType the affiliate type
	 * @param injectionDate the injection date
	 * @return the response entity
	 */
	@GetMapping(value = "/count")
	public ResponseEntity<?> countAllLacottoJsenJobs(@RequestParam String affiliateType,
			@RequestParam String injectionDate) {
		if (affiliateType.equalsIgnoreCase("j-sen") || affiliateType.equalsIgnoreCase("jsen")
				|| affiliateType.equalsIgnoreCase("lacotto")) {

			return ResponseEntity.ok(jobService
					.findAllJobsByAffiliateInjectionDate(affiliateType, LocalDate.parse(injectionDate)).size());

		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(0);
	}

}
