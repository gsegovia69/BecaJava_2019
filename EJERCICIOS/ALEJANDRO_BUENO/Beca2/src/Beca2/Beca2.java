package Beca2;

import java.io.FileReader;
import java.io.BufferedReader;

public class Beca2 {
	
	public static void main(String arg[])
	{
		String texto;

		try
		{
	
			FileReader leer=new FileReader("C:\\Users\\Administrador\\Desktop\\Nuevacarpeta\\BecaJava_2019\\EJERCICIOS\\alumnos.xml");
			BufferedReader temp=new BufferedReader(leer);

			while((texto=temp.readLine())!=null)
			{
				System.out.println(texto);
			}
			temp.close();
		}

		catch(Exception e)
		{
			System.out.println("Error al leer el archivo");
		}
	}

}