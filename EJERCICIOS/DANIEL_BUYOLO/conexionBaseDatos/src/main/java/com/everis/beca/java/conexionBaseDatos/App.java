package com.everis.beca.java.conexionBaseDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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
    		//System.out.println("Alumnos");
    		
    		
    		/* SOLO CON SENTENCIAS SQL
    		 * Y DENTRO DE UN SOLO MAIN
    		 */
    		
    		// 1. PINTAR POR CONSOLA TODOS LOS DATOS DE LOS ALUMNOS DE LA BBD
    		// 2. PINTAR POR CONSOLA NOMBRE Y EMAIL DE TODOS LOS ALUMNOS DE LA BBDD QUE TENGAN UNA 'S' EN EL NOMBRE
    		// 3. PINTAR POR SONOLA EL NOMBRE DE ALUMNO Y NOMBRE DE CURSO DE TODOS LOS ALUMNOS DE LA BBDD QUE TENGAN UNA 'A' EN EL APELLIDO
    		// 4. PINTAR POR CONSOLA NOMBRE DE ALUMNO, NOMBRE DE CLASE Y NOMBRE DE ASIGNATURAS DE TODOS LOS ALUMNOS DE LA BBDD
    		
    		
    		// 1.PINTAR POR CONSOLA TODOS LOS DATOS DE LOS ALUMNOS DE LA BBD
    		
    		/*
    		System.out.println("---------------------------");
    		
    		System.out.println("-------- Ejercicio 1 ------");
    		System.out.println("---------------------------");
    		while (rs.next()) {
    			String id = rs.getString(1);
    			String nombre = rs.getString(2);
    			String apellidos = rs.getString(3);
    			String email = rs.getString(4);
    			String ciudad = rs.getString(5);
    			
    			System.out.println(id + " " + nombre + " " + apellidos + " " + email + " " + ciudad);
    		}
    		
    		// 2. PINTAR POR CONSOLA NOMBRE Y EMAIL DE TODOS LOS ALUMNOS DE LA BBDD QUE TENGAN UNA 'S' EN EL NOMBRE
    		
    		String query2 = "SELECT nombre, email FROM alumno WHERE nombre LIKE '%S%'";
    		st = conn.createStatement();
    		rs = st.executeQuery(query2);
    	 
    		System.out.println("---------------------------");
    		System.out.println("-------- Ejercicio 2 ------");
    		System.out.println("---------------------------");
    		while (rs.next()) {
    			String nombre = rs.getString(1);
    			String email = rs.getString(2);
    			
    			System.out.println(nombre + " " + email + " ");
    			
    		}
    		
    		// 3. PINTAR POR SONOLA EL NOMBRE DE ALUMNO Y NOMBRE DE CURSO DE TODOS LOS ALUMNOS DE LA BBDD QUE TENGAN UNA 'A' EN EL APELLIDO
    		
    		String query3 = "SELECT alumno.nombre, clase.nombre FROM alumno, clase WHERE alumno.id_clase = clase.id AND alumno.apellidos LIKE '%A%'";
    		st = conn.createStatement();
    		rs = st.executeQuery(query3);
    	 
    		System.out.println("---------------------------");
    		System.out.println("-------- Ejercicio 3 ------");
    		System.out.println("---------------------------");
    		while (rs.next()) {
    			String nombre = rs.getString(1);
    			String curso = rs.getString(2);
    			
    			System.out.println(nombre + " " + curso + " ");
    			
    		}
    		
    		// 4. PINTAR POR CONSOLA NOMBRE DE ALUMNO, NOMBRE DE CLASE Y NOMBRE DE ASIGNATURAS DE TODOS LOS ALUMNOS DE LA BBDD
    		
    		String query4 = "SELECT alumno.nombre, clase.nombre, asignatura.nombre FROM alumno, clase, asignatura WHERE alumno.id_clase = clase.id AND asignatura.id_clase = clase.id";
    		st = conn.createStatement();
    		rs = st.executeQuery(query4);
    	 
    		System.out.println("---------------------------");
    		System.out.println("-------- Ejercicio 4 ------");
    		System.out.println("---------------------------");
    		while (rs.next()) {
    			String nombre = rs.getString(1);
    			String curso = rs.getString(2);
    			String asignatura = rs.getString(3);
    			
    			System.out.println(nombre + " " + curso + " " + " " + asignatura);
    			
    		}*/
    		st.close();
    		rs.close();
    		conn.close();
    		
    		
		} catch (Exception e) {
		}
    	
    	// SCRIPT SQL.
    	// 1. CREAR TABLA ASIGNATURA
    	//		- IDENTIFICADOR
    	//		- NOMBRE
    	//		- ORDEN
    	//		- CLASE
    	// 2. ESTABLECER CLAVE PRIMARIA NUMERICA.
    	// 3. ESTABLECER CLAVE AJENA A LA TABLA CLASE.
    	// 4. INSERTAR VALORES:
    	//		- JAVA
    	//		- SQL
    	//		- SPRING
    	//		- SPRING JPA
    	//		- SPRING CORE
    	//		- SPRING BOOT
    	//		- SPRING REST
    	//		- SPRING MVC
    }
}
