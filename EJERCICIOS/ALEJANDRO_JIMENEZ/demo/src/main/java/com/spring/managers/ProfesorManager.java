package com.spring.managers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.AlumnoDTO;
import com.spring.dto.ProfesorDTO;
import com.spring.entities.ProfesorEntity;
import com.spring.repositories.ProfesorRepository;

@Service
public class ProfesorManager {

	@Autowired
	private ProfesorRepository repository;
	
	@Autowired
	private ClaseManager claseManager;
	
	public ProfesorRepository getRepository() {
		return repository;
	}
	
	public List<ProfesorDTO> getProfesores(){
		List<ProfesorEntity> listaEntities = (List<ProfesorEntity>) repository.findAll();
		List<ProfesorDTO> listaDTO = new ArrayList<>();
		for(ProfesorEntity entity : listaEntities) {
			listaDTO.add(toDTO(entity));
		}
		return listaDTO;
	}
	
	public ProfesorDTO getOneProfesor(Long idProfesor) {
		ProfesorEntity entity = repository.findById(idProfesor).orElse(new ProfesorEntity());
		return toDTO(entity);
	}
	
	public ProfesorDTO guardarProfesor(ProfesorDTO dto) {
		ProfesorEntity entity = toEntity(dto);
		entity = repository.save(entity);
		return toDTO(entity);
	}
	
	
	public List<ProfesorDTO> filtrarProfe(ProfesorDTO dto){
		List <ProfesorDTO> dtoList = new ArrayList<ProfesorDTO>();
		List<ProfesorEntity> entityList = repository.filtrarEmailCiudad(dto.getNombre(), dto.getCiudad());
		for(ProfesorEntity entity : entityList) {
			ProfesorDTO auxDTO = toDTO(entity);
			dtoList.add(auxDTO);
		}
		return dtoList;
	}

	
	public void borrarProfesor(ProfesorDTO dto) {
		repository.delete(toEntity(dto));
	}
	
	
	private ProfesorDTO toDTO(ProfesorEntity entity) {
		ProfesorDTO dto = new ProfesorDTO();
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		dto.setApellidos(entity.getApellidos());
		dto.setEmail(entity.getEmail());
		dto.setCiudad(entity.getCiudad());
		
		try {
			dto.setNombreClase(entity.getClaseProfesor().getNombre());
			dto.setIdClase(entity.getClaseProfesor().getId());
		}
		catch(Exception e) {
			
		}
		return dto;
	}
	
	private ProfesorEntity toEntity(ProfesorDTO dto) {
		ProfesorEntity entity = new ProfesorEntity();
		entity.setId(dto.getId());
		entity.setNombre(dto.getNombre());
		entity.setApellidos(dto.getApellidos());
		entity.setEmail(dto.getEmail());
		entity.setCiudad(dto.getCiudad());
		entity.setClaseProfesor(claseManager.dameClaseEntitdad(dto.getIdClase()));
		return entity;
	}
}
