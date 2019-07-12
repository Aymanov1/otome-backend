package com.hrdatabank.otome.services;

import java.io.IOException;

/**
 * The Interface IJsenLacottoService.
 */
public interface IJsenLacottoService {


	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: IJsenLacottoService.java
	 * 
	 *         this method Import jsen CSV.
	 * @param fileName
	 *            the file name
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void importJsenCSV(String fileName) throws IOException;

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: IJsenLacottoService.java
	 * 
	 *         this method Import CSV for lacotto jobs with open csv.
	 * @param fileName
	 *            the file name
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void importCSVForLacottoJobsWithOpenCsv(String fileName) throws IOException;
}
