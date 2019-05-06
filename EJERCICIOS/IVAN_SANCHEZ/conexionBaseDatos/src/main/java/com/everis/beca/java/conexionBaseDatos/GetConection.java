package com.everis.beca.java.conexionBaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConection {

	private static final String URL_DB = "jdbc:mysql://10.118.124.196:3306/beca_java?useTimezone=true&serverTimezone=UTC";
	private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	private static final String USER = "beca_java";
	private static final String PWD = "beca_java";

	public Connection getConnection() {
Connection conn = null;
		try {
//		Carga del driver jdbc
			Class.forName(DRIVER_CLASS).newInstance();
//			Conexion con la base de datos.
			conn = DriverManager.getConnection(URL_DB,USER,PWD);


		} catch (ClassNotFoundException e) {
			System.out.println("Error al conectar con el driver JDBC");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
