package com.chaluutali.kululawebapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.chaluutali.kululawebapp.objects.PerPersonFares;

public interface PerPersonFaresRepository extends CrudRepository<PerPersonFares, Integer> {
	
	public List<PerPersonFares> findByScheduledFlightScheduledFlightId(Integer flightId);

	public void save(Optional<PerPersonFares> fares);

	public Optional<PerPersonFares> findBySearchLogSearchLogDateId(String searchLogDateId);

}
