package com.demo.prueba.dto;


import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AsignaturaDTO {

	private int id;
	private String nombre;
	private int orden;
	private int idClase;
	private String nombreClase;
	
	private List<ClaseDTO> listaClase;
}
