package dto;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity

public class Alumno {

	private int id;
	private String nombre;
	private String apellidos;
	private String email;
	private String ciudad;
	private int id_clase;

//	// Constructores-------------------------
//
//	public Alumno() {
//		this.nombre = "";
//		this.apellidos = "";
//		this.eMail = "";
//		this.ciudad = "";
//	}
//
//	public Alumno(String nombre, String apellidos, String eMail, String ciudad) {
//		this.nombre = nombre;
//		this.apellidos = apellidos;
//		this.eMail = eMail;
//		this.ciudad = ciudad;
//
//	}
//
//	// Metodos Get---------------------------
//
//	public String getNombre() {
//		return nombre;
//	}
//
//	public String getApellidos() {
//		return apellidos;
//	}
//
//	public String getEmail() {
//		return eMail;
//	}
//
//	public String getCiudad() {
//		return ciudad;
//	}
//
//	// Metodos Set----------------------------
//
//	public void setNombre(String snombre) {
//		this.nombre = snombre;
//	}
//
//	public void setApellidos(String sapellidos) {
//		this.apellidos = sapellidos;
//	}
//
//	public void seteMail(String seMail) {
//		this.eMail = seMail;
//	}
//
//	public void setCiudad(String sciudad) {
//		this.ciudad = sciudad;
//	}
//
//	// Metodo que comprueba que el nombre introducido no esta vacio
//
//	public boolean compruebaNombre() {
//		if (nombre.equals("")) {
//			return false;
//		}
//		return true;
//
//	}
//
//	public String toString() {
//		String formatocadena = "";
//
//	
//
//		return formatocadena;
//	}

}