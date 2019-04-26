package ejercicio3;

public class Alumno {

	private String nombre = "";
	private String apellidos = "";
	private String correo = "";
	private String ciudad = "";
	
	public Alumno () {
		
	}
	
	public Alumno (String nombre){
		this.nombre = nombre;
	}

	public Alumno (String nombre, String apellidos){
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public Alumno (String nombre, String apellidos, String correo){
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
	}
	
	public Alumno (String nombre, String apellidos, String correo, String ciudad){
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.ciudad = ciudad;
	}
	
	public String getNombre () {
		return nombre;
	}
	
	public String getApellido () {
		return apellidos;
	}
	
	public String getcorreo () {
		return correo;
	}
	
	public String getCiudad () {
		return ciudad;
	}
	
	public String getTodo () {
		return nombre + " " + apellidos + " " + correo + " " + ciudad;
	}
	
	public void setNombre (String nombre) {
		this.nombre = nombre;
	}
	
	public void setApellido (String apellidos) {
		this.apellidos = apellidos;
	}
	
	public void setCorreo (String correo) {
		this.correo = correo;
	}
	
	public void setCiudad (String ciudad) {
		this.ciudad = ciudad;
	}
	
	public void setTodo (String nombre, String apellidos, String correo, String ciudad) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.ciudad = ciudad;
	}
}
