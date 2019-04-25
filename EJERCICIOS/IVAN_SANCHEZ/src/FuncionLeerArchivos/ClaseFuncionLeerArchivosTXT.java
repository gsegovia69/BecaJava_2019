package FuncionLeerArchivos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClaseFuncionLeerArchivosTXT {

	public static List<String> muestraContenido(String archivo) throws FileNotFoundException, IOException {
		String cadena;

		List<String> alist = new ArrayList<String>();

		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);
		while ((cadena = b.readLine()) != null) {
			alist.add(cadena);

			System.out.println(alist);
		}
		b.close();
		return alist;

	}
		
public static void mostrarMap(String archivo) throws IOException {
	String cadena;
	int cont = 0;

	HashMap<Integer, String> maping = new HashMap<Integer, String>();
	FileReader f = new FileReader(archivo);
	BufferedReader b = new BufferedReader(f);
	while ((cadena = b.readLine()) != null) {

		maping.put(cont, cadena);
		cont++;

		System.out.println(maping);
	}
	b.close();

}

	

	public static void main(String[] args) throws IOException {
		if (args != null) {
			muestraContenido(args[0]);
		} else {
			System.out.println();
		}
	}


}


