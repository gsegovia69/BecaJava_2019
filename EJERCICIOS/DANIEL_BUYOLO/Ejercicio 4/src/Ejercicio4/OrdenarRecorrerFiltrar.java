package Ejercicio4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;



public class OrdenarRecorrerFiltrar {

	public static List listaProf (String fileName) throws FileNotFoundException, IOException {
		List<Profesor> listaProfesor = new ArrayList<Profesor>();
		
		final String nomFich = fileName;
		boolean nuevaFila = false;
		boolean prof = false;
		String cadena;
        FileReader f = new FileReader(nomFich);
        BufferedReader b = new BufferedReader(f);
        Profesor profe = null;
        
        while((cadena = b.readLine())!=null) {
            //System.out.println(cadena);
	        	if (cadena.trim().equalsIgnoreCase(Constantes.ETIQUETA_APERTURA_PROFESOR)){
	    			profe = new Profesor();
	    			nuevaFila = true;
	    			prof = true;
	    		}
        		
        		if (nuevaFila && cadena.trim().contains(Constantes.ETIQUETA_APERTURA_NOMBRE)) {
        			if(prof) { profe.setNombre(cadena);}
          		}
        		if (nuevaFila && cadena.trim().contains(Constantes.ETIQUETA_APERTURA_APELLIDOS)) {
        			if(prof) { profe.setApellido(cadena);}
        		}
        		if (nuevaFila && cadena.trim().contains(Constantes.ETIQUETA_APERTURA_EMAIL)) {
        			if(prof) {profe.setCorreo(cadena);}
        		}
        		if (nuevaFila && cadena.trim().contains(Constantes.ETIQUETA_APERTURA_CIUDAD)) {
        			if(prof) { profe.setCiudad(cadena);}
        		}
        		if (nuevaFila && cadena.trim().equalsIgnoreCase(Constantes.ETIQUETA_CIERRE_PROFESOR)) {
        			listaProfesor.add(profe);
        			prof = false;
        			nuevaFila = false;
        		}
        }
        //listaProfesor.forEach(System.out::println);
        b.close();
     
        return listaProfesor;
		
	}
	
	public static List listaAlumno (String fileName) throws FileNotFoundException, IOException {
		List<Alumno> listaAlumno = new ArrayList<Alumno>();
		
		final String nomFich = fileName;
		boolean nuevaFila = false;
		boolean alum = false;
		String cadena;
        FileReader f = new FileReader(nomFich);
        BufferedReader b = new BufferedReader(f);
        Alumno al = null;
        
        while((cadena = b.readLine())!=null) {
            //System.out.println(cadena);
        		if (cadena.trim().equalsIgnoreCase(Constantes.ETIQUETA_APERTURA_ALUMNO)) {
        			al = new Alumno();
        			nuevaFila = true;
        			alum = true;
        		}
        		
        		if (nuevaFila && cadena.trim().contains(Constantes.ETIQUETA_APERTURA_NOMBRE)) {
        			if(alum) { al.setNombre(cadena);}
          		}
        		if (nuevaFila && cadena.trim().contains(Constantes.ETIQUETA_APERTURA_APELLIDOS)) {
        			if(alum) { al.setApellido(cadena);}
        		}
        		if (nuevaFila && cadena.trim().contains(Constantes.ETIQUETA_APERTURA_EMAIL)) {
        			if(alum) {al.setCorreo(cadena);}
        		}
        		if (nuevaFila && cadena.trim().contains(Constantes.ETIQUETA_APERTURA_CIUDAD)) {
        			if(alum) { al.setCiudad(cadena);}
        		}
        		if (nuevaFila && cadena.trim().equalsIgnoreCase(Constantes.ETIQUETA_CIERRE_ALUMNO)) {
        			listaAlumno.add(al);
        			alum = false;
        			nuevaFila = false;
        		}
        }
        //listaAlumno.forEach(System.out::println);
        b.close();
     
        return listaAlumno;
		
	}
	/*
		public static List listaAlumnoProf (String fileName) throws FileNotFoundException, IOException {
		List<Alumno> listaAlumno = new ArrayList<Alumno>();
		List<Profesor> listaProfesor = new ArrayList<Profesor>();
		List<Alumno> lista = new ArrayList<>();
		
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
        //listaAlumno.forEach(System.out::println);
        //listaProfesor.forEach(System.out::println);
        b.close();
     
        return lista;
		
	}*/
	
	public static void main(String[] args) throws IOException {
		
		List<Alumno> listaAlumno = new ArrayList<Alumno>();
		List<Profesor> listaProfesor = new ArrayList<Profesor>();
		
		listaAlumno = listaAlumno (Constantes.PATH_FICHERO);
		listaProfesor = listaProf(Constantes.PATH_FICHERO);
		
		/*
		 * 1. Ordenar por Apellido y pintar el resultado
		 * 2. Ordenar por Ciudad y pintar el resultado
		 * 3. Recorrer con stream y pintar el resultado
		 * 4. Rcorrer con for tradicionadl y pintar el resultado
		 * 5. Filtrar por nombre ("Alejandro") y pintar el resultado
		 * 6. Filtrar cuyo nombre empieza por "A" o por "S" y pintar el resultado
		 * 7. Filtrar cuyo nombre contenga una "a" y pintar el resultado
		 * 8. Crear objetos Alumno y profesor y rellenar una lista con los profesores y otra lista con los alumnos
		 * y pintar el resultado.
		 * */
		 
		
		 //  1. Ordenar por Apellido y pintar el resultado
		System.out.println("---------------------------------------");
		System.out.println("Ejercicio 1");
		System.out.println("---------------------------------------");
		
		listaAlumno.stream().sorted(Comparator.comparing(Alumno::getApellido)).forEach(System.out::println);
		

		// 2. Ordenar por Ciudad y pintar el resultado
		System.out.println("---------------------------------------");
		System.out.println("Ejercicio 2");
		System.out.println("---------------------------------------");
		
		listaAlumno.stream().sorted(Comparator.comparing(Alumno::getCiudad)).forEach(System.out::println);
		
		// 3. Recorrer con stream y pintar el resultado
		System.out.println("---------------------------------------");
		System.out.println("Ejercicio 3");
		System.out.println("---------------------------------------");
		
		listaAlumno.stream().forEach(System.out::println);
		
		// 4. Recorrer con for tradicionadl y pintar el resultado
		
		System.out.println("---------------------------------------");
		System.out.println("Ejercicio 4");
		System.out.println("---------------------------------------");
		
		for (int i = 0; i < listaAlumno.size(); i++) {
			System.out.println(listaAlumno.get(i));
		}
		
		// 5. Filtrar por nombre ("Alejandro") y pintar el resultado
		
		System.out.println("---------------------------------------");
		System.out.println("Ejercicio 5");
		System.out.println("---------------------------------------");
		
		System.out.println("Ejercicio 5.1 (stream)");
		listaAlumno.stream().filter(list -> list.getNombre().equalsIgnoreCase("Alejandro")).forEach(System.out::println);
		System.out.println("---------------------------------------");
		System.out.println("Ejercicio 5.2 (for)");
		for(Alumno alumno : listaAlumno) {
			if(alumno.getNombre().equalsIgnoreCase("alejandro")){
				System.out.println(alumno.toString());
			}
		}
		
		// 6. Filtrar cuyo nombre empieza por "A" o por "S" y pintar el resultado
		System.out.println("---------------------------------------");
		System.out.println("Ejercicio 6");
		System.out.println("---------------------------------------");
		
		listaAlumno.stream().
		filter(list -> list.getNombre().toUpperCase().startsWith("A") || list.getNombre().toUpperCase().startsWith("S"))
		.forEach(System.out::println);
		
		// 7. Filtrar cuyo nombre contenga una "a" y pintar el resultado
		System.out.println("---------------------------------------");
		System.out.println("Ejercicio 7");
		System.out.println("---------------------------------------");
		
		listaAlumno.stream().filter(list -> list.getNombre().toUpperCase().contains("A"))
		.forEach(System.out::println);
		
		// 8. Crear objetos Alumno y profesor y rellenar una lista con los profesores y otra lista con los alumnos
		// y pintar el resultado.
		System.out.println("---------------------------------------");
		System.out.println("Ejercicio 8");
		System.out.println("---------------------------------------");
		
		System.out.println("Lista Profesor:");
		System.out.println("---------------------------------------");
		listaProfesor.forEach(System.out::println);
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------");
		System.out.println("Lista Alumnos:");
		System.out.println("---------------------------------------");
		listaAlumno.forEach(System.out::println);
	}
}
