package com.jsp.registration_api.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.registration_api.model.Admin;
import com.jsp.registration_api.repository.Admin_Repository;

@Repository
public class Admin_dao {
	@Autowired
	private Admin_Repository admin_Repository;
	
	public Admin saveAdmin(Admin admin) {
		return admin_Repository.save(admin);
	}
	public Optional<Admin> findById(int id) {
		return admin_Repository.findById(id);
	}
}
