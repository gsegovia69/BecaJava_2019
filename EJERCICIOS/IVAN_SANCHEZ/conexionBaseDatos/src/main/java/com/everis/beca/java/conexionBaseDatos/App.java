package com.everis.beca.java.conexionBaseDatos;

<<<<<<< HEAD
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
	public static void main(String[] args) {
		try {
			GetConection connectionDatabase = new GetConection();
			Connection conn = connectionDatabase.getConnection();
			Statement st = conn.createStatement();
//		String queryInsert = "insert into alumno (nombre, apellidos, email, ciudad, id_clase) values ('Iván', 'Sánchez Rico','isrmail87@gmail.com','Elda', 1)";
//		st.executeUpdate(queryInsert);
			ResultSet rs = null;
			String querySelect = "Select * from alumno";
			st = conn.createStatement();
			rs = st.executeQuery(querySelect);
			System.out.println("Alumnos");

			while (rs.next()) {
				String id = rs.getString(1);
				String nombre = rs.getString(2);
				String apellido = rs.getString(3);
				String email = rs.getString(4);
				String ciudad = rs.getString(5);
				System.out.println(id + "  " + nombre + "   " + apellido + "   " + email + "   " + ciudad + "\n");
			}

			st = conn.createStatement();
			String querySelectNombreEmailS = "SELECT nombre, email FROM alumno WHERE nombre LIKE  '%S%' ";
			rs = st.executeQuery(querySelectNombreEmailS);
			System.out.println(
					"----------------- Nombre y email  de alumnos que tengan una S en el nombre---------------");

			while (rs.next()) {
				String nombre = rs.getString(1);
				String email = rs.getString(2);
				System.out.println(nombre + "   " + email + "\n");
			}

			st = conn.createStatement();
			String querySelectNombreClaseAenApellido = "SELECT alumno.nombre, clase.nombre FROM alumno, clase WHERE alumno.id_clase = clase.id AND alumno.apellidos LIKE '%A%'";
			rs = st.executeQuery(querySelectNombreClaseAenApellido);
			System.out.println(
					"-----------------Nombre alumno y nombre de clase que tengan una A en apellido ---------------");

			while (rs.next()) {
				String nombre = rs.getString(1);
				String nombreClase = rs.getString(2);
				System.out.println(nombre + "------------------" + nombreClase + "\n");
			}

			rs.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

=======
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
>>>>>>> parent of 24c436d... Connection All ok
}
