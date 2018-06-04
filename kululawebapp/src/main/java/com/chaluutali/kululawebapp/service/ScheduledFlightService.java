package com.chaluutali.kululawebapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaluutali.kululawebapp.objects.ScheduledFlight;
import com.chaluutali.kululawebapp.objects.SearchLog;
import com.chaluutali.kululawebapp.repository.ScheduledFlightRepository;


@Service
public class ScheduledFlightService {
	
	
	@Autowired
	private ScheduledFlightRepository scheduledFlightRepository;
	
	

	public List<ScheduledFlight> getAllFlights() {
		List<ScheduledFlight> scheduledFlights = new ArrayList<>();
		scheduledFlightRepository.findAll()
		.forEach(scheduledFlights::add);
		return scheduledFlights;
		
	}

	public Optional<ScheduledFlight> getFlight(int flightId) {
		return scheduledFlightRepository.findById(flightId);
	}

	public void addFlight(ScheduledFlight scheduledFlight) {
		scheduledFlightRepository.save(scheduledFlight);
		
	}

	public void deleteFlight(int flightId) {
		scheduledFlightRepository.deleteById(flightId);
		
	}

	public List<ScheduledFlight> search(SearchLog searchLog) {
		 List<ScheduledFlight> scheduledFlights = new ArrayList<>();
		 scheduledFlightRepository.search(searchLog.getDestinationFrom(),searchLog.getDestinationTo(),searchLog.getDepartureDate())
		 .forEach(scheduledFlights::add);
		 return scheduledFlights;
		 
	}

	public Optional<ScheduledFlight> getFlightBySearchLogDate(String searchLogDateId) {
		
		return scheduledFlightRepository.findBySearchLogSearchLogDateId(searchLogDateId);
	}

	public List<ScheduledFlight> searchByReturnDate(SearchLog searchLog) {
		List<ScheduledFlight> scheduledFlights = new ArrayList<>();
		 scheduledFlightRepository.searchByReturnDate(searchLog.getReturnDate())
		 .forEach(scheduledFlights::add);
		 return scheduledFlights;
	}

}
