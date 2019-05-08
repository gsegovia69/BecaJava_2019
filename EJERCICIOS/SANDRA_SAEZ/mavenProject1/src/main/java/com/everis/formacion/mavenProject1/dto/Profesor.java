package com.everis.formacion.mavenProject1.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringExclude;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@XStreamAlias("profesor")
@Entity
@Table(name = "profesor")
public class Profesor {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int idProfesor;
	@Column(name = "nombre")
	private String nombreProfesor;
	@Column(name = "apellidos")
	private String apellidosProfesor;
	@Column(name = "email")
	private String emailProfesor;
	@Column(name = "ciudad")
	private String ciudadProfesor;

	@ToStringExclude
	@OneToMany
	@JoinColumn(name = "id_clase")
	private Clase cursoProfesor;

}
