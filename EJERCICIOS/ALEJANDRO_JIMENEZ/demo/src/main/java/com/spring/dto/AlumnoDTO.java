package com.spring.dto;




import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Clase Alumno
 * 
 * @author Alejandro Jimenez
 * @version 03.05.2019
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AlumnoDTO {


	private Long id;
	

	private String nombre;
	

	private String apellidos;
	

	private String email;
	

	private String ciudad;
	
	private Long idClase;

}