package com.demo.prueba.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.demo.prueba.entities.Alumno;

public interface AlumnoRepository extends Repository <Alumno, Integer> {

	void delete(Alumno borraAlumno);
	List<Alumno> findAll();
	Optional<Alumno> findOne(Integer idAlumno);
	Alumno save(Alumno guardaAlumno);
}
