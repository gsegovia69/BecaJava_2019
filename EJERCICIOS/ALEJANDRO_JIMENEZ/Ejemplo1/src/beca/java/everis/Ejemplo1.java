package beca.java.everis;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejemplo1 {

	public static void main(String[] args) {
		//System.out.println("Leer directorio : "+args[0]);
	if (args.length==1) {
		File directorio = new File(args[0]);
		
			if(directorio.isDirectory()) {
				File[] lista = directorio.listFiles();
				BufferedReader b=null;
				for (File fichero : lista) {
					if(fichero.getName().equals("alumnos.xml")) {
						String linea;
						try {
							FileReader archivo = new FileReader(args[0] +"/"+ fichero.getName());
							b = new BufferedReader(archivo);
							       while((linea = b.readLine())!=null) {
							           System.out.println(linea);
							       }
		 					       b.close();
						}
						catch(Exception e) {
							System.out.println("Error leyendo el archivo: "+ e.getMessage());
						}
						finally {
							try {
								b.close();
							} catch (IOException e) {
								System.out.println("No se puede cerrar el archivo: " + e.getMessage());
							}
						}
					}	   
					
	
				}
			
			}
			else 
				System.out.println("Revisa el argumento");
	}
	else
		System.out.println("Error en los argumentos");
				
				/*   Formas recorrer listas
				System.out.println("-----------------------------------------");
				System.out.println("-----------------------------------------");
				
				for (int i=0;i<lista.length;i++) {
					File fichero = lista[i];	
					System.out.println(fichero.getName());
				}
				System.out.println("-----------------------------------------");
				System.out.println("-----------------lambdas-----------------");
				
				Arrays.asList(lista).stream().forEach(f -> System.out.println(f.getName()));
				*/
			}
	
	
	
}


