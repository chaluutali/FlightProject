package com.chaluutali.kululawebapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chaluutali.kululawebapp.objects.AirCraft;
import com.chaluutali.kululawebapp.objects.ScheduledFlight;
import com.chaluutali.kululawebapp.objects.SearchLog;
import com.chaluutali.kululawebapp.objects.User;
import com.chaluutali.kululawebapp.security.JwtGenerator;
import com.chaluutali.kululawebapp.service.AirCraftService;
import com.chaluutali.kululawebapp.service.ScheduledFlightService;
import io.jsonwebtoken.Jwt;



@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
public class ScheduledFlightController 
{
	@Autowired
	private ScheduledFlightService scheduledFlightService;
	
	@Autowired
	private AirCraftService airCraftService;
	
	@Autowired
	private JwtGenerator jwtGenerator;
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/{emailAddress}/searchlog/{searchLogDateId}/search")
	public List<ScheduledFlight> search(@PathVariable String emailAddress, @PathVariable String searchLogDateId,@RequestBody SearchLog searchLog)
	{
		
		return scheduledFlightService.search(searchLog);
	}
	@RequestMapping(method = RequestMethod.POST, value = "/user/{emailAddress}/searchlog/{searchLogDateId}/searchbyreturn")
	public List<ScheduledFlight> searchByReturnDate(@PathVariable String emailAddress, @PathVariable String searchLogDateId,@RequestBody SearchLog searchLog)
	{
		
		return scheduledFlightService.searchByReturnDate(searchLog);
	}
	
	
	
	
	
	@RequestMapping(method = RequestMethod.POST, value ="/user/{emailAddress}/searchlog/{searchLogDateId}/flight/selection")
	public Jwt selection(@PathVariable String emailAddress, @PathVariable String searchLogDateId,@RequestBody ScheduledFlight scheduledFlight) {
		
		
		Optional<AirCraft> obj = airCraftService.getAirCraftByName(scheduledFlight.getFlightNumber());
		scheduledFlight.setFlightNumber(obj.get().getAircraftName());
		scheduledFlight.setCarrierName(obj.get().getCarrierName());
		scheduledFlight.setAirCraftType(obj.get().getAircraftType());
		scheduledFlight.setSearchLog(new SearchLog(searchLogDateId, new User(null,null,null,false,null,null,null, emailAddress)));
		scheduledFlightService.addFlight(scheduledFlight);
		return jwtGenerator.generate(scheduledFlight.getScheduledFlightId()); 
		
	}

	@RequestMapping("/user/{emailAddress}/searchlog/{searchLogDateId}/flight/all")
	public List<ScheduledFlight> getAllFlights()
	{
		return scheduledFlightService.getAllFlights();
	}
	@RequestMapping("/user/{emailAddress}/searchlog/{searchLogDateId}/flight")
	public Optional<ScheduledFlight> getFlightBySearchLogDate(@PathVariable String searchLogDateId) 
	{
		return scheduledFlightService.getFlightBySearchLogDate(searchLogDateId);
	}
	
	@RequestMapping("/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}")
	public Optional<ScheduledFlight> getFlight(@PathVariable Integer flightId) 
	{
		return scheduledFlightService.getFlight(flightId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/{emailAddress}/searchlog/{searchLogDateId}/flight")
	public void addFlight(@PathVariable String emailAddress, @PathVariable String searchLogDateId,@RequestBody ScheduledFlight scheduledFlight)
	{

		Optional<AirCraft> obj = airCraftService.getAirCraftByName(scheduledFlight.getFlightNumber());
		scheduledFlight.setFlightNumber(obj.get().getAircraftName());
		scheduledFlight.setCarrierName(obj.get().getCarrierName());
		scheduledFlight.setAirCraftType(obj.get().getAircraftType());
		scheduledFlight.setSearchLog(new SearchLog(searchLogDateId, new User(null,null,null,false,null,null,null, emailAddress)));
		scheduledFlightService.addFlight(scheduledFlight);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}")
	public void updateFlight(@PathVariable String emailAddress, @PathVariable String searchLogDateId, @PathVariable int flightId ,@RequestBody ScheduledFlight scheduledFlight) 
	{
		scheduledFlight.setSearchLog(new SearchLog(searchLogDateId, new User(null,null,null,false,null,null,null, emailAddress)));
		scheduledFlightService.addFlight(scheduledFlight);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}")
	public void deleteFlight(@PathVariable int flightId) 
	{
		scheduledFlightService.deleteFlight(flightId);
	}

}
