package com.everis.beca.java.conexionBaseDatos.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity

public class Asignatura {

		@Id
		@GeneratedValue
		@Column(name = "id_asignatura")
		private int idAsignatura;
		@Column(name = "nombre")
		private String nombreAsignatura;
		@Column(name = "orden")
		private int ordenAsignaturas;
		
		@ManyToOne
		@JoinColumn(name = "id_clase")
		private Clase claseAsignatura;
}
