package com.hrdatabank.otome.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * The Class MtprojectDBConfiguration.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {
		"com.hrdatabank.mtproject.repositories" }, entityManagerFactoryRef = "mtprojectDSEmFactory", transactionManagerRef = "mtprojectDSTransactionManager")
public class MtprojectDBConfiguration {

	/**
	 * Mtproject DS properties.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: MtprojectDBConfiguration.java
	 * 
	 * Mtproject DS properties.
	 * @return the data source properties
	 */
	@Bean
	@ConfigurationProperties("spring.datasource2")
	public DataSourceProperties mtprojectDSProperties() {
		return new DataSourceProperties();
	}

	/**
	 * Mtproject DS.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: MtprojectDBConfiguration.java
	 * 
	 * Mtproject DS.
	 * @param mtprojectDSProperties the mtproject DS properties
	 * @return the data source
	 */
	@Bean
	public DataSource mtprojectDS(@Qualifier("mtprojectDSProperties") DataSourceProperties mtprojectDSProperties) {
		return mtprojectDSProperties.initializeDataSourceBuilder().build();
	}

	/**
	 * Mtproject DS em factory.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: MtprojectDBConfiguration.java
	 * 
	 * Mtproject DS em factory.
	 * @param mtprojectDS the mtproject DS
	 * @param builder the builder
	 * @return the local container entity manager factory bean
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean mtprojectDSEmFactory(@Qualifier("mtprojectDS") DataSource mtprojectDS,
			EntityManagerFactoryBuilder builder) {
		return builder.dataSource(mtprojectDS).packages("com.hrdatabank.mtproject.entities").build();
	}

	/**
	 * Mtproject DS transaction manager.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: MtprojectDBConfiguration.java
	 * 
	 * Mtproject DS transaction manager.
	 * @param mtprojectDSEmFactory the mtproject DS em factory
	 * @return the platform transaction manager
	 */
	@Bean
	public PlatformTransactionManager mtprojectDSTransactionManager(EntityManagerFactory mtprojectDSEmFactory) {
		return new JpaTransactionManager(mtprojectDSEmFactory);
	}

}
