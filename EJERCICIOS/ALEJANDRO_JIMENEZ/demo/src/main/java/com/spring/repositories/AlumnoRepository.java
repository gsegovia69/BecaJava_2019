package com.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import com.spring.entities.Alumno;

public interface AlumnoRepository extends CrudRepository<Alumno, Long> {

}
