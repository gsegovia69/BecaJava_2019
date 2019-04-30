package com.everis.beca.java.mavenProyect1;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

import com.everis.beca.java.mavenProyect1.dto.Alumno;
import com.everis.beca.java.mavenProyect1.dto.Clase;
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
 * 
 * 
 */

public class App

{

	
	
	
	
	
	
	public static void main(String[] args)

	{

		funcionesBusqueda();
		
	}

	
	
	
	public static void funcionesBusqueda() {
		
		try {
		Clase clase = lectorListaLibreria();
		System.out.println(clase.getProfesor().toString());
		System.out.println("-----------------Ordenar por ciudad y mostrar solo las que NO sean Alicante-------------------");
		clase.getListaAlumnos().stream().sorted(Comparator.comparing(Alumno::getCiudades)).filter(alu -> !alu.getCiudades().equalsIgnoreCase("Alicante"))
		.forEach(System.out::println);
		System.out.println("-----------------Mostrar alumnos que NO comiencen con la letra 'A'-------------------\n");	
		clase.getListaAlumnos().stream().filter(alu -> !alu.getNombre().toUpperCase().startsWith("A")).forEach(System.out::println);;	
					
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	
	public static Clase lectorListaLibreria() {
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
			//clase.getListaAlumnos().stream().forEach(System.out::println);
			
			xstream = null;

			reader.close();

		} catch (Exception e) {

			System.out.println("Error: " + e.toString());

		}

		return clase;
	}
	
}