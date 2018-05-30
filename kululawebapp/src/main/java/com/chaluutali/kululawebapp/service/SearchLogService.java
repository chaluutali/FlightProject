package com.chaluutali.kululawebapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaluutali.kululawebapp.objects.SearchLog;
import com.chaluutali.kululawebapp.repository.SearchLogRepository;

@Service
public class SearchLogService 
{
	@Autowired
	private SearchLogRepository searchLogRepository;
	
	
	public List<SearchLog> getAllSearchLogs(String emailAddress)
	{
		List<SearchLog> searchLogs = new ArrayList<>();
		searchLogRepository.findByUserEmailAddress(emailAddress)
		.forEach(searchLogs::add);
		return searchLogs;
		
	}
	
	public Optional<SearchLog> getSearchLog(String searchLogDateId) 
	{
		return searchLogRepository.findById(searchLogDateId);
	}
	
	public void addSearchLog(SearchLog searchLog)
	{
		searchLogRepository.save(searchLog);
	}
	
	public void updateSearchLog(String searchLogDateId, SearchLog searchLog)
	{
		searchLogRepository.save(searchLog);
	
	}
	public void deleteSearchLog(String searchLogDateId)
	{
		searchLogRepository.deleteById(searchLogDateId);
	}

}
