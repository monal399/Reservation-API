package com.jsp.registration_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.registration_api.model.Admin;

public interface Admin_Repository extends JpaRepository<Admin, Integer> {
	public Optional<Admin> findById(int id);
}
