package dto;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity

public class Asignatura {
	private int id_asignatura;
	private String nombre;
	private int orden;
	private int id_clase;
}
