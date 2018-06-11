package com.chaluutali.kululawebapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaluutali.kululawebapp.objects.Fanmail;
import com.chaluutali.kululawebapp.repository.FanmailRepository;

@Service
public class FanmailService {
	
	@Autowired
	private FanmailRepository fanmailRepository;

	public List<Fanmail> getAllMail(String emailAddress) {

		List<Fanmail> messages = new ArrayList<>();
		fanmailRepository.findByUserEmailAddress(emailAddress)
		.forEach(messages::add);
		return messages;

	}

	public Optional<Fanmail> getMail(int fanmailId) {
		return fanmailRepository.findById(fanmailId);
	}

	public void addMail(Fanmail fanmail) {
		fanmailRepository.save(fanmail);
		
	}

	public void deleteMail(int fanmailId) {
		fanmailRepository.deleteById(fanmailId);
		
	}

}
