package com.chaluutali.kululawebapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaluutali.kululawebapp.objects.TravelBank;
import com.chaluutali.kululawebapp.repository.TravelBankRepository;


@Service
public class TravelBankService {
	
	
	
	@Autowired
	private TravelBankRepository travelBankRepository;


	public List<TravelBank> getAllTravelBanks(String bookingReference) {
		List<TravelBank> travelBanks = new ArrayList<>();
		travelBankRepository.findByFlightItineraryBookingReference(bookingReference)
		.forEach(travelBanks::add);
		return travelBanks;
	}

	public Optional<TravelBank> getTravelBank(int travelBankId) {
		return travelBankRepository.findById(travelBankId);
	}

	public void addTravelBank(TravelBank travelBank) {
		travelBankRepository.save(travelBank);
		
	}

	public void deleteTravelBank(int travelBankId) {
		travelBankRepository.deleteById(travelBankId);
		
	}

}
