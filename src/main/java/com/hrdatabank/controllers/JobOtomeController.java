package com.hrdatabank.controllers;

import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hrdatabank.otome.domain.JobOtome;
import com.hrdatabank.otome.domain.LineStationOtome;
import com.hrdatabank.otome.model.JobDto;
import com.hrdatabank.otome.repositories.JobOtomeRepository;
import com.hrdatabank.otome.repositories.LineStationOtomeRepository;
import com.hrdatabank.otome.services.JobOtomeService;
import com.hrdatabank.otome.services.JobOtomeServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Flux;

// TODO: Auto-generated Javadoc
/**
 * The Class JobOtomeController.
 */
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data
/**
 * Instantiates a new job otome controller.
 */

/**
 * Copyright (c) 2019 by HRDatabank. All rights reserved.
 *
 * @author Aymanov
 * 
 * Using JRE: 1.8
 * 
 * Project Name: otome-backend
 * 
 * Class Name: JobOtomeController.java
 * 
 * Instantiates a new job otome controller.
 */
@NoArgsConstructor

/**
 * Instantiates a new job otome controller.
 *
 * @param jobOtomeRepository
 *            the job otome repository
 * @param lineStationOtomeRepository
 *            the line station otome repository
 */

/**
 * Instantiates a new job otome controller.
 *
 * @param jobOtomeRepository the job otome repository
 * @param jobOtomeService the job otome service
 * @param jobOtomeServiceImpl the job otome service impl
 * @param lineStationOtomeRepository the line station otome repository
 */

/**
 * Copyright (c) 2019 by HRDatabank. All rights reserved.
 *
 * @author Aymanov
 * 
 * Using JRE: 1.8
 * 
 * Project Name: otome-backend
 * 
 * Class Name: JobOtomeController.java
 * 
 * Instantiates a new job otome controller.
 * @param jobOtomeRepository the job otome repository
 * @param jobOtomeService the job otome service
 * @param jobOtomeServiceImpl the job otome service impl
 * @param lineStationOtomeRepository the line station otome repository
 */
@AllArgsConstructor
@RestController
@CrossOrigin(origins = "**")
@RequestMapping(path = "/api")
public class JobOtomeController {

	/** The Constant MAX_KM. */
	private static final int MAX_KM = 1;
	
	/** The Constant COLON. */
	private static final String COLON = ":";
	/** The log. */
	private static Logger log = LoggerFactory.getLogger(JobOtomeController.class);

	/** The job otome repository. */
	@Autowired
	private JobOtomeRepository jobOtomeRepository;

	/** The job otome service. */
	@Autowired
	private JobOtomeService jobOtomeService;

	/** The job otome service impl. */
	@Autowired
	private JobOtomeServiceImpl jobOtomeServiceImpl;

	/** The line station otome repository. */
	@Autowired
	private LineStationOtomeRepository lineStationOtomeRepository;

	/**
	 * Retrieve all job otomes.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobOtomeController.java
	 * 
	 * Retrieve all job otomes.
	 * @return the list
	 */
	@ApiOperation(value = "get Jobs in reactive way")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success/ OK response"),
			@ApiResponse(code = 401, message = "Unauthorized Action"),
			@ApiResponse(code = 403, message = "Forbidden Action"),
			@ApiResponse(code = 500, message = "Internal Server ERROR ") })
	@GetMapping("/jobsOtome")
	public Flux<JobDto> retrieveAllJobOtomes() {
		return jobOtomeServiceImpl.findAllJobDTO();
	}

	/**
	 * Retrieve job.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobOtomeController.java
	 * 
	 * Retrieve job.
	 * @param id            the id
	 * @return the job otome
	 */
	@ApiOperation(value = "Retrieve Job")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success/ OK response"),
			@ApiResponse(code = 401, message = "Unauthorized Action"),
			@ApiResponse(code = 403, message = "Forbidden Action"),
			@ApiResponse(code = 500, message = "Internal Server ERROR ") })
	@GetMapping("/jobsOtome/{id}")
	public JobOtome retrieveJob(@PathVariable long id) {
		Optional<JobOtome> job = jobOtomeRepository.findById(id);
		if (job.isPresent())
			return job.get();

		return (JobOtome) Optional.empty().get();

	}

	/**
	 * Delete job.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobOtomeController.java
	 * 
	 * this method Delete job.
	 * @param id            the id
	 */
	@ApiOperation(value = "Delete Job")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success/ OK response"),
			@ApiResponse(code = 401, message = "Unauthorized Action"),
			@ApiResponse(code = 403, message = "Forbidden Action"),
			@ApiResponse(code = 500, message = "Internal Server ERROR ") })
	@DeleteMapping("/jobsOtome/{id}")
	public void deleteJob(@PathVariable long id) {
		jobOtomeRepository.deleteById(id);
	}

	/**
	 * Gets the job by station time category.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobOtomeController.java
	 * 
	 * Gets the job by station time category.
	 * @param idLineStation            the id line station
	 * @param positionCategoryEnglish            the position category english
	 * @param workTimeEnglish            the work time english
	 * @return the job by station time category
	 */
	@ApiOperation(value = "get Jobs By Station, Time and Category")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success/ OK response"),
			@ApiResponse(code = 401, message = "Unauthorized Action"),
			@ApiResponse(code = 403, message = "Forbidden Action"),
			@ApiResponse(code = 500, message = "Internal Server ERROR ") })
	@GetMapping("/jobsOtome/getJobByStationTimeCategory")
	public List<JobOtome> getJobByStationTimeCategory(@RequestParam(name = "idLineStation") long idLineStation,
			@RequestParam(name = "positionCategoryEnglish") String positionCategoryEnglish,
			@RequestParam(name = "workTimeEnglish") String workTimeEnglish) {
		long start = System.currentTimeMillis();
		List<JobOtome> jobs = Collections.emptyList();
		Optional<LineStationOtome> lineStationOtome = lineStationOtomeRepository.findById(idLineStation);
		if (lineStationOtome.isPresent()) {
			jobs = jobOtomeRepository.findAll().stream()
					.filter(job -> job.getPositionCategoryEnglish().contains(positionCategoryEnglish)
							&& job.getWorkTimeEnglish().equalsIgnoreCase(workTimeEnglish))
					.filter(e -> compareStationToShopAddress(e.getLatitude(), e.getLongitude(), lineStationOtome.get()))
					.collect(Collectors.toList());
			log.info("time to complete : {}", System.currentTimeMillis() - start);
		}

		return jobs;
	}

	/**
	 * Gets the jobs by time working.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobOtomeController.java
	 * 
	 * Gets the jobs by time working.
	 * @param start the start
	 * @param finish the finish
	 * @return the jobs by time working
	 */
	@ApiOperation(value = "Get Jobs By Time Working")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success/ OK response"),
			@ApiResponse(code = 401, message = "Unauthorized Action"),
			@ApiResponse(code = 403, message = "Forbidden Action"),
			@ApiResponse(code = 500, message = "Internal Server ERROR ") })
	@GetMapping("/jobsOtome/getJobsByTimeWorking/{start}/{finish}")
	public List<JobOtome> getJobsByTimeWorking(@PathVariable String start, @PathVariable String finish) {
		Date startTime = setTime(Integer.parseInt(start.substring(0, start.indexOf(COLON))),
				Integer.parseInt(start.substring(start.indexOf(COLON) + 1), start.length()));
		log.info("time to complete : {}", convertTime(startTime.getTime()));
		Date finishTime = setTime(Integer.parseInt(finish.substring(0, finish.indexOf(COLON))),
				Integer.parseInt(finish.substring(finish.indexOf(COLON) + 1), finish.length()));
		log.info("time to complete : {}", convertTime(finishTime.getTime()));

		jobOtomeRepository.findAll().forEach(e -> log.info("time from job: {}", e.getStartTime().getTime()));
		return jobOtomeRepository.findAll().stream().filter(job -> job.getStartTime().getTime() == startTime.getTime()
				&& job.getFinishTime().getTime() == finishTime.getTime()).collect(Collectors.toList());
	}

	/**
	 * Convert time.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobOtomeController.java
	 * 
	 * Convert time.
	 * @param time the time
	 * @return the string
	 */
	public String convertTime(Long time) {
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		return df.format(time);
	}

	/**
	 * Sets the time.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobOtomeController.java
	 * 
	 * Sets the time.
	 * @param hourOfDay the hour of day
	 * @param minute the minute
	 * @return the date
	 */
	public Date setTime(int hourOfDay, int minute) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
		cal.set(Calendar.MINUTE, minute);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * Compare station to shop address.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobOtomeController.java
	 * 
	 * Compare station to shop address.
	 * @param latitudeTocompare            the latitude tocompare
	 * @param longitudeTocompare            the longitude tocompare
	 * @param lineStation            the line station
	 * @return true, if successful
	 */
	public boolean compareStationToShopAddress(double latitudeTocompare, double longitudeTocompare,
			LineStationOtome lineStation) {

		return (Math.acos(Math.sin(Math.toRadians(latitudeTocompare))
				* Math.sin(Math.toRadians(lineStation.getLatitude()))
				+ Math.cos(Math.toRadians(latitudeTocompare)) * Math.cos(Math.toRadians(lineStation.getLatitude())
						* Math.cos(Math.toRadians(lineStation.getLongitude()) - (Math.toRadians(longitudeTocompare)))))
				* 6371) <= MAX_KM;

	}

	/**
	 * Creates the student.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobOtomeController.java
	 * 
	 * Creates the job otome.
	 * @param job            the job
	 * @return the response entity
	 */
	@ApiOperation(value = "Create new Job")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success/ OK response"),
			@ApiResponse(code = 401, message = "Unauthorized Action"),
			@ApiResponse(code = 403, message = "Forbidden Action"),
			@ApiResponse(code = 500, message = "Internal Server ERROR ") })
	@PostMapping("/jobsOtome")
	public ResponseEntity<Object> createJobOtome(@RequestBody JobOtome job) {
		JobOtome savedJob = jobOtomeRepository.save(job);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedJob.getIdJob()).toUri();
		return ResponseEntity.created(location).build();
	}

	/**
	 * Update student.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobOtomeController.java
	 * 
	 * Update job otome.
	 * @param job            the job
	 * @param id            the id
	 * @return the response entity
	 */
	@ApiOperation(value = "Updating Job")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success/ OK response"),
			@ApiResponse(code = 401, message = "Unauthorized Action"),
			@ApiResponse(code = 403, message = "Forbidden Action"),
			@ApiResponse(code = 500, message = "Internal Server ERROR ") })
	@PutMapping("/jobsOtome/{id}")
	public ResponseEntity<Object> updateJobOtome(@RequestBody JobOtome job, @PathVariable long id) {

		Optional<JobOtome> jobOptional = jobOtomeRepository.findById(id);
		if (!jobOptional.isPresent())
			return ResponseEntity.notFound().build();
		job.setIdJob((int) id);
		jobOtomeRepository.save(job);
		return ResponseEntity.noContent().build();
	}

}