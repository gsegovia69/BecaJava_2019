package ejercicio3;

public class Profesor {

	private String nombre = "";
	private String apellidos = "";
	private String correo = "";
	private String ciudad = "";
	
	public Profesor () {
		
	}
	
	public Profesor (String nombre){
		this.nombre = nombre;
	}

	public Profesor (String nombre, String apellidos){
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public Profesor (String nombre, String apellidos, String correo){
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
	}
	
	public Profesor (String nombre, String apellidos, String correo, String ciudad){
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

	public String toString() {
		limpia ();
		return  "Nombre: " + this.nombre + " " + this.apellidos + "		" + "Email: " + this.correo + "		" + "Ciudad: " + this.ciudad;
	}
	
	private void limpia() {
		this.nombre = this.nombre.replace(Constantes.ETIQUETA_APERTURA_NOMBRE,"").replace(Constantes.ETIQUETA_CIERRE_NOMBRE,"").trim().toUpperCase();
		this.apellidos = this.apellidos.replace(Constantes.ETIQUETA_APERTURA_APELLIDOS,"").replace(Constantes.ETIQUETA_CIERRE_APELLIDOS,"").trim().toUpperCase();
		this.correo = this.correo.replace(Constantes.ETIQUETA_APERTURA_EMAIL,"").replace(Constantes.ETIQUETA_CIERRE_EMAIL,"").trim().toLowerCase();
		this.ciudad = this.ciudad.replace(Constantes.ETIQUETA_APERTURA_CIUDAD,"").replace(Constantes.ETIQUETA_CIERRE_CIUDAD,"").trim().toUpperCase();
	}
}
