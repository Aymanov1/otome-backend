package com.hrdatabank.mtproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hrdatabank.mtproject.entities.Notification;
import com.hrdatabank.mtproject.repositories.NotificationRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class NotificationService.
 */
@Service
public class NotificationService {

	/** The notification repository. */
	@Autowired
	private NotificationRepository notificationRepository;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: NotificationService.java
	 * 
	 *         Save memo.
	 * @param notification
	 *            the notification
	 * @return the notification
	 */
	public Notification saveMemo(Notification notification) {
		return notificationRepository.save(notification);
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: NotificationService.java
	 * 
	 *         Gets the last notification by admin.
	 * @param idAdmin
	 *            the id admin
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @return the last notification by admin
	 */
	public Page<Notification> getLastNotificationByAdmin(int idAdmin, int page, int size) {
		return notificationRepository.getLastNotificationByAdmin(idAdmin, PageRequest.of(page, size));
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: NotificationService.java
	 * 
	 *         this method Dissmiss all notification for admin.
	 * @param idAdmin
	 *            the id admin
	 */
	public void dissmissAllNotificationForAdmin(int idAdmin) {
		notificationRepository.dismissAllNotificationAdmin(idAdmin);
	}

}
