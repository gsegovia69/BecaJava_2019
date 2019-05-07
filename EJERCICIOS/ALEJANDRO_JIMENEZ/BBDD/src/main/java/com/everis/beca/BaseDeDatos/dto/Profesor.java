package com.everis.beca.BaseDeDatos.dto;


import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@NoArgsConstructor
@ToString
 class Profesor {
	
	private String nombre;
	
	private String apellidos;
	
	private String email;
	
	private String ciudad;
	
}
