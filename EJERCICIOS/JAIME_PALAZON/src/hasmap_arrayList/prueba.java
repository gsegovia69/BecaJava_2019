package jaimepalazon;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class prueba {

	public static void main(String[] arg) {
		try {
			FileReader fr = new FileReader("C:/Users/Administrador/Desktop/Ejercicio4_XML.xml");
			BufferedReader br = new BufferedReader(fr);

			String linea = "";
			ArrayList<String> lista = new ArrayList<String>();
			while (linea != null) {
				linea = br.readLine();
			   lista.add(linea);
			}
			System.out.println(lista);
			br.close();
			

		} catch (IOException e) {
			System.out.println("No he podido leer del fichero");
			System.out.println("El error es:" + e.getMessage());
		}
		finally {
			
		}
	}

}
