package com.everis.beca.java.conexionBaseDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class App 
{
    public static void main( String[] args )
    {
       try {
		GetConection connectionDatabase = new GetConection();
		Connection conn = connectionDatabase.getConnection();
		Statement st = conn.createStatement();
//		String queryInsert = "insert into alumno (nombre, apellidos, email, ciudad, id_clase) values ('Iván', 'Sánchez Rico','isrmail87@gmail.com','Elda', 1)";
//		st.executeUpdate(queryInsert);
		ResultSet rs =null;
		String querySelect = "Select * from alumno";
		st = conn.createStatement();
		rs = st.executeQuery(querySelect);
		System.out.println("Alumnos");
		while(rs.next()) {
			String id = rs.getString(1);
			String nombre = rs.getString(2);
			System.out.println(id + " " + nombre);
		}
		st.close();
		rs.close();
		conn.close();
	
		
	} catch (Exception e) {
		// TODO: handle exception
	} 
    }
}
