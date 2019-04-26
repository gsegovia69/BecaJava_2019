package Beca2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Beca2 {

	public static void main(String arg[])
	{
		String texto;

		try
		{
			FileReader leer=new FileReader("C:\\Users\\Administrador\\Desktop\\Nuevacarpeta\\BecaJava_2019\\EJERCICIOS\\alumnos.xml");
			BufferedReader temp=new BufferedReader(leer);
			ArrayList<String> lista = new ArrayList<String>();
			int i=0;
			Map<Integer, String> mapa = new HashMap<Integer, String>();
			System.out.println("------------------------Archivo------------------------");
			while((texto=temp.readLine())!=null)
			{
				System.out.println(texto);
				lista.add(texto);
				mapa.put(i++, texto);
			}
			System.out.println("------------------------Lista------------------------");
			Iterator<String> it = lista.iterator();
			while (it.hasNext()) 
			{
			  System.out.println(it.next());
			}
			System.out.println("------------------------Mapa------------------------");
			mapa.forEach((nu,tex) -> System.out.println("i=" + (nu +1) + "		" + tex));	
			temp.close();
		}

		catch(Exception e)
		{
			System.out.println("Error al leer el archivo");
		}
	}

}