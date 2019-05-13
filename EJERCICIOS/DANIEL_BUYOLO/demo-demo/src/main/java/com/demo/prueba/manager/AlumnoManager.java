package com.demo.prueba.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.prueba.entities.Alumno;
import com.demo.prueba.repository.AlumnoRepository;

@Service
public class AlumnoManager {

	@Autowired
	private AlumnoRepository repository;
	
	public AlumnoRepository getRepository() {
		return repository;
	}
	
	public List<Alumno> dameAlumnos() {
		return (List<Alumno>) repository.findAll();
	}
	
	public Alumno dameUnAlumno(Integer idAlumno) {
		return repository.findOne(idAlumno).get();
	}
}
