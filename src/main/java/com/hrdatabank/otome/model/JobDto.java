package com.hrdatabank.otome.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class JobDto {
	private long idJob;
	private String shopName;
	private String jobURL;
	private String positionName;
	private String positionCategory;
	private String shopAddress;
	private String hourlyWage;
	private String affiliateType;
	private boolean transportation;
	private boolean status;
	private Date startTime;
	private Date finishTime;

}
