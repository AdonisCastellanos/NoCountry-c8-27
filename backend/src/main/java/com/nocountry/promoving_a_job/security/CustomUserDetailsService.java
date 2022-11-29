package com.nocountry.promoving_a_job.security;

import com.nocountry.promoving_a_job.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{


	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		com.nocountry.promoving_a_job.entity.User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not found with email: " + email));
		//new AppException(HttpStatus.UNAUTHORIZED,"User not found with username or email: " + usernameOrEmail
		String roleName = "USER";
		Collection<? extends GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(roleName));
		return new User(user.getEmail(), user.getPassword(), authorities);
	}

}
