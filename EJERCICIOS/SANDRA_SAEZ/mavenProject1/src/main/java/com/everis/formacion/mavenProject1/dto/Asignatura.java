package com.everis.formacion.mavenProject1.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringExclude;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table (name ="asignatura")

public class Asignatura {
	@Id
	@GeneratedValue
	@Column(name ="id_asignatura")
	private int id;
	
	@Column (name="nombre")
	private String nombre;
	
	@Column(name="orden")
	private int orden;
	
	@ToStringExclude
	@ManyToMany
	@JoinColumn(name ="id_clase")
	private Clase cursoAsignatura;
	

}
