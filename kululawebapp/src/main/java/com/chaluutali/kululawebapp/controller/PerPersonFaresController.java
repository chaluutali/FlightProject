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

import com.chaluutali.kululawebapp.objects.PerPersonFares;
import com.chaluutali.kululawebapp.objects.ScheduledFlight;
import com.chaluutali.kululawebapp.objects.SearchLog;
import com.chaluutali.kululawebapp.objects.User;
import com.chaluutali.kululawebapp.service.PerPersonFaresService;
import com.chaluutali.kululawebapp.service.ScheduledFlightService;




@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
public class PerPersonFaresController 
{
	@Autowired
	private PerPersonFaresService perPersonFaresService;
	@Autowired
	private ScheduledFlightService scheduledFlightService;
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/fares")
	public void selectFlight(@PathVariable String emailAddress, @PathVariable String searchLogDateId, @PathVariable int flightId,  @RequestBody PerPersonFares perPersonFares)
	{
		
		
		
		
		
		if(perPersonFares.getFareType().equals("Standard")) {	
			Optional<PerPersonFares> obj = perPersonFaresService.getPerPersonFares(1);
			perPersonFares.setNumberOfCheckedBaggage(obj.get().getNumberOfCheckedBaggage());
			perPersonFares.setPreFlightCancellationFee(obj.get().getPreFlightCancellationFee());
			perPersonFares.setFlightChangesFee(obj.get().getFlightChangesFee());
			perPersonFares.setFareTotal(obj.get().getFareTotal());
			perPersonFares.setValueAddedTax(obj.get().getValueAddedTax());
			perPersonFares.setFuelSurCharge(obj.get().getFuelSurCharge());
			perPersonFares.setPassengerSafetyCharge(obj.get().getPassengerSafetyCharge());
			perPersonFares.setPassengerSecurityCharge(obj.get().getPassengerSecurityCharge());
			perPersonFares.setPassengerServiceCharge(obj.get().getPassengerServiceCharge());
			perPersonFares.setScheduledFlight(perPersonFares.getScheduledFlight());
			perPersonFares.setSearchLog(new SearchLog(searchLogDateId, new User(null,null,null,false,null,null,null, emailAddress)));
			perPersonFaresService.addPerPersonFares(perPersonFares);
			
		
		}
		if(perPersonFares.getFareType().equals("Semi Flex")) {	
			Optional<PerPersonFares> obj = perPersonFaresService.getPerPersonFares(2);
			perPersonFares.setNumberOfCheckedBaggage(obj.get().getNumberOfCheckedBaggage());
			perPersonFares.setPreFlightCancellationFee(obj.get().getPreFlightCancellationFee());
			perPersonFares.setFlightChangesFee(obj.get().getFlightChangesFee());
			perPersonFares.setFareTotal(obj.get().getFareTotal());
			perPersonFares.setValueAddedTax(obj.get().getValueAddedTax());
			perPersonFares.setFuelSurCharge(obj.get().getFuelSurCharge());
			perPersonFares.setPassengerSafetyCharge(obj.get().getPassengerSafetyCharge());
			perPersonFares.setPassengerSecurityCharge(obj.get().getPassengerSecurityCharge());
			perPersonFares.setPassengerServiceCharge(obj.get().getPassengerServiceCharge());
			perPersonFares.setScheduledFlight(perPersonFares.getScheduledFlight());
			perPersonFares.setSearchLog(new SearchLog(searchLogDateId, new User(null,null,null,false,null,null,null, emailAddress)));
			perPersonFaresService.addPerPersonFares(perPersonFares);
			
		
		
		}
		if(perPersonFares.getFareType().equals("Fully Flex")) {	
			Optional<PerPersonFares> obj = perPersonFaresService.getPerPersonFares(3);
			perPersonFares.setNumberOfCheckedBaggage(obj.get().getNumberOfCheckedBaggage());
			perPersonFares.setPreFlightCancellationFee(obj.get().getPreFlightCancellationFee());
			perPersonFares.setFlightChangesFee(obj.get().getFlightChangesFee());
			perPersonFares.setFareTotal(obj.get().getFareTotal());
			
			perPersonFares.setValueAddedTax(obj.get().getValueAddedTax());
			perPersonFares.setFuelSurCharge(obj.get().getFuelSurCharge());
			perPersonFares.setPassengerSafetyCharge(obj.get().getPassengerSafetyCharge());
			perPersonFares.setPassengerSecurityCharge(obj.get().getPassengerSecurityCharge());
			perPersonFares.setPassengerServiceCharge(obj.get().getPassengerServiceCharge());
			perPersonFares.setScheduledFlight(perPersonFares.getScheduledFlight());
			perPersonFares.setSearchLog(new SearchLog(searchLogDateId, new User(null,null,null,false,null,null,null, emailAddress)));
			perPersonFaresService.addPerPersonFares(perPersonFares);
			
		
		
		}
		if(perPersonFares.getFareType().equals("Business")) {	
			Optional<PerPersonFares> obj = perPersonFaresService.getPerPersonFares(4);
			
			perPersonFares.setNumberOfCheckedBaggage(obj.get().getNumberOfCheckedBaggage());
			perPersonFares.setPreFlightCancellationFee(obj.get().getPreFlightCancellationFee());
			perPersonFares.setFlightChangesFee(obj.get().getFlightChangesFee());
			perPersonFares.setFareTotal(obj.get().getFareTotal());
			
			perPersonFares.setValueAddedTax(obj.get().getValueAddedTax());
			perPersonFares.setFuelSurCharge(obj.get().getFuelSurCharge());
			perPersonFares.setPassengerSafetyCharge(obj.get().getPassengerSafetyCharge());
			perPersonFares.setPassengerSecurityCharge(obj.get().getPassengerSecurityCharge());
			perPersonFares.setPassengerServiceCharge(obj.get().getPassengerServiceCharge());
			perPersonFares.setScheduledFlight(perPersonFares.getScheduledFlight());
			perPersonFares.setSearchLog(new SearchLog(searchLogDateId, new User(null,null,null,false,null,null,null, emailAddress)));
			perPersonFaresService.addPerPersonFares(perPersonFares);
			
			
		
		}
		
	}
	
	
	

	@RequestMapping("/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/fares/all")
	public List<PerPersonFares> getAllPerPersonFares(@PathVariable int flightId)
	{
		return perPersonFaresService.getAllPerPersonFares(flightId);
	}
	@RequestMapping("/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/fares")
	public Optional<PerPersonFares> getBySearchLogId(@PathVariable String searchLogDateId)
	{
		return perPersonFaresService.getBySearchLogId(searchLogDateId);
	}
	
	@RequestMapping("/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/fares/{perPersonFaresId}")
	public Optional<PerPersonFares> getPerPersonFares(@PathVariable int perPersonFaresId) 
	{
		return perPersonFaresService.getPerPersonFares(perPersonFaresId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/fares/admin")
	public void addPerPersonFares(@PathVariable String emailAddress, @PathVariable String searchLogDateId, @PathVariable int flightId,  @RequestBody PerPersonFares perPersonFares)
	{
		
		perPersonFares.setScheduledFlight(new ScheduledFlight(flightId, new SearchLog(searchLogDateId, new User(null,null,null,false,null,null,null, emailAddress))));
		perPersonFaresService.addPerPersonFares(perPersonFares);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/fares/{perPersonFaresId}")
	public void updatePerPersonFares(@PathVariable String emailAddress, @PathVariable String searchLogDateId, @PathVariable int flightId,  @RequestBody PerPersonFares perPersonFares) 
	{
		perPersonFares.setScheduledFlight(new ScheduledFlight(flightId, new SearchLog(searchLogDateId, new User(null,null,null,false,null,null,null, emailAddress))));
		perPersonFaresService.addPerPersonFares(perPersonFares);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/fares/{perPersonFaresId}")
	public void deletePerPersonFares(@PathVariable int perPersonFaresId) 
	{
		perPersonFaresService.deletePerPersonFares(perPersonFaresId);
	}




	public ScheduledFlightService getScheduledFlightService() {
		return scheduledFlightService;
	}




	public void setScheduledFlightService(ScheduledFlightService scheduledFlightService) {
		this.scheduledFlightService = scheduledFlightService;
	}

}
