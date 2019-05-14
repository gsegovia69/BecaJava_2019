package com.example.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.repository.Repository;

import com.example.entities.Asignatura;

public interface AsignaturaRepository extends Repository<Asignatura, Integer>{
	void delete(Asignatura asignatura);
	List<Asignatura> findAll();
	Optional<Asignatura> findOne(int id);
	Asignatura save(Asignatura asignatura);
	

}