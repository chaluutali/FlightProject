package com.chaluutali.kululawebapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chaluutali.kululawebapp.objects.Fanmail;
import com.chaluutali.kululawebapp.objects.User;
import com.chaluutali.kululawebapp.service.FanmailService;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
public class FanmailController 
{
	@Autowired
	private FanmailService fanmailService;

	@RequestMapping("/user/{emailAddress}/fanmail")
	public List<Fanmail> getAllMail(@PathVariable String emailAddress)
	{
		return fanmailService.getAllMail(emailAddress);
	}
	
	@RequestMapping("/user/{emailAddress}/fanmail/{fanmailId}")
	public Optional<Fanmail> getMail(@PathVariable int fanmailId) 
	{
		return fanmailService.getMail(fanmailId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/{emailAddress}/fanmail")
	public void addMail(@RequestBody Fanmail fanmail, @PathVariable String emailAddress)
	{
		fanmail.setUser(new User(null,null,null,false,null,null,null, emailAddress));
		
		fanmailService.addMail(fanmail);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/user/{emailAddress}/fanmail/{fanmailId}")
	public void updateMail(@PathVariable String emailAddress, @PathVariable int fanmailId, @RequestBody Fanmail fanmail) 
	{
		fanmail.setUser(new User(null,null,null,false,null,null,null, emailAddress));
		
		fanmailService.addMail(fanmail);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/user/{emailAddress}/fanmail/{fanmailId}")
	public void deleteMail(@PathVariable int fanmailId) 
	{
		fanmailService.deleteMail(fanmailId);
	}

}
