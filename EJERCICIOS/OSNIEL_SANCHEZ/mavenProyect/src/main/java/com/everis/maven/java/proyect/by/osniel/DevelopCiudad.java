package com.everis.maven.java.proyect.by.osniel;
import java.util.List;
import com.everis.maven.java.proyect.by.osniel.dto.Alumno;
import lombok.AllArgsConstructor;
@AllArgsConstructor

public class DevelopCiudad{
	List<Alumno> alumno;
	public void ordenaCiuad() {
		this.alumno
        .stream()
        .filter(Alumno::getCiudadContainsA)
        .map(Alumno::getaAlumnosFormatoFecha)
        .forEach(System.out::println);
	};
}
