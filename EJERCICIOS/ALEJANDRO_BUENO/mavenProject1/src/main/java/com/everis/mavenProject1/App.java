package com.everis.mavenProject1;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;
import java.util.Comparator;
import com.everis.mavenProject1.dto.Alumno;
import com.everis.mavenProject1.dto.Clase;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try 
    	{
    		Clase clase = obtenerClase();
    		System.out.println(clase.getProfesor().toString());
    		System.out.println("--------------------------------------");
    		clase.getListaAlumnos().stream().sorted(Comparator.comparing(Alumno::getApellidos)).forEach(System.out::println); 
    		//Ordenar por ciudad y mostrar los de NO Alicante
    		System.out.println("------------");
    		clase.getListaAlumnos().stream().sorted(Comparator.comparing(Alumno::getCiudad)).filter(t->t.getCiudad().equalsIgnoreCase("Alicante")).forEach(System.out::println);
    		System.out.println("------------");
    		clase.getListaAlumnos().stream().filter(t->!t.getNombre().toUpperCase().startsWith("A")).forEach(System.out::println);
    		
    	}
    	catch (Exception e) 
    	{
    		System.out.println("Error: "+e.toString());
        }
    }

	private static Clase obtenerClase()
	{
		Clase clase = new Clase();
		try 
		{
			File fichero = new File("C:\\Users\\Administrador\\Desktop\\Nuevacarpeta\\BecaJava_2019\\EJERCICIOS\\alumnos.xml");
			Reader reader = new InputStreamReader(new FileInputStream(fichero), "ISO-8859-1");
            XStream xstream = new XStream(new StaxDriver());
            xstream.addPermission(NoTypePermission.NONE);
            xstream.addPermission(NullPermission.NULL);
            xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
            xstream.allowTypeHierarchy(Collection.class);
            xstream.allowTypesByWildcard(new String[] { "com.everis.mavenProject1.dto.*" });
            xstream.ignoreUnknownElements();
            xstream.processAnnotations(Clase.class);
            clase = (Clase)xstream.fromXML(reader);
            reader.close();
		}
		catch (Exception e)
		{
			System.out.println("Error: " +e.toString());
		}
		return clase;
	}
}