package Beca2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Beca2 
{
	public static void main(String arg[])
	{
		String texto;
		try
		{
			FileReader leer=new FileReader("C:\\Users\\Administrador\\Desktop\\Nuevacarpeta\\BecaJava_2019\\EJERCICIOS\\alumnos.xml");
			BufferedReader temp=new BufferedReader(leer);
			ArrayList<String> lista = new ArrayList<String>();
			int i=0;
			Map<Integer, String> mapa = new HashMap<Integer, String>();
			System.out.println("------------------------Archivo------------------------");
			while((texto=temp.readLine())!=null)
			{
				System.out.println(texto);
				lista.add(texto);
				mapa.put(i++, texto);
			}
			System.out.println("------------------------Lista------------------------");
			Iterator<String> it = lista.iterator();
			while (it.hasNext()) 
			{
				System.out.println(it.next());
			}
			System.out.println("------------------------Mapa------------------------");
			mapa.forEach((nu,tex) -> System.out.println("i=" + (nu +1) + "		" + tex));
			System.out.println("------------------------Filtrado------------------------");
			String ruta = "C:\\Users\\Administrador\\Desktop\\Nuevacarpeta\\BecaJava_2019\\EJERCICIOS\\alumnos.xml";
			listaAlumno(ruta);
			listaStream(ruta);
			temp.close();
		}
		catch(Exception e)
		{
			System.out.println("Error al leer el archivo");
		}
	}

	public static void listaAlumno(String fileName) 
	{
		BufferedReader temp = null;
		try 
		{
			FileReader leer = new FileReader(fileName);
			temp = new BufferedReader(leer);
			String linea = "";
			boolean ca = false;
			List<Alumno> lista = new ArrayList<Alumno>();
			Alumno alum = null;
			while ((linea = temp.readLine()) != null) 
			{
				if (linea.trim().equalsIgnoreCase(Constantes.INICIO_ITERACION_ALUMNO)) 
				{
					alum = new Alumno();
					ca = true;
				}
				if (ca && linea.trim().contains(Constantes.INICIO_ITERACION_NOMBRE)) 
				{
					alum.setNombre(linea.substring(linea.indexOf(">") + 1, linea.indexOf("</")));
				}
				if (ca && linea.trim().contains(Constantes.INICIO_ITERACION_APELLIDOS)) 
				{
					alum.setApellido(linea.substring(linea.indexOf(">") + 1, linea.indexOf("</")));
				}
				if (ca && linea.trim().contains(Constantes.FIN_ITERACION_ALUMNO)) 
				{
					lista.add(alum);
					ca = false;
				}
			}
			lista.forEach(System.out::println);
		}
		catch (Exception e) 
		{
		} 
		finally 
		{
			if (temp != null) 
			{
				try 
				{
					temp.close();
				} 
				catch (IOException e) 
				{
				}
			}
		}
	}
	
	public static void listaStream(String fileName) 
	{
		BufferedReader temp = null;
		try 
		{
			FileReader leer = new FileReader(fileName);
			temp = new BufferedReader(leer);
			String linea = "";
			boolean ca = false , cp = false;
			List<Alumno> lista = new ArrayList<Alumno>();
			List<Profesor> lista2 = new ArrayList<Profesor>();
			Alumno alum = null;
			Profesor prof = null;
			while ((linea = temp.readLine()) != null) 
			{
				if (linea.trim().equalsIgnoreCase(Constantes.INICIO_ITERACION_ALUMNO)) 
				{
					alum = new Alumno();
					ca = true;
				}
				if (ca && linea.trim().contains(Constantes.INICIO_ITERACION_NOMBRE)) 
				{
					alum.setNombre(linea.substring(linea.indexOf(">") + 1, linea.indexOf("</")));
				}
				if (ca && linea.trim().contains(Constantes.INICIO_ITERACION_APELLIDOS)) 
				{
					alum.setApellido(linea.substring(linea.indexOf(">") + 1, linea.indexOf("</")));
				}
				if (ca && linea.trim().contains(Constantes.INICIO_ITERACION_EMAIL)) 
				{
					alum.setEmail(linea.substring(linea.indexOf(">") + 1, linea.indexOf("</")));
				}
				if (ca && linea.trim().contains(Constantes.INICIO_ITERACION_CIUDAD)) 
				{
					alum.setCiudad(linea.substring(linea.indexOf(">") + 1, linea.indexOf("</")));
				}
				if (ca && linea.trim().contains(Constantes.FIN_ITERACION_ALUMNO)) 
				{
					lista.add(alum);
					ca = false;
				}
				if (linea.trim().equalsIgnoreCase(Constantes.INICIO_ITERACION_PROFESOR)) 
				{
					prof = new Profesor();
					cp = true;
				}
				if (cp && linea.trim().contains(Constantes.INICIO_ITERACION_NOMBRE)) 
				{
					prof.setNombre(linea.substring(linea.indexOf(">") + 1, linea.indexOf("</")));
				}
				if (cp && linea.trim().contains(Constantes.INICIO_ITERACION_APELLIDOS)) 
				{
					prof.setApellido(linea.substring(linea.indexOf(">") + 1, linea.indexOf("</")));
				}
				if (cp && linea.trim().contains(Constantes.INICIO_ITERACION_EMAIL)) 
				{
					prof.setEmail(linea.substring(linea.indexOf(">") + 1, linea.indexOf("</")));
				}
				if (cp && linea.trim().contains(Constantes.INICIO_ITERACION_CIUDAD)) 
				{
					prof.setCiudad(linea.substring(linea.indexOf(">") + 1, linea.indexOf("</")));
				}
				if (cp && linea.trim().contains(Constantes.FIN_ITERACION_PROFESOR)) 
				{
					lista2.add(prof);
					cp = false;
				}
			}
			System.out.println("------------------------Stream------------------------");
			lista.stream().forEach((p)->
			{
				System.out.println("Nombre: " + p.getNombre() + ", Apellidos: " + p.getApellido() + ", Email:  " + p.getEmail() + ", Ciudad: " + p.getCiudad());
			});
			System.out.println("------------------------Apellido------------------------");
			lista.stream().sorted(Comparator.comparing(Alumno::getApellido)).forEach(System.out::println);
			System.out.println("------------------------Ciudad------------------------");
			lista.stream().sorted(Comparator.comparing(Alumno::getCiudad)).forEach(System.out::println);
			System.out.println("------------------------For------------------------");
			for (int i = 0; i < lista.size(); i++) 
			{
				System.out.println("i: " + i + " " + lista.get(i));
			}
			System.out.println("------------------------Alejandro------------------------");
			lista.stream().filter(p -> p.getNombre().equalsIgnoreCase("Alejandro")).forEach(System.out::println);
			System.out.println("------------------------Comience A y S------------------------");
			lista.stream().filter(p -> p.getNombre().toUpperCase().startsWith("A") || p.getNombre().toUpperCase().startsWith("S")).forEach(System.out::println);
			System.out.println("------------------------Contenga A------------------------");
			lista.stream().filter(list -> list.getNombre().toUpperCase().contains("A")).forEach(System.out::println);
			System.out.println("------------------------Lista profesor y Alumnos------------------------");
			System.out.println("---------------------------------------------------------PROFESOR----------------------------------------------------------");
			lista2.stream().forEach((p)->
			{
				System.out.println("Nombre: " + p.getNombre() +" " + p.getApellido() + ", Email:  " + p.getEmail() + ", Ciudad: " + p.getCiudad());
			});
			System.out.println("----------------------------------------------------------ALUMNOS----------------------------------------------------------");
			lista.stream().forEach((p)->
			{
				System.out.println("Nombre: " + p.getNombre() + " " + p.getApellido() + ", Email:  " + p.getEmail() + ", Ciudad: " + p.getCiudad());
			});
			
		}
		catch (Exception e) 
		{
		} 
		finally 
		{
			if (temp != null) 
			{
				try 
				{
					temp.close();
				} 
				catch (IOException e) 
				{
				}
			}
		}
	}
	
}