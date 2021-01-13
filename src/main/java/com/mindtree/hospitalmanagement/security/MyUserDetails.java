package com.mindtree.hospitalmanagement.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mindtree.hospitalmanagement.entity.Doctor;

public class MyUserDetails implements UserDetails {
	
	private Doctor doc;	
	
	public MyUserDetails(Doctor doc) {
		
		this.doc = doc;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		System.out.println("getAuthorities()");
		String role = doc.getRole();
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		//for (String role : roles) {
			
		authorities.add(new SimpleGrantedAuthority(role));
		//}
		
		return authorities;
	}

	@Override
	public String getPassword() {
		
		System.out.println("getPassword()");
		return doc.getPassword();
	}

	@Override
	public String getUsername() {

		System.out.println("getUsername()");
		return doc.getName();
	}
	
	public int getId() {

		System.out.println("getId()");
		return doc.getId();
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

}
