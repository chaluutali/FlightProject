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

import com.chaluutali.kululawebapp.objects.Airport;
import com.chaluutali.kululawebapp.service.AirportService;



@RestController

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
public class AirportController 
{
	
	
	@Autowired
	private AirportService airportService;
	
	@RequestMapping("/airport")
	public List<Airport> getAllAirports()
	{
		return airportService.getAllAirports();
	}
	
	@RequestMapping("/airport/{airportId}")
	public Optional<Airport> getAirport(@PathVariable int airportId) 
	{
		return airportService.getAirport(airportId);
	}
	@RequestMapping("/airport/byname/{name}")
	public Optional<Airport> getAirportByName(@PathVariable String name ) 
	{
		return airportService.getAirportByName(name);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/airport")
	public void addAirport(@RequestBody Airport airport)
	{
		
				 
		airportService.addAirport(airport);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/airport/{airportId}")
	public void updateAirport(@PathVariable int airportId,@RequestBody Airport airport) 
	{
		airportService.addAirport(airport);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/airport/{airportId}")
	public void deleteAirport(@PathVariable int airportId) 
	{
		airportService.deleteAirport(airportId);
	}

}
