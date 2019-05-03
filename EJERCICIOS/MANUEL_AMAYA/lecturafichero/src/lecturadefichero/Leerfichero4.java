/*ENUNCIADO:
 * -----------------------------------------------------------------------------------------------------------------------------
 * 1.Ordenar por Apellido y pintar el resultado
 * 2.Ordenar por Ciudad y pintar el resultado
 * 3.Recorrer con stream y pintar el resultado
 * 4.Recorrer con for tradicional y pintar el resultado
 * 5.Filtrar por nombre ("Alejandro") y pintar el resultado
 * 6.Filtrar cuyo nombre empiece por "A" o por "S" y pintar el resultado
 * 7.Filtrar cuyo nombre contenga una "a" y pintar el resultado
 * 8.Crear objetos Alumno y Profesor y rellenar una lista con los profesores y otra lista con los alumnos. Pintar el resultado.
 * ------------------------------------------------------------------------------------------------------------------------------
 * */

package lecturadefichero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
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
		System.out.println(this.getNombre() + " " + this.getApellidos() + " -- " + this.getEmail() + " -- " + this.getCiudad());
	}
	public String toString() {
		return this.getNombre() + " " + this.getApellidos() + " -- " + this.getEmail() + " -- " + this.getCiudad();
	}
}

class Profesor{
	private String nombre, apellidos, email, ciudad;
	
	//Metodos Constructores
	public Profesor() {
		nombre = "";
		apellidos = "";
		email = "";
		ciudad = "";
	}
	
	public Profesor(String nombre, String apellidos, String email, String ciudad) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.ciudad = ciudad;
	}
	
	public Profesor(String nombre, String apellidos) {
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
	
	public void getDatosProfesor() {
		System.out.println("\n" + this.getNombre() + " " + this.getApellidos() + "\n" + this.getEmail() + "\n" + this.getCiudad() + "\n");
	}
	public String toString() {
		return this.getNombre() + " " + this.getApellidos() + " -- " + this.getEmail() + " -- " + this.getCiudad();
	}
}

public class Leerfichero4 {
	
	public static void imprimirDatos(List<Alumno> Alum, List<Profesor> Prof) {
		System.out.println("Alumnos ordenados por apellido:");
		Alum.stream().sorted(Comparator.comparing(Alumno::getApellidos)).forEach(System.out::println);
		
		System.out.println("\nAlumnos ordenados por ciudad:");
		Alum.stream().sorted(Comparator.comparing(Alumno::getCiudad)).forEach(System.out::println);
		
		System.out.println("\nListado de Alumnos con Stream: ");
		Alum.stream().forEach(System.out::println);
		
		System.out.println("\nListado de Alumnos con For tradicional: ");
		for(Alumno alu : Alum) { alu.getDatosAlumno(); }
		
		System.out.println("\nListado de Alumnos con el filtrado: ");
		Alum.stream().filter(a -> a.getNombre().toLowerCase().contains("alejandro")).forEach(System.out::println);
		
		System.out.println("\nListado de Alumnos que empiezan por A o por S: ");
		Alum.stream().filter(a -> a.getNombre().startsWith("A") || a.getNombre().startsWith("S")).sorted(Comparator.comparing(Alumno::getNombre)).forEach(System.out::println);
		
		System.out.println("\nListado de Alumnos cuyo nombre contiene una a: ");
		Alum.stream().filter(a -> a.getNombre().toLowerCase().contains("a")).forEach(System.out::println);
		
		System.out.println("\nListado de Profesores y de Alumnos: ");
		System.out.println("\nAlumnos: ");
		Alum.stream().forEach(System.out::println);
		System.out.println("\nProfesores: ");
		Prof.stream().forEach(System.out::println);
	}

	public static void main(String[] args) {		
		File fichero = new File("C:\\Users\\Administrador\\Desktop\\BecaJava\\BecaJava_2019\\EJERCICIOS\\alumnos.xml");
		
		try {
			List<Alumno> listadoAlum = new ArrayList<Alumno>();
			List<Profesor> listadoProf = new ArrayList<Profesor>();
			FileReader lector = new FileReader(fichero);
			BufferedReader lector2 = new BufferedReader(lector);
			Alumno alum = null; //Se crea el alumno base
			Profesor prof = null; //Se crea el profesor base
			boolean esAlumnos = false, esProfe = false;
			
			if(fichero.exists()) {
				if(fichero.isFile()) {
					System.out.println("El fichero existe\n");
					try {
						
						//Se inician las variables necesarias y se inicia el bucle para leer el fichero
						String cadena, cadNombre, cadApellidos, cadEmail, cadCiudad;		
						while((cadena = lector2.readLine()) != null){
							
							
							//COMPROBACIONES DEL PROFESOR
							if(cadena.trim().equals("<profesor>")) {				//Se comprueba que entra dentro del bloque del profesor
								prof = new Profesor();								//Se crea un objeto profesor para ir metiendole datos
								esProfe = true;
							}
							
							//Si es así, se comprueba cada linea y se recorta el String para copiar los datos al profesor base
							if(esProfe && cadena.trim().contains("<nombre>")) {
								cadNombre = cadena.replace("<nombre>","").replace("</nombre>","").trim();
								prof.setNombre(cadNombre.toUpperCase());
							} 
							if(esProfe && cadena.trim().contains("<apellidos>")){
								cadApellidos = cadena.replace("<apellidos>","").replace("</apellidos>","").trim();
								prof.setApellidos(cadApellidos.toUpperCase());
							} 
							if(esProfe && cadena.trim().contains("<email>")){
								cadEmail = cadena.replace("<email>","").replace("</email>","").trim();
								prof.setEmail(cadEmail);
							} 
							if(esProfe && cadena.trim().contains("<ciudad>")){
								cadCiudad = cadena.replace("<ciudad>","").replace("</ciudad>","").trim();
								prof.setCiudad(cadCiudad.toUpperCase());
							}
							
							if(cadena.trim().equals("</profesor>")) {
								listadoProf.add(prof);
								esProfe = false;
							}
							
							//COMPROBACIONES DE LOS ALUMNOS
							if(cadena.trim().equals("<alumno>")) {			//Se comprueba que entra dentro del bloque de los alumnos
								alum = new Alumno();
								esAlumnos= true;
							}
							
							//Si es así, se comprueba cada linea y se recorta el String para copiar los datos al alumno base
							if(esAlumnos && cadena.trim().contains("<nombre>")) {
								cadNombre = cadena.replace("<nombre>","").replace("</nombre>","").trim();
								alum.setNombre(cadNombre.toUpperCase());
							} 
							if(esAlumnos && cadena.trim().contains("<apellidos>")){
								cadApellidos = cadena.replace("<apellidos>","").replace("</apellidos>","").trim();
								alum.setApellidos(cadApellidos.toUpperCase());
							} 
							if(esAlumnos && cadena.trim().contains("<email>")){
								cadEmail = cadena.replace("<email>","").replace("</email>","").trim();
								alum.setEmail(cadEmail);
							} 
							if(esAlumnos && cadena.trim().contains("<ciudad>")){
								cadCiudad = cadena.replace("<ciudad>","").replace("</ciudad>","").trim();
								alum.setCiudad(cadCiudad.toUpperCase());
							}	
							
							//Una vez acabado, se inserta el objeto dentro de la lista y se falsea la comprobación del bloque alumnos
							if(cadena.trim().equals("</alumno>")) {
								listadoAlum.add(alum);
								esAlumnos = false;
							}
						} //fin bucle while
						
						//Se imprime los datos solicitados
						imprimirDatos(listadoAlum, listadoProf);
						
						//Se cierran los lectores del archivo
						lector.close();
						lector2.close();
						
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				System.out.println("El fichero no existe");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
