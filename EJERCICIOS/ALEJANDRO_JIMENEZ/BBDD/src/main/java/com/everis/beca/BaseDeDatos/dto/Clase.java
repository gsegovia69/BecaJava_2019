package com.everis.beca.BaseDeDatos.dto;




import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
@Table(name="clase")
public class Clase {
	
	@Id
	private int id;
	
	private String nombre;
	
}
