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

import com.chaluutali.kululawebapp.objects.FlightItinerary;
import com.chaluutali.kululawebapp.objects.ScheduledFlight;
import com.chaluutali.kululawebapp.objects.SearchLog;
import com.chaluutali.kululawebapp.objects.TravelBank;
import com.chaluutali.kululawebapp.objects.User;
import com.chaluutali.kululawebapp.service.TravelBankService;




@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
public class TravelBankController 
{
	@Autowired
	private TravelBankService travelBankService;

	@RequestMapping("/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/flightitinerary/{bookingReference}/travelbank")
	public List<TravelBank> getAllTravelBanks(@PathVariable String bookingReference)
	{
		return travelBankService.getAllTravelBanks(bookingReference);
	}
	
	@RequestMapping("/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/flightitinerary/{bookingReference}/travelbank/{travelBankId}")
	public Optional<TravelBank> getTravelBank(@PathVariable int travelBankId) 
	{
		return travelBankService.getTravelBank(travelBankId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/flightItinerary/{bookingReference}/travelbank")
	public void addTravelBank(@PathVariable String emailAddress, @PathVariable String searchLogDateId, @PathVariable int flightId, @PathVariable String bookingReference,  @RequestBody TravelBank travelBank)
	{
		travelBank.setFlightItinerary(new FlightItinerary (bookingReference, new ScheduledFlight(flightId, new SearchLog(searchLogDateId, new User(null,null,null,false,null,null,null, emailAddress)))));
		travelBank.setUser(new User(null,null,null,false,null,null,null, emailAddress));
		travelBankService.addTravelBank(travelBank);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/flightItinerary/{bookingReference}/travelbank/{travelBankId}")
	public void updateTravelBank(@PathVariable String emailAddress, @PathVariable String searchLogDateId, @PathVariable int flightId, @PathVariable String bookingReference, @PathVariable int travelBankId,  @RequestBody TravelBank travelBank) 
	{
		travelBank.setFlightItinerary(new FlightItinerary (bookingReference, new ScheduledFlight(flightId, new SearchLog(searchLogDateId, new User(null,null,null,false,null,null,null, emailAddress)))));
		travelBank.setUser(new User(null,null,null,false,null,null,null, emailAddress));
		travelBankService.addTravelBank(travelBank);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/flightItinerary/{bookingReference}/travelbank/{travelBankId}")
	public void deleteTravelBank(@PathVariable int travelBankId) 
	{
		travelBankService.deleteTravelBank(travelBankId);
	}

}
