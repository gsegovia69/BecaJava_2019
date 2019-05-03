package proyecto.prueba.ejercicio1.mavenProyect0.dto;

/**
 * Hello world!
 *
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;
import java.util.Comparator;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.mapper.CannotResolveClassException;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

/**
 * 
 * Hello world!
 * 
 * @param <Clase>
 *
 * 
 * 
 */

public class App

{

	public static void main(String[] args) {
		try {

			File fishero = new File("C:\\Users\\Administrador\\Downloads\\BecaJava_2019\\EJERCICIOS\\alumnos.xml");
			Reader reader = new InputStreamReader(new FileInputStream(fishero), "ISO-8859-1");
			XStream xstream = new XStream(new StaxDriver()) {
				protected MapperWrapper wrapMapper(MapperWrapper next) {
					return new MapperWrapper(next) {
						public boolean shouldSerializeMember(Class definedIn, String fieldName) {
							try {
								return definedIn != Object.class || realClass(fieldName) != null;
							} catch (CannotResolveClassException cnrce) {
								return false;
							}
						}
					};
				}
			};
			xstream.addPermission(NoTypePermission.NONE);
			xstream.addPermission(NullPermission.NULL);
			xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
			xstream.allowTypeHierarchy(Collection.class);
			xstream.allowTypesByWildcard(new String[] { "proyecto.prueba.ejercicio1.mavenProyect0.dto.*" });
			xstream.ignoreUnknownElements();
			xstream.processAnnotations(Clase.class);
			Clase clase = (Clase) xstream.fromXML(reader);
			xstream = null;
			reader.close();
			System.out.println(clase.getProfesor());
			System.out.println("-----------------");
			clase.getListaAlumnos().stream().sorted(Comparator.comparing(Alumno::getApellidos))
					.forEach(System.out::println);

		} catch (Exception e) {

			System.out.println("Error: " + e.toString());

		}
	}

}