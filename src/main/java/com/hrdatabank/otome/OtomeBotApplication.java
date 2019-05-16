package com.hrdatabank.otome;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
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
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import com.hrdatabank.otome.domain.ConfigCrawler;
import com.hrdatabank.otome.repositories.ApplicationUserRepository;
import com.hrdatabank.otome.repositories.ConfigCrawlerRepository;

import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

// TODO: Auto-generated Javadoc
/**
 * The Class OtomeBotApplication.
 */

// scan otome bot parts
@ComponentScan(basePackages = { "com.hrdatabank.otome.*", "com.hrdatabank.otome.model", "com.hrdatabank.otome.security",
		"com.hrdatabank.otome.repositories", "com.hrdatabank.otome.domain", "com.hrdatabank.controllers",
		"com.hrdatabank.otome.services", "com.hrdatabank.otome.config", "org.crawler.web.*",
		"org.crawler.web.crawlcontroller" })
// scan joboty parts after migration to spring 2
@ComponentScan(basePackages = { "com.hrdatabank.mtproject.repositories", "com.hrdatabank.mtproject.entities",
		"com.hrdatabank.mtproject.model", "com.hrdatabank.mtproject.services",
		"com.hrdatabank.mtproject.specifications", })
@EnableAsync(proxyTargetClass = true)
@EntityScan(basePackages = { "com.hrdatabank.mtproject.entities", "com.hrdatabank.otome.domain" })
@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class })
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class OtomeBotApplication implements CommandLineRunner {

	/** The description. */
	@Value("${myapp.description}")
	String description;

	/** The connection pool size. */
	@Value("${spring.datasource.maximum-pool-size}")
	private int connectionPoolSize;

	/** The application user repository. */
	@Autowired
	ApplicationUserRepository applicationUserRepository;

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
	 * Inits the.
	 *
	 * @param configRepository
	 *            the config repository
	 * @return the application runner
	 */
	@Bean
	ApplicationRunner init(ConfigCrawlerRepository configRepository) {

		if (configRepository.findAll().isEmpty()) {
			ConfigCrawler configCrawler = new ConfigCrawler();
			configCrawler.setScheduler("0 0 0 * * *");
			configCrawler.setSchedulerShopName("0 0 0 * * *");
			configRepository.save(configCrawler);

		}
		return args -> configRepository.findAll().forEach(e -> {
			System.out.println(e);
		});
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

	/**
	 * Task executor.
	 *
	 * @return the executor for crawling process
	 */
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

	/**
	 * B crypt password encoder.
	 *
	 * @return the bcrypt password encoder for registration
	 */
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * Jdbc scheduler.
	 *
	 * @return the scheduler of database in order to prepare JPA connection to be
	 *         reactive
	 */
	@Bean
	public Scheduler jdbcScheduler() {
		return Schedulers.fromExecutor(Executors.newFixedThreadPool(connectionPoolSize));
	}

	/**
	 * Transaction template.
	 *
	 * @param transactionManager
	 *            the transaction manager
	 * @return the transaction template in order to prepare JPA connection to be
	 *         reactive
	 */
	@Bean
	public TransactionTemplate transactionTemplate(PlatformTransactionManager transactionManager) {
		return new TransactionTemplate(transactionManager);
	}

}
