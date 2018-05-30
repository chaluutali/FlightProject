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
import com.chaluutali.kululawebapp.objects.ShoppingCart;
import com.chaluutali.kululawebapp.objects.User;
import com.chaluutali.kululawebapp.service.FlightItineraryService;




@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
public class FlightItineraryController 
{
	@Autowired
	private FlightItineraryService flightItineraryService;

	@RequestMapping("/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/flightitinerary")
	public List<FlightItinerary> getAllFlightItineraries(@PathVariable int flightId)
	{
		return flightItineraryService.getAllFlightItineraries(flightId);
	}
	
	@RequestMapping("/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/flightitinerary/{bookingReference}")
	public Optional<FlightItinerary> getFlightItinerary(@PathVariable String bookingReference) 
	{
		return flightItineraryService.getFlightItinerary(bookingReference);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/flightitinerary")
	public void addFlightItinerary(@PathVariable String emailAddress, @PathVariable String searchLogDateId, @PathVariable int flightId,@RequestBody FlightItinerary flightItinerary)
	{
		flightItinerary.setScheduledFlight(new ScheduledFlight(flightId, new SearchLog(searchLogDateId, new User(null,null,null,false,null,null,null, emailAddress))));
		flightItinerary.setShoppingCart(new ShoppingCart(flightItinerary.getShoppingCart().getCartId(), new ScheduledFlight(flightId, new SearchLog(searchLogDateId, new User(null,null,null,false,null,null,null, emailAddress))), new SearchLog(searchLogDateId, new User(null,null,null,false,null,null,null, emailAddress))));
		flightItineraryService.addFlightItinerary(flightItinerary);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/flightitinerary/{bookingReference}")
	public void updateFlightItinerary(@PathVariable String emailAddress, @PathVariable String searchLogDateId, @PathVariable int flightId, @PathVariable String bookingReference,  @RequestBody FlightItinerary flightItinerary) 
	{
		flightItinerary.setScheduledFlight(new ScheduledFlight(flightId, new SearchLog(searchLogDateId, new User(null,null,null,false,null,null,null, emailAddress))));
		flightItineraryService.addFlightItinerary(flightItinerary);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/flightItinerary/{bookingReference}")
	public void deleteFlightItinerary(@PathVariable String bookingReference) 
	{
		flightItineraryService.deleteFlightItinerary(bookingReference);
	}

}
