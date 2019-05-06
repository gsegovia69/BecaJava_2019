package manuelAmaya.proyecto1.mavenProject1.dto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConsultarBBDD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
     		Conectar connectionDatabase = new Conectar();
     		Connection conn = connectionDatabase.getConnection();
     		Statement st = conn.createStatement();
     		ResultSet rs = null;
     		
     		//Datos de todos los alumnos de la BBDD
     		System.out.println("1. PINTAR POR CONSOLA TODOS LOS DATOS DE LOS ALUMNOS DE LA BBDD");
     		String querySelect1 = "select * from alumno";
     		st = conn.createStatement();
     		rs = st.executeQuery(querySelect1);
     		while(rs.next()) {
     			System.out.println("ID: " + rs.getString(1) + " // Nombre: " + rs.getString(2) + " " + rs.getString(3) + " // Email: " + rs.getString(4) + 
     					" // Ciudad: " + rs.getString(5));
     		}
     		
     		System.out.println("\n2. PINTAR POR CONSOLA NOMBRE Y EMAIL DE TODOS LOS ALUMNOS DE LA BBDD QUE TENGAN UNA \"S\" EN EL NOMBRE");
     		String querySelect2 = "select nombre, email from alumno where nombre like '%S%'";
     		st = conn.createStatement();
     		rs = st.executeQuery(querySelect2);
     		while(rs.next()) {
     			System.out.println("Nombre: " + rs.getString(1) + " // Email: " + rs.getString(2));
     		}
     		
     		System.out.println("\n3. PINTAR POR CONSOLA NOMBRE DE ALUMNO Y NOMBRE DE CURSO DE TODOS LOS ALUMNOS DE LA BBDD QUE TENGAN UNA \"A\"·EN EL APELLIDO");
     		String querySelect3 = "select alumno.nombre, clase.nombre from alumno, clase where alumno.apellidos like '%A%'and clase.id <> alumno.id_clase";
     		st = conn.createStatement();
     		rs = st.executeQuery(querySelect3);
     		while(rs.next()) {
     			System.out.println("Nombre de Alumno: " + rs.getString(1) + " // Nombre de clase: " + rs.getString(2));
     		}
     		
     		
     		/*//String queryInsert = "insert into alumno (nombre, apellidos, email, ciudad, id_clase) values('Manuel Alejandro', 'Amaya Alcaraz', 'alejandro_amayaa@hotmail.com', 'Busot', 1)";
     		//st.executeUpdate(queryInsert);
     		
     		String querySelect = "Select * from alumno";
     		st = conn.createStatement();
     		rs = st.executeQuery(querySelect);
     		while(rs.next()){
     			String id = rs.getString(1);
     			String nombre = rs.getString(2);
     			String email = rs.getString(3);
     			String ciudad = rs.getString(4);
     			System.out.println(id + " " + nombre + " " + email + " " + ciudad);
     		}*/
     		st.close();
     		rs.close();
     		conn.close();
     	} catch(Exception e){
     		System.out.println(e.toString());
     	}
		
	}

}
