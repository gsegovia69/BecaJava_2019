package com.everis.sonia.conexionBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectBD {
	public static void main (String[] arg) {
		
			try {
				Connect connenctionDateBase = new Connect(); //se define la variable para la conexion en la base de datos
				Connection conn = connenctionDateBase.getConnection();
				Statement st= conn.createStatement();
				//Para insertar los datos propios de cada alumno, solo se hace la primera vez.
			//String queryInsert  = "insert into alumno (nombre, apellidos, email, ciudad, id_clase)values ('Sonia', 'Borrell Plaza', 's.borrell.p@gmail.com', 'Alicante', 1)";
			//st.executeUpdate(queryInsert);
			
				
			//realizamos la select para recuperar la informacion Alumno
			ResultSet rs = null;
			String querySelect = "Select * from alumno";
			st = conn.createStatement()	;
			rs =st.executeQuery(querySelect);
			System.out.println("ALUMNO");
			while (rs.next()) {
				String id = rs.getString(1);
				String nombre = rs.getString(2);
				System.out.println(id + "  " +nombre);
				
				//hay que cerrar la conexion con la base de datos
			st.close();
			rs.close();
			conn.close();
			}
			
			}catch (SQLException e) {
				System.out.println("Error al obtener la conexion");
			}
			
		}	
	}
	


