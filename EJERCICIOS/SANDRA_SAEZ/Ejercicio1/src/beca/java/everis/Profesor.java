package beca.java.everis;

public class Profesor {
	private String nombre;
	private String apellido;
	private String email;
	private String ciudad;
	
	public Profesor() {
		
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
		return "Profesor [nombre = " + nombre + ", apellido = " + apellido + 
			//	", email = " + email + ", ciudad = " + ciudad +
				
				"]";
	}
	
	
	
	

	  
}

