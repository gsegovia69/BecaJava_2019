package com.everis.beca.java.mavenProyect1;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class MostrarFecha {

	
	
	
	public void fechaBarra(String formatoFecha) {
		
		
		Date myDate = new Date();

		System.out.print(new SimpleDateFormat(formatoFecha).format(myDate));
		
	
	}
	
}
