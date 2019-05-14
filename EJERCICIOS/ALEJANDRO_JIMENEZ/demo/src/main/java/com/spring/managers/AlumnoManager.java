package com.spring.managers;

import java.util.ArrayList;
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
		AlumnoEntity entity = repository.findById(idAlumno).orElse(new AlumnoEntity());
		return entityToDTO(entity);
	}
	
	public AlumnoDTO guardarAlumno(AlumnoDTO dto) {
		AlumnoEntity entity = dtoToEntity(dto);
		entity = repository.save(entity);
		return entityToDTO(entity);
	}

	public List<AlumnoDTO> buscarPorNombreDesc(String name){
		List <AlumnoDTO> dtoList = new ArrayList<>();
		repository.findAllByNombreOrderByApellidosDesc(name)
		.forEach(entity -> dtoList.add(entityToDTO(entity)));
		return dtoList;
	}
	public List<AlumnoDTO> buscarPorNombreApellidos(String name,String apellidos){
		List <AlumnoDTO> dtoList = new ArrayList<>();
		repository.findAllByNombreAndApellidosOrderByApellidosAsc(name,apellidos)
		.forEach(entity -> dtoList.add(entityToDTO(entity)));
		return dtoList;
	}
	public List<AlumnoDTO> buscarPorNombreApellidosCiudad(String name,String apellidos,String ciudad){
		List <AlumnoDTO> dtoList = new ArrayList<>();
		repository.findAllByNombreOrApellidosOrCiudadOrderByEmailAsc(name,apellidos,ciudad)
		.forEach(entity -> dtoList.add(entityToDTO(entity)));
		return dtoList;
	}
	
	public List<AlumnoDTO> buscarTodo(String name,String apellidos,String ciudad){
		List <AlumnoDTO> dtoList = new ArrayList<>();
		repository.findAllByOrderByNombreDesc()
		.forEach(entity -> dtoList.add(entityToDTO(entity)));
		return dtoList;
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
