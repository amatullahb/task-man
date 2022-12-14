package com.brown.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.ws.config.annotation.EnableWs;

/**
 * Utilizes Spring Security to authenticate and authorize users
 * @author Amatullah Brown
 *
 */
@Configuration
@EnableWebSecurity
@EnableWs
public class SpringSecurity {
	
	/**
	 * Uses bcrypt algorithm to hash password
	 * @return hashed password
	 */
	@Bean
	public static PasswordEncoder passwordEncoder () {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/register").permitAll()
			.and()
			.formLogin(
					form -> form
						.loginPage("/login")
						.usernameParameter("email")
						.passwordParameter("password")
						.defaultSuccessUrl("/project")
						.permitAll()
			).logout(
					logout -> logout
						.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
						.permitAll()
			);
		return http.build();
	}

}
