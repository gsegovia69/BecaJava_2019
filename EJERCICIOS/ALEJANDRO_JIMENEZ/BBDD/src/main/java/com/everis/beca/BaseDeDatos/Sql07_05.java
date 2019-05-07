package com.everis.beca.BaseDeDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Sql07_05 {

	public static void main(String[] args) {
		try {
			ConnectionDataBase connectionDatabase = new ConnectionDataBase();
			Connection conn = connectionDatabase.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = null;
			
			String querySelect = "Select * from alumno";
			st = conn.createStatement();
			rs = st.executeQuery(querySelect);
			
			System.out.println("Todos los datos de alumno\n");
			while (rs.next()) {
				
							}
					
			
			
		}catch(Exception e) {
			System.err.println("Error " + e.getMessage());
		}
	}

}
