
package actividad06.renombrarArchivo;

import actividad06.pideDatos.Pregunta;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class renombrarArchivo {
    public static void renombrarArchivo (){
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
        String numeroArchivo =("Introduce el número del archivo para modificar: ");
        dato1= Pregunta.pideEntero(numeroArchivo);
        if (dato1<0){System.out.println("Se ha introducido un número negativo");}
        if (dato1>arrayArchivos.length){System.out.println("Se ha introducido un"
                + " número no válido");}
        }while (dato1>arrayArchivos.length || dato1 < 1);
          System.out.println(arrayArchivos[dato1 - 1]);
          
        
        File ficheroAntiguo = new File(rutaCarpeta + separador + arrayArchivos[dato1-1]);
        Scanner sc = new Scanner(System.in); 
        System.out.println("Introduce el nuevo nombre del achivo:");
        String nombre = sc.next()+".txt";
    
        File ficheroNuevo = new File(rutaCarpeta + separador + nombre);
        
        
        ficheroAntiguo.renameTo(ficheroNuevo);
    
    
    }
}
