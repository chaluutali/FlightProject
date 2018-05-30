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

import com.chaluutali.kululawebapp.objects.SearchLog;
import com.chaluutali.kululawebapp.objects.User;
import com.chaluutali.kululawebapp.service.SearchLogService;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
public class SearchLogController 
{
	@Autowired
	private SearchLogService searchLogService;

	@RequestMapping("/user/{emailAddress}/searchlog")
	public List<SearchLog> getAllSearchLogs(@PathVariable String emailAddress)
	{
		return searchLogService.getAllSearchLogs(emailAddress);
	}
	
	@RequestMapping("/user/{emailAddress}/searchlog/{searchLogDateId}")
	public Optional<SearchLog> getSearchLog(@PathVariable String searchLogDateId) 
	{
		return searchLogService.getSearchLog(searchLogDateId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/{emailAddress}/searchlog")
	public void addSearchLog(@RequestBody SearchLog searchLog, @PathVariable String emailAddress)
	{
		searchLog.setUser(new User(null,null,null,false,null,null,null, emailAddress));
		
		searchLogService.addSearchLog(searchLog);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/user/{emailAddress}/searchlog/{searchLogDateId}")
	public void updateSearchLog(@PathVariable String emailAddress, @PathVariable String searchLogDateId,@RequestBody SearchLog searchLog) 
	{
		searchLog.setUser(new User(null,null,null,false,null,null,null, emailAddress));
		
		searchLogService.addSearchLog(searchLog);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/user/{emailAddress}/searchlog/{searchLogDateId}")
	public void deleteSearchLog(@PathVariable String searchLogDateId) 
	{
		searchLogService.deleteSearchLog(searchLogDateId);
	}

}
