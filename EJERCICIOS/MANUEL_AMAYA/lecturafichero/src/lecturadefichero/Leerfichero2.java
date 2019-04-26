package lecturadefichero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Leerfichero2 {

	public static void main(String[] args) {
		File fichero = new File("C:\\Users\\Administrador\\Desktop\\BecaJava\\BecaJava_2019\\EJERCICIOS\\alumnos.xml");
		
		try {
			
			FileReader lector = new FileReader(fichero);
			BufferedReader lector2 = new BufferedReader(lector);
			
			if(fichero.exists()) {
				if(fichero.isFile()) {
					System.out.println("El fichero existe");
					String cadena;
					
					try {
						Integer contador = 1;
						List<String> milista = new ArrayList<String>();
						Map<Integer, String> mimapa = new HashMap<Integer, String>();
						while((cadena = lector2.readLine()) != null){
							if(cadena != null) {
								milista.add(cadena);
								mimapa.put(contador, cadena);
								contador++;
								//System.out.println(cadena);
								
							}
						}
						
						Iterator<String> itera = milista.iterator();
						while(itera.hasNext()) {
							System.out.println(itera.next());
						}
						lector.close();
						lector2.close();
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else {
				System.out.println("El fichero no existe");
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
