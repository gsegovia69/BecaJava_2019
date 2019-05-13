package com.spring.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.spring.entities.Profesor;

public interface ProfesorRepository extends Repository<Profesor, Integer> {
	
	void delete(Profesor deleted);
	
	List<Profesor> findAll();
	
	Optional<Profesor> findOne(int id);
	
	Profesor save(Profesor persisted);
}
