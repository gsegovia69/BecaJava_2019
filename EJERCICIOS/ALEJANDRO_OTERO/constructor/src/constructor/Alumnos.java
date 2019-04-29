package constructor;

public class Alumnos {
	
		

	
private String nombre;
	
	private String apellidos;
	
	private String email;
	
	private String ciudad;
	
	public Alumnos() {
		
	}
	
	public Alumnos(String nombre,String apellidos,String email,String ciudad) {
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.email=email;
		this.ciudad=ciudad;
	}
	
	public Alumnos (String nombre, String apellidos) {
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

