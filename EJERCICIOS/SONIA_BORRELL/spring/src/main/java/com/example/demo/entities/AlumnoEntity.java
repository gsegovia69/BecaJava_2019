package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table (name = "Alumno")
public class AlumnoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Long id;
	@Column (name = "nombre")
	private String nombreAlumno;
	@Column (name = "apellidos")
	private String apellidosAlumno;
	@Column (name = "email")
	private String emailAlumno;
	@Column (name = "ciudad")
	private String ciudadAlumno;
	
	//relacionamos las tablas a traves de la clave externa id
	@ToString.Exclude
	@ManyToOne
	@JoinColumn (name = "id_clase")
	public CursoEntity idCurso;
	
	
}
