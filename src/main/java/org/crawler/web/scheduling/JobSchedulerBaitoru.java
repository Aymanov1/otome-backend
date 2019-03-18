/**
 * 
 */
package org.crawler.web.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.hrdatabank.otome.repositories.ConfigCrawlerRepository;
import com.hrdatabank.otome.services.JobOtomeService;

/**
 * @author Hanios
 *
 */
@Configuration
@EnableScheduling
public class JobSchedulerBaitoru {
	private static Logger log = LoggerFactory.getLogger(JobSchedulerBaitoru.class);

	@Autowired
	JobOtomeService jobOtomeService;

	@Autowired
	ConfigCrawlerRepository configCrawlerRepository;

	}
