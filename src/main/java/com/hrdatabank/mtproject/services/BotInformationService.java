package com.hrdatabank.mtproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrdatabank.mtproject.entities.BotInformation;
import com.hrdatabank.mtproject.repositories.BotInformationRepository;

@Service
public class BotInformationService {

	@Autowired
	BotInformationRepository botInformationRepository;

	public void setBotInformationRepository(BotInformationRepository botInformationRepository) {
		this.botInformationRepository = botInformationRepository;
	}

	public Iterable<BotInformation> listAllBotInformations() {
		return botInformationRepository.findAll();
	}

	public Optional<BotInformation> getBotInformationById(long id) {
		return botInformationRepository.findById(id);
	}

	public void deleteBotInformation(long idBotInformation) {
		botInformationRepository.deleteById(idBotInformation);
	}

	public BotInformation saveBotInformation(BotInformation botInformation) {
		return botInformationRepository.saveAndFlush(botInformation);
	}

	// scheduler candidate lists for Line
	public List<BotInformation> getList1BotInformation() {
		return botInformationRepository.getList1BotInformation();
	}

	public List<BotInformation> getList5BotInformation() {
		return botInformationRepository.getList5BotInformation();
	}

	public List<BotInformation> getList6BotInformation() {
		return botInformationRepository.getList6BotInformation();
	}

	public List<BotInformation> getList7BotInformation() {
		return botInformationRepository.getList7BotInformation();
	}

	public List<BotInformation> getList8BotInformation() {
		return botInformationRepository.getList8BotInformation();
	}

	public List<BotInformation> getList9BotInformation() {
		return botInformationRepository.getList9BotInformation();
	}

	// scheduler story 46 incomplete search
	public List<BotInformation> getStationIncompleteSearchBotInformation() {
		return botInformationRepository.getStationIncompleteSearchBotInformation();
	}

	public List<BotInformation> getTimeIncompleteSearchBotInformation() {
		return botInformationRepository.getTimeIncompleteSearchBotInformation();
	}

	public List<BotInformation> getCategoryIncompleteSearchBotInformation() {
		return botInformationRepository.getCategoryIncompleteSearchBotInformation();
	}

	// scheduler candidate lists for Messenger
	public List<BotInformation> getMessengerList1BotInformation() {
		return botInformationRepository.getMessengerList1BotInformation();
	}

	public List<BotInformation> getMessengerList5BotInformation() {
		return botInformationRepository.getMessengerList5BotInformation();
	}

	public List<BotInformation> getMessengerList6BotInformation() {
		return botInformationRepository.getMessengerList6BotInformation();
	}

	public List<BotInformation> getMessengerList7BotInformation() {
		return botInformationRepository.getMessengerList7BotInformation();
	}

	public List<BotInformation> getMessengerList8BotInformation() {
		return botInformationRepository.getMessengerList8BotInformation();
	}

	public List<BotInformation> getMessengerList9BotInformation() {
		return botInformationRepository.getMessengerList9BotInformation();
	}

	public List<BotInformation> getMessengerStationIncompleteSearchBotInformation() {
		return botInformationRepository.getMessengerStationIncompleteSearchBotInformation();
	}

	public List<Integer> getSearchIgnoreBotInformation() {
		return botInformationRepository.getSearchIgnoreBotInformation();
	}

	public List<BotInformation> getMessengerTimeIncompleteSearchBotInformation() {
		return botInformationRepository.getMessengerTimeIncompleteSearchBotInformation();
	}

	public List<BotInformation> getMessengerCategoryIncompleteSearchBotInformation() {
		return botInformationRepository.getMessengerCategoryIncompleteSearchBotInformation();
	}

}
