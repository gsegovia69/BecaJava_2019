package beca.java.everis.read.faile;

public class Persona {
	
	String aNombre;
    String aApellidos;
    String aEmail;
    String aCiudad;
    
    public Persona(){
		
	}
    
    public Persona(String aNombre, String aApellidos, String aEmail, String aCiudad) {
		super();
		this.aNombre = aNombre;
		this.aApellidos = aApellidos;
		this.aEmail = aEmail;
		this.aCiudad = aCiudad;
	}

	public String getaNombre() {
		return aNombre;
	}
    
    public void setaNombre(String aNombre) {
		this.aNombre = aNombre;
	}

	public String getaApellidos() {
		return aApellidos;
	}
	
	

	public void setaApellidos(String aApellidos) {
		this.aApellidos = aApellidos;
	}

	public String getaEmail() {
		return aEmail;
	}

	public void setaEmail(String aEmail) {
		this.aEmail = aEmail;
	}

	public String getaCiudad() {
		return aCiudad;
	}

	public void setaCiudad(String aCiudad) {
		this.aCiudad = aCiudad;
	}
	public boolean isAlejandro() {
		return this.aNombre.equalsIgnoreCase("Alejandro");
	}
	
	public boolean getNameAandS() {
		return this.aNombre.substring(0, 1).equalsIgnoreCase("A") || this.aNombre.substring(0, 1).equalsIgnoreCase("S");
	}
	
	public String getaAlumnos() {
		return String.format("%s %s %s %s %s %s", aNombre ,aApellidos, "......",aEmail,".....",aCiudad);
    }
	
	public boolean getNameContainsA() {
		return this.aNombre.contains("a");
	}

}
