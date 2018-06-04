package com.chaluutali.kululawebapp.objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airport
{
	
	private String airportName;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int airportId;
	
	
	
	
	public Airport()
	{
		
	}




	public Airport(String airportName, int airportId) {
		super();
		this.airportName = airportName;
		this.airportId = airportId;
	}




	public String getAirportName() {
		return airportName;
	}




	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}




	public int getAirportId() {
		return airportId;
	}




	public void setAirportId(int airportId) {
		this.airportId = airportId;
	}


}
