package com.chaluutali.kululawebapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chaluutali.kululawebapp.objects.User;
import com.chaluutali.kululawebapp.security.JwtGenerator;
import com.chaluutali.kululawebapp.service.UserService;

import io.jsonwebtoken.Jwt;



@RestController

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtGenerator jwtGenerator;
	
	@RequestMapping(method = RequestMethod.POST, value ="/login")
	public Jwt login( @RequestBody User userLogin) {
		
		
		Optional<User> obj = userService.getUser(userLogin.getEmailAddress());
		if (BCrypt.checkpw(userLogin.getPassword(), obj.get().getPassword()) == true) {
		return jwtGenerator.generate(userLogin.getEmailAddress(), userLogin.getPassword()); 
		}
		return null;
	}

	@RequestMapping("/user")
	public List<User> getAllUsers()
	{
		return userService.getAllUsers();
	}
	
	
	
	@RequestMapping("/user/{emailAddress}")
	public Optional<User> getUser(@PathVariable String emailAddress) 
	{
		return userService.getUser(emailAddress);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user")
	public void addUser(@RequestBody User user)
	{
		
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		userService.addUser(user);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/user/{emailAddress}")
	public void updateUser(@PathVariable String emailAddress,@RequestBody User user) 
	{
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		userService.addUser(user);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/user/{emailAddress}")
	public void deleteUser(@PathVariable String emailAddress) 
	{
		userService.deleteUser(emailAddress);
	}

}
