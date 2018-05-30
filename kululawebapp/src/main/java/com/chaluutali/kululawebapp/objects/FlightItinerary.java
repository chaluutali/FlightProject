package com.chaluutali.kululawebapp.objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class FlightItinerary
{
	
	@OneToOne
	private ShoppingCart shoppingCart;
	
	@Id
	private String bookingReference;
	
	@OneToOne
	private ScheduledFlight scheduledFlight;
	
	
	public FlightItinerary()
	{
		
	}
	


	public FlightItinerary(ShoppingCart shoppingCart, String bookingReference, ScheduledFlight scheduledFlight) {
		super();
		this.shoppingCart = new ShoppingCart();
		this.bookingReference = bookingReference;
		this.scheduledFlight = new ScheduledFlight();
	}
	
	


	public FlightItinerary(String bookingReference, ScheduledFlight scheduledFlight) {
		
		this.bookingReference = bookingReference;
		this.scheduledFlight = new ScheduledFlight();
		this.shoppingCart = new ShoppingCart();
	}



	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}


	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}


	public String getBookingReference() {
		return bookingReference;
	}


	public void setBookingReference(String bookingReference) {
		this.bookingReference = bookingReference;
	}


	public ScheduledFlight getScheduledFlight() {
		return scheduledFlight;
	}


	public void setScheduledFlight(ScheduledFlight scheduledFlight) {
		this.scheduledFlight = scheduledFlight;
	}
	




	
	
}
