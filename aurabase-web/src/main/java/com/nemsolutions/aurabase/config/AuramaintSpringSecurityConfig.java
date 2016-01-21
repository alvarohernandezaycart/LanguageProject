package com.nemsolutions.aurabase.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.nemsolutions.auracore.config.SpringSecurityConfig;

@Configuration
@EnableWebSecurity
public class AuramaintSpringSecurityConfig extends SpringSecurityConfig {

	@Override
	public void addAuthorizedRequests(HttpSecurity http) throws Exception {
		http.authorizeRequests()
        	.antMatchers("/**").hasRole("DEVELOPER")
        	.and();
		
	}
 
 
}
