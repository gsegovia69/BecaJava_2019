package com.everis.jaime.mavenJaime2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;
import java.util.Comparator;


import com.everis.jaime.mavenJaime2.dto.ClaseProfesorAlumnos2;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;
import com.everis.jaime.mavenJaime2.dto.Alumno2;


public class ListadoAlumnosA {
	
	
public void obtenerClase2() throws IOException  { 
		
		File fishero = new File("C:\\Users\\Administrador\\Documents\\GitHub\\BecaJava_2019\\EJERCICIOS\\alumnos.xml");
        Reader reader = new InputStreamReader(new FileInputStream(fishero), "ISO-8859-1");
        XStream xstream = new XStream(new StaxDriver());
 
               xstream.addPermission(NoTypePermission.NONE);
               xstream.addPermission(NullPermission.NULL);
               xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
               xstream.allowTypeHierarchy(Collection.class);
               xstream.allowTypesByWildcard(new String[] { "com.everis.jaime.mavenJaime2.dto.*" });
               xstream.ignoreUnknownElements();
               xstream.processAnnotations(ClaseProfesorAlumnos2.class);
               ClaseProfesorAlumnos2 clase2 = (ClaseProfesorAlumnos2) xstream.fromXML(reader);             
               xstream = null;
               reader.close();
               
               
               
               
                            
               
               clase2.getListaAlumnos().stream().sorted(Comparator.comparing(Alumno2::getApellidos).thenComparing(Alumno2::getNombre))
                                                 .forEach(a -> {System.out.println ( Fecha.getFecha() + " " + a.toString());});
            		                            
}

}
