package com.everis.jaime.mavenJaime2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fecha {
	
public static String getFecha() {
		
		String pattern ="dd-MM-yyyy HH:mm:ss";
        SimpleDateFormat SimpleDateFormat = new SimpleDateFormat(pattern);
        
        String date = SimpleDateFormat.format (new Date());
		
		return date;
	}

}
