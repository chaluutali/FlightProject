package com.chaluutali.kululawebapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaluutali.kululawebapp.objects.AirCraft;
import com.chaluutali.kululawebapp.repository.AirCraftRepository;

@Service
public class AirCraftService {
	
	
	@Autowired
	private AirCraftRepository airCraftRepository;

	public List<AirCraft> getAllAirCrafts() {
		
		List<AirCraft> airCrafts = new ArrayList<>();
		airCraftRepository.findAll()
		.forEach(airCrafts::add);
		return airCrafts;
	}

	public Optional<AirCraft> getAirCraft(int airCraftId) {
		return airCraftRepository.findById(airCraftId);
	}

	public void addAirCraft(AirCraft airCraft) {
		airCraftRepository.save(airCraft);
	}

	public void deleteAirCraft(int airCraftId) {
		airCraftRepository.deleteById(airCraftId);
		
	}

	public void updateAirCraft(AirCraft airCraft) {
		airCraftRepository.save(airCraft);
		
	}

	public Optional<AirCraft> getAirCraftByName(String name) {
		
		return airCraftRepository.findByAircraftName(name);
	}

}
