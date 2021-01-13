package com.mindtree.hospitalmanagement.service;

import java.util.Set;

import com.mindtree.hospitalmanagement.dto.DoctorDTO;
import com.mindtree.hospitalmanagement.dto.HospitalDTO;
import com.mindtree.hospitalmanagement.exception.DoctorAlreadyExistsException;

public interface DoctorService {

	Set<HospitalDTO> getAllHospitals();

	DoctorDTO addDoctor(String name, String password, double salary, String dept, String gender, int hospitalId) throws DoctorAlreadyExistsException;

	Set<DoctorDTO> getDoctorsByDept(String dept);

	Set<DoctorDTO> getDoctorsByDeptAndHospital(String dept, int hosId);

	DoctorDTO getDoctorById(int docId);

	DoctorDTO updateSelectedDoctor(String name, double salary);

}
