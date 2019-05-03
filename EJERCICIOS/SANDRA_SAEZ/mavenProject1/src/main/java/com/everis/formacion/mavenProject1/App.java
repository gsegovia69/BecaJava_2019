package com.everis.formacion.mavenProject1;

import java.io.File;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.IOException;

import java.io.InputStreamReader;

import java.io.Reader;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import com.everis.formacion.mavenProject1.dto.Alumno;
import com.everis.formacion.mavenProject1.dto.Clase;
import com.everis.formacion.mavenProject1.dto.OrdenarCiudad;
import com.everis.formacion.mavenProject1.dto.OrdenarNombre;
import com.thoughtworks.xstream.XStream;

import com.thoughtworks.xstream.XStreamException;

import com.thoughtworks.xstream.io.xml.StaxDriver;

import com.thoughtworks.xstream.mapper.CannotResolveClassException;

import com.thoughtworks.xstream.mapper.MapperWrapper;

import com.thoughtworks.xstream.security.NoTypePermission;

import com.thoughtworks.xstream.security.NullPermission;

import com.thoughtworks.xstream.security.PrimitiveTypePermission;

public class App

{

	public static void main(String[] args)

	{
		Clase clase = obtenerClase();

		// System.out.println(clase.getProfesor().toString());
		// clase.getListaAlumnos().stream().sorted(Comparator.comparing(Alumno::getApellidos)).forEach(System.out::println);

		System.out.println("-------------------------------------------------------");
		System.out.println("-------------------------------------------------------");
		clase.getListaAlumnos().stream().filter(alu -> alu.getCiudad().contains("Alicante"))
				.forEach(System.out::println);

		System.out.println("-------------------------------------------------------");
		System.out.println("-------------------------------------------------------");
		clase.getListaAlumnos().stream().filter(alu -> alu.getNombre().toUpperCase().startsWith("A"))
				.forEach(System.out::println);
		System.out.println("-------------------------------------------------------");
		System.out.println("-------------------------------------------------------");

		OrdenarNombre ordenarN = new OrdenarNombre();
		ordenarN.metodo1(clase);

//		ordenarN.OrdenarNombreApellido((ArrayList<Alumno>)lista);

		System.out.println("-------------------------------------------------------");
		System.out.println("-------------------------------------------------------");

		OrdenarCiudad ordenarC = new OrdenarCiudad();
		ordenarC.metodo2(clase);

		System.out.println("-------------------------------------------------------");
		System.out.println("-------------------------------------------------------");

	}

	private static Clase obtenerClase() {
		Clase clase = new Clase();
		try {

			File fichero = new File(
					"C:\\Users\\Administrador\\BecaJava_2019-master\\BecaJava_2019\\EJERCICIOS\\alumnos.xml");

			Reader reader = new InputStreamReader(new FileInputStream(fichero), "ISO-8859-1");

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

			xstream.allowTypesByWildcard(new String[] { "com.everis.formacion.mavenProject1.dto.*" });

			xstream.ignoreUnknownElements();

			xstream.processAnnotations(Clase.class);

			clase = (Clase) xstream.fromXML(reader);

			xstream = null;

			reader.close();

		} catch (Exception e) {

			System.out.println("Error: " + e.toString());

		}

		return clase;

	}
}
