package com.chaluutali.kululawebapp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.chaluutali.kululawebapp.objects.Extras;

public interface ExtrasRepository extends CrudRepository<Extras, Integer> {

	Iterable<Extras> findByScheduledFlightScheduledFlightId(Integer flightId);

	Optional<Extras> findBySearchLogSearchLogDateId(String searchLogDateId);

}
