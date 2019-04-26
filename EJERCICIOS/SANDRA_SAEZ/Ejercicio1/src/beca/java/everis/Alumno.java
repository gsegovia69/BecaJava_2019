package beca.java.everis;



public class Alumno {
	



	private String nombre;
	private String apellido;
	private String email;
	private String ciudad;
	
	public Alumno() {
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
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
	
	@Override
	public String toString() {
		return "Alumno [nombre = " + nombre + ", apellido = " + apellido + 
			//	", email = " + email + ", ciudad = " + ciudad +
				
				"]";
	}
	
	
	
	

	  
}

