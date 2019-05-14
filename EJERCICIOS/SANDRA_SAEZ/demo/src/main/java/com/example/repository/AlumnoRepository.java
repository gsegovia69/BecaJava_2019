package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.example.entities.Alumno;

public interface AlumnoRepository extends Repository <Alumno, Integer> {

	void delete(Alumno borraAlumno);
	List<Alumno> findAll();
	Optional<Alumno> findOne(Integer idAlumno);
	Alumno save(Alumno guardaAlumno);
}