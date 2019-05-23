package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.example.demo.entities.AlumnoEntity;

public interface AlumnoRepository extends Repository<AlumnoEntity, Long> {
	void delete(AlumnoEntity deleted);

	List<AlumnoEntity> findAll();
	Optional<AlumnoEntity> findById(Long id);
	AlumnoEntity save(AlumnoEntity persisted);

//  Devuelve la consulta en forma de lista todos los nombre y apellidos ordenados por apellidos
List<AlumnoEntity> findAllByNombreAlumnoOrderByApellidosAlumnoAsc(String nombre);

//[ASC (ascendente), DESC(descendente)]
//metodo con consulta JPQL para obtener un listado de Alumnos filtrando por NOmbre y ordenado por Apellidos de forma descendente
//Este metodo hay que especificar el orden con un numero y luego hay p q poner en ese mismo orden la recuperacion de datos
// si hubiera muchos datos es mejor de la forma especificada en ProfesorRepository
@Query("SELECT t FROM AlumnoEntity t WHERE t.nombreAlumno= ?1 ORDER BY t.apellidosAlumno desc")
public List<AlumnoEntity> alumnosordenados(String nombre);
//
@Query("SELECT t FROM AlumnoEntity t ORDER BY t.nombreAlumno asc")
public List<AlumnoEntity> findAllByOrderByNombreAsc();

@Query("SELECT t FROM AlumnoEntity t ORDER BY t.nombreAlumno desc")
public List<AlumnoEntity> findAllByOrderByNombreDesc();

@Query("SELECT t FROM AlumnoEntity t ORDER BY t.nombreAlumno")
public List<AlumnoEntity> findAllByOrderByNombre();

public Page<AlumnoEntity> findAllByOrderByApellidosAlumno(Pageable pageable);
}
