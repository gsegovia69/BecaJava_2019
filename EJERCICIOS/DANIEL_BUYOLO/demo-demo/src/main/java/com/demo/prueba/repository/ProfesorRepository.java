package com.demo.prueba.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.demo.prueba.entities.Profesor;

public interface ProfesorRepository extends Repository <Profesor, Integer>{

	void delete(Profesor borraAlumno);
	List<Profesor> findAll();
	Optional<Profesor> findOne(Integer idAlumno);
	Profesor save(Profesor guardaAlumno);
}
