package beca.java.everis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Ejemplo3 {

static final String RUTA = "C:\\BecaJava\\BecaJava_2019/EJERCICIOS/alumnos.xml";
	
public static void main(String[] args) {
		 
	
		try {
		 ArrayList<Alumno> alumnos = extractAlumnos(RUTA);	
			for(int i=0;i<alumnos.size();i++) {
				System.out.println(alumnos.get(i).toString());
			}		
		}
		catch(Exception e){
			System.out.println("Error al extraer los datos");
		}
		
	
	
}
	
	public static ArrayList <Alumno> extractAlumnos(String ruta) {
		File xml = new File(ruta);
		ArrayList<Alumno> lista = new ArrayList<Alumno>();
		BufferedReader b=null;
		String linea;
		Alumno alu = null;
		if(xml.isFile()) 
					try {
						FileReader archivo = new FileReader(ruta);
						b = new BufferedReader(archivo);
								boolean control=false;
						       while((linea = b.readLine())!=null) {
						    	   if(linea.indexOf("<alumno>")!=-1) {
						    		  alu =new Alumno();
						    		  control=true;
						    	   }
						    	   if(control && linea.indexOf("<nombre>")!=-1) {
						    		   alu.setNombre(extractData(linea));
						    		   control=true;
						    		   
						    	   }
						    	   if(control && linea.indexOf("<apellidos>")!=-1) {
						    		   alu.setApellidos(extractData(linea));
						    		   control=true;
						    	   }
						    	   if(control && linea.indexOf("</alumno>")!=-1) {
						    		   lista.add(alu);
						    		   control=false;
						    	   }
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
		
	public static String extractData(String linea) {
	return linea.substring(linea.indexOf(">")+1, linea.indexOf("</"));
	}

}
