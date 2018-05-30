package com.chaluutali.kululawebapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaluutali.kululawebapp.objects.SeatSelectionLog;
import com.chaluutali.kululawebapp.repository.SeatSelectionLogRepository;

@Service
public class SeatSelectionLogService {
	
	
	@Autowired
	private SeatSelectionLogRepository seatSelectionLogRepository;

	

	public List<SeatSelectionLog> getAllSeatSelectionLogs(Integer flightId) {
		

		List<SeatSelectionLog> seatSelectionLogs = new ArrayList<>();
		seatSelectionLogRepository.findByScheduledFlightScheduledFlightId(flightId)
		.forEach(seatSelectionLogs::add);
		return seatSelectionLogs;

	}

	public Optional<SeatSelectionLog> getSeatSelectionLog(int seatSelectionId) {
		
		return seatSelectionLogRepository.findById(seatSelectionId);
	}

	public void addSeatSelectionLog(SeatSelectionLog seatSelectionLog) {
		
		seatSelectionLogRepository.save(seatSelectionLog);
	}

	public void deleteSeatSelectionLog(int seatSelectionId) {
		
		seatSelectionLogRepository.deleteById(seatSelectionId);
	}

	public Optional<SeatSelectionLog> getBySearchLogId(String searchLogDateId) {
		
		return seatSelectionLogRepository.findBySearchLogSearchLogDateId(searchLogDateId);
	}

}
