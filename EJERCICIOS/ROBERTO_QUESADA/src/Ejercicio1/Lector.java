package Ejercicio1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Lector {

	public static void main(String[] args) throws FileNotFoundException {
		FileReader fr = new FileReader("../alumnos.xml");
		BufferedReader bf = new BufferedReader(fr);
		try {
			String line;
			int length = 1;
			while ((line = bf.readLine()) != null) {
				length ++;
					for (int i = 0; i < length;i++) {
						System.out.println(bf.readLine());
					}
				
			}
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

