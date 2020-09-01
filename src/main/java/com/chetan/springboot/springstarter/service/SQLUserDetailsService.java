package com.chetan.springboot.springstarter.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.chetan.springboot.springstarter.model.User;
import com.chetan.springboot.springstarter.repository.UserRepository;

@Service
public class SQLUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Optional<User> user = userRepository.findByUserName(userName);
		
		user.orElseThrow(()-> new UsernameNotFoundException("Not Found: "+userName));
		return user.map(MyUserDetails::new).get();
		//return new MyUserDetails(userName);
	}

}
