package manuelAmaya.proyecto1.mavenProject1;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.Comparator;

import org.apache.commons.collections4.CollectionUtils;

//import com.everis.java.formacion.mavenProject1.dto.Clase;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

import manuelAmaya.proyecto1.mavenProject1.dto.Alumno;
import manuelAmaya.proyecto1.mavenProject1.dto.Clase;
import manuelAmaya.proyecto1.mavenProject1.dto.Conectar;

/**
 * Hello world!
 *
 */
public class App 
{
	private static Clase obtenerClase() {
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
		} catch(Exception e){
			System.out.println("Error: "+e.toString());
		}
		return clase;
	}
	
    public static void main( String[] args )
    {
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	/*try{
     		Conectar connectionDatabase = new Conectar();
     		Connection conn = connectionDatabase.getConnection();
     		Statement st = conn.createStatement();
     		//String queryInsert = "insert into alumno (nombre, apellidos, email, ciudad, id_clase) values('Manuel Alejandro', 'Amaya Alcaraz', 'alejandro_amayaa@hotmail.com', 'Busot', 1)";
     		//st.executeUpdate(queryInsert);
     		ResultSet rs = null;
     		String querySelect = "Select * from alumno";
     		st = conn.createStatement();
     		rs = st.executeQuery(querySelect);
     		while(rs.next()){
     			String id = rs.getString(1);
     			String nombre = rs.getString(2);
     			String email = rs.getString(3);
     			String ciudad = rs.getString(4);
     			System.out.println(id + " " + nombre + " " + email + " " + ciudad);
     		}
     		st.close();
     		rs.close();
     		conn.close();
     	} catch(Exception e){
     		System.out.println(e.toString());
     	}
    	
    	try {
           Clase clase = obtenerClase();
           /*System.out.println(clase.getProfesor().toString());
           System.out.println("--------------------------------------------------------------------------------------------------------------------------");
           clase.getListaAlumnos().stream().sorted(Comparator.comparing(Alumno::getNombre)).forEach(System.out::println);
           
           System.out.println("\nORDENAR POR CIUDAD Y MOSTRAR SOLO LOS QUE NO SEAN DE ALICANTE:");
           
           clase.getListaAlumnos().stream()
           .filter(ciu -> !ciu.getCiudades().equalsIgnoreCase("ALICANTE"))
           .sorted(Comparator.comparing(Alumno::getCiudades))
           .forEach(System.out::println);
           
           System.out.println("\nMOSTRAR ÙNICAMENTE AQUELLOS ALUMNOS CUYO NOMBRE NO EMPIECE POR 'A':");
           
           clase.getListaAlumnos().stream()
           .filter(alu -> !alu.getNombre().toUpperCase().startsWith("A"))
           .sorted(Comparator.comparing(Alumno::getNombre))
           .forEach(System.out::println);
           
           //Añadir - importar dependencia de apache commons (apache commons lang y apache commons collection)
           
           /*CollectionUtils.filter(clase.getListaAlumnos(), x -> !x.getCiudades().toUpperCase().startsWith("A"));
           clase.getListaAlumnos().forEach(System.out::println);
           
        } catch (Exception e) {
            System.out.println("Error: "+e.toString());
        }*/
    }
}
