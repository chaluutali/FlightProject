package com.chaluutali.kululawebapp.objects;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ScheduledFlight
{
	
	
	private String carrierName;
	private String flightNumber;
	private String airCraftType; 
	
	private Date departureDate;
	private String departureFrom;
	
	private Date arrivalTime;
	private String arrivalDestination;
	private String fare_Type;
	
	
	private Timestamp estimatedTimeOfArrival;
	private double economyPriceStandard;
	private double economyPriceSemiFlex;
	private double economyPriceFullyFlex;
	private double businessPrice;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int scheduledFlightId;
	
	@ManyToOne
	private SearchLog searchLog;
	
	
	
	public ScheduledFlight()
	{
		
	}
	public ScheduledFlight(int scheduledFlightId, SearchLog searchLog)
	{
		this.scheduledFlightId = scheduledFlightId;
		this.searchLog = new SearchLog();
	}

	public ScheduledFlight(String carrierName, String flightNumber, String airCraftType, Date departureDate,
			String departureFrom, Date arrivalTime, String arrivalDestination, String fare_Type,
			Timestamp estimatedTimeOfArrival, double economyPriceStandard, double economyPriceSemiFlex,
			double economyPriceFullyFlex, double businessPrice, int scheduledFlightId, SearchLog searchLog) {
		super();
		this.carrierName = carrierName;
		this.flightNumber = flightNumber;
		this.airCraftType = airCraftType;
		this.departureDate = departureDate;
		this.departureFrom = departureFrom;
		this.arrivalTime = arrivalTime;
		this.arrivalDestination = arrivalDestination;
		this.fare_Type = fare_Type;
		this.estimatedTimeOfArrival = estimatedTimeOfArrival;
		this.economyPriceStandard = economyPriceStandard;
		this.economyPriceSemiFlex = economyPriceSemiFlex;
		this.economyPriceFullyFlex = economyPriceFullyFlex;
		this.businessPrice = businessPrice;
		this.scheduledFlightId = scheduledFlightId;
		this.searchLog = new SearchLog();
	}



	public ScheduledFlight(int scheduledFlightId) {
		super();
		this.scheduledFlightId = scheduledFlightId;
		this.searchLog = new SearchLog();
	}
	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getAirCraftType() {
		return airCraftType;
	}

	public void setAirCraftType(String airCraftType) {
		this.airCraftType = airCraftType;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public String getDepartureFrom() {
		return departureFrom;
	}

	public void setDepartureFrom(String departureFrom) {
		this.departureFrom = departureFrom;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getArrivalDestination() {
		return arrivalDestination;
	}

	public void setArrivalDestination(String arrivalDestination) {
		this.arrivalDestination = arrivalDestination;
	}

	public String getFare_Type() {
		return fare_Type;
	}

	public void setFare_Type(String fare_Type) {
		this.fare_Type = fare_Type;
	}

	public Timestamp getEstimatedTimeOfArrival() {
		return estimatedTimeOfArrival;
	}

	public void setEstimatedTimeOfArrival(Timestamp estimatedTimeOfArrival) {
		this.estimatedTimeOfArrival = estimatedTimeOfArrival;
	}

	public double getEconomyPriceStandard() {
		return economyPriceStandard;
	}

	public void setEconomyPriceStandard(double economyPriceStandard) {
		this.economyPriceStandard = economyPriceStandard;
	}

	

	public double getEconomyPriceSemiFlex() {
		return economyPriceSemiFlex;
	}

	public void setEconomyPriceSemiFlex(double economyPriceSemiFlex) {
		this.economyPriceSemiFlex = economyPriceSemiFlex;
	}

	

	public double getEconomyPriceFullyFlex() {
		return economyPriceFullyFlex;
	}

	public void setEconomyPriceFullyFlex(double economyPriceFullyFlex) {
		this.economyPriceFullyFlex = economyPriceFullyFlex;
	}

	

	public double getBusinessPrice() {
		return businessPrice;
	}

	public void setBusinessPrice(double businessPrice) {
		this.businessPrice = businessPrice;
	}

	

	public int getScheduledFlightId() {
		return scheduledFlightId;
	}

	

	public void setScheduledFlightId(int scheduledFlightId) {
		this.scheduledFlightId = scheduledFlightId;
	}

	public SearchLog getSearchLog() {
		return searchLog;
	}

	public void setSearchLog(SearchLog searchLog) {
		this.searchLog = searchLog;
	}

	

	
}
