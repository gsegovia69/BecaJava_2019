
package actividad06.creaArchivo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class creaArchivo {

    public static void creaArchivo (String nombreArchivo) throws IOException{
        //Definir el separador para las rutas de las carpetas según el SO -> /
        String separador = File.separator;

        //Definir la ruta hasta dónde está nuestro proyecto
        String rutaProyecto = System.getProperty("user.dir");

        //Montar la ruta del proyecto para generar la carpeta 
        String rutaArchivo = rutaProyecto + separador + "archivos";

        //Utilizaremos el objeto file para crear nuestra carpeta en la ruta que le hemos indicado        
        File archivo = new File(rutaArchivo);
        
        FileWriter fw = new FileWriter(rutaArchivo + separador + nombreArchivo);
        
        System.out.println("Introduce el contenido del fichero:");
        Scanner sc = new Scanner(System.in);
        String contenido = sc.nextLine();
        
        //Para escribir en el fichero hemos de utilizar el Buffer de escritura
        //este nos permitira escribir String en lugar de bytes.
        BufferedWriter bw = new BufferedWriter(fw);
        //Escribir en el fichero
        bw.write(contenido);
        //Obligar al buffer a que guarde los cambios realizados en el fichero
        bw.flush();
        //Cerrar el buffer y vaciarlo
        bw.close();
        
        
        
        
    }

        
}
    

