package Ejercicio1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class LectorListaMap {

	public static void main(String[] args) throws FileNotFoundException {
		FileReader fr = new FileReader("../alumnos.xml");
		BufferedReader bf = new BufferedReader(fr);
		ArrayList<Alumnos> alumnos = new ArrayList<Alumnos>();
		String linea = "";
		Alumnos alu = null;
		try {
			boolean comprobacion = false;
			while ((linea = bf.readLine()) != null) {
				if (linea.trim().contains(ConstantUtils.INICIO_ITERACION_ALUMNOS)) {
					alu = new Alumnos();
					comprobacion = true;
				}
				if (comprobacion && linea.trim().contains(ConstantUtils.INICIO_ITERACION_NOMBRE)) {
					alu.setNombre(linea);
				}
				if (comprobacion && linea.trim().contains(ConstantUtils.INICIO_ITERACION_APELLIDO)) {
					alu.setApellido(linea);
				}
				if (comprobacion && linea.trim().contains(ConstantUtils.INICIO_ITERACION_EMAIL)) {
					alu.setEmail(linea);
				}
				if (comprobacion && linea.trim().contains(ConstantUtils.INICIO_ITERACION_CIUDAD)) {
					alu.setCiudad(linea);
				}
				if (comprobacion && linea.trim().contains(ConstantUtils.FIN_ITERACION_ALUMNOS)) {
					alumnos.add(alu);
					comprobacion = false;
				}
			}
			String nombres;
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < alumnos.size(); i++) { // Recorro la lista y coloco todas las Strings en la variable nombres
				nombres = alumnos.get(i).allString(); 
				list.add(nombres); // añado la variable nombre en el Array de Strings list
			}
		Collections.sort(list); // ordeno alfabeticamente la lista co
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Nombre: " + list.get(i));
		}
		} catch (Exception e) {
			System.out.println(e.getMessage());

			/**
			 * try { ArrayList<String> list = new ArrayList<String>(); Map<Integer, String>
			 * numeroLista = new HashMap<Integer, String>(); int count = 1; String line =
			 * bf.readLine(); while (line != null) { numeroLista.put(count++, line);
			 * list.add(line); line = bf.readLine(); }
			 * System.out.println("------------------------------------------------");
			 * System.out.println("------------------------------------------------");
			 * System.out.println("LIST");
			 * System.out.println("------------------------------------------------");
			 * System.out.println("------------------------------------------------");
			 * 
			 * for (int i = 0; i < list.size(); i++) { //System.out.println(list.get(i)); }
			 * System.out.println("------------------------------------------------");
			 * System.out.println("------------------------------------------------");
			 * System.out.println("HASHMAP");
			 * System.out.println("------------------------------------------------");
			 * System.out.println("------------------------------------------------");
			 * 
			 * //System.out.println(numeroLista); } catch (IOException e) {
			 **/
			System.out.println(e.getMessage());
		} finally {
			try {
				bf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
