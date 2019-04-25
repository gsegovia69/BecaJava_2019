
package actividad06;

import actividad06.borraArchivos.borraArchivos;
import actividad06.pideDatos.Pregunta;
import actividad06.creaArchivo.creaArchivo;
import actividad06.listarArchivos.listarArchivos;
import actividad06.modificaArchivo.modificaArchivo;
import actividad06.muestraArchivo.muestraArchivo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import actividad06.renombrarArchivo.renombrarArchivo;


public class Ejercicio01 {
    public static void main (String [] arg) throws IOException{

        String separador = File.separator;
        String rutaProyecto = System.getProperty("user.dir");
        String rutaCarpeta = rutaProyecto + separador + "archivos";
        File carpeta = new File(rutaCarpeta);
        
        
        if (!carpeta.exists()) {
            carpeta.mkdir(); // Creamos la carpeta utilizando el método mkdir
        } else {
            System.out.println("La carpeta ya existe");
        }

        
int dato;
   do{
        System.out.println("Menú:\n" +
"1.- Crear nuevo archivo.\n" +
"2.- Listar archivos.\n" +
"3.- Muestra un archivo.\n" +
"4.- Borrar un archivo.\n" +
"5.- Modificar un archivo.\n" +              
"6.- Renombrar un archivo.\n" +
"7.- No quiero realizar ninguna operación"); 

String pregunta= "Introduzca un número del menu: ";
dato = Pregunta.pideEntero(pregunta);

if (dato<0){System.out.println("Se ha introducido un número negativo.");}
if (dato>7){System.out.println("Se ha introducido un número que no corresponde"
        + " con el menú. ");}
switch (dato) {
    case 1 : 
        
    Scanner sc = new Scanner(System.in); 
        System.out.println("Introduce el nombre del achivo:");
        String nombre = sc.next()+".txt";
        creaArchivo.creaArchivo(nombre);
      ;break;       
    case 2 : 
        listarArchivos.listarArchivos();
        ;break;
    case 3 :
        muestraArchivo.muestraArchivo();
        ;break;
    case 4 :
        borraArchivos.borraArchivos();
            ;break;
    case 5 :
        modificaArchivo.modificaArchivo();
            ;break;
    case 6 :
        renombrarArchivo.renombrarArchivo();
            ;break;
    case 7 : 
        System.out.println("Hasta la próxima.")
            ;break;
}

}while (dato != 7);
}
}
    

