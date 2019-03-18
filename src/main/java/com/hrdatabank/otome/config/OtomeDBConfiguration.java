package com.hrdatabank.otome.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * The Class OtomeDBConfiguration.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.hrdatabank.otome.repositories", entityManagerFactoryRef = "otomeDSEmFactory", transactionManagerRef = "otomeDSTransactionManager")
@ComponentScan(basePackages = "com.crawler.web.*")
public class OtomeDBConfiguration {

	/**
	 * Otome DS properties.
	 *
	 * @return the data source properties
	 */
	@Primary
	@Bean
	@ConfigurationProperties("spring.datasource1")
	public DataSourceProperties otomeDSProperties() {
		return new DataSourceProperties();
	}

	/**
	 * Otome DS.
	 *
	 * @param otomeDSProperties
	 *            the otome DS properties
	 * @return the data source
	 */
	@Primary
	@Bean
	public DataSource otomeDS(@Qualifier("otomeDSProperties") DataSourceProperties otomeDSProperties) {
		return otomeDSProperties.initializeDataSourceBuilder().build();
	}

	/**
	 * Otome DS em factory.
	 *
	 * @param otomeDS
	 *            the otome DS
	 * @param builder
	 *            the builder
	 * @return the local container entity manager factory bean
	 */
	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean otomeDSEmFactory(@Qualifier("otomeDS") DataSource otomeDS,
			EntityManagerFactoryBuilder builder) {
		return builder.dataSource(otomeDS).packages("com.hrdatabank.otome.domain").build();
	}

	/**
	 * Otome DS transaction manager.
	 *
	 * @param otomeDSEmFactory
	 *            the otome DS em factory
	 * @return the platform transaction manager
	 */
	@Primary
	@Bean
	public PlatformTransactionManager otomeDSTransactionManager(EntityManagerFactory otomeDSEmFactory) {
		return new JpaTransactionManager(otomeDSEmFactory);
	}

}
