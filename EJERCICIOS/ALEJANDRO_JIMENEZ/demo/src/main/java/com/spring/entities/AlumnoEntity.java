package com.spring.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


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
@Entity
@Table(name = "alumno")
public class AlumnoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellidos")
	private String apellidos;
	
	@Column(name="email")
	private String email;
	
	@Column(name="ciudad")
	private String ciudad;
	
	@ManyToOne
	@JoinColumn(name="id_clase")
	private ClaseEntity claseAlumno;

}