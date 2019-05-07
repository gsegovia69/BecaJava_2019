package com.everis.maven.java.proyect.by.osniel.conection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionBD {
	
	private static final String URL_DB ="jdbc:mysql://ALC-67L2MH2:3306/beca_java?useTimezone=true&serverTimezone=UTC";
	private static final String DRIVER_CLASS ="com.mysql.cj.jdbc.Driver";
	private static final String USER ="beca_java";
	private static final String PWD ="beca_java";

	private static final String host_d = "jdbc:mysql://000webhost.com:3306/id5437765_homevip";
	private static final String user_d = "id5437765_osanchezplanes";
	private static final String pass_d = "Osdpapa5";
	private static final String db_nam = "id5437765_homevip";
	private static final String tbl_nam = "perfils";
	
	public Connection getConnection(){
		Connection connection=null;
		try {
			Class.forName(DRIVER_CLASS).newInstance();
			connection = DriverManager.getConnection(URL_DB,USER,PWD);
			//connection = DriverManager.getConnection(host_d,USER,PWD);


		} catch (ClassNotFoundException e) {
			System.out.println("Error obteniendo driver"+ e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error obteniendo la connexionr" + e.getMessage());
		} catch (InstantiationException e) {
			System.out.println("Error obteniendo la driver" + e.getMessage());
		} catch (IllegalAccessException e) {
			System.out.println("Error obteniendo la driver" + e.getMessage());
		}
		
		return connection;
	}

}
