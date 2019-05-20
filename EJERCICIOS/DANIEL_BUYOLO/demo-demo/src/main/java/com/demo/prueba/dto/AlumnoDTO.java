package com.demo.prueba.dto;

import java.util.List;

import com.demo.prueba.entities.ClaseEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AlumnoDTO {

	private int id;
	private String nombre;
	private String apellidos;
	private String email;
	private String ciudad;
	private int idClase;
	private String nombreClase; 
	
	private List<ClaseDTO> listaClase;

}
