package com.chaluutali.kululawebapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.chaluutali.kululawebapp.objects.Fanmail;

public interface FanmailRepository extends CrudRepository<Fanmail, Integer> {

	Iterable<Fanmail> findByUserEmailAddress(String emailAddress);

}
