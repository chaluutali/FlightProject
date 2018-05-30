package com.chaluutali.kululawebapp.objects;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Traveller
{
	
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private boolean gender;
	private String mobileNumber;
	
	@Id
	private String emailAddress;
	
	@ManyToOne
	private ScheduledFlight scheduledFlight;
	
	
	public Traveller()
	{
		
	}
	


	public Traveller(String firstName, String lastName, Date dateOfBirth, boolean gender, String mobileNumber,
			String emailAddress, ScheduledFlight scheduledFlight) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.emailAddress = emailAddress;
		this.scheduledFlight = new ScheduledFlight();
	}



	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public boolean isGender() {
		return gender;
	}


	public void setGender(boolean gender) {
		this.gender = gender;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		
	}



	public ScheduledFlight getScheduledFlight() {
		return scheduledFlight;
	}



	public void setScheduledFlight(ScheduledFlight scheduledFlight) {
		this.scheduledFlight = scheduledFlight;
	}

	
	

}
