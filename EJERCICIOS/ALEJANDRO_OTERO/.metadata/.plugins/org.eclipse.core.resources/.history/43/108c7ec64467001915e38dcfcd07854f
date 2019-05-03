package practica_java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class pactica_java {
	public static void main(String[] args) {
		File directorio = new File("C:\\Users\\Administrador\\Documents\\GitHub\\BecaJava_2019\\EJERCICIOS");
		String linea;
		if (directorio.isDirectory()) {
			File[] lista = directorio.listFiles();
			for (File fichero : lista) {
				if (fichero.getName().equals("alumnos.xml")) {
					try {
						FileReader archivo = new FileReader(args[0] + "/" + fichero.getName());
						BufferedReader b = new BufferedReader(archivo);
						while (b.readLine() != null) {
							linea = b.readLine();
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
}