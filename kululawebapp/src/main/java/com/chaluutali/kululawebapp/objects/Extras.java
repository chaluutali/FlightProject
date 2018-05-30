package com.chaluutali.kululawebapp.objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Extras
{
	
	private double extraBagPrice;
	private double travelCover;
	private double slowXSLoungePrice;
	private double passengerServiceCharge;
	private int numExtraBag;
	private int numTravelCover;
	private int numSlowXsLounge;
	private double totalExtraBag;
	private double totalTravelCover;
	private double totalSlowXsLounge;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int extrasId;
	
	@ManyToOne
	private ScheduledFlight scheduledFlight;
	
	@OneToOne
	private SearchLog searchLog;
	
	
	public Extras()
	{
		
	}
	


	public Extras(double extraBagPrice, double travelCover, double slowXSLoungePrice, double passengerServiceCharge,
			int numExtraBag, int numTravelCover, int numSlowXsLounge, double totalSlowXsLounge, double totalExtraBag, double totalTravelCover, int extrasId,
			ScheduledFlight scheduledFlight, SearchLog searchLog) {
		super();
		this.extraBagPrice = extraBagPrice;
		this.travelCover = travelCover;
		this.slowXSLoungePrice = slowXSLoungePrice;
		this.passengerServiceCharge = passengerServiceCharge;
		this.numExtraBag = numExtraBag;
		this.numTravelCover = numTravelCover;
		this.numSlowXsLounge = numSlowXsLounge;
		this.totalSlowXsLounge = totalSlowXsLounge;
		this.totalExtraBag = totalExtraBag;
		this.totalTravelCover = totalTravelCover;
		this.extrasId = extrasId;
		this.scheduledFlight = new ScheduledFlight();
		this.searchLog = new SearchLog();
	}



	public Extras(double extraBagPrice2, double travelCover2, double slowXSLoungePrice2, double passengerServiceCharge2,
			int numExtraBag2, int numTravelCover2, int numSlowXsLounge2, double totalSlowXsLounge2, double totalBagCover, double travelCover3,int extrasId2, int selectionId) {
		
		
		this.extraBagPrice = extraBagPrice2;
		this.travelCover = travelCover2;
		this.slowXSLoungePrice = slowXSLoungePrice2;
		this.passengerServiceCharge = passengerServiceCharge2;
		this.numExtraBag = numExtraBag2;
		this.numTravelCover = numTravelCover2;
		this.numSlowXsLounge = numSlowXsLounge2;
		this.totalSlowXsLounge = totalSlowXsLounge2;
		this.totalExtraBag = totalBagCover;
		this.totalTravelCover = travelCover3;
		this.extrasId = extrasId2;
		this.scheduledFlight = new ScheduledFlight(selectionId);
		this.searchLog = new SearchLog();
		
		
		
		
	}



	public Extras(int extrasId2, ScheduledFlight scheduledFlight2, SearchLog searchLog) {
		
		
		this.scheduledFlight = new ScheduledFlight();
		this.searchLog = new SearchLog();
		this.extrasId = extrasId2;
	}



	public double getExtraBagPrice() {
		return extraBagPrice;
	}


	public void setExtraBagPrice(double extraBagPrice) {
		this.extraBagPrice = extraBagPrice;
	}


	public double getTravelCover() {
		return travelCover;
	}


	public void setTravelCover(double travelCover) {
		this.travelCover = travelCover;
	}


	public double getSlowXSLoungePrice() {
		return slowXSLoungePrice;
	}


	public void setSlowXSLoungePrice(double slowXSLoungePrice) {
		this.slowXSLoungePrice = slowXSLoungePrice;
	}


	public double getPassengerServiceCharge() {
		return passengerServiceCharge;
	}


	public void setPassengerServiceCharge(double passengerServiceCharge) {
		this.passengerServiceCharge = passengerServiceCharge;
	}


	

	public int getNumExtraBag() {
		return numExtraBag;
	}



	public void setNumExtraBag(int numExtraBag) {
		this.numExtraBag = numExtraBag;
	}



	public int getNumTravelCover() {
		return numTravelCover;
	}



	public void setNumTravelCover(int numTravelCover) {
		this.numTravelCover = numTravelCover;
	}



	public int getNumSlowXsLounge() {
		return numSlowXsLounge;
	}



	public void setNumSlowXsLounge(int numSlowXsLounge) {
		this.numSlowXsLounge = numSlowXsLounge;
	}



	public double getTotalExtraBag() {
		return totalExtraBag;
	}


	public void setTotalExtraBag(double totalExtraBag) {
		this.totalExtraBag = totalExtraBag;
	}


	public double getTotalTravelCover() {
		return totalTravelCover;
	}


	public void setTotalTravelCover(double totalTravelCover) {
		this.totalTravelCover = totalTravelCover;
	}


	public int getExtrasId() {
		return extrasId;
	}


	public void setExtrasId(int extrasId) {
		this.extrasId = extrasId;
	}


	public ScheduledFlight getScheduledFlight() {
		return scheduledFlight;
	}


	public void setScheduledFlight(ScheduledFlight scheduledFlight) {
		this.scheduledFlight = scheduledFlight;
	}



	public SearchLog getSearchLog() {
		return searchLog;
	}



	public void setSearchLog(SearchLog searchLog) {
		this.searchLog = searchLog;
	}



	public double getTotalSlowXsLounge() {
		return totalSlowXsLounge;
	}



	public void setTotalSlowXsLounge(double totalSlowXsLounge) {
		this.totalSlowXsLounge = totalSlowXsLounge;
	}
	


	
	
}
