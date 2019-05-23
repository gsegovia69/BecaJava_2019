package paramo.de.la.programacion.managers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paramo.de.la.programacion.dto.ClaseDTO;
import paramo.de.la.programacion.entities.Clase;
import paramo.de.la.programacion.repositories.ClaseRepository;

@Service
public class ClaseManager {
	@Autowired
	private ClaseRepository repository;

	public ClaseRepository getRepository() {
		return repository;
	}

	public List<ClaseDTO> dameClases() {
		List<Clase> listaEntities = repository.findAll();
		List<ClaseDTO> dtoList = new ArrayList<>();
		for (Clase entity : listaEntities) {
			dtoList.add(transform(entity));
		}
		return dtoList;
	}

	public Clase giveMeOneClase(int id) {
		return repository.findById(id).get();
	}

	public ClaseDTO guardamelo(ClaseDTO dto) {
		Clase entity = transformDTO(dto);
		entity = repository.save(entity);
		return transform(entity);
	}

	private ClaseDTO transform(Clase clase) {
		ClaseDTO dto = new ClaseDTO();
		dto.setId(clase.getId());
		dto.setNombre(clase.getNombre());
		return dto;
	}

	private Clase transformDTO(ClaseDTO clase) {
		Clase dto = new Clase();
		dto.setId(clase.getId());
		dto.setNombre(clase.getNombre());
		return dto;
	}

}
