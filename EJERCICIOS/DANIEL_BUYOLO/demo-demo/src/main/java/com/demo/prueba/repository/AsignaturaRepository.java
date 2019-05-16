package com.demo.prueba.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.demo.prueba.entities.AsignaturaEntity;

public interface AsignaturaRepository extends CrudRepository<AsignaturaEntity, Integer>{

	//public List<AsignaturaEntity> findAllOrderByNombreDesc();
}
