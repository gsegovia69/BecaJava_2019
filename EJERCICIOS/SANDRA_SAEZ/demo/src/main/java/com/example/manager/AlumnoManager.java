package com.example.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.AlumnoDTO;
import com.example.entities.Alumno;
import com.example.repository.AlumnoRepository;


@Service
public class AlumnoManager {

	@Autowired
	private AlumnoRepository repository;
	
	public AlumnoRepository getRepository() {
		return repository;
	}
	
	public List<AlumnoDTO> dameAlumnos(){
		List<AlumnoDTO> dtoList = new ArrayList<>();
		repository.findAll().forEach(entity -> dtoList.add(transformEntity(entity)));
		return dtoList;
	}
	
	
	
//	public List<Alumno> dameAlumnos() {
//		return (List<Alumno>) repository.findAll();
//	}
	
	public Alumno dameUnAlumno(Integer idAlumno) {
		return repository.findOne(idAlumno).get();
	}
	
	private AlumnoDTO transformEntity(Alumno entity) {
		AlumnoDTO dto = new AlumnoDTO();
		dto.setId(entity.getIdAlumno());
		dto.setNombre(entity.getNombreAlumno());
		return dto;
	}
}