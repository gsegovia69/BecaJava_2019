package com.everis.jaime.mavenJaime2.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@Getter
@Setter
@XStreamAlias("profesor")
public class Profesor2 {
	private String nombre;
	private String apellidos;
	private String email;
	private String ciudad;

}