package beca.java.everis;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	public static void main(String[] args) {
		 String ruta = "C:\\Users\\Administrador\\BecaJava_2019-master\\BecaJava_2019\\EJERCICIOS";
       
	        ruta += "\\";
	        try 
	        {
	            System.out.println(ruta);
	            mostrarArchivoPantalla(ruta + "alumnos.xml");
	        } catch (IOException ex) 
	        {
	            System.out.println(ex.getMessage());
	        }
	    }
	    
	    public static void mostrarArchivoPantalla(String ruta) throws IOException
	    {
	        File fichero = new File(ruta);
	        BufferedReader ficheroL;
	        ficheroL = new BufferedReader(new FileReader(fichero));
	        String linea = ficheroL.readLine();
	        while (linea!=null) 
	        {
	            System.out.println(linea);
	            linea = ficheroL.readLine();
	        }
	        ficheroL.close();
	    }
	}
