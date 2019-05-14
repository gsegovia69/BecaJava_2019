package com.example.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.AsignaturaDTO;
import com.example.dto.ProfesorDTO;
import com.example.entities.Asignatura;
import com.example.entities.Profesor;
import com.example.repository.ProfesorRepository;

@Service
public class ProfesorManager {

	@Autowired
	private ProfesorRepository repository;
	
	public ProfesorRepository getRepository() {
		return repository;
	}
	

	
	public List<ProfesorDTO> dameProfesores(){
		List<Profesor> entityList = repository.findAll();
		List<ProfesorDTO> dtoList = new ArrayList<>();
		for (Profesor entity : entityList) {
			dtoList.add(transformEntity(entity));
		}
		return dtoList;
	}
	 
	
	private ProfesorDTO transformEntity(Profesor entity) {
		ProfesorDTO dto = new ProfesorDTO();
		dto.setId(entity.getIdProfesor());
		dto.setNombre(entity.getNombreProfesor());
		return dto;
	}



	public Profesor dameUnProfesor(Integer idProfesor) {
		return repository.findOne(idProfesor).get();
	}
}