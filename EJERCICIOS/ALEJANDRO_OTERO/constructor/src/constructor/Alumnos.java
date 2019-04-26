package constructor;

public class Alumnos {
	private String	nombre;
	private String Apellidos;
	
	public Alumnos () {
	}
	public Alumnos(String nombre, String Apellidos) {
		this.nombre = nombre;
		this.Apellidos = Apellidos;
		
	}
	public String getnombre () {
		return nombre;
		
	}
	public String getApellidos() {
		return Apellidos;
		
				
	}
	public String getNombreCompleto() {
		return this.nombre +""+ this.Apellidos;
		
	}
}


