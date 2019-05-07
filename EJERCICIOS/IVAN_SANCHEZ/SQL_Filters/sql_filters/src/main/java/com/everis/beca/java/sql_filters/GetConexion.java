package com.everis.beca.java.sql_filters;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConexion {

	private static final String URL_DB = "jdbc:mysql://ALC-67L2MH2:3306/beca_java?useTimezone=true&serverTimezone=UTC";
	private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	private static final String USER = "beca_java";
	private static final String PWD = "beca_java";

	public Connection getConnection()
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection conn = null;

		try {
			// Carga el driver JDBC
			Class.forName(DRIVER_CLASS).newInstance();
			// Conexion con la base de datos.
			conn = DriverManager.getConnection(URL_DB, USER, PWD);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			System.out.println("Error: " + e.toString());
		}
		return conn;
	}
}
