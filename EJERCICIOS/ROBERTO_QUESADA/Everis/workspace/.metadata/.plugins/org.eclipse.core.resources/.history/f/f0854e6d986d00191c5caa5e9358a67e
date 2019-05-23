package everis.beca.java.practicas.mavenPrueba;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InteraccionBBDD {

	public Connection getConnection() throws SQLException {
		String url = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println("Error al conectar a la base de datos.");
		}
		Connection cn = DriverManager.getConnection(url);
		return cn;
	}

	public void delete(Client client) throws IOException {

		String sql = "BORRAR CLIENTES CUYO NIF SEA = " + client.getDni() + "'";
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
