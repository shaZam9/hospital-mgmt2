package com.mindtree.hospitalmanagement.dto;

import java.util.Set;

import javax.persistence.OneToMany;

import com.mindtree.hospitalmanagement.entity.Doctor;

public class HospitalDTO {

	private int id;
	
	private String name;
	private String city;
	
	Set<DoctorDTO> doctors;
	
	public HospitalDTO() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<DoctorDTO> getDoctors() {
		return doctors;
	}

	public void setDoctors(Set<DoctorDTO> doctors) {
		this.doctors = doctors;
	}
}
