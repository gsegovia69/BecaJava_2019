package com.everis.maven.java.proyect.by.osniel.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

@XStreamAlias("profesor")
public class Profesor{
	
	String nombre;
    String apellidos;
    String email;
    String ciudad;

}
