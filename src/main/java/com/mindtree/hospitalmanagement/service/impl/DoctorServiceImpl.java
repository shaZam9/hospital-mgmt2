package com.mindtree.hospitalmanagement.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.hospitalmanagement.dto.DoctorDTO;
import com.mindtree.hospitalmanagement.dto.HospitalDTO;
import com.mindtree.hospitalmanagement.entity.Doctor;
import com.mindtree.hospitalmanagement.entity.Hospital;
import com.mindtree.hospitalmanagement.exception.DoctorAlreadyExistsException;
import com.mindtree.hospitalmanagement.repository.DoctorRepository;
import com.mindtree.hospitalmanagement.repository.HospitalRepository;
import com.mindtree.hospitalmanagement.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorRepository docRepo;
	
	@Autowired
	HospitalRepository hosRepo;
	
	ModelMapper mapper = new ModelMapper();
	
	@Override
	public Set<HospitalDTO> getAllHospitals() {
		
		List<Hospital> hospitals = hosRepo.findAll();
		return hospitals.stream().map(x -> mapper.map(x, HospitalDTO.class)).collect(Collectors.toSet());
	}

	@Override
	public DoctorDTO addDoctor(String name, String password, double salary, String dept, String gender, int hospitalId) throws DoctorAlreadyExistsException {
		
		if(docRepo.existsByNameAndHospitalId(name, hospitalId)) {
			
			throw new DoctorAlreadyExistsException("Doctor already exists in this Hospital");
		}
		
		Doctor doc = new Doctor();
		doc.setName(name);
		doc.setPassword(password);
		doc.setSalary(salary);
		doc.setDept(dept);
		doc.setGender(gender);
		doc.setRole("ROLE_USER");
		doc.setHospital(hosRepo.findById(hospitalId).get());
		
		docRepo.save(doc);
		return mapper.map(doc, DoctorDTO.class);
	}

	@Override
	public Set<DoctorDTO> getDoctorsByDept(String dept) {
		
		Set<Doctor> doctors = docRepo.findByDept(dept);
		System.out.println(doctors);
		
		return doctors.stream().map(x -> mapper.map(x, DoctorDTO.class)).collect(Collectors.toSet());
	}

	@Override
	public Set<DoctorDTO> getDoctorsByDeptAndHospital(String dept, int hosId) {
		Set<Doctor> doctors = docRepo.findByDeptAndHospitalId(dept, hosId);
		
		System.out.println(doctors);
		
		return doctors.stream().map(x -> mapper.map(x, DoctorDTO.class)).collect(Collectors.toSet());
	}

	@Override
	public DoctorDTO getDoctorById(int docId) {
		
		return mapper.map(docRepo.findById(docId).get(), DoctorDTO.class);
	}

	@Override
	public DoctorDTO updateSelectedDoctor(String name, double salary) {
		
		Doctor doc = docRepo.findByName(name);
		
		doc.setSalary(salary);
		
		docRepo.save(doc);
		return mapper.map(doc, DoctorDTO.class);
	}

}
