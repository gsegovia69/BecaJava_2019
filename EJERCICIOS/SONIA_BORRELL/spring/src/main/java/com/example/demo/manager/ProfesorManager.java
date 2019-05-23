package com.example.demo.manager;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.demo.dto.ProfesorDTO;
import com.example.demo.entities.ProfesorEntity;
import com.example.demo.repository.ProfesorRepository;

@Service
public class ProfesorManager {
	@Autowired
	private ProfesorRepository repository;
@Autowired
public CursoManager cursoManager;

	public ProfesorRepository getRepository() {
		return repository;
	}

	public List<ProfesorDTO> dameProfesor() {
		List<ProfesorEntity> listaEntities = repository.findAll();
		List<ProfesorDTO> dtolist = new ArrayList<>();
		for (ProfesorEntity entity : listaEntities) {
			dtolist.add(transformEntity(entity));
		}
		return dtolist;
	}

	public List<ProfesorDTO> dameProfesorFiltrado(String email, String ciudad) {
		List<ProfesorEntity> listaEntities = repository.ProfesorOrdenado(email, ciudad);
		List<ProfesorDTO> dtolist = new ArrayList<>();
		for (ProfesorEntity entity : listaEntities) {
			dtolist.add(transformEntity(entity));
		}
		return dtolist;
	}

	public ProfesorDTO giveOneProfesor(Long idProfesor) {
		ProfesorEntity entity=new ProfesorEntity();
		entity=repository.findById(idProfesor).get();
		return transformEntity(entity);
	}

	public ProfesorDTO guardame(ProfesorDTO profesordto) {
		ProfesorEntity dto = transformDTO(profesordto);
		dto = repository.save(dto);
		return transformEntity(dto);
	}
	
	public void borraProfesor (ProfesorDTO profesor) {
		ProfesorEntity entity=transformDTO (profesor);
		repository.delete(entity);
	}

	private ProfesorDTO transformEntity(ProfesorEntity profesorentity) {
		ProfesorDTO dto = new ProfesorDTO();
		dto.setNombreProfesor(profesorentity.getNombreProfesor());
		dto.setApellidosProfesor(profesorentity.getApellidosProfesor());
		dto.setCiudadProfesor(profesorentity.getCiudadProfesor());
		dto.setEmailProfesor(profesorentity.getEmailProfesor());
		dto.setId(profesorentity.getId());
		try {
		dto.setIdCurso(cursoManager.transformEntity(cursoManager.dameClaseEntity(profesorentity.getIdCurso().getId())));
		}catch(Exception e) {}
		return dto;
	}

	private ProfesorEntity transformDTO(ProfesorDTO profesordto) {
		ProfesorEntity entity = new ProfesorEntity();
		entity.setNombreProfesor(profesordto.getNombreProfesor());
		entity.setApellidosProfesor(profesordto.getApellidosProfesor());
		entity.setCiudadProfesor(profesordto.getCiudadProfesor());
		entity.setEmailProfesor(profesordto.getEmailProfesor());
		entity.setId(profesordto.getId());
		entity.setIdCurso(cursoManager.dameClaseEntity(profesordto.getIdCurso().getId()));
		return entity;
	}
}
