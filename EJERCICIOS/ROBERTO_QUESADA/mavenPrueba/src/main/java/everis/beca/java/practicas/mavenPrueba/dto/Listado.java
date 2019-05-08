/*package everis.beca.java.practicas.mavenPrueba.dto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Listado {

	public void metodo1(ClaseEveris clase, String fecha) {

		List<Alumno> nuevo = clase.getListaAlumnos().stream()
				.sorted(Comparator.comparing(Alumno::getNombre).thenComparing(Alumno::getApellidos))
				.collect(Collectors.toList());
		
		for (int i = 0; i < nuevo.size(); i++) { // Recorro la lista y coloco todas las Strings en la variable
			// nombres
			System.out.println(fecha + "--> " + nuevo.get(i).allString());
		}
	}

	public void metodo2(ClaseEveris clase, String fecha) {
		
		List<Alumno> nuevo = clase.getListaAlumnos().stream().filter(x -> x.getCiudad().toUpperCase().startsWith("A"))
				.sorted(Comparator.comparing(Alumno::getNombre)).collect(Collectors.toList());

		for (int i = 0; i < nuevo.size(); i++) { // Recorro la lista y coloco todas las Strings en la variable
			// nombres
			System.out.println(fecha + "--> " + nuevo.get(i).allString());

		}
	}
}
*/