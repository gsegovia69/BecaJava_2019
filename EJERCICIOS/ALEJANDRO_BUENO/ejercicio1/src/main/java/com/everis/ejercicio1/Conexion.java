package com.everis.ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion
{
	public Connection getConecction() throws SQLException
	{
		String url = "jdbc:mysql://localost:3306:name8d";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("ERROR AL CONECTAR CON EL DRIVER");
		}
	Connection cn = DriverManager.getConnection(url);
	return cn;
	}
}
