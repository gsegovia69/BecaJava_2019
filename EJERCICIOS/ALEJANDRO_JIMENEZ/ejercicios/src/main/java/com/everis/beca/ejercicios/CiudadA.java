package com.everis.beca.ejercicios;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.everis.beca.ejercicios.dto.Alumno;

public class CiudadA {
	private List <Alumno> alumnos;

	public CiudadA(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	public void ordenarApellido() throws Exception{
		if (!alumnos.isEmpty()) {
			Collections.sort(alumnos, new Comparator<Alumno>(){
			@Override
			public int compare(Alumno o1, Alumno o2) {
				return o1.getApellidos().toLowerCase().compareTo(o2.getApellidos().toLowerCase());
			
			}
	 		});
			}
			else 
				throw new Exception("La lista de alumnos esta vacia");
	}
	public String getFecha() {
		String fechaHora= null;
		Date date = new Date();
		DateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");
		DateFormat hora = new SimpleDateFormat("HH:mm:ss");
		
		fechaHora = fecha.format(date) + " " + hora.format(date);

		
		return fechaHora;
	}
	
	public String toString(Alumno alu) {
		
		return getFecha() + " " + StringUtils.capitalize(alu.getApellidos()) + ", " + StringUtils.capitalize(alu.getNombre());
	}
	
	public void mostrar() throws Exception {
		ordenarApellido();
		for (Alumno alu : alumnos) {
			
		if(alu.getCiudad().toLowerCase().startsWith("a")) {
			System.out.println(toString(alu));
		}
		}
	}
}
