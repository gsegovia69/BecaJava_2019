package com.demo.prueba.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "asignatura")
public class AsignaturaEntity {

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
		private ClaseEntity claseAsignatura;
}

