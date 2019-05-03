package com.everis.beca.java.mavenProject1;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;

import com.everis.beca.java.mavenProject1.dto.Clase;
import com.everis.beca.java.mavenProject1.dto.OrdenarAlumnosCiudadFecha;
import com.everis.beca.java.mavenProject1.dto.OrdenarAlumnosNombreFecha;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.mapper.CannotResolveClassException;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

public class Mostrar {

	private static Clase obtenerClase ( ) {
		
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

                 xstream = null;

                 reader.close();


          } catch (Exception e) {

                 System.out.println("Error: "+e.toString());

          }
		 
		return clase;
		 
	}
	
	public static void main(String[] args) {
		
		Clase clase = new Clase();
		
		OrdenarAlumnosNombreFecha ordenaAluNom = new OrdenarAlumnosNombreFecha();
		OrdenarAlumnosCiudadFecha ordenaAluCiu = new OrdenarAlumnosCiudadFecha();
		
    	
    	clase = obtenerClase();
    	
    	/* 1. clase con metodo main que lea el fichero xml "alumnos.xml"
    	 * 2. Clase que muestre por consola el listado de alumnos ordenados por apellido y nombre. Con la fecha antes de cada alumno.
    	 * Formato = Dia/mes/año Horas:Minutos:Segundos
    	 * 3. Clase que muestre por consola el listado de alumnos cuyo ciduad empiece por "a". Con la fecha antes de cada alumno.
    	 * Formato = Mes-Dia-Año Horas:Minutos:segundos
    	 * 4. java.io -> File - Read - Write
    	 * 
    	 */
    	
    	// 1. clase con metodo main que lea el fichero xml "alumnos.xml"
    			
		// 2. Clase que muestre por consola el listado de alumnos ordenados por apellido y nombre. Con la fecha antes de cada alumno.
   	 	// Formato = Dia/mes/año Horas:Minutos:Segundos
		
    	ordenaAluNom.mostrarListaAlumno(clase);
    			
    	// 3. Clase que muestre por consola el listado de alumnos cuyo ciduad empiece por "a". Con la fecha antes de cada alumno.
   	    //* Formato = Mes-Dia-Año Horas:Minutos:segundos
    	
    	ordenaAluCiu.mostrarListaAlumno(clase);
	}
}
