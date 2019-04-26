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
		 
	
		try {
			
			System.out.println("\n--------------------Lista-----------------------------");
			ArrayList<String> lista = lista(ConstantUtils.RUTA);
			for(int i=0;i<lista.size();i++) {
				System.out.println(lista.get(i));
			}
			System.out.println("\n--------------------Mapa-----------------------------");
			Map<Integer,String>mapa = mapa(ConstantUtils.RUTA);
			for (int i=0;i<mapa.size();i++) {
				System.out.println(mapa.get(i));
	
			}
		}
		catch(Exception e){
			System.out.println("Error al extraer los datos");
		}	
}

/**
 * Extrae la lista del fichero llamado alumnos.xml de la ruta especificada
 * @param ruta : Ruta donde se encuentra el fichero
 * @return : ArrayList con las lineas del fichero
 */
public static ArrayList <String> lista(String ruta){
	File xml = new File(ruta);
	ArrayList<String> lista = new ArrayList<String>();
	BufferedReader b=null;
	String linea;
	if(xml.isFile()) 
				try {
					FileReader archivo = new FileReader(ruta);
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
	return lista;
}



/**
 * Extrae la lista del fichero llamado alumnos.xml de la ruta especificada
 * @param ruta : Ruta donde se encuentra el fichero
 * @return : mapa con las lineas del fichero con su correspondiente clave numérica  0,n
 */
public static Map <Integer, String> mapa(String ruta){
	File xml = new File(ruta);
	Map <Integer,String> mapa = new HashMap<Integer,String>();
	BufferedReader b=null;
	String linea;
	Integer cont=0;
	if(xml.isFile()) 
				try {
					FileReader archivo = new FileReader(ruta);
					b = new BufferedReader(archivo);
					       while((linea = b.readLine())!=null) {
					    	   mapa.put(cont, linea);
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
	return mapa;
}


}











