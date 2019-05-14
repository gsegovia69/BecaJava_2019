package com.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class AsignaturaDTO {
	private int id, idClase;
	private String nombre;
	private int orden;

}
