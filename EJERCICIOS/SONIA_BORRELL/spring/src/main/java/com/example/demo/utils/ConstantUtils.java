package com.example.demo.utils;

import com.example.demo.dto.CursoDTO;
import com.example.demo.entities.CursoEntity;

public class ConstantUtils {
	public static CursoDTO conversorCursoToCursoDTO(CursoEntity entity) {
		CursoDTO dto = new CursoDTO();
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		return dto;
	}
	public static CursoEntity conversorCursoDTOToCurso(CursoDTO dto) {
		CursoEntity entity = new CursoEntity();
		entity.setId(dto.getId());
		entity.setNombre(dto.getNombre());
		return entity; 
	}
}
