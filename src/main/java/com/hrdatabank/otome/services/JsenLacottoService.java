package com.hrdatabank.otome.services;

import java.io.IOException;

import org.springframework.stereotype.Service;

/**
 * The Class JsenLacottoService.
 */
@Service
public class JsenLacottoService implements IJsenLacottoService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hrdatabank.otome.services.IJsenLacottoService#importJsenCSV(java.lang.
	 * String)
	 */
	@Override
	public void importJsenCSV(String fileName) throws IOException {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hrdatabank.otome.services.IJsenLacottoService#
	 * importCSVForLacottoJobsWithOpenCsv(java.lang.String)
	 */
	@Override
	public void importCSVForLacottoJobsWithOpenCsv(String fileName) throws IOException {
	}

}
