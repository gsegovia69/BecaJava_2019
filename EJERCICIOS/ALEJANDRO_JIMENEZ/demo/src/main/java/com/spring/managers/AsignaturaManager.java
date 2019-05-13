package com.spring.managers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.AsignaturaDTO;
import com.spring.entities.Asignatura;
import com.spring.repositories.AsignaturaRepository;

@Service
public class AsignaturaManager {
	@Autowired
	private AsignaturaRepository repository;
	
	public AsignaturaRepository getRepository() {
		return repository;
	}
	
	public List<AsignaturaDTO> getAlumnos(){
		
		List<Asignatura> listaEntities =repository.findAll();
		List<AsignaturaDTO> dtoList= new ArrayList<>();
		
		for(Asignatura entity : listaEntities) {
			dtoList.add(transformEntity(entity));
		}
		return dtoList;
	}
	
	public AsignaturaDTO getOneAsignatura(Long idAsignatura) {
		return transformEntity(repository.findOne(idAsignatura).get());
	}
	public AsignaturaDTO guardar(AsignaturaDTO dto) {
		Asignatura entity = transformDTO(dto);
		entity= repository.save(entity);
		return transformEntity(entity);
	}
	private AsignaturaDTO transformEntity(Asignatura asignatura) {
		AsignaturaDTO dto = new AsignaturaDTO();
		dto.setId(asignatura.getId());
		dto.setNombre(asignatura.getNombre());
		dto.setOrden(asignatura.getOrden());
		dto.setIdClase(asignatura.getId());
		return dto;
		
	}
	private Asignatura transformDTO(AsignaturaDTO dto) {
		Asignatura entity = new Asignatura();
		entity.setId(dto.getId());
		entity.setNombre(dto.getNombre());
		entity.setOrden(dto.getOrden());
		return entity;
		
	}
}
