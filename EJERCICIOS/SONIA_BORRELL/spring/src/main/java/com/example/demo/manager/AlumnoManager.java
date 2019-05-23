package com.example.demo.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AlumnoDTO;
import com.example.demo.entities.AlumnoEntity;
import com.example.demo.repository.AlumnoRepository;

@Service
public class AlumnoManager {

	@Autowired
	private AlumnoRepository repository;
	
	@Autowired
	private CursoManager cursoManager;
	
	
	public AlumnoRepository getRepository() {
			return repository;
		}
	
	//Nos da la lista de AlumnoDTO, que la hemos recuperado de AlumnoEntity
	public List<AlumnoDTO> dameAlumno(){
		List<AlumnoEntity> listaEntities = repository.findAll();
		List<AlumnoDTO> dtolist =new ArrayList<>();
		for(AlumnoEntity entity : listaEntities) {
			dtolist.add(transform(entity));
		}
		return dtolist;
	}
	public List<AlumnoDTO> dameAlumnoOrdenado(String nombre){
		List<AlumnoEntity> listaEntities = repository.alumnosordenados(nombre);
		List<AlumnoDTO> dtolist =new ArrayList<>();
		for(AlumnoEntity entity : listaEntities) {
			dtolist.add(transform(entity));
		}
		return dtolist;
	}
	public AlumnoDTO giveOneAlumno (Long idAlumno) {
		AlumnoEntity entity= new AlumnoEntity();
		entity=repository.findById(idAlumno).get();
		return transform(entity);	
	}
	public AlumnoDTO guardame(AlumnoDTO alumnoDTO) {
		AlumnoEntity dto = transformDTO(alumnoDTO);
		dto = repository.save(dto);
		return transform(dto);
	}
	public void borramelo (AlumnoDTO alumno) {
		AlumnoEntity entity= transformDTO(alumno);
		repository.delete(entity);
	}
	public List<AlumnoDTO> ordenarAlumnoAsc() {
	List<AlumnoEntity> listaEntity=repository.findAllByOrderByNombreAsc();
	List<AlumnoDTO> dtolist=new ArrayList<>();
	for(AlumnoEntity entity:listaEntity) {
			dtolist.add(transform(entity));
		}
		return  dtolist;	
	}
	public List<AlumnoDTO> ordenarAlumnoDesc() {
		List<AlumnoEntity> listaEntity=repository.findAllByOrderByNombreDesc();
		List<AlumnoDTO> dtolist=new ArrayList<>();
		for(AlumnoEntity entity:listaEntity) {
				dtolist.add(transform(entity));
			}
			return  dtolist;			
		}
	public List<AlumnoDTO> ordenarAlu(){
		List<AlumnoEntity> listEntity=repository.findAllByOrderByNombre();
		List<AlumnoDTO> dtolist=new ArrayList<>();
		for(AlumnoEntity entity:listEntity) {
			dtolist.add(transform(entity));
		}return dtolist;	
	}
	public Page<AlumnoEntity> numeroPagina(Pageable pageable) {
		Page<AlumnoEntity> alumnos = repository.findAllByOrderByApellidosAlumno(pageable);
		return alumnos;	
	}

	private AlumnoDTO transform (AlumnoEntity alumnoEntity) {
		AlumnoDTO dto= new AlumnoDTO();
		dto.setNombreAlumno(alumnoEntity.getNombreAlumno());
		dto.setApellidosAlumno(alumnoEntity.getApellidosAlumno());
		dto.setCiudadAlumno(alumnoEntity.getCiudadAlumno());
		dto.setEmailAlumno(alumnoEntity.getEmailAlumno());
		dto.setId(alumnoEntity.getId());
		try {
		dto.setId_curso(cursoManager.transformEntity(cursoManager.dameClaseEntity(alumnoEntity.getIdCurso().getId())));
		}catch(Exception e) {}
		return dto;
	}
	private AlumnoEntity transformDTO(AlumnoDTO alumnoDTO) {
		AlumnoEntity entity= new AlumnoEntity();
		//CursoEntity cursoEntity = ConstantUtils.conversorCursoDTOToCurso(alumnoDTO.getId_curso());
		entity.setNombreAlumno(alumnoDTO.getNombreAlumno());
		entity.setApellidosAlumno(alumnoDTO.getApellidosAlumno());
		entity.setCiudadAlumno(alumnoDTO.getCiudadAlumno());
		entity.setEmailAlumno(alumnoDTO.getEmailAlumno());
		entity.setId(alumnoDTO.getId());
		entity.setIdCurso(cursoManager.dameClaseEntity(alumnoDTO.getId_curso().getId()));
		return entity;
	}
}
	
	

