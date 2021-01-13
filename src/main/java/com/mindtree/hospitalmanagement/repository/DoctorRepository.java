package com.mindtree.hospitalmanagement.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.hospitalmanagement.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

	Set<Doctor> findByDept(String dept);
	
	@Query(value = "select distinct(dept) from Doctor d")
	Set<String> findDeptsOnly();

	Set<Doctor> findByHospitalId(int hospitalId);

	Set<Doctor> findByDeptAndHospitalId(String dept, int hosId);

	Doctor findByName(String name);

	boolean existsByName(String name);

	boolean existsByNameAndHospitalId(String name, int hospitalId);
}
