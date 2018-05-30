package com.chaluutali.kululawebapp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.chaluutali.kululawebapp.objects.ShoppingCart;

public interface CartRepository extends CrudRepository<ShoppingCart, Integer> {

	Iterable<ShoppingCart> findByScheduledFlightScheduledFlightId(Integer flightId);

	Optional<ShoppingCart> findBySearchLogSearchLogDateId(String searchlogId);

}
