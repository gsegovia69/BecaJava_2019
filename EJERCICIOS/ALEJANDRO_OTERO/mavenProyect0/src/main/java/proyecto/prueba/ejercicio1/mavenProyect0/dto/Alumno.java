package proyecto.prueba.ejercicio1.mavenProyect0.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@XStreamAlias("alumno")

@Table(name ="alumno")
@Entity


public class Alumno {
	@Id
	@GeneratedValue
		
	@Column(name="id")
	private String id;
	@Column(name="nombre")
	
	private String nombre;
	@Column(name="apellido")
	private String apellidos;
	@Column(name="email")
	private String email;
	@Column(name="ciudad")
	private String ciudad;
	
	@ToString.Exclude
	



}
