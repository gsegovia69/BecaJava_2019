package com.everis.beca.java.mavenProyect1;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;

import com.everis.beca.java.mavenProyect1.dto.Clase;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.mapper.CannotResolveClassException;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

public class OrdenarApellidoNombre {

	public static void main(String[] args) {

		Clase clase = new Clase();

		clase = lectorListaLibreria();

		MuestraListadoFechaDelanteBarras ordena = new MuestraListadoFechaDelanteBarras();
		MostrarListadoFechaGuiones ordenaGuiones = new MostrarListadoFechaGuiones();

		ordena.funcionMostrarListaAlumnos(clase);

		System.out.println("---------------------Con Guiones-----------------------");

		ordenaGuiones.funcionMostrarListaAlumnos(clase);

	}

	private static Clase lectorListaLibreria() {
		Clase clase = new Clase();
		try {

			File fishero = new File(
					"C:\\Users\\Administrador\\Desktop\\Beca_ISR\\BecaJava_2019\\EJERCICIOS\\alumnos.xml");

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

			xstream.allowTypesByWildcard(new String[] { "com.everis.beca.java.mavenProyect1.dto.*" });

			xstream.ignoreUnknownElements();

			xstream.processAnnotations(Clase.class);

			clase = (Clase) xstream.fromXML(reader);
			// clase.getListaAlumnos().stream().forEach(System.out::println);

			xstream = null;

			reader.close();

		} catch (Exception e) {

			System.out.println("Error: " + e.toString());

		}

		return clase;
	}

}
