package Ejercicio1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class LectorListaMap {

	public static void main(String[] args) throws FileNotFoundException {
		FileReader fr = new FileReader("../alumnos.xml");
		BufferedReader bf = new BufferedReader(fr);
		try {
			ArrayList<String> list = new ArrayList<String>();
			HashMap<Integer,  String> numeroLista = new HashMap<Integer, String>();
			AtomicInteger count = new AtomicInteger(1);
			String line = bf.readLine();
			while (line != null) {
				numeroLista.put(new Integer(count.getAndIncrement()), line);
				list.add(line);
				line=bf.readLine();
			}
			 System.out.println("------------------------------------------------");
			 System.out.println("------------------------------------------------");
			 System.out.println("LIST");
			 System.out.println("------------------------------------------------");
			 System.out.println("------------------------------------------------");
			
			 for (int i = 0; i < list.size(); i++) {
				  System.out.println(list.get(i));
			    }
			 System.out.println("------------------------------------------------");
			 System.out.println("------------------------------------------------");
			 System.out.println("HASHMAP");
			 System.out.println("------------------------------------------------");
			 System.out.println("------------------------------------------------");
			
			 System.out.println(numeroLista);
			} catch ( IOException e ) {
			System.out.println( e.getMessage() );
		} finally {
		try {
			bf.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		}
	}
}

