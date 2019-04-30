package com.everis.beca.java.mavenProject1;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;
import java.util.Comparator;

import com.everis.beca.java.mavenProject1.dto.Alumno;
import com.everis.beca.java.mavenProject1.dto.Clase;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.mapper.CannotResolveClassException;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.collections4.CollectionUtils;

public class App 
{
	
	public static Clase obtenerClase ( ) {
		
		 Clase clase = new Clase(); 
		
		try {
			 
			 File fishero = new File("C:\\Users\\Administrador\\Desktop\\Prueba Git\\BecaJava_2019\\EJERCICIOS\\alumnos.xml");

             Reader reader = new InputStreamReader(new FileInputStream(fishero), "ISO-8859-1");

             XStream xstream = new XStream(new StaxDriver()) {

                           protected MapperWrapper wrapMapper(MapperWrapper next) {

                                  return new MapperWrapper(next) {

                                        public boolean shouldSerializeMember(Class definedIn, String fieldName) {

                                               try {

                                                      return definedIn != Object.class || realClass(fieldName) != null;

                                               } catch (CannotResolveClassException cnrce) {

                                                      return false;

                                               }

                                        }

                                  };

                           }

                    };

                    xstream.addPermission(NoTypePermission.NONE);

                    xstream.addPermission(NullPermission.NULL);

                    xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);

                    xstream.allowTypeHierarchy(Collection.class);

                    xstream.allowTypesByWildcard(new String[] { "com.everis.beca.java.mavenProject1.dto.*" });

                    xstream.ignoreUnknownElements();

                    xstream.processAnnotations(Clase.class);

                    clase = (Clase) xstream.fromXML(reader);
                    //clase.getListaAlumno().stream().forEach(System.out::println);

                    xstream = null;

                    reader.close();


             } catch (Exception e) {

                    System.out.println("Error: "+e.toString());

             }
		 
		return clase;
		 
	}
	
    public static void main( String[] args )
    {
    	Clase clase = new Clase();
    	
    	clase = obtenerClase();
    	
    	//clase.getListaAlumno().stream().forEach(System.out::println);
    	
    	//ORDENAR POR CIUDAD Y MOSTRAR SOLO LOS QUE NO SEAN DE ALICANTE.
    	System.out.println("---------------------------------------");
		System.out.println("Ejercicio 1");
		System.out.println("---------------------------------------");
    	clase.getListaAlumno().stream().sorted(Comparator.comparing(Alumno::getCiudades)).filter(alum -> !alum.getCiudades().equalsIgnoreCase("Alicante"))
    	.forEach(System.out::println);
    	
    	//MOSTRAR ÚNICAMENTE AQUELLOS ALUMNOS CUYO NOMBRE NO EMPIECE POR "A"
    	System.out.println("---------------------------------------");
		System.out.println("Ejercicio 2");
		System.out.println("---------------------------------------");
    	clase.getListaAlumno().stream().filter(alum -> !alum.getNombre().toUpperCase().startsWith("A")).forEach(System.out::println);;
    	
    }
}
