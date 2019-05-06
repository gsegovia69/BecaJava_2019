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
			while (rs.next()) {
				String id = rs.getString(1);
				String nombre = rs.getString(2);
				System.out.println(id + " " + nombre);
			}
			st.close();
			rs.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
