package com.jsp.registration_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jsp.registration_api.dto.ResponseStructure;

@ControllerAdvice
public class AdminExceptionHandler {
	@ExceptionHandler(AdminNotFound.class)
	public ResponseEntity<ResponseStructure<String>> admExcHandler(AdminNotFound a){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Admin Not available");
		structure.setData(a.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(structure);
	}
}
