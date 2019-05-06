package com.everis.maven.java.proyect.by.osniel;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.everis.maven.java.proyect.by.osniel.conection.ConnectionBD;
import com.everis.maven.java.proyect.by.osniel.dto.Alumno;
import com.everis.maven.java.proyect.by.osniel.dto.Clase;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

public class App {
	public static void main( String[] args ){
		try {
			Alumno alumno = null;
			List<Alumno> alumnos = new ArrayList<Alumno>();
			//String query = "INSERT INTO alumno (nombre,apellidos,email,ciudad) VALUES ('Osniel','Sanchez Planes','osanchezplanes@yahoo.es','Alicante')";
			String queryExecute = "select alumno.nombre,alumno.apellidos,alumno.email,alumno.ciudad,alumno.id_clase from alumno ";
			ConnectionBD connectionBD = new ConnectionBD();
			Connection connection = connectionBD.getConnection();
			Statement st = connection.createStatement();
			//ResultSet rs = st.executeQuery(query);
			//st.executeUpdate(query);
			ResultSet resultSet = st.executeQuery(queryExecute);
			while(resultSet.next()) {
				alumno = new Alumno(resultSet.getString("nombre"),resultSet.getString("apellidos")
						, resultSet.getString("email"), resultSet.getString("ciudad"),resultSet.getString("id_clase"));
				alumnos.add(alumno);
			}
			st.close();
			Develop develop = new Develop(alumnos);
			develop.ordenaListApellidos();
            System.out.println("---yes----");

			/*Clase  developClass= readFileXML();
			Develop develop = new Develop(developClass.getAlumnos());
			DevelopCiudad developciudad = new DevelopCiudad(developClass.getAlumnos());
            System.out.println("---Ordena por nombre----");
			//develop.ordenaListNombre();
            System.out.println(String.format("---Ordena por apellidos----"));
			develop.ordenaListApellidos(developClass);
            System.out.println("---Ciudad empieza por a----");
            System.out.println(String.format("%s %25s %40s %40s","Hora", "Nombre", "Email", "Ciudad"));
            developciudad.ordenaCiuad(developClass);*/
		} catch (Exception e) {
            System.out.println(e.getMessage());
		}
    }
	private static Clase readFileXML() {
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

