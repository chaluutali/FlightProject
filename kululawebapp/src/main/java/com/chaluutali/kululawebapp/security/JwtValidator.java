package com.chaluutali.kululawebapp.security;

import org.springframework.stereotype.Component;

import com.chaluutali.kululawebapp.objects.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {


    private String secret = "chaluutali";

    public User validate(String token) {

        User User = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            User = new User();

            User.setEmailAddress(body.getSubject());
            User.setPassword((String) body.get("password"));
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return User;
    }
}