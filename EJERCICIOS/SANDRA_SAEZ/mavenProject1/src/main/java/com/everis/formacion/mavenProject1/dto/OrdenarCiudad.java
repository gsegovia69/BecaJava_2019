package com.everis.formacion.mavenProject1.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class OrdenarCiudad {

	public void OrdenarCiudadNombre(List<Alumno> lista) {

		Collections.sort(lista, new Comparator<Alumno>() {
			public int compare(Alumno obj1, Alumno obj2) {
				return obj1.getCiudad().compareTo(obj2.getCiudad());
			}
		});
		for (Alumno alumno : lista) {
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("Fecha: " + dateFormat.format(date));
			System.out.println(alumno.getCiudad().toUpperCase().startsWith("A"));

		}

	}

	public void metodo2(Clase clase) {
		clase.getListaAlumnos().stream().filter(a -> a.getCiudad().toLowerCase().startsWith("a")).forEach(a -> {
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("Fecha: " + dateFormat.format(date));

			System.out.println(a.toString());
		});
	}

}