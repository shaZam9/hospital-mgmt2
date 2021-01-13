package com.mindtree.hospitalmanagement.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mindtree.hospitalmanagement.entity.Doctor;
import com.mindtree.hospitalmanagement.repository.DoctorRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	DoctorRepository docRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("loadUserByUsername()");
		System.out.println(username);
		Doctor doc = docRepo.findByName(username);
		
		String role = doc.getRole();
		
		//for (String role : roles) {
		
		System.out.println("User detail Service name: " + username);
		System.out.println("User detail Service role: " + role);
		//}
		return new MyUserDetails(doc);		
	}

}
