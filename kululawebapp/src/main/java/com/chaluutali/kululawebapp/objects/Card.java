package com.chaluutali.kululawebapp.objects;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Card
{
	
	
	private String nameOnCard;
	private Date expirationDate;
	private String cvv;
	private String billingAddress;
	private String  country;
	private String city;
	private String zipCode;
	
	
	@Id
	private int cardNumber;
	
	@OneToOne
	private FlightItinerary flightItinerary;
	@OneToOne
	private User user;
	
	
	public Card()
	{
		
	}
	


	public Card(String nameOnCard, Date expirationDate, String cvv, String billingAddress, String country, String city,
			String zipCode, int cardNumber, FlightItinerary flightItinerary) {
		super();
		this.nameOnCard = nameOnCard;
		this.expirationDate = expirationDate;
		this.cvv = cvv;
		this.billingAddress = billingAddress;
		this.country = country;
		this.city = city;
		this.zipCode = zipCode;
		this.cardNumber = cardNumber;
		this.flightItinerary =  new FlightItinerary();

	}

	


	
	public Card(String nameOnCard, Date expirationDate, String cvv, String billingAddress, String country, String city,
			String zipCode, int cardNumber, User user) {
		super();
		this.nameOnCard = nameOnCard;
		this.expirationDate = expirationDate;
		this.cvv = cvv;
		this.billingAddress = billingAddress;
		this.country = country;
		this.city = city;
		this.zipCode = zipCode;
		this.cardNumber = cardNumber;
		this.user = new User();
	}



	public String getNameOnCard() {
		return nameOnCard;
	}


	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}


	public Date getExpirationDate() {
		return expirationDate;
	}


	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}


	public String getCvv() {
		return cvv;
	}


	public void setCvv(String cvv) {
		this.cvv = cvv;
	}


	public String getBillingAddress() {
		return billingAddress;
	}


	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	public int getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
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
