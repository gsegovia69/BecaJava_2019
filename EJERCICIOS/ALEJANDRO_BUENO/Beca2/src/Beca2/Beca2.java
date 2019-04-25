package Beca2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Beca2 {
	
	public static void main(String arg[])
	{
		String texto;

		try
		{
			FileReader leer=new FileReader("C:\\Users\\Administrador\\Desktop\\Nuevacarpeta\\BecaJava_2019\\EJERCICIOS\\alumnos.xml");
			BufferedReader temp=new BufferedReader(leer);
			ArrayList<String> Lista = new ArrayList<String>();
			int i=0;
			Map<Integer, String> Mapa = new HashMap<Integer, String>();
			System.out.println("------------------------Archivo------------------------");
			while((texto=temp.readLine())!=null)
			{
				System.out.println(texto);
				Lista.add(texto);
				i++;
				Mapa.put(i, texto);
			}
			System.out.println("------------------------Lista------------------------");
			Iterator<String> it = Lista.iterator();
			while (it.hasNext()) 
			{
			  System.out.println(it.next());
			}
			System.out.println("------------------------Mapa------------------------");
			temp.close();
		}

		catch(Exception e)
		{
			System.out.println("Error al leer el archivo");
		}
	}

}