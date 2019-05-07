package proyecto.prueba.ejercicio1.mavenProyect0.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDataBase {
	private static final String URL_DB = "jdbc:mysql://ALC-67L2MH2:3306/beca_java?useTimezone=true&serverTimezone=UTC";
	private static final String DRIVER_SQL = "com.mysql.cj.jdbc.Driver";
	private static final String USER = "beca_java";
	private static final String PASS = "beca_java";

	public Connection getConnection() throws SQLException {
		Connection cn = null;
		try {
			Class.forName(DRIVER_SQL).newInstance();
			cn = DriverManager.getConnection(URL_DB, USER, PASS);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver ERROR" + e.toString());
		} catch (InstantiationException e) {
			System.out.println("Connection ERROR" + e.toString());
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.out.println("Driver ERROR" + e.toString());
			e.printStackTrace();
		} 

		
		return cn;
	}

	public static void main(String[] args) {
		try {
			ConnectionDataBase connectionDatabase = new ConnectionDataBase();
			Connection conn = connectionDatabase.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = null;
		
			//String queryInsert = "Insert into alumno (nombre , apellidos, email , ciudad , id_clase) values ('alejandro','otero','oterokorze@gmail.com','San Vicente del raspeig', 1)";
			//st.executeUpdate(queryInsert);
			String querySelect = "Select * from alumno";
			st = conn.createStatement();
			rs = st.executeQuery(querySelect);			
			   st = conn.createStatement();
			   rs = st.executeQuery(querySelect);
			   System.out.println("------------------------------------------------------------");
			   System.out.println("------------------------------------------------------------");
			   System.out.println("PINTAR POR CONSOLA TODOS LOS DATOS DE LOS ALUMNOS DE LA BBDD");
			   System.out.println("------------------------------------------------------------");
			   System.out.println("------------------------------------------------------------");
			   while (rs.next()) {
			    String id = rs.getString(1);
			    String nombre = rs.getString(2);
			    String apellidos = rs.getString(3);
			    String email = rs.getString(4);
			    String ciudad = rs.getString(5);
			    System.out.println(id + " " + nombre + " " + apellidos+ " " + ciudad + " " + email);
			   }
			   querySelect = "Select alumno.nombre, alumno.email FROM alumno WHERE nombre LIKE '%S%'";
			   
			   rs = st.executeQuery(querySelect);
			    System.out.println("------------------------------------------------------------");
			   System.out.println("------------------------------------------------------------");
			   System.out.println("PINTAR POR CONSOLA NOMBRE Y EMAIL DE TODOS LOS ALUMNOS DE LA BBDD QUE TENGAN UNA 'S' EN EL NOMBRE");
			   System.out.println("------------------------------------------------------------");
			   System.out.println("------------------------------------------------------------");
			   while (rs.next()) {
			    String nom2 = rs.getString(1);
			    String em2 = rs.getString(2);
			    System.out.println(nom2 + " " + em2);
			   }
			   
			   querySelect = "Select alumno.apellidos, alumno.nombre, clase.nombre FROM alumno, clase WHERE alumno.id_clase = clase.id AND apellidos LIKE '%A%'";
			   rs = st.executeQuery(querySelect);
			   System.out.println("------------------------------------------------------------");
			   System.out.println("------------------------------------------------------------");
			   System.out.println("PINTAR POR CONSOLA NOMBRE DEL ALUMNO Y NOMBRE DE CURSO DE TODOS LOS ALUMNOS DE LA BBDD QUE TENGAN UNA 'A' EN EL APELLIDO");
			   System.out.println("------------------------------------------------------------");
			   System.out.println("------------------------------------------------------------");
			   while (rs.next()) {
			    String nom3 = rs.getString(2);
			    String curso = rs.getString(3);
			    System.out.println(nom3 + " " + curso);
			   }
			   querySelect = "Select alumno.nombre, clase.nombre, asignatura.nombre FROM alumno, clase, asignatura WHERE asignatura.id_clase = clase.id";
			   rs = st.executeQuery(querySelect);
			   System.out.println("------------------------------------------------------------");
			   System.out.println("------------------------------------------------------------");
			   System.out.println("PINTAR POR CONSOLA NOMBRE DEL ALUMNO, NOMBRE DE CLASE Y NOMBRE DE ASIGNATURAS DE TODOS LOS ALUMNOS DE BBDD");
			   System.out.println("------------------------------------------------------------");
			   System.out.println("------------------------------------------------------------");
			   while (rs.next()) {
			    
			     String nombre = rs.getString(1);
			     String curso = rs.getString(2);
			     String asignatura = rs.getString(3);
			     
			     System.out.println(nombre +" " + curso + " " + asignatura );
			     
			   }
			   rs.close();
			   st.close();
			   
			   conn.close();
			  } catch (Exception e) {
			   System.out.println(e.toString());
			  }
			 }
			}
				
