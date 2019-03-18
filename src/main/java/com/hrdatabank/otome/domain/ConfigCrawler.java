package com.hrdatabank.otome.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostUpdate;

import lombok.Data;

@Entity
@Data
//@EntityListeners(JobSchedulerBaitoru.class)
public class ConfigCrawler {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String scheduler;
	private String schedulerShopName;

	@PostUpdate
	void onPostUpdate() {
		System.out.println("MyEntity.onPostUpdate() " + scheduler);
	}
}
