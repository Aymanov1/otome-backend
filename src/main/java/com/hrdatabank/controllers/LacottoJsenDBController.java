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

@Controller
@RequestMapping("/fetch")
public class LacottoJsenDBController {

	@Autowired
	private JobService jobService;

	@GetMapping
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

}
