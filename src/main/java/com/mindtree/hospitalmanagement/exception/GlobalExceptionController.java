package com.mindtree.hospitalmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(DoctorAlreadyExistsException.class)
	public ResponseEntity<?> handleCustomException(DoctorAlreadyExistsException e) {

		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HospitalAlreadyExistsException.class)
	public ResponseEntity<?> handleCustomException(HospitalAlreadyExistsException e) {

		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DoctorNotFoundException.class)
	public ResponseEntity<?> handleCustomException(DoctorNotFoundException e) {

		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
