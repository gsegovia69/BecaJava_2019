package com.spring.managers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.dto.ProfesorDTO;
import com.spring.entities.ProfesorEntity;
import com.spring.repositories.ProfesorRepository;

public class ProfesorManager {

	@Autowired
	private ProfesorRepository repository;
	
	public ProfesorRepository getRepository() {
		return repository;
	}
	
	public List<ProfesorDTO> getProfesores(){
		List<ProfesorEntity> listaEntities = (List<ProfesorEntity>) repository.findAll();
		List<ProfesorDTO> listaDTO = new ArrayList<>();
		for(ProfesorEntity entity : listaEntities) {
			listaDTO.add(entityToDTO(entity));
		}
		return listaDTO;
	}
	
	public ProfesorDTO getOneProfesor(int idProfesor) {
		return entityToDTO(repository.findById(idProfesor).get());
	}
	
	public ProfesorDTO guardarProfesor(ProfesorDTO dto) {
		ProfesorEntity entity = dtoToEntity(dto);
		entity = repository.save(entity);
		return entityToDTO(entity);
	}
	
	
	public List<ProfesorDTO> filtrarProfe(ProfesorDTO dto){
		List <ProfesorDTO> dtoList = new ArrayList<ProfesorDTO>();
		List<ProfesorEntity> entityList = repository.filtrarEmailCiudad(dto.getNombre(), dto.getCiudad());
		for(ProfesorEntity entity : entityList) {
			ProfesorDTO auxDTO = entityToDTO(entity);
			dtoList.add(auxDTO);
		}
		return dtoList;
	}

	
	
	
	
	private ProfesorDTO entityToDTO(ProfesorEntity entity) {
		ProfesorDTO dto = new ProfesorDTO();
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		dto.setApellidos(entity.getApellidos());
		dto.setEmail(entity.getEmail());
		dto.setCiudad(entity.getCiudad());
		return dto;
		
	}
	private ProfesorEntity dtoToEntity(ProfesorDTO dto) {
		ProfesorEntity entity = new ProfesorEntity();
		entity.setId(dto.getId());
		entity.setNombre(dto.getNombre());
		entity.setApellidos(dto.getApellidos());
		entity.setEmail(dto.getEmail());
		entity.setCiudad(dto.getCiudad());
		return entity;
	}
}
