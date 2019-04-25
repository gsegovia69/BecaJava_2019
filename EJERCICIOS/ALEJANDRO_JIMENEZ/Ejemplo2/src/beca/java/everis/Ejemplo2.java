package beca.java.everis;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ejemplo2 {

public static void main(String[] args) {
		
	if (args != null) {
		try {
		ArrayList<String> lista = lista(args[0]);
		/*for(int i=0;i<lista.size();i++) {
			System.out.println(lista.get(i));
		}*/
		Map<Integer,String>mapa = mapa(args[0]);
		for (int i=0;i<mapa.size();i++) {
			System.out.println(mapa.get(i));
		}
		}
		catch(Exception e){
			System.out.println("Error al extraer los datos");
		}
		
	}
	else
		System.out.println("Error en los argumentos");
	
	
	
}
	
	







/**
 * Extrae la lista del fichero llamado alumnos.xml de la ruta especificada
 * @param ruta : Ruta donde se encuentra el fichero
 * @return : ArrayList con las lineas del fichero
 */
public static ArrayList <String> lista(String ruta){
	File directorio = new File(ruta);
	ArrayList<String> lista = new ArrayList<String>();
	
	if(directorio.isDirectory()) {
		File[] archivos = directorio.listFiles();
		BufferedReader b=null;
		
		for (File fichero : archivos) {
			if(fichero.getName().equals("alumnos.xml")) {
				String linea;
				try {
					FileReader archivo = new FileReader(ruta +"/"+ fichero.getName());
					b = new BufferedReader(archivo);
					       while((linea = b.readLine())!=null) {
					    	   lista.add(linea);
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
	return lista;
}



/**
 * Extrae la lista del fichero llamado alumnos.xml de la ruta especificada
 * @param ruta : Ruta donde se encuentra el fichero
 * @return : mapa con las lineas del fichero con su correspondiente clave numérica  0,n
 */
public static Map <Integer, String> mapa(String ruta){
	File directorio = new File(ruta);
	Map <Integer, String> mapa = new HashMap<Integer,String>();
	if(directorio.isDirectory()) {
		File[] archivos = directorio.listFiles();
		BufferedReader b=null;
		Integer cont=0;
		for (File fichero : archivos) {
			if(fichero.getName().equals("alumnos.xml")) {
				String linea;
				try {
					FileReader archivo = new FileReader(ruta +"/"+ fichero.getName());
					b = new BufferedReader(archivo);
					       while((linea = b.readLine())!=null) {
					    	   mapa.put(cont,linea);
					    	   cont++;
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
	return mapa;
}


}











