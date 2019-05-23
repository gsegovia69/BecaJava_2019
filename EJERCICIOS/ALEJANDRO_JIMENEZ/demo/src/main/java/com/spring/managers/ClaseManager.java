package com.spring.managers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.AsignaturaDTO;
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
			dtoList.add(toDTO(entity));
		}
		return dtoList;
	}
	
	public List<ClaseDTO> buscarNombre(String nombre){
		List<ClaseDTO> lista=new ArrayList<>();
		List<ClaseDTO> dtoList=new ArrayList<>();
		repository.findAllByOrderByNombreAsc().forEach(entity -> lista.add(toDTO(entity))); 
		for(int i = 0 ; i<lista.size();i++) {
			if(lista.get(i).getNombre().contains(nombre)) {
				dtoList.add(lista.get(i));
			}
		}
		return dtoList;
	}
	
	public ClaseDTO getOneClase(Long idClase) {
		 ClaseEntity entity =repository.findById(idClase).get();
		 ClaseDTO clase = toDTO(entity);
		return clase;
	}
	
	public ClaseDTO guardarClase(ClaseDTO dto) {
		ClaseEntity entity = toEntity(dto);
		entity = repository.save(entity);
		return toDTO(entity);
	}
	
	private ClaseDTO toDTO(ClaseEntity entity) {
		ClaseDTO dto = new ClaseDTO();
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		return dto;
		
	}
	private ClaseEntity toEntity(ClaseDTO dto) {
		ClaseEntity entity = new ClaseEntity();
		entity.setId(dto.getId());
		entity.setNombre(dto.getNombre());
		return entity;
		
	}
	
	public ClaseEntity dameClaseEntitdad (Long id) {
		return repository.findById(id).orElse(new ClaseEntity());
	}
}
