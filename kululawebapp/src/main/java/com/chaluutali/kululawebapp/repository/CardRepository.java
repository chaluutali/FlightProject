package com.chaluutali.kululawebapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.chaluutali.kululawebapp.objects.Card;

public interface CardRepository extends CrudRepository<Card, Integer> {

	Iterable<Card> findByFlightItineraryBookingReference(String bookingReference);

	Iterable<Card> findByUserEmailAddress(String emailAddress);

}
