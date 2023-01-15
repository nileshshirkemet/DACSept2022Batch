package com.met.iit.cdac.spingbootsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	
	private String ROLE_ADMIN="admin";
	private String ROLE_USER = "user";
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication().
			withUser("admin").password(passwordEncoder().encode("admin@123")).roles(ROLE_ADMIN).
			and().
			withUser("user").password(passwordEncoder().encode("user@123")).roles(ROLE_USER);
		
		//auth.authenticationProvider(new DaoAuthenticationProviPanka
		
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
			.antMatchers("/test/admin").hasRole(ROLE_ADMIN)
			.antMatchers("/test/user").hasAnyRole(ROLE_ADMIN, ROLE_USER)
			.antMatchers("/hello").permitAll()
			.and().formLogin();
	}
	
}

