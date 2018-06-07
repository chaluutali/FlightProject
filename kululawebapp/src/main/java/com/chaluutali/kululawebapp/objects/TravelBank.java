package com.chaluutali.kululawebapp.objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class TravelBank
{
	
	
	private int currentBalance;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int travelBankId;
	
	@OneToOne
	private FlightItinerary flightItinerary;
	@OneToOne
	private User user;
	
	
	public TravelBank()
	{
		
	}


	public TravelBank(int currentBalance, int travelBankId, FlightItinerary flightItinerary, User user) {
		super();
		this.currentBalance = currentBalance;
		this.travelBankId = travelBankId;
		this.flightItinerary = new FlightItinerary();
		this.user = new User();
	}


	public int getCurrentBalance() {
		return currentBalance;
	}


	public void setCurrentBalance(int currentBalance) {
		this.currentBalance = currentBalance;
	}


	public int getTravelBankId() {
		return travelBankId;
	}


	public void setTravelBankId(int travelBankId) {
		this.travelBankId = travelBankId;
	}


	public FlightItinerary getFlightItinerary() {
		return flightItinerary;
	}


	public void setFlightItinerary(FlightItinerary flightItinerary) {
		this.flightItinerary = flightItinerary;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	


}
