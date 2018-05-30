package com.chaluutali.kululawebapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaluutali.kululawebapp.repository.UserRepository;
import com.chaluutali.kululawebapp.objects.User;

@Service
public class UserService 
{
	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> getAllUsers()
	{
		List<User> user = new ArrayList<>();
		userRepository.findAll()
		.forEach(user::add);
		return user;
		
	}
	
	public Optional<User> getUser(String emailAddress) 
	{
		return userRepository.findById(emailAddress);
	}
	
	public void addUser(User user)
	{
		userRepository.save(user);
	}
	
	public void updateUser(String emailAddress, User user)
	{
		userRepository.save(user);
	
	}
	public void deleteUser(String emailAddress)
	{
		userRepository.deleteById(emailAddress);
	}

	
	

}
