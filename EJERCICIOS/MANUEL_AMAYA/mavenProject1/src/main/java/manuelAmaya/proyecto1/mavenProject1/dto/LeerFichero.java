package manuelAmaya.proyecto1.mavenProject1.dto;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;
import java.util.Comparator;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

public class LeerFichero {

	public static void main(String[] args) {
		//File ficherito = new File("C:\\Users\\Administrador\\Desktop\\BecaJava\\BecaJava_2019\\EJERCICIOS\\alumnos.xml");
		Clase clase = new Clase();
		try {
			File fishero = new File("C:\\Users\\Administrador\\Desktop\\BecaJava\\BecaJava_2019\\EJERCICIOS\\alumnos.xml");
			Reader reader = new InputStreamReader(new FileInputStream(fishero), "ISO-8859-1");
			XStream xstream = new XStream(new StaxDriver());
			
			xstream.addPermission(NoTypePermission.NONE);
            xstream.addPermission(NullPermission.NULL);
            xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
            xstream.allowTypeHierarchy(Collection.class);
            xstream.allowTypesByWildcard(new String[] { "manuelAmaya.proyecto1.mavenProject1.dto.*" });
            xstream.ignoreUnknownElements();
            xstream.processAnnotations(Clase.class);
            clase = (Clase) xstream.fromXML(reader);
            xstream = null;
            reader.close();
            
            VerAlumnos1 lista1 = new VerAlumnos1(clase);
            lista1.listarAlumnos();
            System.out.println("\n");
            VerAlumnos2 lista2 = new VerAlumnos2(clase);
            lista2.listarAlumnos();
		} catch(Exception e){
			System.out.println("Error: "+e.toString());
		}
	}
}
