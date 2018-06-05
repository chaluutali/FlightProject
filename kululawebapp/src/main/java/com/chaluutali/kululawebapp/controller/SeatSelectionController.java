package com.chaluutali.kululawebapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chaluutali.kululawebapp.objects.AirCraft;
import com.chaluutali.kululawebapp.objects.ScheduledFlight;
import com.chaluutali.kululawebapp.objects.SearchLog;
import com.chaluutali.kululawebapp.objects.SeatSelectionLog;
import com.chaluutali.kululawebapp.objects.User;
import com.chaluutali.kululawebapp.service.AirCraftService;
import com.chaluutali.kululawebapp.service.SeatSelectionLogService;




@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
public class SeatSelectionController 
{
	
	
	private boolean[] backPrice;
	private boolean[] frontPrice;
	private boolean[] sZonePrice;
	private boolean[] eRowPrice;
	private boolean[] fRowPrice;
	@Autowired
	private SeatSelectionLogService seatSelectionLogService;
	@Autowired
	private AirCraftService airCraftService;

	@RequestMapping("/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/seatselectionlog/all")
	public List<SeatSelectionLog> getAllSeatSelectionLogs(@PathVariable int flightId)
	{
		return seatSelectionLogService.getAllSeatSelectionLogs(flightId);
	}
	@RequestMapping("/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/seatselectionlog")
	public Optional<SeatSelectionLog> getBySearchLogId(@PathVariable String searchLogDateId) 
	{
		return seatSelectionLogService.getBySearchLogId(searchLogDateId);
	}
	@RequestMapping("/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/seatselectionlog/{seatSelectionId}")
	public Optional<SeatSelectionLog> getSeatSelectionLog(@PathVariable int seatSelectionId) 
	{
		return seatSelectionLogService.getSeatSelectionLog(seatSelectionId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/seatselectionlog")
	public void addSeatSelectionLog(@PathVariable String emailAddress, @PathVariable String searchLogDateId, @PathVariable int flightId,  @RequestBody SeatSelectionLog seatSelectionLog)
	{
		Optional <AirCraft> craft = airCraftService.getAirCraftByName(seatSelectionLog.getCraftName());
		int numStandardBack = craft.get().getNumStandardBack();
		int numStandardFront = craft.get().getNumStandardFront();
		int numStretchZone = craft.get().getNumStretchZone();
		int numExitRow = craft.get().getNumExitRow();
		int numFrontRow = craft.get().getNumFrontRow();
		
		backPrice = craft.get().getBackPrice();
		frontPrice = craft.get().getFrontPrice();
		sZonePrice =  craft.get().getsZonePrice();
		eRowPrice = craft.get().geteRowPrice();
		fRowPrice = craft.get().getfRowPrice();
				
				

					if(seatSelectionLog.getSeatType().equals("Back"))
					{
						for(int c = 0; c < numStandardBack; c++)
						{
						
						backPrice[seatSelectionLog.getSeatId()] = true;
						
						}
					}
					if(seatSelectionLog.getSeatType().equals("Front"))
					{
						for(int c = 0; c < numStandardFront; c++)
						{
						
						frontPrice[seatSelectionLog.getSeatId()] = true;
						
						}
					}
					if(seatSelectionLog.getSeatType().equals("sZone"))
					{
						for(int c = 0; c < numStretchZone; c++)
						{
						
						sZonePrice[seatSelectionLog.getSeatId()] = true;
						
						}
					}
					if(seatSelectionLog.getSeatType().equals("eRow"))
					{
						for(int c = 0; c < numExitRow; c++)
						{
						
						eRowPrice[seatSelectionLog.getSeatId()] = true;
						
						}
					}
					if(seatSelectionLog.getSeatType().equals("fRow"))
					{
						for(int c = 0; c < numFrontRow; c++)
						{
						
						fRowPrice[seatSelectionLog.getSeatId()] = true;
						
						}
					}
				
				
		craft.get().setBackPrice(backPrice);
		craft.get().seteRowPrice(eRowPrice);
		craft.get().setFrontPrice(frontPrice);
		craft.get().setfRowPrice(fRowPrice);
		craft.get().setsZonePrice(sZonePrice);
		airCraftService.updateAirCraft(craft.get());
		
		seatSelectionLog.setBackPrice(backPrice);
		seatSelectionLog.seteRowPrice(eRowPrice);
		seatSelectionLog.setFrontPrice(frontPrice);
		seatSelectionLog.setfRowPrice(fRowPrice);
		seatSelectionLog.setsZonePrice(sZonePrice);
		
		//set seat selection
		Optional <SeatSelectionLog> obj = seatSelectionLogService.getSeatSelectionLog(1);
		
		seatSelectionLog.setNumExitRow(0);
		seatSelectionLog.setNumFrontRow(0);
		seatSelectionLog.setNumStandardBack(0);
		seatSelectionLog.setNumStandardFront(0);
		seatSelectionLog.setNumStretchZone(0);
		
		if(seatSelectionLog.getSeatType().equals("Back")) {
			
			
			seatSelectionLog.setExitRowPrice(0);
			seatSelectionLog.setFrontRowPrice(0);
			seatSelectionLog.setStandardBackPrice(obj.get().getStandardBackPrice());
			seatSelectionLog.setStandardFrontPrice(0);
			seatSelectionLog.setStretchZonePrice(0);
		}
		if(seatSelectionLog.getSeatType().equals("Front")) {
			
			
			seatSelectionLog.setExitRowPrice(0);
			seatSelectionLog.setFrontRowPrice(0);
			seatSelectionLog.setStandardBackPrice(0);
			seatSelectionLog.setStandardFrontPrice(obj.get().getFrontRowPrice());
			seatSelectionLog.setStretchZonePrice(0);
		}
		if(seatSelectionLog.getSeatType().equals("sZone")) {
			
			
			seatSelectionLog.setExitRowPrice(0);
			seatSelectionLog.setFrontRowPrice(0);
			seatSelectionLog.setStandardBackPrice(0);
			seatSelectionLog.setStandardFrontPrice(0);
			seatSelectionLog.setStretchZonePrice(obj.get().getStretchZonePrice());
		}
		if(seatSelectionLog.getSeatType().equals("eRow")) {
			
			
			seatSelectionLog.setExitRowPrice(obj.get().getExitRowPrice());
			seatSelectionLog.setFrontRowPrice(0);
			seatSelectionLog.setStandardBackPrice(0);
			seatSelectionLog.setStandardFrontPrice(0);
			seatSelectionLog.setStretchZonePrice(0);
		}
		if(seatSelectionLog.getSeatType().equals("fRow")) {
			
			
			seatSelectionLog.setExitRowPrice(0);
			seatSelectionLog.setFrontRowPrice(obj.get().getFrontRowPrice());
			seatSelectionLog.setStandardBackPrice(0);
			seatSelectionLog.setStandardFrontPrice(0);
			seatSelectionLog.setStretchZonePrice(0);
		}
		
		seatSelectionLog.setAirCraft(craft.get().getAirCraftId());
		seatSelectionLog.setSearchLog(new SearchLog(searchLogDateId, new User(null,null,null,false,null,null,null, emailAddress)));
		seatSelectionLog.setScheduledFlight(new ScheduledFlight(flightId, new SearchLog(searchLogDateId, new User(null,null,null,false,null,null,null, emailAddress))));
		seatSelectionLogService.addSeatSelectionLog(seatSelectionLog);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/seatselectionlog/{seatSelectionId}")
	public void updateSeatSelectionLog(@PathVariable String emailAddress, @PathVariable String searchLogDateId, @PathVariable int flightId,  @RequestBody SeatSelectionLog seatSelectionLog) 
	{
		seatSelectionLog.setScheduledFlight(new ScheduledFlight(flightId, new SearchLog(searchLogDateId, new User(null,null,null,false,null,null,null, emailAddress))));
		seatSelectionLogService.addSeatSelectionLog(seatSelectionLog);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/seatselectionlog/{seatSelectionId}")
	public void deleteSeatSelectionLog(@PathVariable int seatSelectionId) 
	{
		seatSelectionLogService.deleteSeatSelectionLog(seatSelectionId);
	}
	
	
	@Transactional
	@RequestMapping(method = RequestMethod.DELETE, value = "/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/seatselectionlog/bysearchlogdate")
	public void deleteSeatbylogdate(@PathVariable String searchLogDateId) 
	{
		seatSelectionLogService.deleteSeatbylogdate(searchLogDateId);
	}

}
