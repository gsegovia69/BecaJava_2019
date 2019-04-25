package actividad06.modificaArchivo;

import actividad06.pideDatos.Pregunta;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;




public class modificaArchivo {
    
    public static void modificaArchivo() {
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
        
        }while (dato1 > arrayArchivos.length || dato1 < 1 );  
          try{
            Scanner sc = new Scanner(System.in); 
            System.out.println("Introduce el nuevo texto:");
            String nombre = sc.nextLine();
            FileWriter fw2 = new FileWriter(rutaCarpeta + separador + arrayArchivos[dato1-1]);
            BufferedWriter bw2 = new BufferedWriter(fw2);
            bw2.write(nombre);
            bw2.flush();
            bw2.close();
            System.out.println("Fichero modificado con éxito");
           
        }catch(IOException ex){
            System.out.println("No he podido leer o escribir el fichero");
            System.out.println("El error es: " + ex.getMessage());
        }
    

}
    
}
