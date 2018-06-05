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

import com.chaluutali.kululawebapp.objects.Extras;
import com.chaluutali.kululawebapp.objects.ScheduledFlight;
import com.chaluutali.kululawebapp.objects.SearchLog;
import com.chaluutali.kululawebapp.objects.User;
import com.chaluutali.kululawebapp.service.ExtrasService;




@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
public class ExtrasController 
{
	@Autowired
	private ExtrasService extrasService;

	@RequestMapping("/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/extras/all")
	public List<Extras> getAllExtras(@PathVariable int flightId)
	{
		return extrasService.getAllExtras(flightId);
	}
	@RequestMapping("/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/extras")
	public Optional<Extras> getBySearchLogId(@PathVariable String searchLogDateId)
	{
		return extrasService.getBySearchLogId(searchLogDateId);
	}
	
	@RequestMapping("/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/extras/{extrasId}")
	public Optional<Extras> getExtras(@PathVariable int extrasId) 
	{
		return extrasService.getExtras(extrasId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/extras")
	public void addExtras(@PathVariable String emailAddress, @PathVariable String searchLogDateId, @PathVariable int flightId,  @RequestBody Extras extras)
	{
		Optional<Extras> obj = extrasService.getExtras(1);
		double totalSlowXs = extras.getNumSlowXsLounge()*obj.get().getSlowXSLoungePrice();
		double totalBagCover = extras.getNumTravelCover()*obj.get().getTravelCover();
		double totalExtraBags = extras.getNumExtraBag()*obj.get().getExtraBagPrice();
		
		extras.setTotalSlowXsLounge(totalSlowXs);
		extras.setTotalExtraBag(totalExtraBags);
		extras.setTotalTravelCover(totalBagCover);
		extras.setExtraBagPrice(obj.get().getExtraBagPrice());
		extras.setPassengerServiceCharge(obj.get().getPassengerServiceCharge());
		extras.setSlowXSLoungePrice(obj.get().getSlowXSLoungePrice());
		extras.setTravelCover(obj.get().getTravelCover());
		extras.setScheduledFlight(new ScheduledFlight(flightId, new SearchLog(searchLogDateId, new User(null,null,null,false,null,null,null, emailAddress))));
		extras.setSearchLog(new SearchLog(searchLogDateId, new User(null,null,null,false,null,null,null, emailAddress)));
		 
		extrasService.addExtras(extras);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/extras/{extrasId}")
	public void updateExtras(@PathVariable String emailAddress, @PathVariable String searchLogDateId, @PathVariable int flightId,  @RequestBody Extras extras) 
	{
		extras.setScheduledFlight(new ScheduledFlight(flightId, new SearchLog(searchLogDateId, new User(null,null,null,false,null,null,null, emailAddress))));
		extrasService.addExtras(extras);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/extras/{extrasId}")
	public void deleteExtras(@PathVariable int extrasId) 
	{
		extrasService.deleteExtras(extrasId);
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.DELETE, value = "/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/extras/bysearchlog")
	public void deleteExtrasBySearchLogDate(@PathVariable String searchLogDateId) 
	{
		extrasService.deleteExtrasBySearchLogDate(searchLogDateId);
	}


}
