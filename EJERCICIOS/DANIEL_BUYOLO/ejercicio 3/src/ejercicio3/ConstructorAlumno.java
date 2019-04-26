package ejercicio3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ConstructorAlumno {

	public static void listaAlumnoProf (String fileName) throws FileNotFoundException, IOException {
		List<Alumno> listaAlumno = new ArrayList<Alumno>();
		List<Profesor> listaProfesor = new ArrayList<Profesor>();
		final String nomFich = fileName;
		boolean nuevaFila = false;
		boolean alum = false;
		boolean prof = false;
		String cadena;
        FileReader f = new FileReader(nomFich);
        BufferedReader b = new BufferedReader(f);
        Profesor profe = null;
        Alumno al = null;
        
        while((cadena = b.readLine())!=null) {
            //System.out.println(cadena);
	        	if (cadena.trim().equalsIgnoreCase(Constantes.ETIQUETA_APERTURA_PROFESOR)){
	    			profe = new Profesor();
	    			nuevaFila = true;
	    			prof = true;
	    		}
        		if (cadena.trim().equalsIgnoreCase(Constantes.ETIQUETA_APERTURA_ALUMNO)) {
        			al = new Alumno();
        			nuevaFila = true;
        			alum = true;
        		}
        		
        		if (nuevaFila && cadena.trim().contains(Constantes.ETIQUETA_APERTURA_NOMBRE)) {
        			if(alum) { al.setNombre(cadena);}
        			if(prof) { profe.setNombre(cadena);}
          		}
        		if (nuevaFila && cadena.trim().contains(Constantes.ETIQUETA_APERTURA_APELLIDOS)) {
        			if(alum) { al.setApellido(cadena);}
        			if(prof) { profe.setApellido(cadena);}
        		}
        		if (nuevaFila && cadena.trim().contains(Constantes.ETIQUETA_APERTURA_EMAIL)) {
        			if(alum) {al.setCorreo(cadena);}
        			if(prof) {profe.setCorreo(cadena);}
        		}
        		if (nuevaFila && cadena.trim().contains(Constantes.ETIQUETA_APERTURA_CIUDAD)) {
        			if(alum) { al.setCiudad(cadena);}
        			if(prof) { profe.setCiudad(cadena);}
        		}
        		if (nuevaFila && cadena.trim().equalsIgnoreCase(Constantes.ETIQUETA_CIERRE_ALUMNO)) {
        			listaAlumno.add(al);
        			alum = false;
        			nuevaFila = false;
        		}
        		if (nuevaFila && cadena.trim().equalsIgnoreCase(Constantes.ETIQUETA_CIERRE_PROFESOR)) {
        			listaProfesor.add(profe);
        			prof = false;
        			nuevaFila = false;
        		}
        }
        listaAlumno.forEach(System.out::println);
        listaProfesor.forEach(System.out::println);
        b.close();
		
	}
	
	public static void main(String[] args) throws IOException {
		listaAlumnoProf (Constantes.PATH_FICHERO);
		
}
}