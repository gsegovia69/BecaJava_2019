/*package everis.beca.java.practicas.mavenPrueba.dto;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

public class LeerFichero {
	
	public static ClaseEveris leer() throws IOException  {
	File fishero = new File(
			"C:\\Users\\Administrador\\Documents\\GitHub\\BecaJavatortoise\\EJERCICIOS\\alumnos.xml");
	Reader reader = new InputStreamReader(new FileInputStream(fishero), "ISO-8859-1");
	XStream xstream = new XStream(new StaxDriver());
	xstream.addPermission(NoTypePermission.NONE);
	xstream.addPermission(NullPermission.NULL);
	xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
	xstream.allowTypeHierarchy(Collection.class);
	xstream.allowTypesByWildcard(new String[] { "everis.beca.java.practicas.mavenPrueba.dto.*" });
	xstream.ignoreUnknownElements();
	xstream.processAnnotations(ClaseEveris.class);
	ClaseEveris clase = (ClaseEveris) xstream.fromXML(reader);
	reader.close();
	return clase;
	
	}
}*/

