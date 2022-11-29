package com.nocountry.promoving_a_job.security;

import com.nocountry.promoving_a_job.entity.User;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenProvider {

	@Value("${app.jwt-secret}")
	private String jwtSecret;
	
	@Value("${app.jwt-expiration-milliseconds}")
	private int jwtExpirationInMs;
	
	public String generateToken(Authentication authentication) {
		String username = authentication.getName();
		Date actualDate = new Date();
		Date expirationDate = new Date(actualDate.getTime() + jwtExpirationInMs);
		Map<String, Object> claims= new HashMap<>();
		claims.put("email",username);
		
		String token = Jwts.builder().setSubject(username).setIssuedAt(new Date()).setExpiration(expirationDate)
				.setClaims(claims)
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
		
		return token;
	}
	public String generateToken(User authentication) {
		String username = authentication.getEmail();
		Date actualDate = new Date();
		Date expirationDate = new Date(actualDate.getTime() + jwtExpirationInMs);
		Map<String, Object> claims= new HashMap<>();
		claims.put("email",username);

		String token = Jwts.builder().setSubject(username).setIssuedAt(new Date()).setExpiration(expirationDate)
				.setClaims(claims)
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();

		return token;
	}
	
	public String getUsernameFromJWT(String token) {
		Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}
	
	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
			return true;
		}catch (SignatureException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid JWT Firm");//firma invalida
		}
		catch (MalformedJwtException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid JWT Token");
		}
		catch (ExpiredJwtException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Expired JWT Token");
		}
		catch (UnsupportedJwtException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Unsupported JWT Token");
		}
		catch (IllegalArgumentException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"JWT claims string is empty.");
		}
	}
}

