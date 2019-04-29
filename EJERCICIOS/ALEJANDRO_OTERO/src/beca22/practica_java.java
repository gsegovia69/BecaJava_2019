package practica_java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class practica_java {
	

	public static void main(String[] args) {
		File directorio = new File("C:/Users/Administrador/Downloads/BecaJava_2019");
		String linea;
		if (directorio.isDirectory()) {
			File[] lista = directorio.listFiles();
			for (File fichero : lista) {
				if (fichero.getName().equals("alumnos.xml")) {
					try {
						FileReader archivo = new FileReader(directorio + "/" + fichero.getName());
						List<String> list1 = new ArrayList<String>();
						int i=0
						map<Integer, String> mapa = new HashMap<Integer, String>();
						BufferedReader b = new BufferedReader(archivo);
						
						while ((linea = b.readLine()) != null) {
							//linea = b.readLine();
						System.out.println(linea);
						}
						b.close();
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

	