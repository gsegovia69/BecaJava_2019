package everis.beca.java.practicas.mavenPrueba;

import java.util.Comparator;

import everis.beca.java.practicas.mavenPrueba.dto.Alumno;
import everis.beca.java.practicas.mavenPrueba.dto.ClaseEveris;
import everis.beca.java.practicas.mavenPrueba.dto.LeerFichero;

public class App {
	public static void main(String[] args) {
		try {
			ClaseEveris clase = LeerFichero.leer();
			System.out.println(clase.getProfesor().toString());
			System.out.println("-----------------------------------------------------------------");
			System.out.println("--------------------------------------------------------------");
			System.out.println("--------------------------------------------------------------");
			clase.getListaAlumnos().stream().filter(x -> !x.getNombre().toLowerCase().startsWith("a"))
					.sorted(Comparator.comparing(Alumno::getNombre)).forEach(System.out::println);

			// IMPORTAR - AÑADIR DEPENDENCIA DE APACHE COMMONS
			System.out.println("--------------------------------------------------------------");
			System.out.println("--------------------------------------------------------------");
			System.out.println("--------------------------------------------------------------");
			System.out.println("ORDENAR POR CIUDAD Y MOSTRAR SOLO LOS QUE NO SON DE ALICANTE");
			System.out.println("--------------------------------------------------------------");
			System.out.println("--------------------------------------------------------------");
			System.out.println("--------------------------------------------------------------");
			 clase.getListaAlumnos().stream().filter(x ->
			 !x.getCiudad().equalsIgnoreCase("Alicante"))
			 .sorted(Comparator.comparing(Alumno::getCiudad)).forEach(System.out::println);
			 System.out.println("--------------------------------------------------------------");
			 System.out.println("--------------------------------------------------------------");
			 System.out.println("--------------------------------------------------------------");
			System.out.println("MOSTRAR UNICAMENTE AQUELLOS ALUMNOS CUYO NOMBRE NO EMPIECE POR A");
			System.out.println("--------------------------------------------------------------");
			System.out.println("--------------------------------------------------------------");
			System.out.println("--------------------------------------------------------------");
			 clase.getListaAlumnos().stream().filter(x -> !x.getNombre().startsWith("A"))
			 .sorted(Comparator.comparing(Alumno::getNombre)).forEach(System.out::println);
		} catch (Exception e) {
			System.out.println("Error: " + e.toString());
		}

	}

	
}
