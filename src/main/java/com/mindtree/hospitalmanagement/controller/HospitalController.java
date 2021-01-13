package com.mindtree.hospitalmanagement.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.mindtree.hospitalmanagement.dto.HospitalDTO;
import com.mindtree.hospitalmanagement.exception.HospitalAlreadyExistsException;
import com.mindtree.hospitalmanagement.service.HospitalService;

@Controller
public class HospitalController {

	@Autowired
	HospitalService hospitalService;
	
	@GetMapping("/")
	public String home() {

		return "home.jsp";
	}

	@GetMapping("index")
	public String index() {

		return "index.jsp";
	}

	@GetMapping("welcome")
	public String welcome() {

		return "welcome.jsp";
	}
	
	@GetMapping("hospital")
	public String hospital() {
		
		return "hospital.jsp";
	}
		
	@RequestMapping("createHospital")
	public String addHospital(@RequestParam("name") String name, @RequestParam("city") String city) throws HospitalAlreadyExistsException {
				
		hospitalService.addHospital(name, city);
		return "hospital.jsp";
	}
	
	@RequestMapping("showData")
	public String showCities(Model model) {
		
		model.addAttribute("cities", hospitalService.getAllCities());
		return "showCities.jsp";
	}
	
	@RequestMapping("showHospitals")
	public String showHospitals(Model model, @RequestParam("city") String city) {
		
		model.addAttribute("hospitals", hospitalService.getHospitalsOfACity(city));
		return "showHospitals.jsp";
	}
	
	@RequestMapping("showDepts")
	public String showDepts(Model model, @RequestParam("hospital") int hospitalId) {
		
		model.addAttribute("depts", hospitalService.getDeptsOfAHospital(hospitalId));
		model.addAttribute("hosId", hospitalId);
		//System.out.println(hospitalService.getDeptsOfAHospital(hospitalId));
		return "showDepts.jsp";
		//return "showHospitals.jsp";
	}
	
	@ResponseBody
	@GetMapping("getHospitalsByCity/{city}")
	public String getHospitalsByCity(@PathVariable("city") String city) {
		
		Set<HospitalDTO> hospitals = hospitalService.getHospitalsOfACity(city);
		Gson gson = new Gson();
		
		return gson.toJson(hospitals);
	}
	@ResponseBody
	@GetMapping("getDeptsByHospital/{hospital}")
	public String getDeptsByHospital(@PathVariable("hospital") int hospitalId) {
		
		System.out.println("hosID: " + hospitalId);
		Set<String> depts = hospitalService.getDeptsOfAHospital(hospitalId);
		Gson gson = new Gson();
		System.out.println(depts);
		
		return gson.toJson(depts);
	}
	
	@GetMapping("/accessDenied")
	public String accessDenied() {

		return "accessDenied.jsp";
	}
}
