package com.neosoft.main.simpleSequrity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// for simple spring security
//@Configuration
//@EnableWebSecurity
public class WebSecurityConfiguration  extends WebSecurityConfigurerAdapter{
 
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//	  
//		http.cors().and().csrf().disable()
//		.authorizeRequests()
//		
//		.anyRequest().authenticated()
//		.and().httpBasic();
//}
// 
}