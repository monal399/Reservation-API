package com.jsp.registration_api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.registration_api.dao.Admin_dao;
import com.jsp.registration_api.dto.ResponseStructure;
import com.jsp.registration_api.exception.AdminNotFound;
import com.jsp.registration_api.model.Admin;

@Service
public class Admin_Services {
	@Autowired
	private Admin_dao admin_dao;
	
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin){
		ResponseStructure<Admin> structure = new ResponseStructure<>();
		structure.setMessage("Admin Added Successfully...");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(admin_dao.saveAdmin(admin));
		return ResponseEntity.status(HttpStatus.CREATED).body(structure);
	}
	
	public ResponseEntity<ResponseStructure<Admin>> findById(int id){
		Optional<Admin> admDetails = admin_dao.findById(id);
		if(admDetails.isPresent()) {
			ResponseStructure<Admin> structure = new ResponseStructure<>();
			structure.setMessage("Admin found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(admDetails.get());
			return ResponseEntity.status(HttpStatus.FOUND).body(structure);
		}
		throw new AdminNotFound("Admin not found ");
	}
	
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin){
		Optional<Admin> admDetails = admin_dao.findById(admin.getId());
		if (admDetails.isPresent()) {
			ResponseStructure<Admin> structure = new ResponseStructure<>();
			Admin dbAdmin = admDetails.get();
			dbAdmin.setName(admin.getName());
			dbAdmin.setPhone(admin.getPhone());
			dbAdmin.setEmail(admin.getEmail());
			dbAdmin.setGst_number(admin.getGst_number());
			dbAdmin.setPassword(admin.getPassword());
			dbAdmin.setTravel_name(admin.getTravel_name());
			structure.setData(admin_dao.saveAdmin(dbAdmin));
		}
		throw new AdminNotFound("Admin not available");
	}
}
