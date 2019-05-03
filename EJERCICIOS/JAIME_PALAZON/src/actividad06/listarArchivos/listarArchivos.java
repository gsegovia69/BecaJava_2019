
package actividad06.listarArchivos;

import java.io.File;


public class listarArchivos {
    public static String [] listarArchivos () {
        String separador = File.separator;
        String rutaProyecto = System.getProperty("user.dir");
        String rutaCarpeta = rutaProyecto + separador + "archivos";
        File carpeta = new File(rutaCarpeta);
         
        String[] arrayArchivos = carpeta.list();                        
        for(int i = 0; i < arrayArchivos.length; i++){
            String nombreFichero = arrayArchivos[i];
            System.out.println((i + 1) + " - " + nombreFichero);}
            return arrayArchivos;

} 
}
