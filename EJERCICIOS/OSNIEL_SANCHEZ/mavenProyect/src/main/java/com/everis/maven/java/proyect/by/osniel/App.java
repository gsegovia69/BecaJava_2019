package com.everis.maven.java.proyect.by.osniel;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;
import com.everis.maven.java.proyect.by.osniel.dto.Clase;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

public class App 
{
	
		
	public static void main( String[] args )

    {
		
		try {

			Clase  developClass= getDevelopClass();
			Develop develop = new Develop(developClass.getAlumnos());
			DevelopCiudad developciudad = new DevelopCiudad(developClass.getAlumnos());


            System.out.println("---Ordena por nombre----");

			develop.ordenaListNombre();
            System.out.println("---Ordena por apellidos----");

			develop.ordenaListApellidos();
			
            System.out.println("---Ciudad empieza por a----");
            developciudad.ordenaCiuad();
                          
		} catch (Exception e) {
            System.out.println(e.getMessage());
		}

    }
	private static Clase getDevelopClass() {
		
		Clase develop = new Clase();
		
		try {

            File fishero = new File("C:\\Users\\Administrador\\Desktop\\Git_java\\EJERCICIOS\\alumnos.xml");
            Reader reader = new InputStreamReader(new FileInputStream(fishero), "ISO-8859-1");
            XStream xstream = new XStream(new StaxDriver());
            xstream.addPermission(NoTypePermission.NONE);
            xstream.addPermission(NullPermission.NULL);
            xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
            xstream.allowTypeHierarchy(Collection.class);
            xstream.allowTypesByWildcard(new String[] {"com.everis.maven.java.proyect.by.osniel.dto.*"});
            xstream.ignoreUnknownElements();
            xstream.processAnnotations(Clase.class);
            develop = (Clase) xstream.fromXML(reader);
            reader.close();                   

            } catch (Exception e) {
                   System.out.println("Error: "+e.toString());
            }
		
		return develop;
		
	}
	
	
	
}

