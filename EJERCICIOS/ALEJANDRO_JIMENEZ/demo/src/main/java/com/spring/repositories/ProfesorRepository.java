package com.spring.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.spring.entities.ProfesorEntity;

public interface ProfesorRepository extends Repository<ProfesorEntity, Integer> {
	
	void delete(ProfesorEntity deleted);
	
	List<ProfesorEntity> findAll();
	
	Optional<ProfesorEntity> findOne(Long id);
	
	ProfesorEntity save(ProfesorEntity persisted);
}
