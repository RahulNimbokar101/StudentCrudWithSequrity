package com.neosoft.main.simpleSequrity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;
// for use  digest oauth

//@Configuration
//@Order(1)
public class AdminSecurityConfiguration extends WebSecurityConfigurerAdapter {

//	private DigestAuthenticationEntryPoint getDigestEntryPoint() {
//		DigestAuthenticationEntryPoint digestEntryPoint = new DigestAuthenticationEntryPoint();
//		digestEntryPoint.setRealmName("admin-digest-realm");
//		digestEntryPoint.setKey("somedigestkey");
//		return digestEntryPoint;
//	}
//	// using for digest security
//	//@Bean
//	//public PasswordEncoder passwordEncoder() {
////		return NoOpPasswordEncoder.getInstance();
//	//}
//	
////	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////		auth.inMemoryAuthentication()
////        .withUser("TestUser")
////            .password(passwordEncoder().encode("digestsecret"))
////            .roles("USER")
////    .and()
////        .withUser("TestAdmin")
////            .password(passwordEncoder().encode("adminsecret"))
////            .roles("ADMIN");
////	}
////	@Bean
//	public UserDetailsService userDetailsServiceBean() throws Exception {
//		return super.userDetailsServiceBean();
//	}
//	
//	private DigestAuthenticationFilter getDigestAuthFilter() throws Exception {
//		DigestAuthenticationFilter digestFilter = new DigestAuthenticationFilter();
//
//		digestFilter.setUserDetailsService(userDetailsServiceBean());
//
//
//		digestFilter.setAuthenticationEntryPoint(getDigestEntryPoint());
//		return digestFilter;
//	}
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.cors().and().csrf().disable()
//		.antMatcher("/student-portal/api/**").
//		addFilter(getDigestAuthFilter()).exceptionHandling()
//		.authenticationEntryPoint(getDigestEntryPoint())
//		.and().authorizeRequests().antMatchers("/student-portal/api/**").hasRole("ADMIN");
//	}
}
