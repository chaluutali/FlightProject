package com.chaluutali.kululawebapp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.chaluutali.kululawebapp.objects.AirCraft;

public interface AirCraftRepository extends CrudRepository<AirCraft, Integer> {

	Optional<AirCraft> findByAircraftName(String name);

}
