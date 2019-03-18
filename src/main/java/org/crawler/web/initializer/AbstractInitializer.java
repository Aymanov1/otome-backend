package org.crawler.web.initializer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.crawler.web.domain.LogEvents;

import com.hrdatabank.otome.domain.JobOtome;

import lombok.Data;

/**
 * The Class AbstractInitializer.
 * 
 * @author Hanios
 */
@Data
public abstract class AbstractInitializer {

	/** The basics URL website. */
	protected Map<String, String> basicsURLWebsite = new HashMap<>();

	/** The job map. */
	protected HashMap<String, String> jobMap = new HashMap<>();

	/** The visited urls. */
	protected List<String> visitedUrls = new ArrayList<>();

	/** The job details. */
	protected List<JobOtome> jobDetails = new ArrayList<>();

	/** The log exceptions. */
	protected List<LogEvents> logExceptions = new ArrayList<>();

	/**
	 * This method to initialize basicsURlWebsite {@link List}.
	 *
	 * @author Hanios
	 * @param basicsURLWebsite
	 *            empty list of strings
	 */
	public abstract void initializeBasicsURLWebsite(Map<String, String> basicsURLWebsite);

	/**
	 * This method to initialize jobMap {@link Map}.
	 *
	 * @author Hanios
	 * @param jobMap
	 *            empty map of String key and String value
	 */
	public abstract void initializeJobMap(HashMap<String, String> jobMap);

}
