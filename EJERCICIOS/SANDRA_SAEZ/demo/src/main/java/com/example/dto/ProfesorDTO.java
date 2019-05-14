package com.example.dto;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class ProfesorDTO {
	
	private int id,idClase;
	private String nombre;
	private String apellidos;
	private String email;
	private String ciudad;

}
