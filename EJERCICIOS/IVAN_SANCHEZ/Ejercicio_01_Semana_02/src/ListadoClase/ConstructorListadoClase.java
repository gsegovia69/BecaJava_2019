package ListadoClase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ConstructorListadoClase {

	public static void main(String[] args) {

	 String ruta = ("C:\\Users\\Administrador\\Desktop\\Beca_ISR\\BecaJava_2019\\EJERCICIOS\\alumnos.xml");

	 listaProfesor(ruta);
	 listaAlumnos(ruta);

		
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
			
			lista.forEach(System.out::println);

			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

		
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
				
				lista.forEach(alu -> alu.limpiarCadena());

				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}
}

