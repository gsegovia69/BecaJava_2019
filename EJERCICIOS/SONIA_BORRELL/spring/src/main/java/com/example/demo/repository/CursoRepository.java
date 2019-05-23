package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.CursoEntity;

public interface CursoRepository extends CrudRepository<CursoEntity, Long> {
	void delete(CursoEntity deleted);

	List<CursoEntity> findAll();
	Optional<CursoEntity> findById(Long id);
	@SuppressWarnings("unchecked")
	CursoEntity save(CursoEntity persisted);

}

