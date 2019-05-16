package com.demo.prueba.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.prueba.dto.ProfesorDTO;
import com.demo.prueba.entities.ClaseEntity;
import com.demo.prueba.entities.ProfesorEntity;
import com.demo.prueba.repository.ProfesorRepository;

@Service
public class ProfesorManager {

	@Autowired
	private ProfesorRepository repository;
	
	public ProfesorRepository getRepository() {
		return repository;
	}
	
	public List<ProfesorDTO> dameProfesores() {
		List<ProfesorEntity> listaProfesorEntity = repository.findAll();
		List<ProfesorDTO> listaProfesorDTO = new ArrayList<>();
		for (ProfesorEntity ProfesorEntity : listaProfesorEntity) {
			listaProfesorDTO.add(transformEntity(ProfesorEntity));
		}
		
		return listaProfesorDTO;
	}
	
	public ProfesorDTO dameUnProfesor(Integer idProfesor) {
		return transformEntity(repository.findById(idProfesor).get());
	}
	
	public ProfesorEntity guardaProfesorBaseDatos(ProfesorDTO profesorDto) {
		ProfesorEntity ProfesorEntity = transformDTO(profesorDto);
		ProfesorEntity = repository.save(ProfesorEntity);
		
		return ProfesorEntity;
	}
	
	private ProfesorEntity transformDTO(ProfesorDTO profesorDto ) {
		ProfesorEntity profesorEntity = new ProfesorEntity();
		profesorEntity.setIdProfesor(profesorDto.getId());
		profesorEntity.setNombreProfesor(profesorDto.getNombre());
		profesorEntity.setApellidosProfesor(profesorDto.getApellidos());
		profesorEntity.setEmailProfesor(profesorDto.getEmail());
		profesorEntity.setCiudadProfesor(profesorDto.getCiudad());
		profesorEntity.setClaseProfesor(transformClaseDtoaEntity(profesorDto));
		
		return profesorEntity;
	}
	
	private ProfesorDTO transformEntity (ProfesorEntity profesorEntity) {
		ProfesorDTO profesorDto = new ProfesorDTO();
		profesorDto.setId(profesorEntity.getIdProfesor());
		profesorDto.setNombre(profesorEntity.getNombreProfesor());
		profesorDto.setApellidos(profesorEntity.getApellidosProfesor());
		profesorDto.setEmail(profesorEntity.getEmailProfesor());
		profesorDto.setCiudad(profesorEntity.getCiudadProfesor());
		profesorDto.setIdClase(profesorEntity.getClaseProfesor().getIdClase());
		profesorDto.setNombreClase(profesorEntity.getClaseProfesor().getNombreClase());
		
		return profesorDto;
	}
	
	private ClaseEntity transformClaseDtoaEntity(ProfesorDTO profesorDTO) {
		ClaseEntity claseEntity = new ClaseEntity();
		claseEntity.setIdClase(profesorDTO.getIdClase());
		claseEntity.setNombreClase(profesorDTO.getNombreClase());
		
		return claseEntity;
	}
	
	public List<ProfesorDTO> listarProfesorPorEmailCiudadOrdenadoNmbreCiudad(ProfesorDTO profesorDto) {
		List<ProfesorDTO> listaProfesorDto = new ArrayList<>();
		List<ProfesorEntity> listaProfesorEntity = repository.listaProfesorPorEmailCiudadOrderNombreCiudad(profesorDto.getEmail(),profesorDto.getCiudad());
		
		for (ProfesorEntity profesorEntity : listaProfesorEntity) {
			ProfesorDTO dto = transformEntity(profesorEntity);
			listaProfesorDto.add(dto);
		}
		
		return listaProfesorDto;
	}
}
