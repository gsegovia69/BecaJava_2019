package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.ProfesorEntity;

public interface ProfesorRepository extends Repository<ProfesorEntity, Long> {
	void delete (ProfesorEntity deleted);
	List<ProfesorEntity> findAll();
	Optional<ProfesorEntity> findById(Long id);
	ProfesorEntity save(ProfesorEntity persisted);

	
	//metodo con consulta SQL par aobetner un listado de profesores 
	//filtrado por email y ciudad y ordenado por nombre de forma ascendente y por ciudad de forma descendente

	
	@Query(value = "SELECT * FROM ProfesorEntity p WHERE p.email = :email AND p.ciudad = :ciudad ORDER BY p.nombre, p.ciudad desc",
		nativeQuery=true)
	List<ProfesorEntity> ProfesorOrdenado (@Param("email") String email, @Param ("ciudad") String ciudad);

}