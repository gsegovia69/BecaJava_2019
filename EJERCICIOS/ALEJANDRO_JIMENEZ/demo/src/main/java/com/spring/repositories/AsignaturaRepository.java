package com.spring.repositories;



import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spring.entities.AlumnoEntity;
import com.spring.entities.AsignaturaEntity;


public interface AsignaturaRepository extends CrudRepository<AsignaturaEntity, Long> {
	
	List<AsignaturaEntity> findAllByOrderByNombreAsc();	
	
}
