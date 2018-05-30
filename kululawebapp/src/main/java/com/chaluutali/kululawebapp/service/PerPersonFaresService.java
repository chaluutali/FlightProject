package com.chaluutali.kululawebapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaluutali.kululawebapp.objects.PerPersonFares;
import com.chaluutali.kululawebapp.repository.PerPersonFaresRepository;


@Service
public class PerPersonFaresService {
	
	@Autowired
	private  PerPersonFaresRepository perPersonFaresRepository;
	

	public List<PerPersonFares> getAllPerPersonFares(Integer flightId) {
		
		List<PerPersonFares> perPersonFares2 = new ArrayList<>();
		perPersonFaresRepository.findByScheduledFlightScheduledFlightId(flightId)
		.forEach(perPersonFares2::add);
		return perPersonFares2;
	}

	public Optional<PerPersonFares> getPerPersonFares(int perPersonFaresId) {
		
		return perPersonFaresRepository.findById(perPersonFaresId);
	}

	public void addPerPersonFares(PerPersonFares perPersonFares) {
		
		perPersonFaresRepository.save(perPersonFares);
	}

	public void deletePerPersonFares(int perPersonFaresId) {
		perPersonFaresRepository.deleteById(perPersonFaresId);
		
	}

	public void selectFlight(Optional<PerPersonFares> fares) {
		
		perPersonFaresRepository.save(fares);
		
	}

	public Optional<PerPersonFares> getFare(int i) {

		return perPersonFaresRepository.findById(i);
	}

	public Optional<PerPersonFares> getBySearchLogId(String searchLogDateId) {
		
		return perPersonFaresRepository.findBySearchLogSearchLogDateId(searchLogDateId);
	}


}
