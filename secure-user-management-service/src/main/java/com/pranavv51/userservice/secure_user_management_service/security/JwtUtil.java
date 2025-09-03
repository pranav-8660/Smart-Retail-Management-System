package com.pranavv51.userservice.secure_user_management_service.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.rsocket.RSocketSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    private static final String SECRET_KEY = "optimusprime"; //only the backend knows the secret key, to verify the jwt token shared by ui...we can also keep this in environment variables(and later be used in sealed secrets(in kubernetes cluster)/ a config server also)
    private static final long EXPIRATION = 1000 * 30 * 60; // half an hour expiry for the token

    public String generateToken(UserDetails userDetails){

        return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + EXPIRATION)).signWith(SignatureAlgorithm.HS256,SECRET_KEY).compact();

    }

    // extracting the username from the jwt token (which will be shared by ui)
    public String extractUserName(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }

    //check if the shared jwt token has still not expired..if expired, the validateToken function returns false, so this request will be filtered...hence the user's request will not be served...
    public boolean isTokenExpired(String token){
        Date expiration = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getExpiration();

        return expiration.before(new Date());
    }

    public boolean validateToken(String token,UserDetails userDetails){
        var par1 = extractUserName(token).equals(userDetails.getUsername());

        return par1 && !isTokenExpired(token);
    }



}
