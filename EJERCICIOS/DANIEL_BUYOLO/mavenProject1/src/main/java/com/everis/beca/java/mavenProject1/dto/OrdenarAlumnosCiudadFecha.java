package com.everis.beca.java.mavenProject1.dto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrdenarAlumnosCiudadFecha {

	public void mostrarListaAlumno(Clase clase) {	
		
		MostrarFecha fecha = new MostrarFecha();
		
		String dateFormat = "MM-dd-yyyy hh:mm:ss";
		
		System.out.println("---------------------------------------");
		System.out.println("Ejercicio 3");
		System.out.println("---------------------------------------");
		
		// otra manera:
		/* clase.getListaAlumno().stream().filter(a -> a.getCiudades().toLowerCase()
				.startsWith("a")).forEach(a -> { 
					System.out.println(fecha.mostrarFecha(dateFormat) + " --> " + a.toString());
					});		
		*/
		
		List <Alumno> lista =clase.getListaAlumno().stream()
								  .sorted(Comparator.comparing(Alumno::getNombre))
								  .sorted(Comparator.comparing(Alumno::getApellidos))
								  .filter(a -> a.getCiudades().toUpperCase().startsWith("A"))
								  .collect(Collectors.toList());
	
		for( int i = 0; i < lista.size(); i++) {
			fecha.mostrarFecha(dateFormat);
			Alumno a = lista.get(i);
			System.out.println(" "+a);
		}
	}
}
