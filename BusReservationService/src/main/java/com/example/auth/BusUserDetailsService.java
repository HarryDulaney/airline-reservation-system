package com.example.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BusUserDetailsService implements UserDetailsService{
	
	private final UserRepository userRepository;
	public static long userID1 = 0;
	
	public BusUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepository.findByUsername(username);
		if (null == username) {
			throw new UsernameNotFoundException("Cannot find Username");
		}
		userID1 = user.getUserID();
		System.out.println(userID1);
		return new UserPrincipal(user);
	}
	
	
	
	




	
	
	
}
