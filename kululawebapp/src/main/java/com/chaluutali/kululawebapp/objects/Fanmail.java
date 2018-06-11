package com.chaluutali.kululawebapp.objects;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Fanmail
{
	
	private String receiver;
	private String sender;
	private String subject;
	
	private String message;
	private Timestamp time;
	private String[] attachment;
	private boolean isViewed;
	private boolean isStarred;
	private boolean isDeleted;
	
	@OneToOne
	private User user;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fanmailId;
	
	
	
	
	public Fanmail(String receiver, String sender, String subject, String message, Timestamp time, String[] attachment,
			boolean isViewed, boolean isStarred, boolean isDeleted, User user, int fanmailId) {
		super();
		this.receiver = receiver;
		this.sender = sender;
		this.subject = subject;
		this.message = message;
		this.time = time;
		this.attachment = attachment;
		this.isViewed = isViewed;
		this.isStarred = isStarred;
		this.isDeleted = isDeleted;
		this.user = new User();
		this.fanmailId = fanmailId;
	}




	public Fanmail()
	{
		
	}




	public String getReceiver() {
		return receiver;
	}




	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}




	public String getSender() {
		return sender;
	}




	public void setSender(String sender) {
		this.sender = sender;
	}




	public String getSubject() {
		return subject;
	}




	public void setSubject(String subject) {
		this.subject = subject;
	}




	public String getMessage() {
		return message;
	}




	public void setMessage(String message) {
		this.message = message;
	}




	public Timestamp getTime() {
		return time;
	}




	public void setTime(Timestamp time) {
		this.time = time;
	}




	public String[] getAttachment() {
		return attachment;
	}




	public void setAttachment(String[] attachment) {
		this.attachment = attachment;
	}




	public boolean isViewed() {
		return isViewed;
	}




	public void setViewed(boolean isViewed) {
		this.isViewed = isViewed;
	}




	public boolean isStarred() {
		return isStarred;
	}




	public void setStarred(boolean isStarred) {
		this.isStarred = isStarred;
	}




	public boolean isDeleted() {
		return isDeleted;
	}




	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public int getFanmailId() {
		return fanmailId;
	}




	public void setFanmailId(int fanmailId) {
		this.fanmailId = fanmailId;
	}
	
	

	
}
