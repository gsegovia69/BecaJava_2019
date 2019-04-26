package Ejercicio1;

public class Alumnos {
	
	private String nombre;
	private String apellido;
	private String email;
	private String ciudad;
	
	public Alumnos() {
		
	}
	public Alumnos(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}
	public Alumnos(String nombre, String apellido, String email, String ciudad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.ciudad = ciudad;
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
	public String getNombreCompleto() {
		return nombre + " " + apellido;
	}
	public String allString() {
		return "Nombre: " + nombre + " " + apellido + " //////Ciudad: " + ciudad + " //////Email: " + email; 
	}
	
	public void componNombre(String nombre) {
		this.nombre = nombre.trim().replaceAll(ConstantUtils.INICIO_ITERACION_NOMBRE, "");
		this.nombre = this.nombre.trim().replaceAll(ConstantUtils.FIN_ITERACION_NOMBRE, "");
	}
	public void componApellido(String apellido) {
		this.apellido = apellido.trim().replaceAll(ConstantUtils.INICIO_ITERACION_APELLIDO, "");
		this.apellido = this.apellido.trim().replaceAll(ConstantUtils.FIN_ITERACION_APELLIDO, "");
	}
	public void componCiudad(String ciudad) {
		this.ciudad = ciudad.trim().replaceAll(ConstantUtils.INICIO_ITERACION_CIUDAD, "");
		this.ciudad = this.ciudad.trim().replaceAll(ConstantUtils.FIN_ITERACION_CIUDAD, "");
	}
	public void componEmail(String email) {
		this.email = email.trim().replaceAll(ConstantUtils.INICIO_ITERACION_EMAIL, "");
		this.email = this.email.trim().replaceAll(ConstantUtils.FIN_ITERACION_EMAIL, "");
	}
	
	
}
