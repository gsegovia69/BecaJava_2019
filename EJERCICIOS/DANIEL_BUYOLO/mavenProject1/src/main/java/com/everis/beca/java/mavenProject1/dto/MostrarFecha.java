package com.everis.beca.java.mavenProject1.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MostrarFecha {

	public void mostrarFecha(String dateFormat) {
		Date fecha = new Date();
		
		SimpleDateFormat fechaFormat = new SimpleDateFormat(dateFormat);
		
		System.out.print(fechaFormat.format(fecha));
	}
}
