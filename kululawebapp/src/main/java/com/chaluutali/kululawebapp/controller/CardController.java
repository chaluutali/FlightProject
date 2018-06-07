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

import com.chaluutali.kululawebapp.objects.Card;
import com.chaluutali.kululawebapp.objects.FlightItinerary;
import com.chaluutali.kululawebapp.objects.ScheduledFlight;
import com.chaluutali.kululawebapp.objects.SearchLog;
import com.chaluutali.kululawebapp.objects.User;
import com.chaluutali.kululawebapp.service.CardService;




@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
public class CardController 
{
	@Autowired
	private CardService cardService;

	@RequestMapping("/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/flightitinerary/{bookingReference}/card")
	public List<Card> getAllCards(@PathVariable String bookingReference)
	{
		return cardService.getAllCards(bookingReference);
	}
	
	@RequestMapping("/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/flightitinerary/{bookingReference}/card/{cardNumber}")
	public Optional<Card> getCard(@PathVariable int cardNumber) 
	{
		return cardService.getCard(cardNumber);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/flightItinerary/{bookingReference}/card")
	public void addCard(@PathVariable String emailAddress, @PathVariable String searchLogDateId, @PathVariable int flightId, @PathVariable String bookingReference,  @RequestBody Card card)
	{
		card.setFlightItinerary(new FlightItinerary (bookingReference, new ScheduledFlight(flightId, new SearchLog(searchLogDateId, new User(null,null,null,false,null,null,null, emailAddress)))));
		card.setUser(new User(null,null,null,false,null,null,null, emailAddress));
		cardService.addCard(card);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/flightItinerary/{bookingReference}/card/{cardNumber}")
	public void updateCard(@PathVariable String emailAddress, @PathVariable String searchLogDateId, @PathVariable int flightId, @PathVariable String bookingReference, @PathVariable int cardNumber,  @RequestBody Card card) 
	{
		card.setFlightItinerary(new FlightItinerary (bookingReference, new ScheduledFlight(flightId, new SearchLog(searchLogDateId, new User(null,null,null,false,null,null,null, emailAddress)))));
		card.setUser(new User(null,null,null,false,null,null,null, emailAddress));
		cardService.addCard(card);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/flightItinerary/{bookingReference}/card/{cardNumber}")
	public void deleteCard(@PathVariable int cardNumber) 
	{
		cardService.deleteCard(cardNumber);
	}

}
