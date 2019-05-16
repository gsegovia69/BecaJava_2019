package com.spring.utils;
import com.spring.dto.ClaseDTO;
import com.spring.entities.ClaseEntity;
import com.spring.managers.ClaseManager;

public class Conversor {

	public Long ClaseToLong(ClaseEntity clase) {
		Long id= clase.getId();
		
		return id;
	}
	private ClaseEntity dtoToEntity(ClaseDTO dto) {
		ClaseEntity entity = new ClaseEntity();
		entity.setId(dto.getId());
		entity.setNombre(dto.getNombre());
		return entity;
	}
	public ClaseEntity LongToClase(Long id) {
		ClaseManager cm = new ClaseManager();
		return dtoToEntity(cm.getOneClase((long) 1));
	}
}
