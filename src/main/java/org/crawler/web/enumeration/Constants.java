package org.crawler.web.enumeration;

import lombok.Getter;

@Getter
public enum Constants {
	HH_MM("HH:mm");

	Constants(String value) {
		this.value = value;

	}

	private String value;
}
