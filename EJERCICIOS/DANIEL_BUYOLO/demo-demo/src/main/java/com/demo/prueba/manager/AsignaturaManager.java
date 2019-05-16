package com.demo.prueba.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.prueba.dto.AsignaturaDTO;
import com.demo.prueba.entities.AsignaturaEntity;
import com.demo.prueba.repository.AsignaturaRepository;

@Service
public class AsignaturaManager {

	@Autowired
	private AsignaturaRepository repository;
	
	public AsignaturaRepository getRepository() {
		return repository;
	}
	
	public List<AsignaturaDTO> dameAsignaturas() {
		List<AsignaturaDTO> listaAsignaturaDto = new ArrayList<>();
		
		repository.findAll().forEach(asignaturaEntity -> listaAsignaturaDto.add(transformEntity(asignaturaEntity)));
		
		return listaAsignaturaDto;
	}
	
	public AsignaturaDTO dameUnaAsignatura(Integer idAsignatura) {
		AsignaturaDTO asignaturaDTO = new AsignaturaDTO();
		AsignaturaEntity asignaturaEntity = repository.findById(idAsignatura).orElse(new AsignaturaEntity());
		
		asignaturaDTO.setIdAsignatura(asignaturaEntity.getIdAsignatura());
		asignaturaDTO.setNombreAsignatura(asignaturaEntity.getNombreAsignatura());
		asignaturaDTO.setOrdenAsignaturas(asignaturaEntity.getOrdenAsignaturas());
		
		return asignaturaDTO;
		
	}
	
	private AsignaturaDTO transformEntity(AsignaturaEntity asignaturaEntity) {
		AsignaturaDTO asignaturaDTO = new AsignaturaDTO();
		
		asignaturaDTO.setIdAsignatura(asignaturaEntity.getIdAsignatura());
		asignaturaDTO.setNombreAsignatura(asignaturaEntity.getNombreAsignatura());
		asignaturaDTO.setOrdenAsignaturas(asignaturaEntity.getOrdenAsignaturas());
		
		return asignaturaDTO;
	}
}
