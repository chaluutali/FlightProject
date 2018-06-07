package com.chaluutali.kululawebapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.chaluutali.kululawebapp.objects.TravelBank;

public interface TravelBankRepository extends CrudRepository<TravelBank, Integer> {

	Iterable<TravelBank> findByFlightItineraryBookingReference(String bookingReference);

}
