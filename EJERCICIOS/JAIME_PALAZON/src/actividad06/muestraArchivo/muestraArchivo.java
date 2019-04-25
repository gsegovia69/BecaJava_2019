
package actividad06.muestraArchivo;

import actividad06.pideDatos.Pregunta;
import actividad06.listarArchivos.listarArchivos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class muestraArchivo {
    public static void muestraArchivo (){
        String separador = File.separator;
        String rutaProyecto = "C:\\Users\\Administrador\\Documents\\GitHub\\BecaJava_2019\\EJERCICIOS\\JAIME_PALAZON";
        String rutaCarpeta = rutaProyecto + separador + "archivos";
        File carpeta = new File(rutaCarpeta);
         
        String[] arrayArchivos = carpeta.list();                        
        for(int i = 0; i < arrayArchivos.length; i++){
            String nombreFichero = arrayArchivos[i];
            System.out.println((i + 1) + " - " + nombreFichero);}
        int dato1;  
      do{
        String numeroArchivo =("Introduce el número del archivo seleccionado: ");
        dato1= Pregunta.pideEntero(numeroArchivo);
        if (dato1<0){System.out.println("Se ha introducido un número negativo");}
        if (dato1>arrayArchivos.length){System.out.println("Se ha introducido un"
                + " número no válido");}
        }while (dato1>arrayArchivos.length || dato1 < 1);
          System.out.println(arrayArchivos[dato1 - 1]);
          
     try{
        FileReader fr = new FileReader(rutaCarpeta + separador + arrayArchivos[dato1-1]);
        BufferedReader br = new BufferedReader(fr);

            String linea = "";

            while(linea != null){
                System.out.println(linea);
                linea = br.readLine();
            }
            br.close();
            
        }catch(IOException e){
            System.out.println("No he podido leer del fichero");
            System.out.println("El error es:" + e.getMessage());
        }
        
        
        
        
    }
    
}
