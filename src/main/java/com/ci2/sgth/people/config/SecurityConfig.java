package com.ci2.sgth.people.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		 httpSecurity.cors().and()
		 .csrf().disable()
         .authorizeHttpRequests(authorize -> authorize
             .mvcMatchers(HttpMethod.GET,"/people-ws/**").hasAuthority("SCOPE_people.read")
             .mvcMatchers(HttpMethod.POST,"/people-ws/**").hasAuthority("SCOPE_people.write")
             .anyRequest().authenticated()
         ).oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
        
         
     return httpSecurity.build();
	}
}
