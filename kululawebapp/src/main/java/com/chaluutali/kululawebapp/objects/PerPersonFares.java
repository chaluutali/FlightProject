package com.chaluutali.kululawebapp.objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class PerPersonFares
{
	private String fareType;
	private int numberOfCheckedBaggage;
	private double preFlightCancellationFee;
	private double flightChangesFee;
	private double fareTotal;
	private double valueAddedTax;
	private double passengerSafetyCharge;
	private double passengerSecurityCharge;
	private double passengerServiceCharge;
	private double fuelSurCharge;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int perPersonFaresId;
	
	@ManyToOne
	private ScheduledFlight scheduledFlight;
	
	@OneToOne
	private SearchLog searchLog;
	
	
	public PerPersonFares()
	{
		
	}
	
	


	public PerPersonFares(String fareType, int numberOfCheckedBaggage, double preFlightCancellationFee,
			double flightChangesFee, double fareTotal, double valueAddedTax, double passengerSafetyCharge,
			double passengerSecurityCharge, double passengerServiceCharge, double fuelSurCharge,
			int perPersonFaresId, ScheduledFlight scheduledFlight, SearchLog searchLog) {
		super();
		this.fareType = fareType;
		this.numberOfCheckedBaggage = numberOfCheckedBaggage;
		this.preFlightCancellationFee = preFlightCancellationFee;
		this.flightChangesFee = flightChangesFee;
		this.fareTotal = fareTotal;
		
		this.valueAddedTax = valueAddedTax;
		this.passengerSafetyCharge = passengerSafetyCharge;
		this.passengerSecurityCharge = passengerSecurityCharge;
		this.passengerServiceCharge = passengerServiceCharge;
		this.fuelSurCharge = fuelSurCharge;
		this.perPersonFaresId = perPersonFaresId;
		this.scheduledFlight = new ScheduledFlight();
		this.searchLog = new SearchLog();
	}




	

	

	public PerPersonFares(String fareType,int perPersonFaresId) {
		
		this.fareType = fareType;
		this.perPersonFaresId = perPersonFaresId;
		this.scheduledFlight = new ScheduledFlight();
		this.searchLog = new SearchLog();
		
		
	}



	

	public PerPersonFares(int perPersonFaresId2, ScheduledFlight scheduledFlight2) {
		
		

		this.scheduledFlight = new ScheduledFlight(); 
		this.perPersonFaresId = perPersonFaresId2;
	}


	public ScheduledFlight getScheduledFlight() {
		return scheduledFlight;
	}


	public void setScheduledFlight(ScheduledFlight scheduledFlight) {
		this.scheduledFlight = scheduledFlight;
	}


	public int getNumberOfCheckedBaggage() {
		return numberOfCheckedBaggage;
	}


	public void setNumberOfCheckedBaggage(int numberOfCheckedBaggage) {
		this.numberOfCheckedBaggage = numberOfCheckedBaggage;
	}


	public double getPreFlightCancellationFee() {
		return preFlightCancellationFee;
	}


	public void setPreFlightCancellationFee(double preFlightCancellationFee) {
		this.preFlightCancellationFee = preFlightCancellationFee;
	}


	public double getFlightChangesFee() {
		return flightChangesFee;
	}


	public void setFlightChangesFee(double flightChangesFee) {
		this.flightChangesFee = flightChangesFee;
	}


	public String getFareType() {
		return fareType;
	}


	public void setFareType(String fareType) {
		this.fareType = fareType;
	}


	public double getFareTotal() {
		return fareTotal;
	}


	public void setFareTotal(double fareTotal) {
		this.fareTotal = fareTotal;
	}


	public int getPerPersonFaresId() {
		return perPersonFaresId;
	}


	public void setPerPersonFaresId(int perPersonFaresId) {
		this.perPersonFaresId = perPersonFaresId;
	}



	public double getValueAddedTax() {
		return valueAddedTax;
	}


	public void setValueAddedTax(double valueAddedTax) {
		this.valueAddedTax = valueAddedTax;
	}


	public double getPassengerSafetyCharge() {
		return passengerSafetyCharge;
	}


	public void setPassengerSafetyCharge(double passengerSafetyCharge) {
		this.passengerSafetyCharge = passengerSafetyCharge;
	}


	public double getPassengerSecurityCharge() {
		return passengerSecurityCharge;
	}


	public void setPassengerSecurityCharge(double passengerSecurityCharge) {
		this.passengerSecurityCharge = passengerSecurityCharge;
	}


	public double getPassengerServiceCharge() {
		return passengerServiceCharge;
	}


	public void setPassengerServiceCharge(double passengerServiceCharge) {
		this.passengerServiceCharge = passengerServiceCharge;
	}


	public double getFuelSurCharge() {
		return fuelSurCharge;
	}


	public void setFuelSurCharge(double fuelSurCharge) {
		this.fuelSurCharge = fuelSurCharge;
	}




	public SearchLog getSearchLog() {
		return searchLog;
	}




	public void setSearchLog(SearchLog searchLog) {
		this.searchLog = searchLog;
	}



	





	
	

	
}
