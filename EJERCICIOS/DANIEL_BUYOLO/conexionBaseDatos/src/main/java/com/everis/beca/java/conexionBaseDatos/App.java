package com.everis.beca.java.conexionBaseDatos;

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
    		GetConexion conexionDatabase = new GetConexion();
    		Connection conn = conexionDatabase.getConnection();
    		Statement st = conn.createStatement();
//    		String queryInsert = "insert into alumno (nombre, apellidos, email, ciudad, id_clase) values ('Daniel','Buyolo Martinez','dbuyolo76@gmail.com','Elche',1)";
//    		st.executeUpdate(queryInsert);
    		ResultSet rs = null;
    		String querySelect = "Select * from alumno";
    		st = conn.createStatement();
    		rs = st.executeQuery(querySelect);
    		System.out.println("Alumnos");
    		while (rs.next()) {
    			String id = rs.getString(1);
    			String nombre = rs.getString(2);
    			System.out.println(id + " " + nombre);
    		}
    		st.close();
    		rs.close();
    		conn.close();
    		
    		
    		
		} catch (Exception e) {
		}
    }
}
