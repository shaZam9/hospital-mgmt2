package com.mindtree.hospitalmanagement.service.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.hospitalmanagement.dto.HospitalDTO;
import com.mindtree.hospitalmanagement.entity.Doctor;
import com.mindtree.hospitalmanagement.entity.Hospital;
import com.mindtree.hospitalmanagement.exception.HospitalAlreadyExistsException;
import com.mindtree.hospitalmanagement.repository.DoctorRepository;
import com.mindtree.hospitalmanagement.repository.HospitalRepository;
import com.mindtree.hospitalmanagement.service.HospitalService;

@Service
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	HospitalRepository hospitalRepo;
	
	@Autowired
	DoctorRepository docRepo;

	ModelMapper mapper = new ModelMapper();

	@Override
	public HospitalDTO addHospital(String name, String city) throws HospitalAlreadyExistsException {
		
		if(hospitalRepo.existsByNameAndCity(name, city)) {
			
			throw new HospitalAlreadyExistsException("Hospital Already Exists");
		}
		
		Hospital hospital = new Hospital();
		
		hospital.setName(name);
		hospital.setCity(city);
		
		hospital = hospitalRepo.save(hospital);
		
		return mapper.map(hospital, HospitalDTO.class);
	}

	@Override
	public Set<String> getAllCities() {
		
		System.out.println("Cities: " + hospitalRepo.findCitiesOnly());
		return hospitalRepo.findCitiesOnly();
	}

	@Override
	public Set<HospitalDTO> getHospitalsOfACity(String city) {
		
		Set<Hospital> hospitals = hospitalRepo.findByCity(city);
		System.out.println(hospitals);
		return hospitals.stream().map(x -> mapper.map(x, HospitalDTO.class)).collect(Collectors.toSet());
	}

	@Override
	public Set<String> getDeptsOfAHospital(int hospitalId) {
		
		Set<Doctor> doctors = docRepo.findByHospitalId(hospitalId);
		
		System.out.println("Doctors of hospital: " + doctors);
		Set<String> depts = new HashSet<>();
		
		doctors.forEach(x -> depts.add(x.getDept()));
		System.out.println("Depts of hospital: " + depts);
		
		return depts;
	}

}
