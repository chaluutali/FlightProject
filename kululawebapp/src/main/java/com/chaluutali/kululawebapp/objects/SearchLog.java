package com.chaluutali.kululawebapp.objects;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.chaluutali.kululawebapp.objects.User;

@Entity
public class SearchLog
{
	
	private String tripType;
	private String destinationFrom;
	private String destinationTo;
	private String preferredClass;
	private Date departureDate;
	private Date returnDate;
	private int numberOfAdults;
	private int numberOfInfants;
	private int numberOfChildren;
	
	@Id
	
	private String searchLogDateId;
	
	@OneToOne
	private User user;
	
	public SearchLog() {
		
	}
	
	
	
	public SearchLog(String searchLogDateId, User user) {
		super();
		this.searchLogDateId = searchLogDateId;
		this.user = user;
	}



	public SearchLog(String tripType, String destinationFrom, String destinationTo, String preferredClass,
			Date departureDate, Date returnDate, int numberOfAdults, int numberOfInfants, int numberOfChildren,
			String searchLogDateId, User user) {
		super();
		this.tripType = tripType;
		this.destinationFrom = destinationFrom;
		this.destinationTo = destinationTo;
		this.preferredClass = preferredClass;
		this.departureDate = departureDate;
		this.returnDate = returnDate;
		this.numberOfAdults = numberOfAdults;
		this.numberOfInfants = numberOfInfants;
		this.numberOfChildren = numberOfChildren;
		this.searchLogDateId = searchLogDateId;
		this.user = new User();
		
	}
	
	public String getTripType() {
		return tripType;
	}
	public void setTripType(String tripType) {
		this.tripType = tripType;
	}
	public String getDestinationFrom() {
		return destinationFrom;
	}
	public void setDestinationFrom(String destinationFrom) {
		this.destinationFrom = destinationFrom;
	}
	public String getDestinationTo() {
		return destinationTo;
	}
	public void setDestinationTo(String destinationTo) {
		this.destinationTo = destinationTo;
	}
	public String getPreferredClass() {
		return preferredClass;
	}
	public void setPreferredClass(String preferredClass) {
		this.preferredClass = preferredClass;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public int getNumberOfAdults() {
		return numberOfAdults;
	}
	public void setNumberOfAdults(int numberOfAdults) {
		this.numberOfAdults = numberOfAdults;
	}
	public int getNumberOfInfants() {
		return numberOfInfants;
	}
	public void setNumberOfInfants(int numberOfInfants) {
		this.numberOfInfants = numberOfInfants;
	}
	public int getNumberOfChildren() {
		return numberOfChildren;
	}
	public void setNumberOfChildren(int numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}
	public String getSearchLogDateId() {
		return searchLogDateId;
	}
	public void setSearchLogDateId(String searchLogDateId) {
		this.searchLogDateId = searchLogDateId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	

}
