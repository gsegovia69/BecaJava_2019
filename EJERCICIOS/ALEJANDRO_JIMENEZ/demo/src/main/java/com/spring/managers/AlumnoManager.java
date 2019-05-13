package com.spring.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entities.Alumno;
import com.spring.repositories.AlumnoRepository;

@Service
public class AlumnoManager{

	@Autowired
	private AlumnoRepository repository;
	
	public AlumnoRepository getRepository() {
		return repository;
	}
	
	public List<Alumno> getAlumnos(){
		return (List<Alumno>) repository.findAll();
	}
	
	public Alumno getOneAlumno(Long idAlumno) {
		return repository.findById(idAlumno).get();
	}
}
