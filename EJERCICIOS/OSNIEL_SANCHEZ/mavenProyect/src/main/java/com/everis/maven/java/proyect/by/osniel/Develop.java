package com.everis.maven.java.proyect.by.osniel;
import lombok.AllArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import com.everis.maven.java.proyect.by.osniel.dto.Alumno;
import com.everis.maven.java.proyect.by.osniel.dto.Clase;
@AllArgsConstructor

public class Develop{
	List<Alumno> alumno;
	
	public void ordenaListApellidos(Clase clase) {
		List<Alumno> alumnos = clase.getAlumnos()
		.stream()
		.sorted(Comparator.comparing(Alumno::getApellidos))
		.collect(Collectors.toList());
		for (Alumno alumno : alumnos) {
			System.out.println(alumno.getaAlumnos());
		}
	  }
	public void ordenaListApellidos() {
		Collections.sort(this.alumno, new Comparator<Alumno>() {
			@Override
			public int compare(Alumno a1, Alumno a2) {
				return a1.getApellidos().compareTo(a2.getApellidos());
			}
		});
		this.alumno
        .stream()
        .map(Alumno::getaAlumnos)
        .forEach(System.out::println);
	  }
	public void ordenaListNombre() {
		Collections.sort(this.alumno, new Comparator<Alumno>() {
			@Override
			public int compare(Alumno a1, Alumno a2) {
				return a1.getNombre().compareTo(a2.getNombre());
			}
		});
		this.alumno
        .stream()
        .map(Alumno::getaAlumnos)
        .forEach(System.out::println);
	  }
}
