package com.spring.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.Repository;

import com.spring.entities.AsignaturaEntity;


public interface AsignaturaRepository extends Repository<AsignaturaEntity, Long> {
	
	void delete(AsignaturaEntity deleted);
	
	List<AsignaturaEntity> findAll();
	
	Optional<AsignaturaEntity> findOne(Long id);
	
	AsignaturaEntity save(AsignaturaEntity persisted);
	
	
	
}
