package com.chaluutali.kululawebapp.objects;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User
{
	
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private boolean gender;
	private String mobileNumber;
	private String userName;
	private String password;
	
	@Id
	private String emailAddress;
	
	
	public User()
	{
		
	}

	public User(String firstName, String lastName, Date dateOfBirth, boolean gender, String mobileNumber, String userName,
			String password, String emailAddress) 
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.userName = userName;
		this.password = password;
		this.emailAddress = emailAddress;
	}




	public User(String password, String emailAddress) {
		super();
		this.password = password;
		this.emailAddress = emailAddress;
	}

	public String getFirstName() 
	{
		return firstName;
	}



	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}



	public String getLastName() 
	{
		return lastName;
	}



	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}



	public Date getDateOfBirth()
	{
		return dateOfBirth;
	}



	public void setDateOfBirth(Date dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}



	public boolean isGender() 
	{
		return gender;
	}



	public void setGender(boolean gender)
	{
		this.gender = gender;
	}



	public String getMobileNumber() 
	{
		return mobileNumber;
	}



	public void setMobileNumber(String mobileNumber) 
	{
		this.mobileNumber = mobileNumber;
	}



	public String getUserName() 
	{
		return userName;
	}



	public void setUserName(String userName)
	{
		this.userName = userName;
	}



	public String getPassword()
	{
		return password;
	}



	public void setPassword(String password)
	{
		this.password = password;
	}



	public String getEmailAddress()
	{
		return emailAddress;
	}



	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}
	
	
	

}
