package com.everis.formacion.mavenProject1.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Fecha {
	public static String getFecha(String pattern) {

		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Fecha: " + dateFormat.format(date));
		return pattern;
	}

}
