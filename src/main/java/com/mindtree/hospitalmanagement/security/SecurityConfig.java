package com.mindtree.hospitalmanagement.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetService;

//	@Autowired
//	Oauth2AuthenticationSuccessHandler oauthSuccessHandler;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		System.out.println("configure(AuthenticationManagerBuilder)");
		//auth.authenticationProvider(provider());
		auth.inMemoryAuthentication().withUser("Admin2").password("1234").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("User1").password("1234").roles("USER");
	}

	public AuthenticationProvider provider() {
		
		System.out.println("provider()");
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setUserDetailsService(userDetService);
		dao.setPasswordEncoder(getPasswordEncoder());
		//dao.setPasswordEncoder(encoder());
		return dao;
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {

		return NoOpPasswordEncoder.getInstance();
	}
	
//	@Bean
//	public PasswordEncoder encoder() {
//	    return new BCryptPasswordEncoder(11);
//	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("configure(HttpSecurity)");
		http.authorizeRequests()
		.antMatchers("/updateSelectedDoctor").hasRole("USER")
		
		.antMatchers("/showDoctors").hasAnyRole("USER", "ADMIN")
		.antMatchers("/updateDoctor").hasRole("USER")
		.antMatchers("/showDepts").hasRole("ADMIN")
		.antMatchers("/showHospitals").hasRole("ADMIN")
		.antMatchers("/showData").hasRole("ADMIN")
		
		
		.antMatchers("/createHospital").hasRole("ADMIN")
		.antMatchers("/hospital").hasRole("ADMIN")
		.antMatchers("/createDoctor").permitAll()
		.antMatchers("/doctor").permitAll()
		.antMatchers("/welcome").permitAll()
		.antMatchers("/index").permitAll()
		.antMatchers("/").permitAll()
		.and().oauth2Login()//.loginPage("/login")
		//.successHandler(oauthSuccessHandler)
		.defaultSuccessUrl("/addInfo")
		.permitAll()
		.and().formLogin().permitAll()
		.and().logout().permitAll()
		.and().exceptionHandling().accessDeniedPage("/accessDenied");
		http.csrf().disable();
	}

}
