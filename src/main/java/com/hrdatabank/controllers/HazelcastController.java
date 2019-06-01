package com.hrdatabank.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrdatabank.otome.model.JobDto;
import com.hrdatabank.otome.services.HazelCastJobService;

@RestController
@RequestMapping("/actuator")
public class HazelcastController {
	/** The Constant LOGGER. */
	private static final Logger logger = LoggerFactory.getLogger(HazelcastController.class);

//	@Autowired
//	HazelCastJobService hazelCastJobService;
//
//	@GetMapping("/allJobsOtome")
//	@CrossOrigin(origins = "http://localhost:4200")
//	public List<JobDto> retrieveAllJobOtomes() {
//		logger.info("####", hazelCastJobService.findAllJobs().size());
//		return hazelCastJobService.findAllJobs();
//	}
}
