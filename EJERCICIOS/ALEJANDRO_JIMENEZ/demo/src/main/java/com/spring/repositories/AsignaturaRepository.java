package com.spring.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.spring.entities.Asignatura;

public interface AsignaturaRepository extends Repository<Asignatura, Long> {
	
	void delete(Asignatura deleted);
	
	List<Asignatura> findAll();
	
	Optional<Asignatura> findOne(Long id);
	
	Asignatura save(Asignatura persisted);
	
	@Query(value="Select a from Asignatura a where a.idClase = ?")
	List<Asignatura> dameAsignaturasPorCurso(Long idClase);
}
