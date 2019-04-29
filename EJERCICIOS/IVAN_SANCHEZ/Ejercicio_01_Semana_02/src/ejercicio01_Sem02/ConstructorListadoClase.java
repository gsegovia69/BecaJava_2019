package ejercicio01_Sem02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;



public class ConstructorListadoClase {
	public static void main(String[] args) {

		 String ruta = ("C:\\Users\\Administrador\\Desktop\\Beca_ISR\\BecaJava_2019\\EJERCICIOS\\alumnos.xml");
		 listaAlumnos(ruta);
		 listaProfesor(ruta);
		

			
		}
			public static void listaProfesor(String fileName) {
			FileReader leer = null;
			BufferedReader temp = null;
			try {
				leer = new FileReader(fileName);
				temp = new BufferedReader(leer);
				String linea = "";
				boolean newRow = false;
				List<Profesor> lista = new ArrayList<Profesor>();
				Profesor p = null;
				while ((linea = temp.readLine()) != null) {
					if(linea.trim().equalsIgnoreCase(ListaConstantes.ETIQUETA_APERTURA_PROFESOR)) {
						p = new Profesor();
						newRow = true;
					}
					if(newRow && linea.trim().contains(ListaConstantes.ETIQUETA_APERTURA_NOMBRE)) {
						p.setNombre(linea);
					}
					if(newRow && linea.trim().contains(ListaConstantes.ETIQUETA_APERTURA_APELLIDO)) {
						p.setApellidos(linea);
					}
					if(newRow && linea.trim().contains(ListaConstantes.ETIQUETA_APERTURA_EMAIL)) {
						p.seteMail(linea);
					}
					if(newRow && linea.trim().contains(ListaConstantes.ETIQUETA_APERTURA_CIUDAD)) {
						p.setCiudad(linea);
					}
					if(newRow && linea.trim().contains(ListaConstantes.ETIQUETA_CIERRE_PROFESOR)) {
						lista.add(p);
						newRow = false;
					}
				}
				
				//lista.forEach(System.out::println);
				lista.forEach(System.out::println);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}

			
			
		/*	public static String ImprimirTexto(Alumno alu) {
				String texto=null;
				
				texto = "Nombre: " + alu.getNombre();
				
				return texto;
			}*/
			
			public static void listaAlumnos(String fileName) {
				FileReader leer = null;
				BufferedReader temp = null;
				try {
					leer = new FileReader(fileName);
					temp = new BufferedReader(leer);
					String linea = "";
					boolean newRow = false;
					List<Alumno> lista = new ArrayList<Alumno>();
					Alumno al = null;
					
					while ((linea = temp.readLine()) != null) {						
						if(linea.trim().equalsIgnoreCase(ListaConstantes.ETIQUETA_APERTURA_ALUMNO)) {
							al = new Alumno();
							newRow = true;
						}
						if(newRow && linea.trim().contains(ListaConstantes.ETIQUETA_APERTURA_NOMBRE)) {
							al.setNombre(linea);
						}
						if(newRow && linea.trim().contains(ListaConstantes.ETIQUETA_APERTURA_APELLIDO)) {
							al.setApellidos(linea);
						}
						if(newRow && linea.trim().contains(ListaConstantes.ETIQUETA_APERTURA_EMAIL)) {
							al.seteMail(linea);
						}
						if(newRow && linea.trim().contains(ListaConstantes.ETIQUETA_APERTURA_CIUDAD)) {
							al.setCiudad(linea);
						}
						if(newRow && linea.trim().equalsIgnoreCase(ListaConstantes.ETIQUETA_CIERRE_ALUMNO)) {
							lista.add(al);
							newRow = false;
						}
						
					}
						
					System.out.println("-----------------------------------------Con metodo For---------------------------------------------");
					for (int i = 0; i < lista.size(); i++) {
						lista.get(i).limpiarCadena();
					}
												
					System.out.println("-----------------------------------------Filtrado por Alejandro---------------------------------------------");
					lista.stream().filter(a -> a.getNombre().trim().equalsIgnoreCase("<nombre>alejandro</nombre>")).forEach(alu -> alu.limpiarCadena());
					//Que Contengan la letra "A".
					System.out.println("-----------------------------------------Contenga la letra 'A'---------------------------------------------");
					lista.stream().filter(a -> a.getNombre().trim().toUpperCase().contains("A")).forEach(alu -> alu.limpiarCadena());	
					System.out.println("-----------------------------------------Ordena por Apellidos---------------------------------------------");
					lista.stream().sorted(Comparator.comparing(Alumno::getApellidos)).collect(Collectors.toList()).forEach(alu -> alu.limpiarCadena());
					System.out.println("-----------------------------------------Contenga la letra 'A' || 'S'---------------------------------------------");
					/*for(Alumno a : lista) {
						System.out.println(a.getNombre().trim().substring(8, a.getNombre().trim().length() -9));
					}*/
					lista.stream().filter(a -> a.getNombre().trim().toUpperCase().startsWith("A",8) || a.getNombre().trim().toUpperCase().startsWith("S", 8)).forEach(alu -> alu.limpiarCadena());	
					System.out.println("-----------------------------------------Contenga la letra 'a'---------------------------------------------");
					lista.stream().filter(a -> a.getNombre().trim().substring(8, a.getNombre().length()-9).contains("a")).forEach(alu -> alu.limpiarCadena());
					System.out.println("-----------------------------------------Rellanar listas Alumno y Profesor---------------------------------------------");
					lista.forEach(alu -> alu.limpiarCadena());
				
				} catch (Exception e) {
					
				}
				
				
			}







}
