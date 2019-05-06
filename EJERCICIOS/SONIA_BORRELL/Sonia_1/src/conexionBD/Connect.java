package com.everis.sonia.conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect 
{
    
   private static final String URL_DB ="jdbc:mysql://ALC-67L2MH2:3306/beca_java?useTimezone=true&serverTimezone=UTC";
	private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
   private static final String USER = "beca_java";
   private static final String PWD ="beca_java";
	
	
	public Connection getConnection() throws SQLException {
    	Connection conn = null;
    	try{
    		Class.forName(DRIVER_CLASS).newInstance();
    		conn = DriverManager.getConnection(URL_DB, USER, PWD);
    	}catch (ClassNotFoundException e) {
    		System.out.println("Error al obtener el driver:" + e.toString());
    		
    	}catch (SQLException e) {
    		System.out.println("Error al obtener la conexion:" + e.toString());
    	}catch (InstantiationException e) {
    		System.out.println("Error al obtener la instancia:" + e.toString());
    	}catch (IllegalAccessException e) {
    		System.out.println("Error al obtener el acceso:" + e.toString());
    	}
		return conn;
    	
    		
    }
    
    }

