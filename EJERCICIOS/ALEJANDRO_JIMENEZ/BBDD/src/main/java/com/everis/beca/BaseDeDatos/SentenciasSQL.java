package com.everis.beca.BaseDeDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class SentenciasSQL {

	public static void main(String[] args) {
		
		try {
			ConnectionDataBase connectionDatabase = new ConnectionDataBase();
			Connection conn = connectionDatabase.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = null;
			//String queryInsert= "insert into alumno(nombre,apellidos,email,ciudad,id_clase) values ('Alejandro','Jimenez Erades','alejandrojimenezerades@gmail.com','Aspe',1)";
			//st.executeUpdate(queryInsert);
			String querySelect = "Select * from alumno";
			st = conn.createStatement();
			rs = st.executeQuery(querySelect);
			System.out.println("Todos los datos de alumno\n");
			while (rs.next()) {
						for(int i=1;i<rs.getMetaData().getColumnCount();i++) {
							System.out.print(rs.getString(i)+" ");
							if (i==rs.getMetaData().getColumnCount()-1) {
								System.out.print("\n");
							}
						}
					
			}
			
			querySelect = "select nombre, email from alumno where nombre like '%s%' ";
			st = conn.createStatement();
			rs = st.executeQuery(querySelect);
			System.out.println("\nNombre y Email de alumnos que tienen una s en el nombre\n");
			while(rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2));
			}
			
			querySelect = "select a.nombre , c.nombre from alumno a , clase c where c.id=a.id_clase and apellidos like '%a%' ";
			st = conn.createStatement();
			rs = st.executeQuery(querySelect);
			System.out.println("\nNombre y Clase de alumnos que tienen una a en el apellido\n");
			
			while(rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2));
			}
			querySelect = "select a.nombre , c.nombre , a.id , c.id from alumno a , clase c where c.id=a.id_clase";
			st = conn.createStatement();
			rs = st.executeQuery(querySelect);
		
			
			while(rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2));
			}

			querySelect = "select alumno.nombre,clase.nombre, from alumno ,clase where alumno.id_clase = clase.id";
			st = conn.createStatement();
			rs = st.executeQuery(querySelect);
		
			
			while(rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2));
			}
			st.close();
			rs.close();
			conn.close();		
		} catch(Exception e) {
			System.err.println("Error " + e.getMessage());
			
		}
		
	}

}
