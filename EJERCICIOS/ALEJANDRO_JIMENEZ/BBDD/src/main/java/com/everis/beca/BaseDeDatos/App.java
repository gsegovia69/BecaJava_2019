package com.everis.beca.BaseDeDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {
		ConnectionDataBase connectionDatabase = new ConnectionDataBase();
		Connection conn = connectionDatabase.getConnection();
		Statement st = conn.createStatement();
		
		//String queryInsert= "insert into alumno(nombre,apellidos,email,ciudad,id_clase) values ('Alejandro','Jimenez Erades','alejandrojimenezerades@gmail.com','Aspe',1)";
		//st.executeUpdate(queryInsert);
		
		ResultSet rs = null;
		String QuerySelect = "Select * from profesor";
		st = conn.createStatement();
		rs = st.executeQuery(QuerySelect);
		System.out.println("Profesor");
		while (rs.next()) {
			String id =rs.getString(1);
			String nombre=rs.getString(2);
			System.out.println(id + " " + nombre);
		}
		QuerySelect = "select * from alumno";
		st = conn.createStatement();
		rs = st.executeQuery(QuerySelect);
		
		System.out.println("Alumnos");
		while( rs.next()){ 
			String id =rs.getString(1);
			String nombre=rs.getString(2);
			System.out.println(id + " " + nombre + " " + rs.getString(3));
		}
		
		
		
		st.close();
		rs.close();
		conn.close();
	}catch (Exception e) {
		System.out.println("Error con la consulta "+e.toString());
	}
    }
    
    
}
