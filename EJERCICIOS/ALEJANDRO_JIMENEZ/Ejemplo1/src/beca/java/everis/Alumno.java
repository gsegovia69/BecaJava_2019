package beca.java.everis;
/**
 * Clase Alumno
 * @author Alejandro Jiménez
 *@version 26.04.2019
 */
public class Alumno {
	
	private String nombre;
	
	private String apellidos;
	
	private String email;
	
	private String ciudad;
	
	public Alumno() {
		
	}
	
	public Alumno(String nombre,String apellidos,String email,String ciudad) {
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.email=email;
		this.ciudad=ciudad;
	}
	
	public Alumno (String nombre, String apellidos) {
		this.nombre=nombre;
		this.apellidos=apellidos;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getEmail() {
		return email;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public String toString() {
		return "Nombre: " + this.nombre + "\nApellidos: " + this.apellidos+ 
				"\neMail: " + this.email  +"\nCiudad: " + this.ciudad+
				"\n------------------";
	}

	
}
