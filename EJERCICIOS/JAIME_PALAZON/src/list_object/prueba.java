package jaimepalazon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class prueba {
	
	
	
	
	public static void main(String[] arg) {
		try {
			FileReader fr = new FileReader("C:/Users/Administrador/Desktop/alumnos.xml");
			BufferedReader br = new BufferedReader(fr);
			
			List <Prueba5> lista = new ArrayList<Prueba5>(); // me haces una lista de la clase "Prueba5"
			
			boolean newRow = false;// acabar
			String linea;
			
			Prueba5 alumnos = null; // creo un objeto de la clase "Prueba5"
			
	        while ((linea = br.readLine()) != null) {
				if(linea.trim().contains("<alumno>")) {
					alumnos = new Prueba5(); // abres objeto
					newRow = true;
					}
				if(newRow && linea.trim().contains("<nombre>")) {
					linea = linea.trim().replaceAll("<nombre>", "");
					linea = linea.trim().replaceAll("</nombre>", "");
					alumnos.setNombre(linea); // añades a la variable de dentro del objeto
					}
				if(newRow && linea.trim().contains("<apellidos>")) {
					linea = linea.trim().replaceAll("<apellidos>", "");
					linea = linea.trim().replaceAll("</apellidos>", "");
					alumnos.setApellidos(linea); // añades a la variable de dentro del objeto
					}
				if(newRow && linea.trim().contains("<email>")) {
					linea = linea.trim().replaceAll("<email>", "");
					linea = linea.trim().replaceAll("</email>", "");
					alumnos.setEmail(linea); // añades a la variable de dentro del objeto
					}
				if(newRow && linea.trim().contains("<ciudad>")) {
					linea = linea.trim().replaceAll("<ciudad>", "");
					linea = linea.trim().replaceAll("</ciudad>", "");
					alumnos.setCiudad(linea); // añades a la variable de dentro del objeto
					}
				if(newRow && linea.trim().contains("</alumno>")) {
					lista.add(alumnos); // añades el objeto a la lista
					newRow = false; 
					}
			}
	        //recorres la lista y me sacas (en este caso el nombre)
	        
	        for(int i= 0; i<lista.size(); i++) {   
	        System.out.println(lista.get(i).allString());
	        }
			
	        br.close();
		
		} catch (IOException e) {
			System.out.println("No he podido leer del fichero");
			System.out.println("El error es:" + e.getMessage());
		}
		finally {
			
		}
	}

}
