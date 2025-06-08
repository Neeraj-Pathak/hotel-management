package com.example.project.Hotel.Management.Util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {

    //GENERATING TOKEN FOR USER
    private String generateToken(Map<String, Object> extraClaims, UserDetails details) {
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(details.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))  // 24 hours expiry
                .signWith(getSigningKey())  // no SignatureAlgorithm needed here
                .compact();
    }

    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    //VERIFYING TOKEN VALIDITY
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    // Extract all claims from the token
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Generic method to extract any claim from token
    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // Secret key for signing JWT tokens (Base64 encoded)
    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode("l6Bz3L+XPeq+e1K6VxA7W4TfzQ0RB2lk9xNtYgFPrd8=");  // your base64 secret key
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
