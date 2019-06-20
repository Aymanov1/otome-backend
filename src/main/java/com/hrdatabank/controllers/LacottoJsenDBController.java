package com.hrdatabank.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hrdatabank.otome.domain.Job;
import com.hrdatabank.otome.services.JobService;

@Controller
@RequestMapping("/fetch")
public class LacottoJsenDBController {

	@Autowired
	private JobService jobService;
	private DateFormat format = new SimpleDateFormat();

	@SuppressWarnings("deprecation")
	@GetMapping
	public ResponseEntity<Page<Job>> findAllLacottoJobs(@RequestParam String affiliateType,
			@RequestParam String injectionDate, @RequestParam(name = "numPage", defaultValue = "0") int numPage,
			@RequestParam(name = "size", defaultValue = "10") int size) throws ParseException {

		return ResponseEntity.ok(jobService.findAllJobsByAffiliateInjectionDate(affiliateType,
				format.parse(injectionDate), PageRequest.of(numPage, size)));
	}

}
