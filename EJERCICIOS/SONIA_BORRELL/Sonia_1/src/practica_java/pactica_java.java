package practica_java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class pactica_java {

	public static void main(String[] args) {

		File directorio = new File("C:\\Users\\Administrador\\Documents\\GitHub\\BecaJava_2019\\EJERCICIOS");
		String linea = null;
		ArrayList<String> lista_a = new ArrayList<String>();
		HashMap <Integer, String> mapa = new HashMap<Integer, String>();
		if (directorio.isDirectory()) {
			File[] lista = directorio.listFiles();
			for (File fichero : lista) {
				if (fichero.getName().equals("alumnos.xml")) {
					try {
						FileReader archivo = new FileReader(directorio + "/" + fichero.getName());
						BufferedReader b = new BufferedReader(archivo);
						int contador = 0;
						while ((linea = b.readLine()) != null){
						
							// linea = b.readLine();
							//System.out.println(linea);

							lista_a.add(linea);
							mapa.put (contador++, linea);
						}
						
						System.out.println(lista_a);
						System.out.println("HOLA, SOY EL MAPA: "+mapa);

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

