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

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "asignatura")
public class AsignaturaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_asignatura")
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="orden")
	private int orden;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_clase")
	private ClaseEntity claseAsignatura;

	
}
