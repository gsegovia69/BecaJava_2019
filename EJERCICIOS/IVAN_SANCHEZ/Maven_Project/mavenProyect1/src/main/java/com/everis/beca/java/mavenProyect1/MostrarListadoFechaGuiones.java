package com.everis.beca.java.mavenProyect1;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.everis.beca.java.mavenProyect1.dto.Alumno;
import com.everis.beca.java.mavenProyect1.dto.Clase;

public class MostrarListadoFechaGuiones {

	
	public void funcionMostrarListaAlumnos(Clase clase) {

		MostrarFecha fecha = new MostrarFecha();
		
		String formatoFecha = "MM-dd-yyyy hh:mm:ss";
		
		try {
			

			List<Alumno> lista = clase.getListaAlumnos().stream()
					.sorted(Comparator.comparing(Alumno::getApellidos))
					.sorted(Comparator.comparing(Alumno::getNombre)).filter(alu -> alu.getCiudades().toUpperCase().startsWith("A")).collect(Collectors.toList());
			
			for(int i= 0; i < lista.size(); i++) {				
				fecha.fechaBarra(formatoFecha);
				Alumno alu = lista.get(i);
				System.out.println(" "+ alu);
				
			}


		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
