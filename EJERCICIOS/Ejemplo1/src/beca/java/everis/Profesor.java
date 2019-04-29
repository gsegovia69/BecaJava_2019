package beca.java.everis;
public class Profesor {

	private String nombre;
	private String apellidos;
	private String email;
	private String ciudad;

	public Profesor() {

	}

	public Profesor(String x, String y) {
		this.nombre = x;
		this.apellidos = y;
	}

	public Profesor(String nombre, String apellidos, String email, String ciudad) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.ciudad = ciudad;
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

	public String getNombreCompleto() {
		return this.nombre + " " + this.apellidos;
	}

	public String toString() {
		componNombre();
		componApellidos();
		componEmail();
		componCiudad();
		return this.nombre + " " + this.apellidos + " ------- " + this.ciudad + " /////// " + this.email;
	}

	private void componNombre() {
		this.nombre = nombre.replaceAll(ConstantUtils.INICIO_ITERACION_NOMBRE, "").trim();
		this.nombre = nombre.replaceAll(ConstantUtils.FIN_ITERACION_NOMBRE, "").trim();
	}

	private void componApellidos() {
		this.apellidos = apellidos.replaceAll(ConstantUtils.INICIO_ITERACION_APELLIDOS, "").trim();
		this.apellidos = apellidos.replaceAll(ConstantUtils.FIN_ITERACION_APELLIDOS, "").trim();
	}

	private void componEmail() {
		this.email = email.replaceAll(ConstantUtils.INICIO_ITERACION_EMAIL, "").trim();
		this.email = email.replaceAll(ConstantUtils.FIN_ITERACION_EMAIL, "").trim();
	}

	private void componCiudad() {
		this.ciudad = ciudad.replaceAll(ConstantUtils.INICIO_ITERACION_CIUDAD, "").trim();
		this.ciudad = ciudad.replaceAll(ConstantUtils.FIN_ITERACION_CIUDAD, "").trim();
	}

}