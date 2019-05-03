package com.everis.formacion.mavenProject1.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class OrdenarNombre {
	

	public void OrdenarNombreApellido(ArrayList<Alumno> lista) {

		Collections.sort(lista, new Comparator<Alumno>() {
			public int compare(Alumno obj1, Alumno obj2) {
				return obj1.getApellidos().compareTo(obj2.getApellidos());
			}
		});
		for (Alumno alumno : lista) {
			Date date = new Date();
			//Caso 1: obtener la hora y salida por pantalla con formato:
			DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
			System.out.println("Hora: "+hourFormat.format(date));
			
			System.out.println(alumno.getApellidos());
			
		}

	}
	
	
	
	public void metodo1(Clase clase) {
		List<Alumno>lista = clase.getListaAlumnos().stream().sorted(Comparator.comparing(Alumno::getApellidos)).
		sorted(Comparator.comparing(Alumno::getNombre)).collect(Collectors.toList());
		for(Alumno a : lista) {
			Date date = new Date();
			DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
			System.out.println("Hora: "+hourFormat.format(date));
			System.out.println(a.toString());
		}
		
	}
}


