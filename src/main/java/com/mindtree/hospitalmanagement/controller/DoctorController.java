package com.mindtree.hospitalmanagement.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mindtree.hospitalmanagement.dto.DoctorDTO;
import com.mindtree.hospitalmanagement.exception.DoctorAlreadyExistsException;
import com.mindtree.hospitalmanagement.service.DoctorService;

@Controller
public class DoctorController {
	
	@Autowired
	DoctorService docService;

	@GetMapping("doctor")
	public String doctor(Model model) {
		
		model.addAttribute("hospitalList", docService.getAllHospitals());
		return "doctor.jsp";
	}
	
	@RequestMapping("createDoctor")
	public String addDoctor(Model model, @RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("salary") double salary, @RequestParam("dept") String dept, @RequestParam("gender") String gender, @RequestParam("hospital") int hospitalId) throws DoctorAlreadyExistsException {
		
		docService.addDoctor(name, password, salary, dept, gender, hospitalId);
		model.addAttribute("hospitalList", docService.getAllHospitals());
		return "doctor.jsp";
	}
	
	@RequestMapping("showDoctors")
	public String showDoctors(Model model, @RequestParam("dept") String dept, @RequestParam("hospital") int hosId) {

		//Set<DoctorDTO> doctors = docService.getDoctorsByDept(dept);
		Set<DoctorDTO> doctors = docService.getDoctorsByDeptAndHospital(dept, hosId);
		System.out.println("doctors");
		doctors.forEach(x -> System.out.println(x.getName()));
		model.addAttribute("doctors", doctors);
		return "showDoctors.jsp";
	}
	
	@RequestMapping("updateDoctor")
	public String updateDoctor(Model model, @RequestParam("docId") int docId) {
		
		DoctorDTO doc = docService.getDoctorById(docId);
		model.addAttribute("docName", doc.getName());
		model.addAttribute("docSalary", doc.getSalary());
		model.addAttribute("docGender", doc.getGender());
		model.addAttribute("docDept", doc.getDept());
		return "updateDoctor.jsp";
	}
	
	@RequestMapping("updateSelectedDoctor")
	public String updateSelectedDoctor(Model model, @RequestParam("name") String name, @RequestParam("salary") double salary) {
		
		DoctorDTO doc = docService.updateSelectedDoctor(name, salary);
		System.out.println(doc.getSalary());
		return "welcome.jsp";
	}	
	
	@RequestMapping("addInfo")
	public String addInfo(Model model) {
		
		OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) SecurityContextHolder.getContext()
				.getAuthentication();
		OAuth2User principal = token.getPrincipal();
		Map<String, Object> result = new HashMap<String, Object>(principal.getAttributes());
		System.out.println(result.get("given_name").toString());
		model.addAttribute("name", result.get("given_name").toString());
		model.addAttribute("hospitalList", docService.getAllHospitals());
		return "addInfo.jsp";
	}	
	
}
