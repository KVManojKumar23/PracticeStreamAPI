package com.Streams.PracticeStreamAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.Streams.PracticeStreamAPI.filters.JwtAuthFilter;
import com.Streams.PracticeStreamAPI.utills.JwtUtils;


@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	private final JwtUtils jwtUtiles;
	private final UserDetailsService userDetailsService;

	public SecurityConfig(JwtUtils jwtUtiles, UserDetailsService userDetailsService) {
		this.jwtUtiles = jwtUtiles;
		this.userDetailsService = userDetailsService;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		JwtAuthFilter jwtAuthFilter = new JwtAuthFilter(jwtUtiles, userDetailsService);

		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(authz -> authz
						.requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html").permitAll()
						.requestMatchers("/v3/api-docs/swagger-config").permitAll()
						.requestMatchers("/auth/**").permitAll()
						.requestMatchers("/employees/**").hasAnyAuthority("EMPLOYEE")
						.anyRequest()
						.authenticated())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

	@Bean
	public AuthenticationManager authManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
