package com.hrdatabank.mtproject.repositories;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hrdatabank.mtproject.entities.Alert;

/**
 * The Interface AlertRepository.
 */
@Repository

public interface AlertRepository extends JpaRepository<Alert, Serializable> {

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: AlertRepository.java
	 * 
	 *         Gets the alert list.
	 * @param pageable
	 *            the pageable
	 * @return the alert list
	 */
	@Query(value = "select s from Alert s  order by notificationDate DESC", countQuery = "select count(*) from Alert s  ")
	public Page<Alert> getAlertList(Pageable pageable);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: AlertRepository.java
	 * 
	 *         Gets the alert list by type.
	 * @param pageable
	 *            the pageable
	 * @param type
	 *            the type
	 * @return the alert list by type
	 */
	@Query(value = "select s from Alert s where  s.checked=:type order by notificationDate DESC", countQuery = "select count(*) from Alert s where  s.checked=:type  ")
	public Page<Alert> getAlertListByType(Pageable pageable, @Param("type") boolean type);

}
