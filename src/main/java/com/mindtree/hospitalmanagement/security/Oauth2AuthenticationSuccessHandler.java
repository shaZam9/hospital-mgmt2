//package com.mindtree.hospitalmanagement.security;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//
//import com.mindtree.customerproductmanagement.entity.Customer;
//import com.mindtree.customerproductmanagement.repository.CustomerRepository;
//
//@Configuration("oauth2authSuccessHandler")
//
//public class Oauth2AuthenticationSuccessHandler implements AuthenticationSuccessHandler {
//
//	@Autowired
//	CustomerRepository custRepo;
//	
//	
//	@Override
//	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//			Authentication authentication) throws IOException, ServletException {
//		
////		if(!this.userRepo.existsByName(authentication.getName())) {
////			
////			
////		}
//        //Map<String, Object> properties = (LinkedHashMap<String, Object>) authentication.getCredentials();
//		//User user = (User) authentication.getPrincipal();
//		
//		//System.out.println("Name: "+user.getName() + " " + user.getPassword()+ " " + user.getRole());
//		//System.out.println("Success: " + authentication.getName());
//		
//		System.out.println("Auth Success");
//		OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) SecurityContextHolder.getContext()
//				.getAuthentication();
//		OAuth2User principal = token.getPrincipal();
//		Map<String, Object> result = new HashMap<String, Object>(principal.getAttributes());
//		
//		if(!this.custRepo.existsByName(result.get("given_name").toString())) {
//			
//			Customer cust = new Customer();
//			cust.setName(result.get("given_name").toString());
//			cust.setEmail(result.get("email").toString());
//			cust.setRole("ROLE_USER");
//			custRepo.save(cust);
//		}
//		
//		//System.out.println("Success2: " + authentication.getAuthorities());
//	}
//
//}
