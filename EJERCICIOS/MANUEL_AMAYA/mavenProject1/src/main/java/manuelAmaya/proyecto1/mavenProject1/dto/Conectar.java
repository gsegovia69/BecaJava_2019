package manuelAmaya.proyecto1.mavenProject1.dto;

import java.sql.Connection;
import java.sql.*;

public class Conectar {
	
	private static final String URL_DB = "jdbc:mysql://ALC-67L2MH2:3306/beca_java?useTimezone=true&serverTimezone=UTC";
	private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	private static final String USER = "beca_java";
	private static final String PWD = "beca_java";
	
	public Connection getConnection(){
		Connection conn = null;
		
		try {
			Class.forName(DRIVER_CLASS).newInstance();
			conn = DriverManager.getConnection(URL_DB, USER, PWD);
		} catch(InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			System.out.println("Error: " + e.toString());
		}
		
		
		/*catch(ClassNotFoundException e) {
			System.out.println("Error obteniendo el driver..." + e.toString());
		} catch(SQLException e) {
			System.out.println("Error obteniendo la conexion..." + e.toString());
		} catch(InstantiationException e) {
			System.out.println("Error obteniendo el driver..." + e.toString());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		return conn;
	}
}



/*
 EN EL MAIN:
 
 	try{
 		ConnectionDataBase = connectionDatabase = new ConnectionDataBase();
 		Connection conn = connectionDatabase.getConnection();
 		Statement st = conn.createStatement();
 		String queryInsert = "insert into profesor values ("nombre", "Apellidos", "Email", "Ciudad", 1);
 		st.executeUpdate(queryInsert);
 		ResultSet rs = null;
 		String querySelect = "Select * from profesor";
 		st = conn.createStatement();
 		rs = st.executeQuery(querySelect);
 		while(rs.next()){
 			String id = rs.getString();
 			String nombre = rs.getNombre();
 			System.out.println(id + " " + nombre);
 		}
 		st.close();
 		rs.close();
 		conn.close();
 	} catch(Exception e){
 		System.out.println(e.toString());
 	}
 */