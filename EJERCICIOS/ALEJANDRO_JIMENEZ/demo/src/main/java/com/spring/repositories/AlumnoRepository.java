package com.spring.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.spring.entities.AlumnoEntity;


public interface AlumnoRepository extends CrudRepository<AlumnoEntity, Long> {
	
	
	
	List<AlumnoEntity> findAllByOrderByIdAsc();
	List<AlumnoEntity> findAllByOrderByIdDesc();
	
	
	List<AlumnoEntity> findAllByOrderByNombreAsc();
	List<AlumnoEntity> findAllByOrderByNombreDesc();
	
	List<AlumnoEntity> findAllByOrderByApellidosAsc();
	List<AlumnoEntity> findAllByOrderByApellidosDesc();
	
	List<AlumnoEntity> findAllByOrderByEmailAsc();
	List<AlumnoEntity> findAllByOrderByEmailDesc();

	List<AlumnoEntity> findAllByOrderByCiudadAsc();
	List<AlumnoEntity> findAllByOrderByCiudadDesc();
	
	List<AlumnoEntity> findAllByNombreOrderByNombreAsc(String nombre);	
	
}
