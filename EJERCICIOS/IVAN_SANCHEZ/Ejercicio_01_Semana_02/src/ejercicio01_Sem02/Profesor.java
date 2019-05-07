package ejercicio01_Sem02;

public class Profesor {
	String nombre = "";
	String apellidos = "";
	String eMail = "";
	String ciudad = "";

	// Constructores-------------------------

	public Profesor() {
		this.nombre = "";
		this.apellidos = "";
		this.eMail = "";
		this.ciudad = "";
	}

	public Profesor(String nombre, String apellidos, String eMail, String ciudad) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.eMail = eMail;
		this.ciudad = ciudad;

	}

	// Metodos Get---------------------------

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getEmail() {
		return eMail;
	}

	public String getCiudad() {
		return ciudad;
	}

	// Metodos Set----------------------------

	public void setNombre(String snombre) {
		this.nombre = snombre;
	}

	public void setApellidos(String sapellidos) {
		this.apellidos = sapellidos;
	}

	public void seteMail(String seMail) {
		this.eMail = seMail;
	}

	public void setCiudad(String sciudad) {
		this.ciudad = sciudad;
	}

	// Metodo que comprueba que el nombre introducido no esta vacio

	public boolean compruebaNombre() {
		if (nombre.equals("")) {
			return false;
		}
		return true;

	}

	public String toString() {
		limpia();

		return (this.nombre + this.apellidos + this.eMail + this.ciudad);
	}

	private void limpia() {
		this.nombre = this.nombre.replace(ListaConstantes.ETIQUETA_APERTURA_NOMBRE, "")
				.replace(ListaConstantes.ETIQUETA_CIERRE_NOMBRE.trim(), "");
		this.apellidos = this.apellidos.replace(ListaConstantes.ETIQUETA_APERTURA_APELLIDO, "")
				.replace(ListaConstantes.ETIQUETA_CIERRE_APELLIDO.trim(), "");
		this.eMail = this.eMail.replace(ListaConstantes.ETIQUETA_APERTURA_EMAIL, "")
				.replace(ListaConstantes.ETIQUETA_CIERRE_EMAIL.trim(), "");
		this.ciudad = this.ciudad.replace(ListaConstantes.ETIQUETA_APERTURA_CIUDAD, "")
				.replace(ListaConstantes.ETIQUETA_CIERRE_CIUDAD.trim(), "");
	}
}
