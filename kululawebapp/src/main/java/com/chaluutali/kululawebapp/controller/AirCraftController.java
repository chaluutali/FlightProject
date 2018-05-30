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
import com.chaluutali.kululawebapp.service.AirCraftService;



@RestController

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
public class AirCraftController 
{
	
	private boolean[] backPrice;
	private boolean[] frontPrice;
	private boolean[] sZonePrice;
	private boolean[] eRowPrice;
	private boolean[] fRowPrice;
	@Autowired
	private AirCraftService airCraftService;
	
	@RequestMapping("/aircraft")
	public List<AirCraft> getAllAirCrafts()
	{
		return airCraftService.getAllAirCrafts();
	}
	
	@RequestMapping("/aircraft/{airCraftId}")
	public Optional<AirCraft> getAirCraft(@PathVariable int airCraftId) 
	{
		return airCraftService.getAirCraft(airCraftId);
	}
	@RequestMapping("/aircraft/byname/{name}")
	public Optional<AirCraft> getAirCraftByName(@PathVariable String name ) 
	{
		return airCraftService.getAirCraftByName(name);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/aircraft")
	public void addAirCraft(@RequestBody AirCraft airCraft)
	{
		
		
		
		int numStandardBack = airCraft.getNumStandardBack();
		int numStandardFront = airCraft.getNumStandardFront();
		int numStretchZone = airCraft.getNumStretchZone();
		int numExitRow = airCraft.getNumExitRow();
		int numFrontRow = airCraft.getNumFrontRow();
		
		
		backPrice = new boolean [numStandardBack];
		frontPrice = new boolean [numStandardFront];
		sZonePrice =  new boolean [numStretchZone];
		eRowPrice = new boolean [numExitRow];
		fRowPrice = new boolean [numFrontRow];
		
		

			
			for(int c = 0; c < numStandardBack; c++)
			{
				backPrice[c] = false;
			}
			
			for(int c = 0; c < numStandardFront; c++ )
			{
				
				frontPrice[c] = false;
			}
			
			for(int c = 0; c < numStretchZone; c++ )
			{
				
				sZonePrice[c] = false;
			}
			for(int c = 0; c < numExitRow; c++ )
			{
				
				eRowPrice[c] = false;
			}
			
			for(int c = 0; c < numFrontRow; c++ )
			{
				
				fRowPrice[c] = false;
			}
			
			
			
			
		
		//set airCraft
		airCraft.setBackPrice(backPrice);
		airCraft.seteRowPrice(eRowPrice);
		airCraft.setFrontPrice(frontPrice);
		airCraft.setfRowPrice(fRowPrice);
		airCraft.setsZonePrice(sZonePrice);
		
		 
		airCraftService.addAirCraft(airCraft);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/aircraft/{airCraftId}")
	public void updateAirCraft(@PathVariable int airCrfatId,@RequestBody AirCraft airCraft) 
	{
		airCraftService.addAirCraft(airCraft);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/aircraft/{airCraftId}")
	public void deleteAirCraft(@PathVariable int airCraftId) 
	{
		airCraftService.deleteAirCraft(airCraftId);
	}

}
