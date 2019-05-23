package com.example.demo.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CursoDTO;
import com.example.demo.entities.CursoEntity;
import com.example.demo.repository.CursoRepository;

@Service
public class CursoManager {

	@Autowired
	private CursoRepository repository;
	
		public CursoRepository getRepository() {
			return repository;
		}
	public List<CursoDTO> dameCurso(){
		List<CursoEntity> listaEntities = repository.findAll();
		List<CursoDTO> dtolist =new ArrayList<>();
		for(CursoEntity entity : listaEntities) {
			dtolist.add(transformEntity(entity));
		}
		return dtolist;
	}
	public CursoEntity giveOneCurso (Long idCurso) {
		return repository.findById(idCurso).get();
	}
	public CursoDTO guardame(CursoDTO Cursodto) {
		CursoEntity dto = transformDTO(Cursodto);
		dto = repository.save(dto);
		return transformEntity(dto);
	}
	
	public CursoDTO transformEntity (CursoEntity entity) {
		CursoDTO dto= new CursoDTO();
		dto.setId(entity.getId()) ;
		dto.setNombre(entity.getNombre());
		return dto;
		
		
	}
	public CursoEntity transformDTO(CursoDTO curso) {
		CursoEntity entity= new CursoEntity();
		entity.setId(curso.getId());
		entity.setNombre(curso.getNombre());
		return entity;
		
	}
	public CursoEntity dameClaseEntity (Long id) {
		return repository.findById(id).orElse(new CursoEntity());
	}
}
