package everis.beca.java.practicas.mavenPrueba.dto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;

public class BbDd {
	JFrame frame = new JFrame();
	private static final String URL_DB = "jdbc:mysql://ALC-67L2MH2:3306/beca_java?useTimezone=true&serverTimezone=UTC";
	private static final String DRIVER_SQL = "com.mysql.cj.jdbc.Driver";
	private static final String USER = "beca_java";
	private static final String PASS = "beca_java";

	public Connection getConnection() {
		Connection con = null;
		
			try {
				Class.forName(DRIVER_SQL).newInstance();
				con = DriverManager.getConnection(URL_DB, USER, PASS);

			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("ERROR 404: " + e.toString());
			}
			
		
		return con;
	}

	public void delete() throws IOException {

		String sql = "BORRAR CLIENTES CUYO NIF SEA = " + "//insertar objeto" + "'";
		int total;

		try {
			Connection cn = this.getConnection();
			Statement st = cn.createStatement();
			total = st.executeUpdate(sql);
			System.out.println("Se han eliminado " + total + " registros.");
			st.close();
		} catch (Exception e) {
			System.out.println("Error al obtener la tabla.");
		}
	}
}
