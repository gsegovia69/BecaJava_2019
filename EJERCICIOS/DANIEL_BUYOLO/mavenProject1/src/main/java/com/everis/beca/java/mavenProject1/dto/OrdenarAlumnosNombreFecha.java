package com.everis.beca.java.mavenProject1.dto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrdenarAlumnosNombreFecha {
	
	// 2. Clase que muestre por consola el listado de alumnos ordenados por apellido y nombre. Con la fecha antes de cada alumno.
	 	//* Formato = Dia/mes/año Horas:Minutos:Segundos
	
	public void mostrarListaAlumno(Clase clase) {	
	
		MostrarFecha fecha = new MostrarFecha();
		String dateFormat = "dd/MM/yyyy hh:mm:ss";
		
		System.out.println("---------------------------------------");
		System.out.println("Ejercicio 2");
		System.out.println("---------------------------------------");
		
		List <Alumno> lista =clase.getListaAlumno().stream().sorted(Comparator.comparing(Alumno::getApellidos))
							 .sorted(Comparator.comparing(Alumno::getNombre)).collect(Collectors.toList());
	
		for( int i = 0; i < lista.size(); i++) {
			fecha.mostrarFecha(dateFormat);
			Alumno a = lista.get(i);
			System.out.println(" "+a);
		}
	}
}	
