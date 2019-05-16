package com.demo.prueba.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.demo.prueba.entities.AlumnoEntity;

public interface AlumnoRepository extends Repository <AlumnoEntity, Integer> {

	void delete(AlumnoEntity borraAlumno);
	List<AlumnoEntity> findAll();
	Optional<AlumnoEntity> findById(Integer idAlumno);
	AlumnoEntity save(AlumnoEntity guardaAlumno);
	
	//public List<AlumnoEntity> findAllByNombreOrderByApellidosAsc(String name);
	
	// 1. Metodo con consulta JPQL para obetener un listado de Alumnos filtrando por Nombre y 
	// ordenado por Apellidos de forma descendente
	@Query("SELECT a FROM AlumnoEntity a WHERE a.nombreAlumno= :nombre ORDER BY a.apellidosAlumno DESC")
	List<AlumnoEntity> listaAlumnosPorNombreYOrdenadoPorApellido(@Param("nombre") String nombre);
	
}
