package com.chaluutali.kululawebapp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.chaluutali.kululawebapp.objects.TravelBank;

public interface TravelBankRepository extends CrudRepository<TravelBank, Integer> {

	Iterable<TravelBank> findByFlightItineraryBookingReference(String bookingReference);

	Optional<TravelBank> findByUserEmailAddress(String emailAddress);

}
