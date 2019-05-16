package com.spring.dto;


import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AsignaturaDTO {


	private Long id;

	private String nombre;
	
	private int orden;
	
	private List<ClaseDTO> listaClases;
	
	private Long idClase;
}
