package constructor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class readfile1 {
	public static void main(String[] args) {
		String texto;
		try {
			FileReader leer = new FileReader(
					"C:\\Users\\Administrador\\Downloads\\BecaJava_2019\\EJERCICIOS\\alumnos.xml");
			BufferedReader temp = new BufferedReader(leer);
			ArrayList<String> lista = new ArrayList<String>();
			System.out.println("---Archivo---");
			while ((texto = temp.readLine()) != null) {
				System.out.println(texto);
				lista.add(texto);
			}
			temp.close();
		} catch (Exception e) {
		}

	}
}
