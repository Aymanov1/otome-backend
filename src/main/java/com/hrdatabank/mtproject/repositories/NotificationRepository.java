package com.hrdatabank.mtproject.repositories;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.hrdatabank.mtproject.entities.Notification;

// TODO: Auto-generated Javadoc
/**
 * The Interface NotificationRepository.
 */
@Repository
@RepositoryRestResource
public interface NotificationRepository extends JpaRepository<Notification, Serializable> {

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: NotificationRepository.java
	 * 
	 *         Gets the last notification by admin.
	 * @param idAdmin  the id admin
	 * @param pageable the pageable
	 * @return the last notification by admin
	 */
	@Query(value = "select s from Notification s where s.admin.idUser=:idAdmin and  s.notificationDate= CURRENT_DATE and  s.read=false ", countQuery = "select count(*) from Notification s where  s.admin.idUser=:idAdmin  and  s.notificationDate= CURRENT_DATE and  s.read=false ")
	public Page<Notification> getLastNotificationByAdmin(@Param("idAdmin") int idAdmin, Pageable pageable);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: NotificationRepository.java
	 * 
	 *         this method Dismiss all notification admin.
	 * @param idAdmin the id admin
	 */
	@Transactional
	@Modifying
	@Query(value = "update Notification s SET s.read=true WHERE s.admin.idUser=:idAdmin")
	public void dismissAllNotificationAdmin(@Param("idAdmin") int idAdmin);

}
