package practica_java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Practica_ListaArrays {

	public static void main(String[] args) {

		File directorio = new File("C:\\Users\\Administrador\\Documents\\GitHub\\BecaJava_2019\\EJERCICIOS");
		String linea = null;

		if (directorio.isDirectory()) {
			File[] lista = directorio.listFiles();
			for (File fichero : lista) {
				if (fichero.getName().equals("alumnos.xml")) {
					try {
						FileReader archivo = new FileReader(directorio + "/" + fichero.getName());
						BufferedReader b = new BufferedReader(archivo);

						boolean newAlumno = false;
						boolean newProfesor = false;
						List<Practica2> listaAlumno = new ArrayList<Practica2>();
						List<Practica2> listaProfesor = new ArrayList<Practica2>();
						Practica2 alumno = null;
						Practica2 profesor = null;

						while ((linea = b.readLine()) != null) {

							if (linea.trim().equalsIgnoreCase(Constantes.INICIO_ITERACION_ALUMNO)) {
								alumno = new Practica2();
								newAlumno = true;
							}
							if (linea.trim().contains(Constantes.INICIO_ITERACION_NOMBRE)) {
								if (newAlumno) {
									alumno.setNombre(linea.trim().replaceAll(Constantes.INICIO_ITERACION_NOMBRE, "")
											.replaceAll(Constantes.FINAL_ITERACION_NOMBRE, ""));
								}
								if (newProfesor) {
									profesor.setNombre(linea.trim().replaceAll(Constantes.INICIO_ITERACION_NOMBRE, "")
											.replaceAll(Constantes.FINAL_ITERACION_NOMBRE, ""));
								}

							}
							if (linea.trim().contains(Constantes.INICIO_ITERACION_APELLIDOS)) {
								linea = linea.trim().replaceAll("<apellidos>", "");
								linea = linea.trim().replaceAll("</apellidos>", "");
								if (newAlumno) {
									alumno.setApellido(linea);
								}
								if (newProfesor) {
									profesor.setApellido(linea);
								}

							}
							if (linea.trim().contains(Constantes.INICIO_ITERACION_EMAIL)) {
								linea = linea.trim().replaceAll("<email>", "");
								linea = linea.trim().replaceAll("</email>", "");
								if (newAlumno) {
									alumno.setEmail(linea);
								}
								if (newProfesor) {
									profesor.setEmail(linea);
								}
							}
							if (linea.trim().contains(Constantes.INICIO_ITERACION_CIUDAD)) {
								linea = linea.trim().replaceAll("<ciudad>", "");
								linea = linea.trim().replaceAll("</ciudad>", "");
								if (newAlumno) {
									alumno.setCiudad(linea);
								}
								if (newProfesor) {
									profesor.setCiudad(linea);
								}

							}
							if (newAlumno && linea.trim().contains(Constantes.FIN_ITERACION_ALUMNO)) {
								listaAlumno.add(alumno);
								newAlumno = false;
							}
							if (linea.trim().equalsIgnoreCase(Constantes.INICIO_ITERACION_PROFESOR)) {
								profesor = new Practica2();
								newProfesor = true;
							}
							if (newProfesor && linea.trim().contains(Constantes.FIN_ITERACION_PROFESOR)) {
								listaProfesor.add(profesor);
								newProfesor = false;
							}

						}
						b.close();

						System.out.println("--Recorremos el Array--");
						listaAlumno.stream().forEach(System.out::println);
						System.out.println("__________________________\n");

						System.out.println("-- Escribimos los Apellidos ordenados--");
						listaAlumno.stream().sorted(Comparator.comparing(Practica2::getApellidos)). // convertimos la
																									// lista en stream,
																									// método sort
																									// ordena, interfaz
																									// comparator para
																									// poder ordenar los
																									// apellidos de

								forEach(System.out::println); // pintamos la lista quer acabamos de comprarar
						System.out.println("__________________________\n");
						System.out.println("-- Escribimos las Ciudades ordenados--");
						listaAlumno.stream().sorted(Comparator.comparing(Practica2::getCiudad)). // convertimos la lista
																									// en stream, método
																									// sort ordena,
																									// interfaz
																									// comparator para
																									// poder ordenar los
																									// ciudad
								forEach(System.out::println); // pintamos la lista quer acabamos de comprarar
						System.out.println("__________________________\n");

						System.out.println("-- Filtramos por nombre: Alejandro--");
						listaAlumno.stream().filter(x -> "Alejandro".equals(x.getNombre()))
								.forEach(System.out::println);
						System.out.println("__________________________\n");

						System.out.println("-- Filtramos por nombre cuya letra empieza por A o por S");
						listaAlumno.stream().filter(a -> a.getNombre().startsWith("A") || a.getNombre().startsWith("S"))
								.forEach(System.out::println);
						System.out.println("__________________________\n");

						System.out.println("-- Filtramos cuyo nombre contenga una a--");
						listaAlumno.stream().filter(a -> a.getNombre().contains("a")).forEach(System.out::println);
						System.out.println("__________________________\n");

						System.out.println("-- Escribimos la lista Profesor");
						for (Practica2 pp : listaProfesor) {
							System.out.println(pp.toString());
						}

						System.out.println("-------------------------------------------\n"); // pintamos la lista de los
																								// alumnos
						for (Practica2 pp : listaAlumno) {
							System.out.println(pp.toString());
						}

					} catch (FileNotFoundException e) {

						e.printStackTrace();

						System.out.println(e.toString());

					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			}
		}

	}
}
