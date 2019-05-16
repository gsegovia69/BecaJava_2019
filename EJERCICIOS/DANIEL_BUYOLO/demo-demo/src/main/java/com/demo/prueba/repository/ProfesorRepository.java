package com.demo.prueba.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.demo.prueba.entities.ProfesorEntity;

public interface ProfesorRepository extends Repository <ProfesorEntity, Integer>{

	void delete(ProfesorEntity borraAlumno);
	List<ProfesorEntity> findAll();
	Optional<ProfesorEntity> findById(Integer idAlumno);
	ProfesorEntity save(ProfesorEntity guardaAlumno);
	
	
	// 2.Metodo con consulta SQL para obtener un listado de profesores filtrando por Email y Ciudad
	// ordenando por Nombre de forma ascendente y por Ciudad de forma descendente
	@Query(value = "SELECT * FROM profesor p WHERE  p.email= :email AND p.ciudad= :ciudad ORDER BY nombre ASC, ciudad DESC", 
			nativeQuery=true)
	public List<ProfesorEntity> listaProfesorPorEmailCiudadOrderNombreCiudad(@Param("email") String email, @Param("ciudad") String ciudad);
}
