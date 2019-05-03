package com.everis.formacion.mavenProject1.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	public Connection getConnection() throws SQLException{
		String url ="jdbc:mysql://localhost:3306/nameBd";
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e){
			System.out.println("Error de conexión");
			
		}
		Connection cn = DriverManager.getConnection(url);
		return cn;

}
	
}
