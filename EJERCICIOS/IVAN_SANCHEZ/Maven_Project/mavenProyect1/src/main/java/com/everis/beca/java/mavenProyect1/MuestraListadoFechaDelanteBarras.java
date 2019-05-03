package com.everis.beca.java.mavenProyect1;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.everis.beca.java.mavenProyect1.dto.Alumno;
import com.everis.beca.java.mavenProyect1.dto.Clase;

import lombok.ToString;

public class MuestraListadoFechaDelanteBarras {

	public void funcionMostrarListaAlumnos(Clase clase) {

		MostrarFecha fecha = new MostrarFecha();
		
		String formatoFecha = "dd/MM/yyyy hh:mm:ss";
		
		try {
			

			List<Alumno> lista = clase.getListaAlumnos().stream()
					.sorted(Comparator.comparing(Alumno::getNombre))
					.sorted(Comparator.comparing(Alumno::getApellidos)).collect(Collectors.toList());
			
			for(Alumno lis: lista) {				
				fecha.fechaBarra(formatoFecha);				
				System.out.println(" "+ lis);
				
			}


		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
