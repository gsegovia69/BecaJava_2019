package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.example.entities.Profesor;

public interface ProfesorRepository extends Repository <Profesor, String>{

	void delete(Profesor asignatura);
	List<Profesor> findAll();
	Optional<Profesor> findOne(Integer idAlumno);
	Profesor save(Profesor guardaAlumno);
	
	

}

