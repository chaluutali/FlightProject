package com.chaluutali.kululawebapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chaluutali.kululawebapp.objects.SearchLog;

public interface SearchLogRepository extends CrudRepository<SearchLog, String>
{

	public List<SearchLog> findByUserEmailAddress(String emailAddress);
}
