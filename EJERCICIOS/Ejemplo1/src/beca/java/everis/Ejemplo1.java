package beca.java.everis;

import java.io.File;
import java.util.Arrays;

public class Ejemplo1 {
	
	public static void main(String[] args) {		System.out.println("Voy a leer el path: "+args[0]);
		File directorio = new File(args[0]);
		if(directorio.isDirectory()) {
			File[] lista = directorio.listFiles();
			System.out.println("------------------------------------------");
			System.out.println("------------------------------------------");
			System.out.println("Foreach");
			for(File fichero : lista) {
				if(fichero.isFile()) {
					System.out.println(fichero.getName());
				}
			}
			System.out.println("------------------------------------------");
			System.out.println("------------------------------------------");
			System.out.println("For tradicional");
			for(int i=0;i<lista.length;i++) {
				File fichero = lista[i];
				if(fichero.isFile()) {
					System.out.println(fichero.getName());
				}
			}
			System.out.println("------------------------------------------");
			System.out.println("------------------------------------------");
			System.out.println("lambdas");
			Arrays.asList(lista).stream().filter(fichero -> fichero.isFile()).forEach(fichero3 -> System.out.println(fichero3.getName()));
		}
			
	}

}
