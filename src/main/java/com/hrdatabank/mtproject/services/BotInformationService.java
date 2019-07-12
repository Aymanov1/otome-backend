package com.hrdatabank.mtproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrdatabank.mtproject.entities.BotInformation;
import com.hrdatabank.mtproject.repositories.BotInformationRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class BotInformationService.
 */
@Service
public class BotInformationService {

	/** The bot information repository. */
	@Autowired
	BotInformationRepository botInformationRepository;

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationService.java
	 * 
	 * Sets the bot information repository.
	 * @param botInformationRepository the new bot information repository
	 */
	public void setBotInformationRepository(BotInformationRepository botInformationRepository) {
		this.botInformationRepository = botInformationRepository;
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationService.java
	 * 
	 * List all bot informations.
	 * @return the iterable
	 */
	public Iterable<BotInformation> listAllBotInformations() {
		return botInformationRepository.findAll();
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationService.java
	 * 
	 * Gets the bot information by id.
	 * @param id the id
	 * @return the bot information by id
	 */
	public Optional<BotInformation> getBotInformationById(long id) {
		return botInformationRepository.findById(id);
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationService.java
	 * 
	 * this method Delete bot information.
	 * @param idBotInformation the id bot information
	 */
	public void deleteBotInformation(long idBotInformation) {
		botInformationRepository.deleteById(idBotInformation);
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationService.java
	 * 
	 * Save bot information.
	 * @param botInformation the bot information
	 * @return the bot information
	 */
	public BotInformation saveBotInformation(BotInformation botInformation) {
		return botInformationRepository.saveAndFlush(botInformation);
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationService.java
	 * 
	 * Gets the list 1 bot information.
	 * @return the list 1 bot information
	 */
	// scheduler candidate lists for Line
	public List<BotInformation> getList1BotInformation() {
		return botInformationRepository.getList1BotInformation();
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationService.java
	 * 
	 * Gets the list 5 bot information.
	 * @return the list 5 bot information
	 */
	public List<BotInformation> getList5BotInformation() {
		return botInformationRepository.getList5BotInformation();
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationService.java
	 * 
	 * Gets the list 6 bot information.
	 * @return the list 6 bot information
	 */
	public List<BotInformation> getList6BotInformation() {
		return botInformationRepository.getList6BotInformation();
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationService.java
	 * 
	 * Gets the list 7 bot information.
	 * @return the list 7 bot information
	 */
	public List<BotInformation> getList7BotInformation() {
		return botInformationRepository.getList7BotInformation();
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationService.java
	 * 
	 * Gets the list 8 bot information.
	 * @return the list 8 bot information
	 */
	public List<BotInformation> getList8BotInformation() {
		return botInformationRepository.getList8BotInformation();
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationService.java
	 * 
	 * Gets the list 9 bot information.
	 * @return the list 9 bot information
	 */
	public List<BotInformation> getList9BotInformation() {
		return botInformationRepository.getList9BotInformation();
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationService.java
	 * 
	 * Gets the station incomplete search bot information.
	 * @return the station incomplete search bot information
	 */
	// scheduler story 46 incomplete search
	public List<BotInformation> getStationIncompleteSearchBotInformation() {
		return botInformationRepository.getStationIncompleteSearchBotInformation();
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationService.java
	 * 
	 * Gets the time incomplete search bot information.
	 * @return the time incomplete search bot information
	 */
	public List<BotInformation> getTimeIncompleteSearchBotInformation() {
		return botInformationRepository.getTimeIncompleteSearchBotInformation();
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationService.java
	 * 
	 * Gets the category incomplete search bot information.
	 * @return the category incomplete search bot information
	 */
	public List<BotInformation> getCategoryIncompleteSearchBotInformation() {
		return botInformationRepository.getCategoryIncompleteSearchBotInformation();
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationService.java
	 * 
	 * Gets the messenger list 1 bot information.
	 * @return the messenger list 1 bot information
	 */
	// scheduler candidate lists for Messenger
	public List<BotInformation> getMessengerList1BotInformation() {
		return botInformationRepository.getMessengerList1BotInformation();
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationService.java
	 * 
	 * Gets the messenger list 5 bot information.
	 * @return the messenger list 5 bot information
	 */
	public List<BotInformation> getMessengerList5BotInformation() {
		return botInformationRepository.getMessengerList5BotInformation();
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationService.java
	 * 
	 * Gets the messenger list 6 bot information.
	 * @return the messenger list 6 bot information
	 */
	public List<BotInformation> getMessengerList6BotInformation() {
		return botInformationRepository.getMessengerList6BotInformation();
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationService.java
	 * 
	 * Gets the messenger list 7 bot information.
	 * @return the messenger list 7 bot information
	 */
	public List<BotInformation> getMessengerList7BotInformation() {
		return botInformationRepository.getMessengerList7BotInformation();
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationService.java
	 * 
	 * Gets the messenger list 8 bot information.
	 * @return the messenger list 8 bot information
	 */
	public List<BotInformation> getMessengerList8BotInformation() {
		return botInformationRepository.getMessengerList8BotInformation();
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationService.java
	 * 
	 * Gets the messenger list 9 bot information.
	 * @return the messenger list 9 bot information
	 */
	public List<BotInformation> getMessengerList9BotInformation() {
		return botInformationRepository.getMessengerList9BotInformation();
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationService.java
	 * 
	 * Gets the messenger station incomplete search bot information.
	 * @return the messenger station incomplete search bot information
	 */
	public List<BotInformation> getMessengerStationIncompleteSearchBotInformation() {
		return botInformationRepository.getMessengerStationIncompleteSearchBotInformation();
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationService.java
	 * 
	 * Gets the search ignore bot information.
	 * @return the search ignore bot information
	 */
	public List<Integer> getSearchIgnoreBotInformation() {
		return botInformationRepository.getSearchIgnoreBotInformation();
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationService.java
	 * 
	 * Gets the messenger time incomplete search bot information.
	 * @return the messenger time incomplete search bot information
	 */
	public List<BotInformation> getMessengerTimeIncompleteSearchBotInformation() {
		return botInformationRepository.getMessengerTimeIncompleteSearchBotInformation();
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationService.java
	 * 
	 * Gets the messenger category incomplete search bot information.
	 * @return the messenger category incomplete search bot information
	 */
	public List<BotInformation> getMessengerCategoryIncompleteSearchBotInformation() {
		return botInformationRepository.getMessengerCategoryIncompleteSearchBotInformation();
	}

}
