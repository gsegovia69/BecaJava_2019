package com.example.demo.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AsignaturaDTO;
import com.example.demo.entities.AsignaturaEntity;
import com.example.demo.repository.AsignaturaRepository;

@Service
public class AsignaturaManager {

	@Autowired
	private AsignaturaRepository repository;
	@Autowired
	private CursoManager cursoManager;
	
		public AsignaturaRepository getRepository() {
			return repository;
		}
	public List<AsignaturaDTO> dameAsignatura(){
		List<AsignaturaEntity> listaEntities = repository.findAll();
		List<AsignaturaDTO> dtolist =new ArrayList<>();
		for(AsignaturaEntity entity : listaEntities) {
			dtolist.add(transformEntity(entity));
		}
		return dtolist;
	}
	public AsignaturaDTO giveOneAsigantura (Long idAsignaturaDTO) {
		AsignaturaEntity entity= new AsignaturaEntity ();
		entity=repository.findById(idAsignaturaDTO).get();
		return transformEntity(entity);
	}
	public AsignaturaDTO guardame(AsignaturaDTO asignaturaDTO) {
		AsignaturaEntity entity = transformDTO(asignaturaDTO);
		entity = repository.save(entity);
		return transformEntity(entity);
	}
	public void borrameAsignatura (AsignaturaDTO asignatura) {
	AsignaturaEntity entity=transformDTO(asignatura);
	repository.delete(entity);
	}
	
	private AsignaturaDTO transformEntity (AsignaturaEntity asignaturaEntity) {
		AsignaturaDTO dto= new AsignaturaDTO();
		dto.setIdAsignatura(asignaturaEntity.getIdAsignatura());
		dto.setNombreAsignatura(asignaturaEntity.getNombreAsignatura());
		try {
		dto.setIdCurso(cursoManager.transformEntity(cursoManager.dameClaseEntity(asignaturaEntity.idCurso.getId())));
		}catch (Exception e) {}
		dto.setOrden(asignaturaEntity.getOrden());
		return dto;
	}
	private AsignaturaEntity transformDTO (AsignaturaDTO asignaturaDTO) {
		AsignaturaEntity entity= new AsignaturaEntity();
		entity.setIdAsignatura(asignaturaDTO.getIdAsignatura());
		entity.setNombreAsignatura(asignaturaDTO.getNombreAsignatura());
		entity.setIdCurso(cursoManager.dameClaseEntity(asignaturaDTO.getIdCurso().getId()));
		entity.setOrden(asignaturaDTO.getOrden());
		return entity;
		
	}
}
