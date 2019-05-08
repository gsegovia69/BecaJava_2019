package com.everis.formacion.mavenProject1.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringExclude;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "alumno")
@Getter
@Setter
@ToString
@XStreamAlias("alumno")
public class Alumno {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int idAlumno;
	@Column(name = "nombre")
	private String nombreAlumno;
	@Column(name = "apellidos")
	private String apellidosAlumno;
	@Column(name = "email")
	private String emailAlumno;
	@Column(name = "ciudad")
	private String ciudadAlumno;

	@ToStringExclude
	@ManyToOne
	@JoinColumn(name = "id_clase")
	private Clase cursoAlumno;

}
