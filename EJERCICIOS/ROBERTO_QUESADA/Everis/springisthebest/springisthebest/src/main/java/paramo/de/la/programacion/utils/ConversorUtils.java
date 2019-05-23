package paramo.de.la.programacion.utils;

import paramo.de.la.programacion.dto.ClaseDTO;
import paramo.de.la.programacion.entities.Clase;

public class ConversorUtils {
	public static ClaseDTO conversorClaseToClaseDTO(Clase clase) {
		ClaseDTO dto = new ClaseDTO();
		dto.setId(clase.getId());
		dto.setNombre(clase.getNombre());
		return dto;
	}

	public static Clase conversorClaseDTOToClase(ClaseDTO clase) {
		Clase entity = new Clase();
		entity.setId(clase.getId());
		entity.setNombre(clase.getNombre());
		return entity;
	}
}
