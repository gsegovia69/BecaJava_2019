package com.demo.prueba.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.prueba.entities.Profesor;
import com.demo.prueba.repository.ProfesorRepository;

@Service
public class ProfesorManager {

	@Autowired
	private ProfesorRepository repository;
	
	public ProfesorRepository getRepository() {
		return repository;
	}
	
	public List<Profesor> dameProfesores() {
		return (List<Profesor>) repository.findAll();
	}
	
	public Profesor dameUnProfesor(Integer idProfesor) {
		return repository.findOne(idProfesor).get();
	}
}
