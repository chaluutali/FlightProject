package com.chaluutali.kululawebapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaluutali.kululawebapp.objects.Extras;
import com.chaluutali.kululawebapp.repository.ExtrasRepository;

@Service
public class ExtrasService {
	
	@Autowired
	private ExtrasRepository extrasRepository;

	public List<Extras> getAllExtras(Integer flightId) {
		
		List<Extras> extras2 = new ArrayList<>();
		extrasRepository.findByScheduledFlightScheduledFlightId(flightId)
		.forEach(extras2::add);
		return extras2;
	}

	public Optional<Extras> getExtras(int extrasId) {
		
		return extrasRepository.findById(extrasId);
	}

	public void addExtras(Extras extras) {
		
		extrasRepository.save(extras);
		
	}

	public void deleteExtras(int extrasId) {
		extrasRepository.deleteById(extrasId);
	}

	public Optional<Extras> getBySearchLogId(String searchLogDateId) {
		
		return extrasRepository.findBySearchLogSearchLogDateId(searchLogDateId);
	}
	

}
