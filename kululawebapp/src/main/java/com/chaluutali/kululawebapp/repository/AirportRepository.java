package com.chaluutali.kululawebapp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.chaluutali.kululawebapp.objects.Airport;

public interface AirportRepository extends CrudRepository<Airport, Integer>{

	
	Optional<Airport> findByAirportName(String name);

}
