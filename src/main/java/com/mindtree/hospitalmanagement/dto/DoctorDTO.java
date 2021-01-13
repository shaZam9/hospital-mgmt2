package com.mindtree.hospitalmanagement.dto;

public class DoctorDTO {
	
	private int id;
	
	private String name;
	private String password;
	private double salary;
	private String dept;
	private String gender;
	
	private String role;
	
	private HospitalDTO hospital;

	public DoctorDTO() {}

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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public HospitalDTO getHospital() {
		return hospital;
	}

	public void setHospital(HospitalDTO hospital) {
		this.hospital = hospital;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
