package com.chaluutali.kululawebapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaluutali.kululawebapp.objects.Airport;
import com.chaluutali.kululawebapp.repository.AirportRepository;



@Service
public class AirportService {
	
	@Autowired
	private AirportRepository airportRepository;

	public List<Airport> getAllAirports() {
		List<Airport> airports = new ArrayList<>();
		airportRepository.findAll()
		.forEach(airports::add);
		return airports;
	}

	public Optional<Airport> getAirport(int airportId) {
		return airportRepository.findById(airportId);
	}

	public Optional<Airport> getAirportByName(String name) {
		return airportRepository.findByAirportName(name);
	}

	public void addAirport(Airport airport) {
		airportRepository.save(airport);
		
	}

	public void deleteAirport(int airportId) {
		airportRepository.deleteById(airportId);
		
	}

	

}
