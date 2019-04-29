package SONIA_BORRELL.Sonia_1.src.practica_java;

public class DatosPersona {
	
	private String nombre;
	private String apellidos;
	private String email;
	private String ciudad;
	
	public DatosPersona () {
		
	}
	
	public DatosPersona (String nombre, String apellidos, String email, String ciudad) {
	}

	public DatosPersona (String nombre, String apellidos) {
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

	public void setApellido(String apellidos) {
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

	public String toString() {
		return this.nombre.trim() +" " + this.apellidos.trim()+ " -- " + this.ciudad.trim()+ " -- " + this.email.trim();
	}

	
	}


