package com.chaluutali.kululawebapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaluutali.kululawebapp.objects.Traveller;
import com.chaluutali.kululawebapp.repository.TravellerRepository;

@Service
public class TravellerService {
	
	
	@Autowired
	private TravellerRepository travellerRepository;

	public List<Traveller> getAllTravellers(Integer flightId) {
		List<Traveller> travellers = new ArrayList<>();
		travellerRepository.findByScheduledFlightScheduledFlightId(flightId)
		.forEach(travellers::add);
		return travellers;
		
	}

	public Optional<Traveller> getTraveller(String emailAddressId) {
		return travellerRepository.findById(emailAddressId);
	}

	public void addTraveller(Traveller traveller) {
		travellerRepository.save(traveller);
		
	}

	public void deleteTraveller(String emailAddressId) {
		travellerRepository.deleteById(emailAddressId);
		
	}

}
