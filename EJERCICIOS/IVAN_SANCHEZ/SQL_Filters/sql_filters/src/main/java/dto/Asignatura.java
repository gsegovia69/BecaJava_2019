package dto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity

public class Asignatura {
	
	@Id
	@GeneratedValue	
	@Column (name = " id_asignatura")
	private int idAsignatura;
	private String nombre;
	private int orden;
	private int id_clase;
	
	
	
	
	@ManyToOne
	@JoinColumn(name = "id_clase")
	private Set<Clase> claseAsignatura;
}
