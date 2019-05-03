package beca.java.everis;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class ReadFile {

	public static void main(String[] args) {
		String ruta = "C:\\Users\\Administrador\\BecaJava_2019-master\\BecaJava_2019\\EJERCICIOS\\alumnos.xml";
//		 ruta += "\\";
		listaAlumno(ruta);
		ruta += "\\";
		try {
//	            System.out.println(ruta);
			mostrarArchivoPantalla(ruta + "alumnos.xml");

		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

		listaAlumno(ruta);

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

	public static void listaAlumno(String fileName) {

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

				
				if (newRow && linea.trim().contains(Constantes.FIN_ITERACION_ALUMNO)) {
					lista.add(al);
					newRow = false;
				}
			}
			lista.forEach(System.out::println);

			System.out.println(al.toString());

		} catch (Exception e) {
		} finally {
			if (temp != null) {
				try {
					temp.close();
				} catch (IOException e) {
				}
			}

		}
	}
}
