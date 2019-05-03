package com.everis.ejercicio1;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

public class App 
{	
    public static void main( String[] args )
    {
    	Clase clase = obtenerClase();
    	try 
    	{
    		System.out.println("--------------------------------------NOMBRE Y APELLIDOS--------------------------------------");
    		Ejercicio2 ejercicio2= new Ejercicio2(clase.getListaAlumnos());
    		ejercicio2.print();
    		System.out.println("----------------------------------------------S----------------------------------------------");
    		Ejercicio3 ejercicio3= new Ejercicio3(clase.getListaAlumnos());
    		ejercicio3.print();
        }
    	catch (Exception e) 
    	{
        	System.out.println("Ha ocurrido un error mostrando la lista ordenada: "+ e.getMessage());
        }
    		
    }
    
    private static Clase obtenerClase() 
    {
    	Clase clase = new Clase();
		try 
		{
			File fichero = new File("C:\\Users\\Administrador\\Desktop\\Nuevacarpeta\\BecaJava_2019\\EJERCICIOS\\alumnos.xml");
			//File fichero = new File(site);
			Reader reader = new InputStreamReader(new FileInputStream(fichero), "ISO-8859-1");
			XStream xstream = new XStream(new StaxDriver());
			xstream.addPermission(NoTypePermission.NONE);
			xstream.addPermission(NullPermission.NULL);
			xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
			xstream.allowTypeHierarchy(Collection.class);
			xstream.allowTypesByWildcard(new String[] { "com.everis.ejercicio1.*" });
			xstream.ignoreUnknownElements();
			xstream.processAnnotations(Clase.class);
			clase = (Clase) xstream.fromXML(reader);
			xstream = null;
			reader.close();
		} 
		catch (Exception e) 
		{
			System.out.println("Error: " + e.toString());
		}
		return clase;
	}
}
