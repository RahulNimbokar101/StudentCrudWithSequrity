package com.neosoft.main.serviceImpl;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("sanketasati".equals(username)) {
			System.out.println("hello data");
			return new User("sanketasati", "$2y$12$qGPWwWxPI3hI4e5VXGTm7.cCI1LhbGkkd3x6f/qCngubIYRSyzDX2",
					
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
	}


