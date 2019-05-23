package com.spring.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spring.entities.AlumnoEntity;
import com.spring.entities.ClaseEntity;

public interface ClaseRepository extends CrudRepository<ClaseEntity, Long> {
	
	List<ClaseEntity> findAllByOrderByNombreAsc();	
	
}
