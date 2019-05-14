package com.spring.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spring.dto.ProfesorDTO;
import com.spring.entities.ProfesorEntity;

public interface ProfesorRepository extends CrudRepository<ProfesorEntity, Integer> {
	


}
