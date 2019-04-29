package beca.java.everis.read.faile;

import java.util.Comparator;

public class Alumno extends Persona implements Comparator<Alumno>{
	
    
    public Alumno() {
		
	}
    
	public Alumno(String aNombre, String aApellidos, String aEmail, String aCiudad) {
		super(aNombre, aApellidos, aEmail, aCiudad);
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

	@Override
	public int compare(Alumno o1, Alumno o2) {
		return o1.getaApellidos().compareTo(o1.getaApellidos());
	}
    
    
    
    
    
	
	

}
