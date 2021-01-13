package com.mindtree.hospitalmanagement.service;

import java.util.Set;

import com.mindtree.hospitalmanagement.dto.HospitalDTO;
import com.mindtree.hospitalmanagement.exception.HospitalAlreadyExistsException;

public interface HospitalService {

	HospitalDTO addHospital(String name, String city) throws HospitalAlreadyExistsException;

	Set<String> getAllCities();

	Set<HospitalDTO> getHospitalsOfACity(String city);

	Set<String> getDeptsOfAHospital(int hospitalId);

}
