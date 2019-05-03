package com.everis.maven.java.proyect.by.osniel;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.everis.maven.java.proyect.by.osniel.dto.Alumno;
import com.everis.maven.java.proyect.by.osniel.dto.Clase;

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
	
	public void ordenaCiuad(Clase clase) {
		clase.getAlumnos()
		.stream()
		.filter(a-> a.getCiudad().toLowerCase().startsWith("a"))
		.forEach(a->System.out.println(a.getaAlumnosFormatoFecha()));
		
	};
}
