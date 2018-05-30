package com.chaluutali.kululawebapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.chaluutali.kululawebapp.objects.Traveller;

public interface TravellerRepository extends CrudRepository<Traveller, String> {

	Iterable<Traveller> findByScheduledFlightScheduledFlightId(Integer flightId);

}
