package com.chaluutali.kululawebapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaluutali.kululawebapp.objects.Card;
import com.chaluutali.kululawebapp.repository.CardRepository;

@Service
public class CardService {
	
	

	@Autowired
	private CardRepository cardRepository;


	public List<Card> getAllCards(String bookingReference) {
		List<Card> cards = new ArrayList<>();
		cardRepository.findByFlightItineraryBookingReference(bookingReference)
		.forEach(cards::add);
		return cards;
	}

	public Optional<Card> getCard(int cardNumber) {
		return cardRepository.findById(cardNumber);
	}

	public void addCard(Card card) {
		cardRepository.save(card);
		
	}

	public void deleteCard(int cardNumber) {
		cardRepository.deleteById(cardNumber);
		
	}

	public List<Card> getAllCardsByEmail(String emailAddress) {
		List<Card> cards = new ArrayList<>();
		cardRepository.findByUserEmailAddress(emailAddress)
		.forEach(cards::add);
		return cards;
	}

}
