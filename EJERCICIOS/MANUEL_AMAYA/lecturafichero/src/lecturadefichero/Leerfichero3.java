package lecturadefichero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Alumno{
	
	private String nombre, apellidos, email, ciudad;
	
	//Metodos Constructores
	public Alumno() {
		nombre = "";
		apellidos = "";
		email = "";
		ciudad = "";
	}
	
	public Alumno(String nombre, String apellidos, String email, String ciudad) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.ciudad = ciudad;
	}
	
	public Alumno(String nombre, String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	
	//Metodos SETTER
	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setApellidos(String apellidos) {this.apellidos = apellidos;}
	public void setEmail(String email) {this.email = email;}
	public void setCiudad(String ciudad) {this.ciudad = ciudad;}
	
	//Metodos GETTER
	public String getNombre() {return this.nombre;}
	public String getApellidos() {return this.apellidos;}
	public String getEmail() {return this.email;}
	public String getCiudad() {return this.ciudad;}
	
	public void getDatosAlumno() {
		System.out.println("\n" + this.getNombre() + " " + this.getApellidos() + "\n" + this.getEmail() + "\n" + this.getCiudad() + "\n");
	}
}

public class Leerfichero3 {

	public static void main(String[] args) {
		File fichero = new File("C:\\Users\\Administrador\\Desktop\\BecaJava\\BecaJava_2019\\EJERCICIOS\\alumnos.xml");
		
		try {
			List<Alumno> listado = new ArrayList<Alumno>();
			FileReader lector = new FileReader(fichero);
			BufferedReader lector2 = new BufferedReader(lector);
			Alumno alum = null; //Se crea el alumno base
			boolean esAlumnos = false;
			
			if(fichero.exists()) {
				if(fichero.isFile()) {
					System.out.println("El fichero existe\n");
					try {
						
						//Se inician las variables necesarias y se inicia el bucle para leer el fichero
						String cadena, cadNombre = new String(), cadApellidos = new String(), cadEmail = new String(), cadCiudad = new String();		
						while((cadena = lector2.readLine()) != null){
							if(cadena.trim().equals("<alumno>")) {			//Se comprueba que entra dentro del bloque de los alumnos
								alum = new Alumno();
								esAlumnos= true;
							}
							
							//Si es así, se comprueba cada linea y se recorta el String para copiar los datos al alumno base
							if(esAlumnos && cadena.trim().contains("<nombre>")) {
								cadNombre = cadena.substring(cadena.indexOf("<nombre>")+8, cadena.indexOf("</nombre>"));
								alum.setNombre(cadNombre.trim());
							} 
							if(esAlumnos && cadena.trim().contains("<apellidos>")){
								cadApellidos = cadena.substring(cadena.indexOf("<apellidos>")+11, cadena.indexOf("</apellidos>"));
								alum.setApellidos(cadApellidos.trim());
							} 
							if(esAlumnos && cadena.trim().contains("<email>")){
								cadEmail = cadena.substring(cadena.indexOf("<email>")+7, cadena.indexOf("</email>"));
								alum.setEmail(cadEmail.trim());
							} 
							if(esAlumnos && cadena.trim().contains("<ciudad>")){
								cadCiudad = cadena.substring(cadena.indexOf("<ciudad>")+8, cadena.indexOf("</ciudad>"));
								alum.setCiudad(cadCiudad.trim());
							}	
							
							//Una vez acabado, se inserta el objeto dentro de la lista y se falsea la comprobación del bloque alumnos
							if(cadena.trim().equals("</alumno>")) {
								listado.add(alum);
								esAlumnos = false;
							}
						} //fin bucle while
						
						//Se imprime los datos de cada alumno del listado
						for(Alumno alu : listado) {
							alu.getDatosAlumno();
						}
						
						lector.close();
						lector2.close();
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else {
				System.out.println("El fichero no existe");
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}