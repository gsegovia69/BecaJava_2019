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
public class ProfesorDTO {
	

	private Long id;
	
	private String nombre;
	
	private String apellidos;

	private String email;

	private String ciudad;
	
	private List<ClaseDTO> listaClases;
	
	private Long idClase;

}
