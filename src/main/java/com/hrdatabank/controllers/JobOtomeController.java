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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

/**
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
@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api")
public class JobOtomeController {

	/** The Constant MAX_KM. */
	private static final int MAX_KM = 1;
	private static final String COLON = ":";
	/** The log. */
	private static Logger log = LoggerFactory.getLogger(JobOtomeController.class);

	/** The job otome repository. */
	@Autowired
	private JobOtomeRepository jobOtomeRepository;

	/** The line station otome repository. */
	@Autowired
	private LineStationOtomeRepository lineStationOtomeRepository;

	/**
	 * Retrieve all job otomes.
	 *
	 * @return the list
	 */
	@GetMapping("/jobsOtome")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<JobDto> retrieveAllJobOtomes() {
		return jobOtomeRepository.getAllJobsByDto();
	}

	/**
	 * Retrieve job.
	 *
	 * @param id
	 *            the id
	 * @return the job otome
	 */
	@GetMapping("/jobsOtome/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public JobOtome retrieveJob(@PathVariable long id) {
		Optional<JobOtome> job = jobOtomeRepository.findById(id);
		if (job.isPresent())
			return job.get();

		return (JobOtome) Optional.empty().get();

	}

	/**
	 * Delete job.
	 *
	 * @param id
	 *            the id
	 */
	@DeleteMapping("/jobsOtome/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public void deleteJob(@PathVariable long id) {
		jobOtomeRepository.deleteById(id);
	}

	/**
	 * Gets the job by station time category.
	 *
	 * @param idLineStation
	 *            the id line station
	 * @param positionCategoryEnglish
	 *            the position category english
	 * @param workTimeEnglish
	 *            the work time english
	 * @return the job by station time category
	 */
	@GetMapping("/jobsOtome/getJobByStationTimeCategory")
	@CrossOrigin(origins = "http://localhost:4200")
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
	 * @param idLineStation
	 *            the id line station
	 * @param positionCategoryEnglish
	 *            the position category english
	 * @param workTimeEnglish
	 *            the work time english
	 * @return the jobs by time working
	 */
	@GetMapping("/jobsOtome/getJobsByTimeWorking/{start}/{finish}")
	@CrossOrigin(origins = "http://localhost:4200")
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

	public String convertTime(Long time) {
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		return df.format(time);
	}

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
	 * @param latitudeTocompare
	 *            the latitude tocompare
	 * @param longitudeTocompare
	 *            the longitude tocompare
	 * @param lineStation
	 *            the line station
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
	 * @param job
	 *            the job
	 * @return the response entity
	 */
	@PostMapping("/jobsOtome")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Object> createJobOtome(@RequestBody JobOtome job) {
		JobOtome savedJob = jobOtomeRepository.save(job);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedJob.getIdJob()).toUri();
		return ResponseEntity.created(location).build();
	}

	/**
	 * Update student.
	 *
	 * @param job
	 *            the job
	 * @param id
	 *            the id
	 * @return the response entity
	 */
	@PutMapping("/jobsOtome/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Object> updateJobOtome(@RequestBody JobOtome job, @PathVariable long id) {

		Optional<JobOtome> jobOptional = jobOtomeRepository.findById(id);
		if (!jobOptional.isPresent())
			return ResponseEntity.notFound().build();
		job.setIdJob((int) id);
		jobOtomeRepository.save(job);
		return ResponseEntity.noContent().build();
	}

}