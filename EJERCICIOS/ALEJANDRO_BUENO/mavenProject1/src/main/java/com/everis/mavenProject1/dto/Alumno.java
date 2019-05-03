package com.everis.mavenProject1.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@XStreamAlias("alumno")
@ToString

public class Alumno 
{
	
	private String nombre, apellidos, email, ciudad;
	
}
