package com.chaluutali.kululawebapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaluutali.kululawebapp.objects.FlightItinerary;
import com.chaluutali.kululawebapp.repository.FlightItineraryRepository;

@Service
public class FlightItineraryService {
	

	@Autowired
	private FlightItineraryRepository flightItineraryRepository;

	public List<FlightItinerary> getAllFlightItineraries(Integer flightId) {
		
		
		List<FlightItinerary> flightItineries = new ArrayList<>();
		flightItineraryRepository.findByScheduledFlightScheduledFlightId(flightId)
		.forEach(flightItineries::add);
		return flightItineries;
	}

	public Optional<FlightItinerary> getFlightItinerary(String bookingReference) {

		return flightItineraryRepository.findById(bookingReference);
	}

	public void addFlightItinerary(FlightItinerary flightItinerary) {
		
		flightItineraryRepository.save(flightItinerary);
	}

	public void deleteFlightItinerary(String bookingReference) {
		
		flightItineraryRepository.deleteById(bookingReference);
		
	}

	public List<FlightItinerary> getAllFlightItinerariesByEmail(String emailAddress) {

		List<FlightItinerary> flightItineries = new ArrayList<>();
		flightItineraryRepository.findByScheduledFlightSearchLogUserEmailAddress(emailAddress)
		.forEach(flightItineries::add);
		return flightItineries;
	}

	

}
