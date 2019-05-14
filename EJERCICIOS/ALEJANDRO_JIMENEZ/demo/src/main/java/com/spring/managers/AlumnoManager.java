package com.spring.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.AlumnoDTO;
import com.spring.entities.AlumnoEntity;
import com.spring.repositories.AlumnoRepository;

@Service
public class AlumnoManager{

	@Autowired
	private AlumnoRepository repository;
	
	public AlumnoRepository getRepository() {
		return repository;
	}
	
	public List<AlumnoEntity> getAlumnos(){
		return (List<AlumnoEntity>) repository.findAll();
	}
	

	public AlumnoDTO getOneAlumno(Long idAlumno) {
		return entityToDTO(repository.findById(idAlumno).get());
	}
	
	public AlumnoDTO guardarAlumno(AlumnoDTO dto) {
		AlumnoEntity entity = dtoToEntity(dto);
		entity = repository.save(entity);
		return entityToDTO(entity);
	}

	private AlumnoDTO entityToDTO (AlumnoEntity entity) {
		AlumnoDTO dto = new AlumnoDTO();
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		dto.setApellidos(entity.getApellidos());
		dto.setEmail(entity.getEmail());
		dto.setCiudad(entity.getCiudad());
		return dto;
		
	}
	private AlumnoEntity dtoToEntity(AlumnoDTO dto) {
		AlumnoEntity entity = new AlumnoEntity();
		entity.setId(dto.getId());
		entity.setNombre(dto.getNombre());
		entity.setApellidos(dto.getApellidos());
		entity.setEmail(dto.getEmail());
		entity.setCiudad(dto.getCiudad());
		return entity;
	}
}
