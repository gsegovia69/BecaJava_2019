package beca.java.everis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Ejercicios.
 * @author Alejandro Jimenez
 * @version 29.04.19
 */
public class Ejercicios {

public static void main(String[] args) {

		try {
		 ArrayList<Alumno> alumnos = extractAlumnos(ConstantUtils.RUTA);	
		 ArrayList<Profesor> profesores = extractProfesor(ConstantUtils.RUTA);

		 if(!alumnos.isEmpty()) {
			System.out.println("--------------------------------------");
			 System.out.println("-------------------Ordenado por apellido-------------------");
			 System.out.println("--------------------------------------");
			ordenarApellidos(alumnos);
			 	/*alumnos.stream().forEach((alu)-> {
			 		System.out.println(alu.toString());
			 		});*/
			 		

		 	System.out.println("--------------------------------------");
		 	System.out.println("-------------------Ordenado por ciudad-------------------");
			 System.out.println("--------------------------------------");
		 			
		 		/*for(int i=0;i<alumnos.size();i++) {
		 			System.out.println(alumnos.get(i).toString());
		 		}*/
			
			ordenarCiudad(alumnos);
			 	
		 	printAlejandros(alumnos);
		 		
		 	printAyS(alumnos);
		 		
		 	contieneA(alumnos);
		 }
		 else {
			 System.out.println("Lista Alumnos Vacia");
		 }
		 
		 
		 
		 		printListaCompleta(alumnos,profesores);
		 		
		}
		catch(Exception e){
			System.out.println("Error al extraer los datos");
		}	
}
	/**
	 * Crea una lista de alumnos
	 * @param ruta : ruta del fichero xml
	 * @return : lista de alumnos procesada
	 */
	public static ArrayList <Alumno> extractAlumnos(String ruta) {
		File xml = new File(ruta);
		ArrayList<Alumno> lista = new ArrayList<Alumno>();
		BufferedReader b=null;

		if(xml.isFile()) 
					try {
						String linea;
						Alumno alu = null;
						FileReader archivo = new FileReader(ruta);
						b = new BufferedReader(archivo);
							boolean alumno=false;
						       while((linea = b.readLine())!=null) {
						    	   
						       try {
						    	   if(linea.contains(ConstantUtils.INICIO_ALUMNO)) {
						    		  alu =new Alumno();
						    		  alumno=true;
						    	   }
						    	   if(alumno && linea.contains(ConstantUtils.NOMBRE)) {
						    		   alu.setNombre(extractData(linea));
						    		   alumno=true;
						    		   
						    	   }
						    	   if(alumno && linea.contains(ConstantUtils.APELLIDOS)) {
						    		   alu.setApellidos(extractData(linea));
						    		   alumno=true;
						    	   }
						    	   if(alumno && linea.contains(ConstantUtils.EMAIL)) {
						    		   alu.setEmail(extractData(linea));
						    		   alumno=true;
						    	   }
						    	   if(alumno && linea.contains(ConstantUtils.CIUDAD)) {
						    		   alu.setCiudad(extractData(linea));
						    		   alumno=true;
						    	   }
						    	   if(alumno && linea.contains(ConstantUtils.FIN_ALUMNO)) {
						    		   lista.add(alu);
						    		   alumno=false;
						    	   }
						       }catch(Exception e) {
						    	   System.out.println("Error: " + e.getMessage()); 
						       }
						       
						       }
						    						       
						    b.close();
					}
					catch(Exception e) {
						System.out.println("Error extrayendo datos: "+ e.getMessage());
					}
					finally {
						try {
							b.close();
						} catch (IOException e) {
							System.out.println("No se puede cerrar el archivo: " + e.getMessage());
						}
						
					}
		return lista;
	}
	
	/**
	 * Crea una lista de profesores
	 * @param ruta : ruta del fichero xml
	 * @return : lista de profesores procesada
	 */
	public static ArrayList <Profesor> extractProfesor(String ruta) {
		File xml = new File(ruta);
		ArrayList<Profesor> lista = new ArrayList<Profesor>();
		BufferedReader b=null;

		if(xml.isFile()) 
					try {
						String linea;
						Profesor prof = null;
						FileReader archivo = new FileReader(ruta);
						b = new BufferedReader(archivo);
							boolean profesor=false;
						       while((linea = b.readLine())!=null) {
						    	   
						       try {
						    	   if(linea.contains(ConstantUtils.INICIO_PROFESOR)) {
						    		  prof =new Profesor();
						    		  profesor=true;
						    	   }
						    	   if(profesor && linea.contains(ConstantUtils.NOMBRE)) {
						    		   prof.setNombre(extractData(linea));
						    		   profesor=true;
						    	   }
						    	   if(profesor && linea.contains(ConstantUtils.APELLIDOS)) {
						    		   prof.setApellidos(extractData(linea));
						    		   profesor=true;
						    	   }
						    	   if(profesor && linea.contains(ConstantUtils.EMAIL)) {
						    		   prof.setEmail(extractData(linea));
						    		   profesor=true;
						    	   }
						    	   if(profesor && linea.contains(ConstantUtils.CIUDAD)) {
						    		   prof.setCiudad(extractData(linea));
						    		   profesor=true;
						    	   }
						    	   if(profesor && linea.contains(ConstantUtils.FIN_PROFESOR)) {
						    		   lista.add(prof);
						    		   profesor=false;
						    	   }
						       }catch(Exception e) {
						    	   System.out.println("Error: " + e.getMessage()); 
						       }
						       
						       }
						    						       
						    b.close();
					}
					catch(Exception e) {
						System.out.println("Error extrayendo datos: "+ e.getMessage());
					}
					finally {
						try {
							b.close();
						} catch (IOException e) {
							System.out.println("No se puede cerrar el archivo: " + e.getMessage());
						}
						
					}
		return lista;
	}

		/**
		 * Extrae los datos dentro de la etiqueta html
		 * @param linea : Linea del fichero html
		 * @return retorna los datos 
		 */
	public static String extractData(String linea) {
	return linea.substring(linea.indexOf(">")+1, linea.indexOf("</"));
	}
	
	/**
	 * Metodo que ordena la lista pasada por parametro alfabeticamente (apellido)
	 * @param alumnos : lista de alumnos
	 */
	public static void ordenarApellidos(ArrayList<Alumno> alumnos) {
 		
		/*Collections.sort(alumnos, new Comparator<Alumno>(){
		@Override
		public int compare(Alumno o1, Alumno o2) {
			return o1.getApellidos().toLowerCase().compareTo(o2.getApellidos().toLowerCase());
		
		}
 		});*/
		
		alumnos.stream().
		sorted(Comparator.comparing(Alumno::getApellidos, String.CASE_INSENSITIVE_ORDER)).
		collect(Collectors.toList()).
		forEach(System.out::println);
	}
	
	/**
	 * Metodo que ordena la lista pasada por parametro alfabeticamente (Ciudad)
	 * @param alumnos : lista de alumnos
	 */
	public static void ordenarCiudad(ArrayList<Alumno> alumnos) {
		 /*Collections.sort(alumnos, new Comparator<Alumno>(){
				@Override
				public int compare(Alumno o1, Alumno o2) {
					return o1.getCiudad().toLowerCase().compareTo(o2.getCiudad().toLowerCase());
				}
			});*/

		alumnos.stream().
		sorted(Comparator.comparing(Alumno::getCiudad, String.CASE_INSENSITIVE_ORDER)).
		collect(Collectors.toList()).
		forEach(System.out::println);
		
	}
	
	/**
	 * metodo que imprime únicamente a los Alejandros de la clase
	 * @param alumnos : lista de alumnos
	 */
	public static void printAlejandros(ArrayList<Alumno> alumnos) {
	 	System.out.println("--------------------------------------");
 		System.out.println("-------------------Solo Alejandros-------------------");
	 	System.out.println("--------------------------------------");
			/*for(Alumno alu : alumnos) {
				if(alu.getNombre().toLowerCase().equals("alejandro")) {
					System.out.println(alu.toString());
				}
			}*/
			/*for(Alumno alu : alumnos) {
				if(alu.getNombre().toLowerCase().contains("alejandro")) {
					System.out.println(alu.toString());
				}
			}*/
			alumnos.stream().
			filter(a -> a.getNombre().toLowerCase().contains("alejandro")).
			sorted(Comparator.comparing(Alumno::getApellidos , String.CASE_INSENSITIVE_ORDER)).
			collect(Collectors.toList()).
			forEach(System.out::println);
	}
	
	/**
	 * Metodo que imprime únicamente los alumnos cuyo nombre empieza por 'A' o por 'S'
	 * @param alumnos : lista de alumnos
	 */
	public static void printAyS(ArrayList<Alumno> alumnos) {
	 	System.out.println("--------------------------------------");
 		System.out.println("-------------------Nombres que empiezan por 'A' o 'S'-------------------");
	 	System.out.println("--------------------------------------");
		/*for(Alumno alu : alumnos) {
			if(alu.getNombre().toLowerCase().indexOf('a')==0 || alu.getNombre().toLowerCase().indexOf('s')==0) {
				System.out.println(alu.toString());
			}
		}*/
	 	alumnos.stream().
	 	filter(a-> a.getNombre().toLowerCase().startsWith("a") || a.getNombre().toLowerCase().startsWith("s")).
	 	sorted(Comparator.comparing(Alumno::getNombre , String.CASE_INSENSITIVE_ORDER)).
	 	collect(Collectors.toList()).
	 	forEach(System.out::println);
	}
	
	/**
	 * Método que imprime únicamente a los alumnos cuyo nombre contiene una o más 'a'
	 * @param alumnos : Lista de alumnos
	 */
	public static void contieneA(ArrayList<Alumno> alumnos) {
	 	System.out.println("--------------------------------------");
		System.out.println("-------------------Nombres que contienen 'A'-------------------");
	 	System.out.println("--------------------------------------");
		/*for(Alumno alu : alumnos) {
			if(alu.getNombre().toLowerCase().contains("a")) {
				System.out.println(alu.toString());
			}
		}*/
	 	alumnos.stream().filter(a -> a.getNombre().toLowerCase().contains("a")).
	 	sorted(Comparator.comparing(Alumno::getApellidos , String.CASE_INSENSITIVE_ORDER)).
	 	collect(Collectors.toList()).
	 	forEach(System.out::println);
	}
	/**
	 * Imprime la lista de profesores y alumnos de la clase por pantalla
	 * @param alumnos : Lista de alumnos
	 * @param profesor : Lista de profesores
	 */
	
	public static void printListaCompleta (ArrayList<Alumno> alumnos, ArrayList<Profesor> profesor) {
		if (!profesor.isEmpty()) {
			if(profesor.size()>1)
				System.out.println("----Profesores-----");
			else 
				System.out.println("----Profesor-----");
			
			profesor.stream().
			sorted(Comparator.comparing(Profesor::getApellidos , String.CASE_INSENSITIVE_ORDER)).
			collect(Collectors.toList()).
			forEach(System.out::println); 
		}
		else
			System.out.println("Lista Profesor Vacia");
		
		if (!alumnos.isEmpty()) {
			if(alumnos.size()>1)
				System.out.println("----Alumnos-----");
			else 
				System.out.println("----Alumno-----");

			alumnos.stream().
			sorted(Comparator.comparing(Alumno::getApellidos , String.CASE_INSENSITIVE_ORDER)).
			collect(Collectors.toList()).
			forEach(System.out::println); 
		}
	}
}
