package everis.beca.java.practicas.mavenPrueba;

import java.io.IOException;
import everis.beca.java.practicas.mavenPrueba.dto.ClaseEveris;
import everis.beca.java.practicas.mavenPrueba.dto.Fecha;
import everis.beca.java.practicas.mavenPrueba.dto.LeerFichero;
import everis.beca.java.practicas.mavenPrueba.dto.Listado;

public class App2 {

	public static void main(String[] args) {

		try {
			ClaseEveris clase = LeerFichero.leer();
			Fecha now = new Fecha();
			String fecha = now.getFecha();
			Listado lista = new Listado();
			System.out.println("--------------------------------------------------------------");
			System.out.println("--------------------------------------------------------------");
			System.out.println("--------------------------------------------------------------");
			System.out.println("METODO 1");
			System.out.println("--------------------------------------------------------------");
			System.out.println("--------------------------------------------------------------");
			System.out.println("--------------------------------------------------------------");
			lista.metodo1(clase, fecha);
			System.out.println("--------------------------------------------------------------");
			System.out.println("--------------------------------------------------------------");
			System.out.println("--------------------------------------------------------------");
			System.out.println("METODO 2");
			System.out.println("--------------------------------------------------------------");
			System.out.println("--------------------------------------------------------------");
			System.out.println("--------------------------------------------------------------");
			lista.metodo2(clase, fecha);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
