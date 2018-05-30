package com.chaluutali.kululawebapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.chaluutali.kululawebapp.objects.FlightItinerary;

public interface FlightItineraryRepository extends CrudRepository<FlightItinerary, String> {

	Iterable<FlightItinerary> findByScheduledFlightScheduledFlightId(Integer flightId);

}
