package com.spring.managers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.AsignaturaDTO;
import com.spring.entities.AsignaturaEntity;
import com.spring.repositories.AsignaturaRepository;

@Service
public class AsignaturaManager {
	@Autowired
	private AsignaturaRepository repository;
	
	public AsignaturaRepository getRepository() {
		return repository;
	}
	
	public List<AsignaturaDTO> getAlumnos(){
		
		List<AsignaturaEntity> listaEntities =repository.findAll();
		List<AsignaturaDTO> dtoList= new ArrayList<>();
		
		for(AsignaturaEntity entity : listaEntities) {
			dtoList.add(entityToDTO(entity));
		}
		return dtoList;
	}
	
	public AsignaturaDTO getOneAsignatura(Long idAsignatura) {
		return entityToDTO(repository.findOne(idAsignatura).get());
	}
	
	public AsignaturaDTO guardar(AsignaturaDTO dto) {
		AsignaturaEntity entity = dtoToEntity(dto);
		entity= repository.save(entity);
		return entityToDTO(entity);
	}
	
	
	
	private AsignaturaDTO entityToDTO(AsignaturaEntity entity) {
		AsignaturaDTO dto = new AsignaturaDTO();
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		dto.setOrden(entity.getOrden());
		return dto;
		
	}
	private AsignaturaEntity dtoToEntity(AsignaturaDTO dto) {
		AsignaturaEntity entity = new AsignaturaEntity();
		entity.setId(dto.getId());
		entity.setNombre(dto.getNombre());
		entity.setOrden(dto.getOrden());
		return entity;
		
	}
}