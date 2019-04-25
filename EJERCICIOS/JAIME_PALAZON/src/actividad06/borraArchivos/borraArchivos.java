
package actividad06.borraArchivos;

import actividad06.pideDatos.Pregunta;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class borraArchivos {
    public static void borraArchivos (){
        
       String separador = File.separator;
        String rutaProyecto = System.getProperty("user.dir");
        String rutaCarpeta = rutaProyecto + separador + "archivos";
        File carpeta = new File(rutaCarpeta);
         
        String[] arrayArchivos = carpeta.list();                        
        for(int i = 0; i < arrayArchivos.length; i++){
            String nombreFichero = arrayArchivos[i];
            System.out.println((i + 1) + " - " + nombreFichero);}
        int dato1;  
      do{
        String numeroArchivo =("Introduce el número del archivo para borrar: ");
        dato1= Pregunta.pideEntero(numeroArchivo);
        if (dato1<0){System.out.println("Se ha introducido un número negativo");}
        if (dato1>arrayArchivos.length){System.out.println("Se ha introducido un"
                + " número no válido");}
        }while (dato1>arrayArchivos.length || dato1 < 1);
        
        File ficheroBorrar = new File(rutaCarpeta + separador + arrayArchivos [dato1-1]);
        
        ficheroBorrar.delete();
        System.out.println("El archivo ha sido borrado");
          
     
        
        
        
        
          
    
    }
    
}
