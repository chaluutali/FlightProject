package com.chaluutali.kululawebapp.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.chaluutali.kululawebapp.objects.ScheduledFlight;

public interface ScheduledFlightRepository extends CrudRepository<ScheduledFlight, Integer> {

	
	
	@Query(
	        value = "SELECT * FROM scheduled_flight where departure_from = :destinationFrom AND arrival_destination = :destinationTo AND departure_date >= :departureDate AND fare_type IS NULL", 
	        nativeQuery=true
	    )
	   List<ScheduledFlight> search( @Param("destinationFrom") String destinationFrom,@Param("destinationTo") String destinationTo, @Param ("departureDate") Date departureDate);

	Optional<ScheduledFlight> findBySearchLogSearchLogDateId(String searchLogDateId);
	
	
	@Query(
	        value = "SELECT * FROM scheduled_flight where departure_date >= :returnDate AND fare_type IS NULL", 
	        nativeQuery=true
	    )
		List<ScheduledFlight> searchByReturnDate( @Param ("returnDate") Date returnDate);

}
