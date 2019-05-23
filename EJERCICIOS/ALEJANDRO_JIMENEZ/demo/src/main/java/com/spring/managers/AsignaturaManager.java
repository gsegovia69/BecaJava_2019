package com.spring.managers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.AlumnoDTO;
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
	
	public List<AsignaturaDTO> buscarNombre(String nombre){
		List<AsignaturaDTO> lista=new ArrayList<>();
		List<AsignaturaDTO> dtoList=new ArrayList<>();
		repository.findAllByOrderByNombreAsc().forEach(entity -> lista.add(toDTO(entity))); 
		for(int i = 0 ; i<lista.size();i++) {
			if(lista.get(i).getNombre().contains(nombre)) {
				dtoList.add(lista.get(i));
			}
		}
		return dtoList;
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
		try {
			dto.setIdClase(entity.getClaseAsignatura().getId());
			dto.setNombreClase(entity.getClaseAsignatura().getNombre());
		}
		catch(Exception e) {
			
		}
		return dto;
		
	}
	
	public void borrarAsignatura(AsignaturaDTO dto) {
		repository.delete(toEntity(dto));
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