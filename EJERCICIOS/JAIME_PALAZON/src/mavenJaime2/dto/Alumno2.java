package com.everis.jaime.mavenJaime2.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@Getter
@Setter
@XStreamAlias("alumno")
public class Alumno2 {
	
	private String nombre;
	private String apellidos;
	private String email;
	private String ciudad;
	
	public String ToStringDate() {
		
		String pattern ="dd-MM-yyyy";
        SimpleDateFormat SimpleDateFormat = new SimpleDateFormat(pattern);
        
        String date = SimpleDateFormat.format (new Date());
		
		return date;
	}
	
	

}
