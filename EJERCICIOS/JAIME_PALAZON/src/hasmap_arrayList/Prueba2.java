package jaimepalazon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Prueba2 {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("C:/Users/Administrador/Desktop/Ejercicio4_XML.xml");
			BufferedReader br = new BufferedReader(fr);

			String linea = "";
			HashMap<Integer, String> xmlDatos = new HashMap<Integer, String>();
			AtomicInteger count = new AtomicInteger(1);
			while (linea != null) {
				linea = br.readLine();
			   xmlDatos.put(new Integer(count.getAndIncrement()),linea);
			}
			System.out.println(xmlDatos);
			br.close();

		} catch (IOException e) {
			System.out.println("No he podido leer del fichero");
			System.out.println("El error es:" + e.getMessage());
		}
		finally {
			
		}
	}

	}


