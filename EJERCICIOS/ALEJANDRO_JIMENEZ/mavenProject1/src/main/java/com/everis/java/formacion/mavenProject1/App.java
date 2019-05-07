package com.everis.java.formacion.mavenProject1;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

import com.everis.java.formacion.mavenProject1.dto.*;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.mapper.CannotResolveClassException;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;



public class App {
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Clase clase = obtenerClase();
		
		mostrarNoAlicante(clase);
		
		mostrarNoA(clase);
		
		
	}
	
	public static void mostrarNoAlicante (Clase clase) {
		
		System.out.println("\n-----Ordenar por ciudad-----------Solo no Alicante------\n");
		clase.getListaAlumnos().stream().
		sorted(Comparator.comparing(Alumno::getCiudad,String.CASE_INSENSITIVE_ORDER)).
//		filter(a -> !a.getCiudad().toLowerCase().equals("alicante")).
		filter(a -> !a.getCiudad().toLowerCase().contains("alicante")).
		 collect(Collectors.toList()).
		forEach(System.out::println);
	}
	
	public static void mostrarNoA(Clase clase) {
		System.out.println("\n-------------------Nombre no empieza por A---------------\n");
		clase.getListaAlumnos().stream().
		sorted(Comparator.comparing(Alumno::getNombre)).
		filter(a-> !a.getNombre().toLowerCase().startsWith("a")).
		collect(Collectors.toList()).
		forEach(System.out::println);
	}

	private static Clase obtenerClase() {
		Clase clase = null;
		try {
			File fichero = new File("C:\\BecaJava\\BecaJava_2019/EJERCICIOS/alumnos.xml");
			Reader reader = new InputStreamReader(new FileInputStream(fichero), "ISO-8859-1");
			XStream xstream = new XStream(new StaxDriver());
			xstream.addPermission(NoTypePermission.NONE);
			xstream.addPermission(NullPermission.NULL);
			xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
			xstream.allowTypeHierarchy(Collection.class);
			xstream.allowTypesByWildcard(new String[] { "com.everis.java.formacion.mavenProject1.dto.*" });
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