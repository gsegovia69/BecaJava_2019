package com.spring.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
public class Asignatura {

	@Id
	@GeneratedValue
	@Column(name = "id_asignatura")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="orden")
	private int orden;
	

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_clase")
	private Clase claseAsignatura;
}
