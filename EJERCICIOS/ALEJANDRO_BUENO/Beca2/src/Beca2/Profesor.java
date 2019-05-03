package Beca2;

public class Profesor 
{
	private String nombre, apellido, email, ciudad; 
	
	public Profesor() 
	{
		
	}
	
	//SETTER
	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setApellido(String apellido) {this.apellido = apellido;}
	public void setEmail(String email) {this.email = email;}
	public void setCiudad(String ciudad) {this.ciudad = ciudad;}
	//GETTER	
	public String getNombre() {return this.nombre;}
	public String getApellido() {return this.apellido;}
	public String getEmail() {return this.email;}
	public String getCiudad() {return this.ciudad;}
	
	@Override
	public String toString() 
	{
		return "Alumno: [Nombre : " + nombre + " " + apellido + "		Email : " + email + "		Ciudad: " + ciudad +"]";
	}
}
