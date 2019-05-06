package com.everis.formacion.mavenProject1.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static final String URL_DB= "jdbc:mysql://10.118.124.196:3306/beca_java?useTimezone=true&serverTimezone=UTC";
	private static final String DRIVER_CLASS="com.mysql.cj.jdbc.Driver";
	private static final String USER ="beca_java";
	private static final String PASS="beca_java";
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;

		try {
			Class.forName(DRIVER_CLASS).newInstance();
			conn = DriverManager.getConnection(URL_DB,USER,PASS);
		} catch (ClassNotFoundException e) {
			System.out.println("Error de conexión");

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

}
