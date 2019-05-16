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
	
	@Autowired
	private ClaseManager clasemanager;
	
	public AsignaturaRepository getRepository() {
		return repository;
	}
	
	public List<AsignaturaDTO> getAsignaturas(){
		
		List<AsignaturaEntity> listaEntities =(List<AsignaturaEntity>) repository.findAll();
		List<AsignaturaDTO> dtoList= new ArrayList<>();
		for(AsignaturaEntity entity : listaEntities) {
			dtoList.add(toDTO(entity));
		}
		return dtoList;
	}
	
	public AsignaturaDTO getOneAsignatura(Long idAsignatura) {
		return toDTO(repository.findById(idAsignatura).get());
	}
	
	public AsignaturaDTO guardarAsignatura(AsignaturaDTO dto) {
		AsignaturaEntity entity = toEntity(dto);
		entity= repository.save(entity);
		return toDTO(entity);
	}
	
	private AsignaturaDTO toDTO(AsignaturaEntity entity) {
		AsignaturaDTO dto = new AsignaturaDTO();
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		dto.setOrden(entity.getOrden());
		if(entity.getClaseAsignatura().getId()!=null) {
			dto.setIdClase(entity.getClaseAsignatura().getId());
		}
		return dto;
		
	}
	
	private AsignaturaEntity toEntity(AsignaturaDTO dto) {
		AsignaturaEntity entity = new AsignaturaEntity();
		entity.setId(dto.getId());
		entity.setNombre(dto.getNombre());
		entity.setOrden(dto.getOrden());
		entity.setClaseAsignatura(clasemanager.dameClaseEntitdad(dto.getIdClase()));

		return entity;
		
	}
}