package com.spring.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.entities.ClaseEntity;
import com.spring.repositories.ClaseRepository;

public class ClaseManager {

	@Autowired
	private ClaseRepository repository;
	
	public ClaseRepository getRepository() {
		return repository;
	}
	
	public List<ClaseEntity> getClase(){
		return (List<ClaseEntity>) repository.findAll();
	}
	
	public ClaseEntity getOneClase(int idClase) {
		return repository.findById(idClase).get();
	}
}
