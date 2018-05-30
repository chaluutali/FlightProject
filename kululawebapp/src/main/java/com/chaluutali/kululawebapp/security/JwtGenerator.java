package com.chaluutali.kululawebapp.security;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {

	public Jwt generate(String emailAddress, String password) {
        Claims claims = Jwts.claims()
                .setSubject(emailAddress);
        claims.put("password", password);
        
        String jws =  Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "chaluutali")
                .compact();
        
        Claims claims2 = Jwts.claims()
                .setSubject(emailAddress);
        claims2.put("token", jws);
        
        
        String jws2 = Jwts.builder()
        		.setClaims(claims2)
        		.signWith(SignatureAlgorithm.HS512, "chaluutali")
                .compact();
        
        
        
        return Jwts.parser().setSigningKey("chaluutali").parse(jws2);
        
	}

	public Jwt generate(int scheduledFlightId) {
		 Claims claims = Jwts.claims()
	                .setSubject(Integer.toString(scheduledFlightId));
	        claims.put("ID", scheduledFlightId);
	        
	        String jws =  Jwts.builder()
	                .setClaims(claims)
	                .signWith(SignatureAlgorithm.HS512, "chaluutali")
	                .compact();
	        
	        Claims claims2 = Jwts.claims()
	                .setSubject(Integer.toString(scheduledFlightId));
	        claims2.put("token", jws);
	        
	        
	        String jws2 = Jwts.builder()
	        		.setClaims(claims2)
	        		.signWith(SignatureAlgorithm.HS512, "chaluutali")
	                .compact();
	        
	        
	        
	        return Jwts.parser().setSigningKey("chaluutali").parse(jws2);
	        
		
	}



}
