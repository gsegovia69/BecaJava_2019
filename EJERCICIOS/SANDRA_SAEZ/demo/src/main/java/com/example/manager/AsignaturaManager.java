package com.example.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.AsignaturaDTO;
import com.example.entities.Asignatura;
import com.example.repository.AsignaturaRepository;

@Service
public class AsignaturaManager {
@Autowired	
private AsignaturaRepository repository;

public AsignaturaRepository getRepository() {
	return repository;
	
}

public List<AsignaturaDTO> dameAsignaturas(){
	List<Asignatura> entityList = repository.findAll();
	List<AsignaturaDTO> dtoList = new ArrayList<>();
	for (Asignatura entity : entityList) {
		dtoList.add(transformEntity(entity));
	}
	return dtoList;
}
 


private AsignaturaDTO transformEntity(Asignatura entity) {
	AsignaturaDTO dto = new AsignaturaDTO();
	dto.setId(entity.getIdAsignatura());
	dto.setNombre(entity.getNombreAsignatura());
	return dto;
}

}
