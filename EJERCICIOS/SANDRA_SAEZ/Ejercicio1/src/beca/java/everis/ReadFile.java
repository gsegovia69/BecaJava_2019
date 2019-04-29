package beca.java.everis;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import java.util.List;

public class ReadFile {

	public static void main(String[] args) {
		String ruta = "C:\\Users\\Administrador\\BecaJava_2019-master\\BecaJava_2019\\EJERCICIOS\\alumnos.xml";
//		 ruta += "\\";
		System.out.println("---------------------------------");
		System.out.println("---------Lista alumno------------");
		System.out.println("---------------------");
		List<Alumno> lista = listaAlumno(ruta);
		ruta += "\\";
		try {
//	            System.out.println(ruta);
			System.out.println("------------------------------------");
			System.out.println("---------mostrar archivo------------");
			System.out.println("------------------------------------");
			mostrarArchivoPantalla(ruta);
			System.out.println("-------------------------------------");
			System.out.println("---------Listar apellido ------------");
			System.out.println("-------------------------------------");
			ordenarListApellido((ArrayList<Alumno>) lista);
			System.out.println("----------------------------------");
			System.out.println("---------Listar ciudad------------");
			System.out.println("----------------------------------");

			ordenarListaCiudad((ArrayList<Alumno>) lista);

			System.out.println("-------------------------------");
			System.out.println("----------Stream --------------");
			System.out.println("-------------------------------");
			recorrerListStream((ArrayList<Alumno>) lista);
			System.out.println("-------------------------------");
			System.out.println("-----------For-----------------");
			System.out.println("-------------------------------");
			recorrerListaFor(lista);
			System.out.println("------------------------------------");
			System.out.println("----------Filtrar Nombre------------");
			System.out.println("------------------------------------");
			filtrarNombre(lista);
			System.out.println("----------------------------------");
			System.out.println("---------Filtrar Inicial----------");
			System.out.println("----------------------------------");
			filtrarNombreInicial(lista);
			System.out.println("---------------------------------");
			System.out.println("--------Lista Alumno-------------");
			System.out.println("---------------------------------");

			listaAlumno(ruta);
			System.out.println("---------------------");
			System.out.println("---------Lista profesor------------");
			System.out.println("---------------------");

			listaProfesor(ruta);
			System.out.println("---------------------");
			System.out.println("--------- ------------");
			System.out.println("---------------------");

		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

	}

	public static void mostrarArchivoPantalla(String ruta) throws IOException {
		File fichero = new File(ruta);
		BufferedReader ficheroL;
		ficheroL = new BufferedReader(new FileReader(fichero));

		String linea = ficheroL.readLine();

		while (linea != null) {
			System.out.println(linea);
			linea = ficheroL.readLine();

		}
		ficheroL.close();
	}

	public static List<Alumno> listaAlumno(String fileName) {

		BufferedReader temp = null;

		try {

			FileReader leer = new FileReader(fileName);
			temp = new BufferedReader(leer);

			String linea = "";

			boolean newRow = false;

			List<Alumno> lista = new ArrayList<Alumno>();
			Alumno al = null;

			while ((linea = temp.readLine()) != null) {
				if (linea.trim().equalsIgnoreCase(Constantes.INICIO_ITERACION_ALUMNO)) {
					al = new Alumno();
					newRow = true;
				}
				if (newRow && linea.trim().contains(Constantes.INICIO_ITERACION_NOMBRE)) {
					al.setNombre(linea.substring(linea.indexOf(">") + 1, linea.indexOf("</")));
				}
				if (newRow && linea.trim().contains(Constantes.INICIO_ITERACION_APELLIDOS)) {
					al.setApellido(linea.substring(linea.indexOf(">") + 1, linea.indexOf("</")));
				}

				if (newRow && linea.trim().contains(Constantes.INICIO_ITERACION_EMAIL)) {
					al.setEmail(linea.substring(linea.indexOf(">") + 1, linea.indexOf("</")));
				}
				if (newRow && linea.trim().contains(Constantes.INICIO_ITERACION_CIUDAD)) {
					al.setCiudad(linea.substring(linea.indexOf(">") + 1, linea.indexOf("</")));
				}

				if (newRow && linea.trim().contains(Constantes.FIN_ITERACION_ALUMNO)) {
					lista.add(al);
					newRow = false;
				}
			}
			lista.forEach(System.out::println);

			System.out.println(al.toString());

			return lista;

		} catch (Exception e) {
		} finally {
			if (temp != null) {
				try {
					temp.close();
				} catch (IOException e) {
				}
			}

		}
		return null;
	}

	public static void ordenarListApellido(ArrayList<Alumno> lista) {

		Collections.sort(lista, new Comparator<Alumno>() {
			public int compare(Alumno obj1, Alumno obj2) {
				return obj1.getApellido().compareTo(obj2.getApellido());
			}
		});
		for (Alumno alumno : lista) {
			System.out.println(alumno.getApellido());
		}

	}

	public static void ordenarListaCiudad(ArrayList<Alumno> lista) {

		Collections.sort(lista, new Comparator<Alumno>() {
			public int compare(Alumno obj1, Alumno obj2) {
				return obj1.getCiudad().compareTo(obj2.getCiudad());
			}
		});
		for (Alumno alumno : lista) {
			System.out.println(alumno.getCiudad());
		}

	}

	public static void recorrerListStream(ArrayList<Alumno> lista) {

		lista.stream().forEach((p) -> {
			System.out.println(p.getNombre());
			System.out.println(p.getApellido());
			System.out.println(p.getEmail());
			System.out.println(p.getCiudad());
		});
	}

	public static void recorrerListaFor(List<Alumno> lista) {

		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));

		}
// System.out.println(lista.toString());
	}

	public static void filtrarNombre(List<Alumno> lista) {

		lista.stream().filter(alu -> alu.getNombre().contains("Alejandro")).forEach(System.out::println);

	}

	public static void filtrarNombreInicial(List<Alumno> lista) {

		lista.stream().filter(
				alu -> alu.getNombre().toUpperCase().startsWith("A") || alu.getNombre().toUpperCase().startsWith("S"))
				.forEach(System.out::println);

	}

	/*
	 * crera obj Alumno y Profesor y rellenar una lista con los profesores y otra
	 * lista con los alumnos
	 */

	public static List<Profesor> listaProfesor(String fileName) {

		BufferedReader temp = null;

		try {

			FileReader leer = new FileReader(fileName);
			temp = new BufferedReader(leer);

			String linea = "";

			boolean newRow = false;

			List<Profesor> lista = new ArrayList<Profesor>();
			Profesor pr = null;

			while ((linea = temp.readLine()) != null) {
				if (linea.trim().equalsIgnoreCase(Constantes.INICIO_ITERACION_PROFESOR)) {
					pr = new Profesor();
					newRow = true;
				}
				if (newRow && linea.trim().contains(Constantes.INICIO_ITERACION_NOMBRE)) {
					pr.setNombre(linea.substring(linea.indexOf(">") + 1, linea.indexOf("</")));
				}
				if (newRow && linea.trim().contains(Constantes.INICIO_ITERACION_APELLIDOS)) {
					pr.setApellido(linea.substring(linea.indexOf(">") + 1, linea.indexOf("</")));
				}

				if (newRow && linea.trim().contains(Constantes.INICIO_ITERACION_EMAIL)) {
					pr.setEmail(linea.substring(linea.indexOf(">") + 1, linea.indexOf("</")));
				}
				if (newRow && linea.trim().contains(Constantes.INICIO_ITERACION_CIUDAD)) {
					pr.setCiudad(linea.substring(linea.indexOf(">") + 1, linea.indexOf("</")));
				}

				if (newRow && linea.trim().contains(Constantes.FIN_ITERACION_PROFESOR)) {
					lista.add(pr);
					newRow = false;
				}
			}
//		lista.forEach(System.out::println);

			System.out.println(pr.toString());

			return lista;

		} catch (Exception e) {
		} finally {
			if (temp != null) {
				try {
					temp.close();
				} catch (IOException e) {
				}
			}

		}
		return null;
	}

}
