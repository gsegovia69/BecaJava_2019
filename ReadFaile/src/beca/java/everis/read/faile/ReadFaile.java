package beca.java.everis.read.faile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ReadFaile {

	public static void main(String[] args) throws FileNotFoundException,IOException{
		
		System.out.println("---------------------ReadFile-----------------------");
		System.out.println(args[0]);
		System.out.println("--------------------------------------------");
        File file = new File(args[0]);
		printContent(file);
	

	}
	
	public static void printContent(File file)throws FileNotFoundException,IOException{
		
		File[] fileList = file.listFiles();
		File afile = null;
		String linea;
		
		for (File files : fileList) {
			
			if (files.isFile() && files.getName().equals("alumnos.xml")) {
				
				System.out.println("Existe file:" + files.getName());
                afile = files;
                break;						
				
			}
			
			
		}
		
		System.out.println("--------------------------------------------");

		
		if (afile != null) {
			
			FileReader fr = new FileReader (afile);
			BufferedReader br = new BufferedReader(fr);
			
			while ((linea = br.readLine()) != null) {
				
				System.out.println(linea);
				System.gc();

				
			}
			
			fr.close();
				
			
		}else {
			
			System.out.println("El directorio no existe:");
			
		}
		
		System.out.println("----------------------------------");

		/*Arrays.asList(fileList)
		.stream()
		.filter(fichero -> fichero.isFile())
		.forEach(fichero -> System.out.println(fichero.getName()));*/	
			
			
			
			
	
		
	}

}
