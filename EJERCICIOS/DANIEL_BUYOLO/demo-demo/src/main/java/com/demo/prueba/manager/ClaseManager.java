package com.demo.prueba.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.prueba.dto.ClaseDTO;
import com.demo.prueba.entities.ClaseEntity;
import com.demo.prueba.repository.ClaseRepository;

@Service
public class ClaseManager {

	@Autowired
	private ClaseRepository repository;
	
	public ClaseRepository getRepository() {
		return repository;
	}
	
	public List<ClaseDTO> dameClases() {
		List<ClaseDTO> listaClaseDto = new ArrayList<>();
		
		repository.findAll().forEach(claseEntity -> listaClaseDto.add(transformEntity(claseEntity)));
		
		return listaClaseDto;
	}
	
	public ClaseDTO dameUnaClase(Integer idClase) {
		ClaseDTO claseDTO = new ClaseDTO();
		ClaseEntity claseEntity = repository.findById(idClase).orElse(new ClaseEntity());
		
		claseDTO.setIdClase(claseEntity.getIdClase());
		claseDTO.setNombreClase(claseEntity.getNombreClase());
		
		return claseDTO;
		
	}
	
	private ClaseDTO transformEntity(ClaseEntity claseEntity) {
		ClaseDTO claseDTO = new ClaseDTO();
		
		claseDTO.setIdClase(claseEntity.getIdClase());
		claseDTO.setNombreClase(claseEntity.getNombreClase());
		
		return claseDTO;
	}
}
