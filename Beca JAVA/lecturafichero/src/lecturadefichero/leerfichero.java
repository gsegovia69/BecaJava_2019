package lecturadefichero;

import java.io.*;

public class leerfichero {

	public static void main(String[] args) {
		File fichero = new File("C:\\Users\\Administrador\\Desktop\\BecaJava\\BecaJava_2019\\EJERCICIOS\\alumnos.xml");
		
		try {
			FileReader lector;
			lector = new FileReader(fichero);
			BufferedReader lector2 = new BufferedReader(lector);
			
			if(fichero.exists()) {
				if(fichero.isFile()) {
					System.out.println("El fichero existe");
					String cadena;
					
					try {
						while((cadena = lector2.readLine()) != null){
							//cadena = lector2.readLine();
							if(cadena != null) {
								System.out.println(cadena);
							}
						}
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
