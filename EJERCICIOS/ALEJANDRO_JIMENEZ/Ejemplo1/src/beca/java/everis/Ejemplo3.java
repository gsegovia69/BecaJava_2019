package beca.java.everis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Ejemplo3 {

public static void main(String[] args) {

		try {
		 ArrayList<Alumno> alumnos = extractAlumnos(ConstantUtils.RUTA);	
			for(int i=0;i<alumnos.size();i++) {
				System.out.println(alumnos.get(i).toString());
			}		
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
		 * Extrae los datos dentro de la etiqueta html
		 * @param linea : Linea del fichero html
		 * @return retorna los datos 
		 */
	public static String extractData(String linea) {
	return linea.substring(linea.indexOf(">")+1, linea.indexOf("</"));
	}

}
