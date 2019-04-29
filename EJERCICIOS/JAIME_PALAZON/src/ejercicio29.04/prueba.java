package jaimepalazon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class prueba {
	
	
	
	
	public static void main(String[] arg) {
		try {
			FileReader fr = new FileReader("C:/Users/Administrador/Desktop/alumnos.xml");
			BufferedReader br = new BufferedReader(fr);
			
			List <Prueba5> listaAlumno = new ArrayList<Prueba5>(); // me haces una lista de la clase "Prueba5"
			List <Prueba5> listaProfesor = new ArrayList<Prueba5>();
			
			boolean newRow = false;//acabar para alumnos
			boolean newRow2 = false; //acabar para profesor
			String linea;
			
			Prueba5 alumnos = null; // creo un objeto de la clase "Prueba5"
			Prueba5 profesor = null; // creo un objeto de la clase "Prueba5"
			
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
					listaAlumno.add(alumnos); // añades el objeto a la lista
					newRow = false; 
				}
					
				if(linea.trim().contains("<profesor>")) {
						profesor = new Prueba5(); // abres objeto
						newRow2 = true;
					}
				if(newRow2 && linea.trim().contains("<nombre>")) {
					linea = linea.trim().replaceAll("<nombre>", "").replaceAll("</nombre>", "");
					profesor.setNombre(linea); // añades a la variable de dentro del objeto
					}
				if(newRow2 && linea.trim().contains("<apellidos>")) {
					linea = linea.trim().replaceAll("<apellidos>", "");
					linea = linea.trim().replaceAll("</apellidos>", "");
					profesor.setApellidos(linea); // añades a la variable de dentro del objeto
					}
				if(newRow2 && linea.trim().contains("<email>")) {
					linea = linea.trim().replaceAll("<email>", "");
					linea = linea.trim().replaceAll("</email>", "");
					profesor.setEmail(linea); // añades a la variable de dentro del objeto
					}
				if(newRow2 && linea.trim().contains("<ciudad>")) {
					linea = linea.trim().replaceAll("<ciudad>", "");
					linea = linea.trim().replaceAll("</ciudad>", "");
					profesor.setCiudad(linea); // añades a la variable de dentro del objeto
					}
				if(newRow2 && linea.trim().contains("</profesor>")) {
					listaProfesor.add(profesor); // añades el objeto a la lista
					newRow2 = false; 
				
			}
				}
	        System.out.println("1.//////////////////////////////// \n");
	        
	        listaProfesor.stream().forEach(System.out::println);
	        
	        System.out.println("\n2.//////////////////////////////// \n");
	        
	        listaAlumno.stream().forEach(System.out::println);
	        
            System.out.println("\n3.//////////////////////////////// \n");
	       
	        listaAlumno.stream().sorted(Comparator.comparing(Prueba5::getApellidos))
	                            .forEach(System.out::println);
	       
	        System.out.println("\n4.//////////////////////////////// \n");
	       
	        listaAlumno.stream().sorted(Comparator.comparing(Prueba5::getCiudad))
                                .forEach(System.out::println);
	      
	       System.out.println("\n5.//////////////////////////////// \n");
	      
	       listaAlumno.stream().forEach(System.out::println);
    
	       System.out.println("\n6.//////////////////////////////// \n");
	       
	       listaAlumno.stream().filter(x -> "Alejandro".equals(x.getNombre()))
	                     .forEach(System.out::println);
	       
	       System.out.println("\n7.//////////////////////////////// \n");
	       
	       listaAlumno.stream().filter(s -> s.getNombre().startsWith("A"))
	                     .forEach(System.out::println);
	       listaAlumno.stream().filter(s -> s.getNombre().startsWith("S"))
                         .forEach(System.out::println);
	       
	       System.out.println("\n8.////////////////////////////////");
	       
	       listaAlumno.stream().filter(s -> s.getNombre().startsWith("A") || s.getNombre().startsWith("S"))
           .forEach(System.out::println);
	       
	       System.out.println("\n9.//////////////////////////////// \n");
	       
	       listaAlumno.stream().filter(s -> s.getNombre().contains("a"))
           .forEach(System.out::println);
	       
	       System.out.println("\n//////////////////////////////// \n");
	       
	       
	       
	       //recorres la lista y me sacas (todo)
	        
	        /*for(int i= 0; i<lista.size(); i++) {   
	        System.out.println(lista.get(i).allString());
	        }*/
			
	        br.close();
		
		    } catch (IOException e) {
			System.out.println("No he podido leer del fichero");
			System.out.println("El error es:" + e.getMessage());
		}
		finally {
			
		}
	}
}

		


