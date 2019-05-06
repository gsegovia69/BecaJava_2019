package com.everis.beca.BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionDataBase {
	
	private static final String URL_DB = "jdbc:mysql://ALC-67L2MH2:3306/beca_java?useTimezone=true&serverTimezone=UTC";
	private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	private static final String USER = "beca_java";
	private static final String PWD = "beca_java";
	public Connection getConnection(){
		Connection conn = null;
		


				try {
					Class.forName(DRIVER_CLASS).newInstance();
					conn= DriverManager.getConnection(URL_DB, USER, PWD);
				} catch (InstantiationException e) {
					System.out.println("Error obteniendo el driver" + e.toString());
				} catch (IllegalAccessException e) {
					System.out.println("Error obteniendo el driver" + e.toString());
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					System.out.println("Error obteniendo el driver" + e.toString());
				} catch (SQLException e) {
					System.out.println("Error obteniendo la conexion" + e.toString());
				}


		return conn;
		}	
}



