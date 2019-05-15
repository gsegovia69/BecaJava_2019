package com.spring.managers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.dto.ClaseDTO;
import com.spring.entities.ClaseEntity;
import com.spring.repositories.ClaseRepository;

@Service
public class ClaseManager {

	@Autowired
	private ClaseRepository repository;
	
	public ClaseRepository getRepository() {
		return repository;
	}
	
	public List<ClaseDTO> getClases(){
		List<ClaseEntity> listaEntities =(List<ClaseEntity>) repository.findAll();
		List<ClaseDTO> dtoList= new ArrayList<>();
		for(ClaseEntity entity : listaEntities) {
			dtoList.add(entityToDTO(entity));
		}
		return dtoList;
	}
	
	
	public ClaseDTO getOneClase(Long idClase) {
		return entityToDTO(repository.findById(idClase).get());
	}
	
	public ClaseDTO guardarClase(ClaseDTO dto) {
		ClaseEntity entity = dtoToEntity(dto);
		entity = repository.save(entity);
		return entityToDTO(entity);
	}
	
	private ClaseDTO entityToDTO(ClaseEntity entity) {
		ClaseDTO dto = new ClaseDTO();
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		return dto;
		
	}
	private ClaseEntity dtoToEntity(ClaseDTO dto) {
		ClaseEntity entity = new ClaseEntity();
		entity.setId(dto.getId());
		entity.setNombre(dto.getNombre());
		return entity;
		
	}
}
