package com.chaluutali.kululawebapp.objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class SeatSelectionLog
{
	
	private double standardBackPrice;
	private double standardFrontPrice;
	private double stretchZonePrice;
	private double exitRowPrice;
	private double frontRowPrice;
	
	
	private int seatId;
	private String seatType;
	private boolean seatSelected;
	private String craftName;
	
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
	private int seatSelectionId;
	
	@ManyToOne
	private ScheduledFlight scheduledFlight;
	
	@OneToOne
	private AirCraft airCraft;
	
	@OneToOne
	private SearchLog searchLog;
	
	
	public SeatSelectionLog()
	{
		
	}
	
	
	
	








	public SeatSelectionLog(double standardBackPrice, double standardFrontPrice, double stretchZonePrice,
			double exitRowPrice, double frontRowPrice, int seatId, String seatType, String craftName, boolean seatSelected,
			boolean[] backPrice, boolean[] frontPrice, boolean[] sZonePrice, boolean[] eRowPrice, boolean[] fRowPrice,
			int numStandardBack, int numStandardFront, int numStretchZone, int numExitRow, int numFrontRow,
			int seatSelectionId, ScheduledFlight scheduledFlight, AirCraft airCraft, SearchLog searchLog) {
		super();
		this.standardBackPrice = standardBackPrice;
		this.standardFrontPrice = standardFrontPrice;
		this.stretchZonePrice = stretchZonePrice;
		this.exitRowPrice = exitRowPrice;
		this.frontRowPrice = frontRowPrice;
		this.seatId = seatId;
		this.craftName = craftName;
		this.seatType = seatType;
		this.seatSelected = seatSelected;
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
		this.seatSelectionId = seatSelectionId;
		this.scheduledFlight = new ScheduledFlight();
		this.airCraft = new AirCraft();
		this.searchLog = new SearchLog();
	}












	public SeatSelectionLog(int seatSelectionId, ScheduledFlight scheduledFlight, AirCraft airCraft,
			SearchLog searchLog) {
		super();
		this.seatSelectionId = seatSelectionId;
		this.scheduledFlight = new ScheduledFlight();
		this.airCraft = new AirCraft();
		this.searchLog = new SearchLog();
	}






	public double getStandardBackPrice() {
		return standardBackPrice;
	}


	public void setStandardBackPrice(double standardBackPrice) {
		this.standardBackPrice = standardBackPrice;
	}


	public double getStandardFrontPrice() {
		return standardFrontPrice;
	}


	public void setStandardFrontPrice(double standardFrontPrice) {
		this.standardFrontPrice = standardFrontPrice;
	}


	public double getStretchZonePrice() {
		return stretchZonePrice;
	}


	public void setStretchZonePrice(double stretchZonePrice) {
		this.stretchZonePrice = stretchZonePrice;
	}


	public double getExitRowPrice() {
		return exitRowPrice;
	}


	public void setExitRowPrice(double exitRowPrice) {
		this.exitRowPrice = exitRowPrice;
	}


	public double getFrontRowPrice() {
		return frontRowPrice;
	}


	public void setFrontRowPrice(double frontRowPrice) {
		this.frontRowPrice = frontRowPrice;
	}


	public String getSeatType() {
		return seatType;
	}


	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}


	public boolean isSeatSelected() {
		return seatSelected;
	}


	public void setSeatSelected(boolean seatSelected) {
		this.seatSelected = seatSelected;
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


	public int getSeatSelectionId() {
		return seatSelectionId;
	}


	public void setSeatSelectionId(int seatSelectionId) {
		this.seatSelectionId = seatSelectionId;
	}


	public ScheduledFlight getScheduledFlight() {
		return scheduledFlight;
	}


	public void setScheduledFlight(ScheduledFlight scheduledFlight) {
		this.scheduledFlight = scheduledFlight;
	}


	public AirCraft getAirCraft() {
		return airCraft;
	}


	public void setAirCraft(AirCraft craft) {
		this.airCraft = craft;
	}


	public SearchLog getSearchLog() {
		return searchLog;
	}


	public void setSearchLog(SearchLog searchLog) {
		this.searchLog = searchLog;
	}












	public int getSeatId() {
		return seatId;
	}












	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}












	public void setAirCraft(int i) {
		this.airCraft = new AirCraft(i);
		
	}












	public String getCraftName() {
		return craftName;
	}












	public void setCraftName(String craftName) {
		this.craftName = craftName;
	}








	
	


	
	
	
	
}
