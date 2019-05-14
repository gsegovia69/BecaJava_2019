package com.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.spring.entities.ProfesorEntity;

public interface ProfesorRepository extends CrudRepository<ProfesorEntity, Integer> {
	
@Query("select p from ProfesorEntity p where p.email = :email and p.ciudad = :ciudad order by p.nombre asc,p.ciudad desc")
List<ProfesorEntity> filtrarEmailCiudad( @Param("email")String email,@Param("ciudad")String ciudad);

}