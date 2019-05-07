package everis.beca.java.practicas.mavenPrueba;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import everis.beca.java.practicas.mavenPrueba.dto.BbDd;

public class ConnectionDatabase {


	public static void main(String[] args) {
		
	
		try {
			BbDd BbDd = new BbDd();
			Connection conn = BbDd.getConnection();
			Statement st = conn.createStatement();
			//String queryInsert = "insert into alumno (nombre, apellidos, email, ciudad, id_alumno) values ('Roberto Carlos', 'Quesada Orts', 'robertocqo@gmail.com', 'Alicante', 1)";
			//st.executeUpdate(queryInsert);
			ResultSet rs = null;
			
	
			String querySelect = "Select * from alumno";
			rs = st.executeQuery(querySelect);
			System.out.println("------------------------------------------------------------");
			System.out.println("------------------------------------------------------------");
			System.out.println("PINTAR POR CONSOLA TODOS LOS DATOS DE LOS ALUMNOS DE LA BBDD");
			System.out.println("------------------------------------------------------------");
			System.out.println("------------------------------------------------------------");
			while (rs.next()) {
				String id = rs.getString(1);
				String nombre = rs.getString(2);
				String apellidos = rs.getString(3);
				String email = rs.getString(4);
				String ciudad = rs.getString(5);
				System.out.println(id + " " + nombre + " " + apellidos+ " " + ciudad + " " + email);
			}
			querySelect = "Select alumno.nombre, alumno.email FROM alumno WHERE nombre LIKE '%S%'";
			
			rs = st.executeQuery(querySelect);
		 	System.out.println("------------------------------------------------------------");
			System.out.println("------------------------------------------------------------");
			System.out.println("PINTAR POR CONSOLA NOMBRE Y EMAIL DE TODOS LOS ALUMNOS DE LA BBDD QUE TENGAN UNA 'S' EN EL NOMBRE");
			System.out.println("------------------------------------------------------------");
			System.out.println("------------------------------------------------------------");
			while (rs.next()) {
				String nom2 = rs.getString(1);
				String em2 = rs.getString(2);
				System.out.println(nom2 + " " + em2);
			}
			
			querySelect = "Select alumno.apellidos, alumno.nombre, clase.nombre FROM alumno, clase WHERE alumno.id_clase = clase.id AND alumno.apellidos LIKE '%A%'";
			rs = st.executeQuery(querySelect);
			System.out.println("------------------------------------------------------------");
			System.out.println("------------------------------------------------------------");
			System.out.println("PINTAR POR CONSOLA NOMBRE DEL ALUMNO Y NOMBRE DE CURSO DE TODOS LOS ALUMNOS DE LA BBDD QUE TENGAN UNA 'A' EN EL APELLIDO");
			System.out.println("------------------------------------------------------------");
			System.out.println("------------------------------------------------------------");
			while (rs.next()) {
				String nom3 = rs.getString(2);
				String curso = rs.getString(3);
				System.out.println(nom3 + " " + curso);
			}
			querySelect = "Select alumno.nombre, clase.nombre, asignatura.nombre FROM alumno, clase, asignatura WHERE asignatura.id_clase = clase.id ORDER BY alumno.nombre";
			rs = st.executeQuery(querySelect);
			System.out.println("------------------------------------------------------------");
			System.out.println("------------------------------------------------------------");
			System.out.println("PINTAR POR CONSOLA NOMBRE DEL ALUMNO, NOMBRE DE CLASE Y NOMBRE DE ASIGNATURAS DE TODOS LOS ALUMNOS DE BBDD");
			System.out.println("------------------------------------------------------------");
			System.out.println("------------------------------------------------------------");
			while (rs.next()) {
				
					String nombre = rs.getString(1);
					String curso = rs.getString(2);
					String asignatura = rs.getString(3);
					System.out.println(nombre +" " + curso + " " + asignatura );
					
			}
			rs.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
}