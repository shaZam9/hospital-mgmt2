package com.mindtree.hospitalmanagement.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.hospitalmanagement.entity.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

	Set<Hospital> findByCity(String city);
	
	@Query(value = "select distinct(city) from Hospital h")
	Set<String> findCitiesOnly();

	boolean existsByNameAndCity(String name, String city);
	
}
