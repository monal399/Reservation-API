package com.jsp.registration_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.registration_api.dto.ResponseStructure;
import com.jsp.registration_api.model.Admin;
import com.jsp.registration_api.services.Admin_Services;

@RestController
@RequestMapping("/admin")
public class Admin_Controller {
	@Autowired
	private Admin_Services admin_Services;
	
	@PostMapping
	ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin){
		return admin_Services.saveAdmin(admin);
	}
	
	@GetMapping("/{id}")
	ResponseEntity<ResponseStructure<Admin>> findById(@PathVariable int id){
		return admin_Services.findById(id);
	}
	
	@PutMapping
	ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestBody Admin admin){
		return admin_Services.saveAdmin(admin);
	}
}
