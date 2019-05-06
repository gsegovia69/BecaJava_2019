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
			st = conn.createStatement();
			rs = st.executeQuery(querySelect);
			while (rs.next()) {
				String id = rs.getString(1);
				String nombre = rs.getString(2);
				System.out.println(id + " " + nombre);
			}
			st.close();
			rs.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
}