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

import com.chaluutali.kululawebapp.objects.ScheduledFlight;
import com.chaluutali.kululawebapp.objects.SearchLog;
import com.chaluutali.kululawebapp.objects.Traveller;
import com.chaluutali.kululawebapp.objects.User;
import com.chaluutali.kululawebapp.service.TravellerService;




@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
public class TravellerController 
{
	@Autowired
	private TravellerService travellerService;

	@RequestMapping("/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/traveller")
	public List<Traveller> getAllTravellers(@PathVariable int flightId)
	{
		return travellerService.getAllTravellers(flightId);
	}
	
	@RequestMapping("/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/traveller/{emailAddressId}")
	public Optional<Traveller> getTraveller(@PathVariable String emailAddressId) 
	{
		return travellerService.getTraveller(emailAddressId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/traveller")
	public void addTraveller(@PathVariable String emailAddress, @PathVariable String searchLogDateId, @PathVariable int flightId,  @RequestBody Traveller traveller)
	{
		traveller.setScheduledFlight(new ScheduledFlight(flightId, new SearchLog(searchLogDateId, new User(null,null,null,false,null,null,null, emailAddress))));
		travellerService.addTraveller(traveller);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/traveller/{emailAddressId}")
	public void updateTraveller(@PathVariable String emailAddress, @PathVariable String searchLogDateId, @PathVariable int flightId, @PathVariable String emailAddressId,  @RequestBody Traveller traveller) 
	{
		traveller.setScheduledFlight(new ScheduledFlight(flightId, new SearchLog(searchLogDateId, new User(null,null,null,false,null,null,null, emailAddress))));
		travellerService.addTraveller(traveller);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/traveller/{emailAddressId}")
	public void deleteTraveller(@PathVariable String emailAddressId) 
	{
		travellerService.deleteTraveller(emailAddressId);
	}

}
