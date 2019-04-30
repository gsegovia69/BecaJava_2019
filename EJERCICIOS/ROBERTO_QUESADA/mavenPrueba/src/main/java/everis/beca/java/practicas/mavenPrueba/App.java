package everis.beca.java.practicas.mavenPrueba;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;
import java.util.Comparator;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

import everis.beca.java.practicas.mavenPrueba.dto.Alumno;
import everis.beca.java.practicas.mavenPrueba.dto.ClaseEveris;

public class App {
	public static void main(String[] args) {
		try {
			ClaseEveris clase = obtenerClase();
			System.out.println(clase.getProfesor().toString());
			System.out.println("-----------------------------------------------------------------");
			clase.getListaAlumnos().stream().filter(x -> !x.getNombre().toLowerCase().startsWith("a"))
					.sorted(Comparator.comparing(Alumno::getNombre)).forEach(System.out::println);

			// IMPORTAR - AÑADIR DEPENDENCIA DE APACHE COMMONS

			// ORDENAR POR CIUDAD Y MOSTRAR SOLO LOS QUE NO SON DE ALICANTE
			// clase.getListaAlumnos().stream().filter(x ->
			// !x.getCiudad().equalsIgnoreCase("Alicante"))
			// .sorted(Comparator.comparing(Alumno::getCiudad)).forEach(System.out::println);
			// MOSTRAR UNICAMENTE AQUELLOS ALUMNOS CUYO NOMBRE NO EMPIECE POR "A"
			// clase.getListaAlumnos().stream().filter(x -> !x.getNombre().startsWith("A"))
			// .sorted(Comparator.comparing(Alumno::getNombre)).forEach(System.out::println);
		} catch (Exception e) {
			System.out.println("Error: " + e.toString());
		}

	}

	private static ClaseEveris obtenerClase() throws IOException {

		File fishero = new File(
				"C:\\Users\\Administrador\\Documents\\GitHub\\BecaJavatortoise\\EJERCICIOS\\alumnos.xml");
		Reader reader = new InputStreamReader(new FileInputStream(fishero), "ISO-8859-1");
		XStream xstream = new XStream(new StaxDriver());
		xstream.addPermission(NoTypePermission.NONE);
		xstream.addPermission(NullPermission.NULL);
		xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
		xstream.allowTypeHierarchy(Collection.class);
		xstream.allowTypesByWildcard(new String[] { "everis.beca.java.practicas.mavenPrueba.dto.*" });
		xstream.ignoreUnknownElements();
		xstream.processAnnotations(ClaseEveris.class);
		ClaseEveris clase = (ClaseEveris) xstream.fromXML(reader);
		xstream = null;

		reader.close();
		return clase;

	}
}
