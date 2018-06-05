package com.chaluutali.kululawebapp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.chaluutali.kululawebapp.objects.SeatSelectionLog;

public interface SeatSelectionLogRepository  extends CrudRepository<SeatSelectionLog, Integer> {

	Iterable<SeatSelectionLog> findByScheduledFlightScheduledFlightId(Integer flightId);

	Optional<SeatSelectionLog> findBySearchLogSearchLogDateId(String searchLogDateId);

	void deleteBySearchLogSearchLogDateId(String searchLogDateId);

}
