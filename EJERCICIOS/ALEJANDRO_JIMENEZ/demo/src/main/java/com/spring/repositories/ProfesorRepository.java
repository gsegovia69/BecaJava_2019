package com.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.spring.entities.AlumnoEntity;
import com.spring.entities.ProfesorEntity;

public interface ProfesorRepository extends CrudRepository<ProfesorEntity, Long> {
	
@Query("select p from ProfesorEntity p where p.email = :email and p.ciudad = :ciudad order by p.nombre asc,p.ciudad desc")
List<ProfesorEntity> filtrarEmailCiudad( @Param("email")String email,@Param("ciudad")String ciudad);


List<ProfesorEntity> findAllByOrderByIdAsc();
List<ProfesorEntity> findAllByOrderByIdDesc();


List<ProfesorEntity> findAllByOrderByNombreAsc();
List<ProfesorEntity> findAllByOrderByNombreDesc();

List<ProfesorEntity> findAllByOrderByApellidosAsc();
List<ProfesorEntity> findAllByOrderByApellidosDesc();

List<ProfesorEntity> findAllByOrderByEmailAsc();
List<ProfesorEntity> findAllByOrderByEmailDesc();

List<ProfesorEntity> findAllByOrderByCiudadAsc();
List<ProfesorEntity> findAllByOrderByCiudadDesc();

List<ProfesorEntity> findAllByNombreOrderByNombreAsc(String nombre);	


}