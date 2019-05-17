package com.hrdatabank.controllers;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrdatabank.otome.domain.JobOtome;
import com.hrdatabank.otome.domain.NearestStationOtome;
import com.hrdatabank.otome.services.JobOtomeService;
import com.hrdatabank.otome.services.NearestStationOtomeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * The Class NearestStationOtomeController.
 */
@RestController
@RequestMapping("/nearestStation")
public class NearestStationOtomeController {

	/** The log. */
	private static Logger log = LoggerFactory.getLogger(JobOtomeController.class);

	/** The nearest station otome service. */
	@Autowired
	private NearestStationOtomeService nearestStationOtomeService;

	/** The job otome service. */
	@Autowired
	private JobOtomeService jobOtomeService;

	/**
	 * Gets the job nearest station.
	 *
	 * @param idNearestStation
	 *            the id nearest station
	 * @param maxKm
	 *            the max km
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @return the job nearest station
	 */
	@ApiOperation(value = "get Job Nearest Station")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success/ OK response"),
			@ApiResponse(code = 401, message = "Unauthorized Action"),
			@ApiResponse(code = 403, message = "Forbidden Action"),
			@ApiResponse(code = 500, message = "Internal Server ERROR ") })
	@GetMapping("/jobs")
	ResponseEntity<LinkedHashMap<String, Object>> getJobNearestStation(
			@RequestParam(name = "idNearestStation", defaultValue = "0") int idNearestStation,
			@RequestParam(name = "maxKm", defaultValue = "10") int maxKm,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {
		Optional<NearestStationOtome> nearestStation = nearestStationOtomeService
				.findNearestStationById(idNearestStation);

		if (!nearestStation.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		Page<JobOtome> jobs = new PageImpl<>(Collections.emptyList());
		Page<JobOtome> jobPagesPrevious = new PageImpl<>(Collections.emptyList());
		Page<JobOtome> jobPagesNext = new PageImpl<>(Collections.emptyList());
		int nearestStationCd = nearestStation.get().getIdNearestStationCD();
		int incremantId = 0;
		int pageN = 0;
		int deliveredpage = 0;

		while (incremantId < 15 && !(jobPagesPrevious.hasContent() || jobPagesNext.hasContent())) {
			incremantId = incremantId + 1;
			log.info("time to complete : {}", incremantId);
			NearestStationOtome nearestStationNext = nearestStationOtomeService
					.getNearStationByIdLineCD(nearestStationCd + incremantId);
			NearestStationOtome nearestStationPrevious = nearestStationOtomeService
					.getNearStationByIdLineCD(nearestStationCd - incremantId);
			if (nearestStationPrevious != null) {
				System.out.println(page - deliveredpage + "************nearestStationPrevious**************"
						+ nearestStationPrevious.getIdNearestStation());
				jobPagesPrevious = jobOtomeService.getJobsByStationAndJobCategory(page - deliveredpage, size,
						nearestStationPrevious.getLatitudeStation(), nearestStationPrevious.getLongitudeStation(),
						maxKm);
			}

			if (nearestStationNext != null) {
				pageN = page - deliveredpage - jobPagesPrevious.getTotalPages() >= 0
						? page - deliveredpage - jobPagesPrevious.getTotalPages()
						: page;
				System.out.println("************nearestStationNext**************"
						+ nearestStationNext.getIdNearestStation() + "***" + pageN);

				jobPagesNext = jobOtomeService.getJobsByStationAndJobCategory(pageN, size,
						nearestStationNext.getLatitudeStation(), nearestStationNext.getLongitudeStation(), maxKm);
			}
			deliveredpage = deliveredpage + jobPagesPrevious.getTotalPages() + jobPagesNext.getTotalPages();
			System.out.println(
					"***********jobPagesPrevious.getTotalPages()**************" + jobPagesPrevious.getTotalPages());
			System.out.println("***********jobPagesNext.getTotalPages()**************" + jobPagesNext.getTotalPages());

			System.out.println("***********deliveredpage**************" + deliveredpage);

			System.out
					.println("***********jobPagesPrevious.hasContent()***************" + jobPagesPrevious.hasContent());

			System.out.println("***********jobPagesNext.hasContent()***************" + jobPagesNext.hasContent());

		}
		System.out.println("************incremantId**************" + incremantId);
		int nearestStationId = 0;
		if (incremantId < 15) {
			if (jobPagesPrevious.hasContent()) {
				System.out.println("************station**************" + (idNearestStation - incremantId));
				nearestStationId = idNearestStation - incremantId;
				jobs = jobPagesPrevious;
			} else {
				System.out.println("************station**************" + (idNearestStation + incremantId));
				nearestStationId = idNearestStation + incremantId;

				jobs = jobPagesNext;
			}
		}

		if (jobs.hasContent()) {
			LinkedHashMap<String, Object> result = new LinkedHashMap<>();

			result.put("return_code", "0");
			result.put("jobs", jobs.getContent().stream().map(jobToJobDto).collect(Collectors.toList()));
			result.put("idNearestStation", nearestStationId);

			return new ResponseEntity<>(result, HttpStatus.OK);

		} else {
			return new ResponseEntity<>(new LinkedHashMap<>(), HttpStatus.OK);
		}

	}

	/** The job to job dto. */
	Function<JobOtome, LinkedHashMap<String, Object>> jobToJobDto = (JobOtome j) -> {
		LinkedHashMap<String, Object> jobDetail = new LinkedHashMap<>();
		jobDetail.put("idJob", j.getIdJob());
		jobDetail.put("positionCategoryEnglish", j.getPositionCategoryEnglish());
		jobDetail.put("positionCategoryJapanese", j.getPositionCategoryJapanese());
		jobDetail.put("jobURL", j.getJobURL());
		jobDetail.put("workTimeEnglish", j.getWorkTimeEnglish());
		jobDetail.put("workTimeJapanese", j.getWorkTimeJapanese());
		jobDetail.put("positionName", j.getPositionName());
		jobDetail.put("salaryDetail", j.getSalaryDetail());
		jobDetail.put("jobDetails", j.getJobDetails());
		jobDetail.put("jobType", j.getJobType());
		jobDetail.put("interviewType", j.getInterviewType());
		jobDetail.put("salary", j.getSalary());
		jobDetail.put("hourlyWage", j.getHourlyWage());
		jobDetail.put("openJobDate", j.getOpenJobDate());
		jobDetail.put("validJobDate", j.getValidJobDate());
		jobDetail.put("imageURL", j.getPictureJob());
		jobDetail.put("affiliateType", j.getAffiliateType());
		return jobDetail;
	};

}
