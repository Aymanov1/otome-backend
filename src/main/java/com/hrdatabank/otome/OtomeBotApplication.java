package com.hrdatabank.otome;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * The Class OtomeBotApplication.
 */
@ComponentScan(basePackages = { "com.hrdatabank.otome.*", "com.hrdatabank.otome.security",
		"com.hrdatabank.otome.repositories", "com.hrdatabank.otome.domain", "com.hrdatabank.controllers",
		"com.hrdatabank.otome.services", "com.hrdatabank.otome.config", "com.hrdatabank.mtproject.repositories",
		"com.hrdatabank.mtproject.entities", "com.hrdatabank.mtproject.model", "com.hrdatabank.mtproject.services",
		"com.hrdatabank.mtproject.specifications", "org.crawler.web.*" })
@EnableAsync(proxyTargetClass = true)
@EntityScan(basePackages = { "com.hrdatabank.mtproject.entities", "com.hrdatabank.otome.domain" })
// @EnableJpaRepositories(basePackages = { "com.hrdatabank.otome.repositories",
// "com.hrdatabank.mtproject.repositories" })
@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class })
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class OtomeBotApplication implements CommandLineRunner {

	/** The description. */
	@Value("${myapp.description}")
	String description;

	/** The log. */
	private static Logger log = LoggerFactory.getLogger(OtomeBotApplication.class);

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(OtomeBotApplication.class, args);

	}

	/**
	 * Randomize number.
	 *
	 * @return the int
	 */
	public int randomizeNumber() {
		Random r = new Random();
		int low = 10;
		int high = 100;
		return r.nextInt(high - low) + low;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... arg0) throws Exception {
		log.info(description);
	}

	/**
	 * Sets the time.
	 *
	 * @param hourOfDay
	 *            the hour of day
	 * @param minute
	 *            the minute
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

	@Bean
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(4);
		executor.setMaxPoolSize(4);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("Crawler-");
		executor.initialize();
		return executor;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
