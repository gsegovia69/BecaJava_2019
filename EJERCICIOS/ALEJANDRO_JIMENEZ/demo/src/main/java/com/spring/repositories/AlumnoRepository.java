package com.spring.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spring.entities.AlumnoEntity;
import com.spring.entities.ProfesorEntity;

public interface AlumnoRepository extends CrudRepository<AlumnoEntity, Long> {

	List<AlumnoEntity> findAllByNombreOrderByApellidosAsc(String name);
	
	List<AlumnoEntity> findAllByNombreAndApellidosOrderByApellidosAsc(String name, String apellidos);
	
	List<AlumnoEntity> findAllByNombreOrApellidosOrCiudadOrderByEmailAsc(String name, String apellidos, String ciudad);
	
	List<AlumnoEntity> findAllByOrderByNombreDesc();
	
}
