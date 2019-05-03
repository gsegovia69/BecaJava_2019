package com.everis.ejercicio1;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@XStreamAlias("alumno")
@ToString
@NoArgsConstructor

public class Alumno 
{
	private String nombre, apellidos, email, ciudad;
}
