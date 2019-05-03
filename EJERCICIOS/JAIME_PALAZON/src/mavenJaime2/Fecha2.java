package com.everis.jaime.mavenJaime2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fecha2 {
public static String getFecha2() {
		
		String pattern ="MM-dd-yyyy HH:mm:ss";
        SimpleDateFormat SimpleDateFormat = new SimpleDateFormat(pattern);
        
        String date = SimpleDateFormat.format (new Date());
		
		return date;
	}

}
