package com.demo.prueba.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.prueba.dto.AsignaturaDTO;
import com.demo.prueba.entities.AsignaturaEntity;
import com.demo.prueba.entities.ClaseEntity;
import com.demo.prueba.repository.AsignaturaRepository;

@Service
public class AsignaturaManager {

	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	@Autowired
	private ClaseManager claseManager;
	
	public AsignaturaRepository getRepository() {
		return asignaturaRepository;
	}
	
	public List<AsignaturaDTO> dameAsignaturas() {
		List<AsignaturaDTO> listaAsignaturaDto = new ArrayList<>();
		
		asignaturaRepository.findAll().forEach(asignaturaEntity -> listaAsignaturaDto.add(transformEntity(asignaturaEntity)));
		
		return listaAsignaturaDto;
	}
	
	public AsignaturaEntity guardaAsignaturaBaseDatos(AsignaturaDTO asignaturaDto) {
		AsignaturaEntity asignaturaEntity = transformDto(asignaturaDto);
		asignaturaEntity = asignaturaRepository.save(asignaturaEntity);
		
		return asignaturaEntity;
	}
	
	public AsignaturaDTO dameUnaAsignatura(Integer idAsignatura) {
		return transformEntity(asignaturaRepository.findById(idAsignatura).orElse(new AsignaturaEntity()));
		
	}
	
	private AsignaturaDTO transformEntity(AsignaturaEntity asignaturaEntity) {
		AsignaturaDTO asignaturaDTO = new AsignaturaDTO();
		
		asignaturaDTO.setId(asignaturaEntity.getIdAsignatura());
		asignaturaDTO.setNombre(asignaturaEntity.getNombreAsignatura());
		asignaturaDTO.setOrden(asignaturaEntity.getOrdenAsignaturas());
		asignaturaDTO.setIdClase(asignaturaEntity.getClaseAsignatura().getIdClase());
		asignaturaDTO.setNombreClase(asignaturaEntity.getClaseAsignatura().getNombreClase());
		asignaturaDTO.setListaClase(claseManager.dameClases());
		
		return asignaturaDTO;
	}
	
	private AsignaturaEntity transformDto(AsignaturaDTO asignaturaDto) {
		AsignaturaEntity asignaturaEntity = new AsignaturaEntity();
		
		asignaturaEntity.setIdAsignatura(asignaturaDto.getId());
		asignaturaEntity.setNombreAsignatura(asignaturaDto.getNombre());
		asignaturaEntity.setOrdenAsignaturas(asignaturaDto.getOrden());
		asignaturaEntity.setClaseAsignatura(transformClaseDtoaEntity(asignaturaDto));
		
		return asignaturaEntity;
	}
	
	private ClaseEntity transformClaseDtoaEntity(AsignaturaDTO asignaturaDto) {
		ClaseEntity claseEntity = new ClaseEntity();
		
		claseEntity.setIdClase(asignaturaDto.getIdClase());
		claseEntity.setNombreClase(asignaturaDto.getNombreClase());
		
		return claseEntity;
	}
}
