package com.everis.beca.java.conexionBaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConection {

	
	public Connection getConnection() throws SQLException{
	
		String url= "";
		
		try {
//		Carga del driver jdbc
			Class.forName("");
//		Conexion con la base de datos.
			
			
			
			
	} catch (ClassNotFoundException e) {
		System.out.println("Error al conectar con el driver JDBC");
	}	
		Connection cn = DriverManager.getConnection(url);
		
		return cn;
	}
	
	
}
