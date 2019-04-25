package ejercicio2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsertarListMap {

	public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            System.out.println(cadena);
        }
        b.close();
    }

		public static void insertaLista(String cad) throws FileNotFoundException, IOException {
			String cadena;
			List<String> lista = new ArrayList<String>();
	        FileReader f = new FileReader(cad);
	        BufferedReader b = new BufferedReader(f);
	        
	       while((cadena = b.readLine())!=null) {
	        	lista.add(cadena);
	        }
	        b.close();
	    }
			
		
		public static void insertaMapa(String cad) throws FileNotFoundException, IOException {
			String cadena;
			int cont=1;
			Map <Integer,String> mapa = new HashMap<>();
	        FileReader f = new FileReader(cad);
	        BufferedReader b = new BufferedReader(f);
	        
	        while((cadena = b.readLine())!=null) {
	        	mapa.put(cont,cadena);
	        	cont++;
	        }
	        b.close();
	    }

		
    public static void main(String[] args) throws IOException {
    	if (args != null  && args.length>0) {
    		muestraContenido(args [0]);
    		insertaLista(args[0]);
    		insertaMapa(args[0]);
    	} else {
    		System.out.println("Archivo no encontrado");
    	}
}
}
