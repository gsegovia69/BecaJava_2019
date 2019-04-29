package practica_java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;




public class pactica_java {

	private static final String String = null;

	public static void main(String[] args) {

		File directorio = new File("C:\\Users\\Administrador\\Documents\\GitHub\\BecaJava_2019\\EJERCICIOS");
		String linea = null;
		
		ArrayList<String> lista_a = new ArrayList<String>(); // Lista de Arrays
		HashMap <Integer, String> mapa = new HashMap<Integer, String>(); // Mapa
		
		if (directorio.isDirectory()) {
			File[] lista = directorio.listFiles();
			
			for (File fichero : lista) {
				
				if (fichero.getName().equals("alumnos.xml")) {
					
					try {
						
						FileReader archivo = new FileReader(directorio + "/" + fichero.getName()); // Lee el fichero
						BufferedReader b = new BufferedReader(archivo); // Lo guarda en el buffer para poder leerlo despues
						int contador = 0;
						while ((linea = b.readLine()) != null){
							
						lista_a.add(linea); //	Primera practica Java, Añadia los alumnos a una lista
						mapa.put (contador++, linea); //Pintaba los alumnos en un mapa
						}
						
						System.out.println("Lista: " +lista_a); // Nos muestra la Lista 
						System.out.println("EL MAPA: "+mapa); // Nos muestra el mapa
						
						//Practica2 p = new Practica2();
						//p.setNombre("Juan");
						//System.out.println(p.getNombre());

						
						b.close();
						
						}	catch (FileNotFoundException e) {

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

