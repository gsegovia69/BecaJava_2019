package com.everis.beca.BaseDeDatos.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="asignatura")
public class Asignatura {
	
	@Id
	private int id_asignatura;
	
	private String nombre;
	
	private int orden;
	
	
	private int id_clase;
}
