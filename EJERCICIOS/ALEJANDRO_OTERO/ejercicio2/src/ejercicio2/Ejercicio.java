package ejercicio2;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;


import com.everis.beca.ejercicios.dto.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

public class Ejercicio 
{
	public static final String RUTA = "C:\\BecaJava\\BecaJava_2019/EJERCICIOS/alumnos.xml";
	
    public static void main( String[] args )
    {
       	Clase clase = obtenerClase(RUTA);
    	try {
    	System.out.println("\n------Mostrar lista ordenada por apellido y nombre-----\n");

    	ApellidoNombre apellidoNombre= new ApellidoNombre(clase.getListaAlumnos());
		apellidoNombre.mostrar();
    	}catch (Exception e) {
    		System.out.println("Ha ocurrido un error mostrando la lista ordenada: "+ e.getMessage());
    	}
	
    	try {
    	System.out.println("\n------Mostrar lista ordenada cuya ciudad empiece por a-----\n");
    	CiudadA ciudadA= new CiudadA(clase.getListaAlumnos());
    	ciudadA.mostrar();
    	}
   	 	catch (Exception e) {
   	 	System.out.println("Ha ocurrido un error mostrando la lista ordenada y filtrada por ciudad: "+ e.getMessage());
   	 	}

    }
    
    private static Clase obtenerClase(String ruta) {
		Clase clase = null;
		try {
			File fichero = new File(ruta);
			Reader reader = new InputStreamReader(new FileInputStream(fichero), "ISO-8859-1");
			XStream xstream = new XStream(new StaxDriver());
			xstream.addPermission(NoTypePermission.NONE);
			xstream.addPermission(NullPermission.NULL);
			xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
			xstream.allowTypeHierarchy(Collection.class);
			xstream.allowTypesByWildcard(new String[] { "com.everis.beca.ejercicios.dto.*" });
			xstream.ignoreUnknownElements();
			xstream.processAnnotations(Clase.class);
			clase = (Clase) xstream.fromXML(reader);
			xstream = null;
			reader.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.toString());
		}
		return clase;
	}

}



