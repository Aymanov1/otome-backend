//package org.crawler.web;
//
//import java.util.concurrent.Executor;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
//@EnableAutoConfiguration
//@EnableAsync(proxyTargetClass = true)
//@SpringBootApplication
//public class Application extends SpringBootServletInitializer {
//
//	@Override
//	public SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(Application.class);
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
//	}
//
//	@Bean
//	public Executor taskExecutor() {
//		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//		executor.setCorePoolSize(4);
//		executor.setMaxPoolSize(4);
//		executor.setQueueCapacity(500);
//		executor.setThreadNamePrefix("GithubLookup-");
//		executor.initialize();
//		return executor;
//	}
//}
