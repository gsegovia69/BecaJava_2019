package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.AsignaturaEntity;

public interface AsignaturaRepository extends CrudRepository<AsignaturaEntity, Long> {
	void delete(AsignaturaEntity deleted);

	List<AsignaturaEntity> findAll();
	Optional<AsignaturaEntity> findByIdAsignatura(Long idAsignatura);
	AsignaturaEntity save(AsignaturaEntity asignatura);

}
