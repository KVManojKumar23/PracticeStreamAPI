package com.Streams.PracticeStreamAPI.Services;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Streams.PracticeStreamAPI.domain.User;
import com.Streams.PracticeStreamAPI.exception.UserNotFoundException;
import com.Streams.PracticeStreamAPI.repository.UserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepo userRepository;

	public CustomUserDetailsService(UserRepo userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        System.out.println("Manoj"+userName);

		User user = userRepository.findByUserName(userName)
				.orElseThrow(() -> new UserNotFoundException("USER NOT FOUND"));

		return new org.springframework.security.core.userdetails.User(
				user.getUserName(), 
				user.getPassword(),
				List.of(new SimpleGrantedAuthority(user.getRole().toString())));

	}

}
