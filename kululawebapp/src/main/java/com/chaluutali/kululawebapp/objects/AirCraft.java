package com.chaluutali.kululawebapp.objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AirCraft
{
	
	private String carrierName;
	private String aircraftName;
	private String aircraftType;
	
	private boolean[] backPrice;
	private boolean[] frontPrice;
	private boolean[] sZonePrice;
	private boolean[] eRowPrice;
	private boolean[] fRowPrice;
	
	private int numStandardBack;
	private int numStandardFront;
	private int numStretchZone;
	private int numExitRow;
	private int numFrontRow;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int airCraftId;
	
	
	
	
	public AirCraft()
	{
		
	}




	public AirCraft(String carrierName, String aircraftName, String aircraftType, boolean[] backPrice,
			boolean[] frontPrice, boolean[] sZonePrice, boolean[] eRowPrice, boolean[] fRowPrice, int numStandardBack,
			int numStandardFront, int numStretchZone, int numExitRow, int numFrontRow, int airCraftId) {
		super();
		this.carrierName = carrierName;
		this.aircraftName = aircraftName;
		this.aircraftType = aircraftType;
		this.backPrice = backPrice;
		this.frontPrice = frontPrice;
		this.sZonePrice = sZonePrice;
		this.eRowPrice = eRowPrice;
		this.fRowPrice = fRowPrice;
		this.numStandardBack = numStandardBack;
		this.numStandardFront = numStandardFront;
		this.numStretchZone = numStretchZone;
		this.numExitRow = numExitRow;
		this.numFrontRow = numFrontRow;
		this.airCraftId = airCraftId;
	}




	




	public AirCraft(int i) {
		
		
		
		getCarrierName();
		getAircraftType();
		getAircraftName();
		getBackPrice();
		getFrontPrice();
		getsZonePrice();
		geteRowPrice();
		getfRowPrice();
		getNumStandardBack();
		getNumStandardFront();
		getNumStretchZone();
		getNumExitRow();
		getNumFrontRow();
		this.airCraftId = i;
	}







	public String getCarrierName() {
		return carrierName;
	}




	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}




	public String getAircraftName() {
		return aircraftName;
	}




	public void setAircraftName(String aircraftName) {
		this.aircraftName = aircraftName;
	}




	public String getAircraftType() {
		return aircraftType;
	}




	public void setAircraftType(String aircraftType) {
		this.aircraftType = aircraftType;
	}




	public boolean[] getBackPrice() {
		return backPrice;
	}




	public void setBackPrice(boolean[] backPrice) {
		this.backPrice = backPrice;
	}




	public boolean[] getFrontPrice() {
		return frontPrice;
	}




	public void setFrontPrice(boolean[] frontPrice) {
		this.frontPrice = frontPrice;
	}




	public boolean[] getsZonePrice() {
		return sZonePrice;
	}




	public void setsZonePrice(boolean[] sZonePrice) {
		this.sZonePrice = sZonePrice;
	}




	public boolean[] geteRowPrice() {
		return eRowPrice;
	}




	public void seteRowPrice(boolean[] eRowPrice) {
		this.eRowPrice = eRowPrice;
	}




	public boolean[] getfRowPrice() {
		return fRowPrice;
	}




	public void setfRowPrice(boolean[] fRowPrice) {
		this.fRowPrice = fRowPrice;
	}




	public int getNumStandardBack() {
		return numStandardBack;
	}




	public void setNumStandardBack(int numStandardBack) {
		this.numStandardBack = numStandardBack;
	}




	public int getNumStandardFront() {
		return numStandardFront;
	}




	public void setNumStandardFront(int numStandardFront) {
		this.numStandardFront = numStandardFront;
	}




	public int getNumStretchZone() {
		return numStretchZone;
	}




	public void setNumStretchZone(int numStretchZone) {
		this.numStretchZone = numStretchZone;
	}




	public int getNumExitRow() {
		return numExitRow;
	}




	public void setNumExitRow(int numExitRow) {
		this.numExitRow = numExitRow;
	}




	public int getNumFrontRow() {
		return numFrontRow;
	}




	public void setNumFrontRow(int numFrontRow) {
		this.numFrontRow = numFrontRow;
	}




	public int getAirCraftId() {
		return airCraftId;
	}




	public void setAirCraftId(int airCraftId) {
		this.airCraftId = airCraftId;
	}
	





	
	
}
