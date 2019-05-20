package com.demo.prueba.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.prueba.dto.AlumnoDTO;
import com.demo.prueba.entities.AlumnoEntity;
import com.demo.prueba.entities.ClaseEntity;
import com.demo.prueba.repository.AlumnoRepository;

@Service
public class AlumnoManager {

	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private ClaseManager claseManager;
	
	public AlumnoRepository getRepository() {
		return alumnoRepository;
	}
	
	public List<AlumnoDTO> dameAlumnos() {
		List<AlumnoEntity> listaAlumnoEntity = alumnoRepository.findAll();
		List<AlumnoDTO> listaAlumnoDTO = new ArrayList<>();
		
		for (AlumnoEntity alumnoEntity : listaAlumnoEntity) {
			listaAlumnoDTO.add(transformEntity(alumnoEntity));
		}
		
		return listaAlumnoDTO;
	}
	
	public AlumnoDTO dameUnAlumno(Integer idAlumno) {
		return transformEntity(alumnoRepository.findById(idAlumno).orElse(new AlumnoEntity()));
	}
	
	public AlumnoEntity guardaAlumnoBaseDatos(AlumnoDTO alumnoDto) {
		AlumnoEntity alumnoEntity = transformDTO(alumnoDto);
		alumnoEntity = alumnoRepository.save(alumnoEntity);
		
		return alumnoEntity;
	}
	
	private AlumnoEntity transformDTO(AlumnoDTO alumnoDto ) {
		AlumnoEntity alumnoEntity = new AlumnoEntity();
		
		alumnoEntity.setIdAlumno(alumnoDto.getId());
		alumnoEntity.setNombreAlumno(alumnoDto.getNombre());
		alumnoEntity.setApellidosAlumno(alumnoDto.getApellidos());
		alumnoEntity.setEmailAlumno(alumnoDto.getEmail());
		alumnoEntity.setCiudadAlumno(alumnoDto.getCiudad());
		alumnoEntity.setClaseAlumno(transformClaseDtoaEntity(alumnoDto));
		
		return alumnoEntity;
	}
	
	public void borraAlumno(Integer id) {
		AlumnoEntity alumnoEntity = new AlumnoEntity();
		alumnoEntity.setIdAlumno(id);
		alumnoRepository.delete(alumnoEntity);
	}
	
	private AlumnoDTO transformEntity (AlumnoEntity alumnoEntity) {
		AlumnoDTO alumnoDto = new AlumnoDTO();
		
		if (alumnoEntity.getClaseAlumno() != null ) {
			alumnoDto.setId(alumnoEntity.getIdAlumno());
			alumnoDto.setNombre(alumnoEntity.getNombreAlumno());
			alumnoDto.setApellidos(alumnoEntity.getApellidosAlumno());
			alumnoDto.setEmail(alumnoEntity.getEmailAlumno());
			alumnoDto.setCiudad(alumnoEntity.getCiudadAlumno());
			alumnoDto.setIdClase(alumnoEntity.getClaseAlumno().getIdClase());
			alumnoDto.setNombreClase(alumnoEntity.getClaseAlumno().getNombreClase());
			alumnoDto.setListaClase(claseManager.dameClases());
		}
		
		return alumnoDto;
	}
	
	private ClaseEntity transformClaseDtoaEntity(AlumnoDTO alumnoDto) {
		ClaseEntity claseEntity = new ClaseEntity();
		
		claseEntity.setIdClase(alumnoDto.getIdClase());
		claseEntity.setNombreClase(alumnoDto.getNombreClase());
		
		return claseEntity;
	}
	
	public List<AlumnoDTO> listarAlumnosPorNombreOrdenadoApellidos(AlumnoDTO alumnoDto) {
		List<AlumnoDTO> listaAlumnoDto = new ArrayList<>();
		List<AlumnoEntity> listaAlumnoEntity = alumnoRepository.listaAlumnosPorNombreYOrdenadoPorApellido(alumnoDto.getNombre());
		
		for (AlumnoEntity alumnoEntity : listaAlumnoEntity) {
			AlumnoDTO dto = transformEntity(alumnoEntity);
			listaAlumnoDto.add(dto);
		}
		
		return listaAlumnoDto;
	}
}
