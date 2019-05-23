package beca.java.everis;

import java.io.File;
import java.util.Arrays;

public class Ejemplo1 {

	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		System.out.println("Voy a leer el path: "+args[0]);
		File directorio2 = new File(args[0]);
		System.out.println("es directorio: "+directorio2.isDirectory());
		System.out.println("es fichero: "+directorio2.isFile());
		if(directorio2.isDirectory()) {
			 File[] lista = directorio2.listFiles();
			 System.out.println("----------------------------------------");
			 System.out.println("----------------------------------------");
			 System.out.println("foreach");
			 for(File fichero : lista) {
				 if(fichero.isFile()) {
				 System.out.println(fichero.getName());
				 }
			 }
			 System.out.println("----------------------------------------");
			 System.out.println("----------------------------------------");
			 System.out.println("for tradicional");
			 for(int i=0;i<lista.length;i++) {
					 File fichero = lista[i];
					 if(fichero.isFile()) {
					 System.out.println(fichero.getName());
					 }
			 }
			 System.out.println("----------------------------------------");
			 System.out.println("----------------------------------------");
			 System.out.println("lambdas");
				 Arrays.asList(lista).stream().filter(fichero -> fichero.isFile()).forEach(fichero3 -> System.out.println(fichero3.getName()));
	}
}
}