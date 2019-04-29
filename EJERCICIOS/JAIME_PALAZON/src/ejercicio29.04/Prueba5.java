package jaimepalazon;

public class Prueba5 {
	private String nombre;
	private String apellidos;
	private String email;
	private String ciudad;

	public Prueba5() {

	}
	
	public Prueba5(String nombre) {
		this.nombre = nombre;
	}
	public Prueba5(String nombre, String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public String allString () {
		
		return nombre + " " + apellidos + "//////// " + email + "////// " + ciudad;
		
	}
public String toString () {
		
		return nombre + " " + apellidos + "//////// " + email + "////// " + ciudad;
		
	}
	public String remolacha () {
		return nombre;
	}
	public  int compareTo(Prueba5 list) {
        int result = list.getApellidos().compareTo(list.getApellidos());
        return result; }

}
