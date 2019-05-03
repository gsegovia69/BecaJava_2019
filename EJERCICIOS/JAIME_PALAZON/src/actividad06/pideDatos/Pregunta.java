
package actividad06.pideDatos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Pregunta {
/* 
Desc: Pide una dato, lee por pantalla y devuelve ese dato. 
Input: necesita una pregunta (String).
Output: Devuelve un dato (int).
*/
   public static int pideEntero (String pregunta) { 
     
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 int dato = 0;
 String numero = "a"; 
 do{      
 try{   System.out.println(pregunta);
        numero = br.readLine();
        dato = Integer.parseInt (numero);
        if (numero.matches ("[0-9]+")){    
        }        
    }catch (NumberFormatException e){
        System.out.println("No es un número. Ha introducido caracteres.");
    }catch (IOException ex) { 
        Logger.getLogger(Pregunta.class.getName()).log(Level.SEVERE, null, ex);
    }
 }while(numero.matches("[a-z]+"));
 return dato;
 }
/*
Desc: Hace unn pregunta, lee por pantalla y devuelve un numero (double).
Input: Un pregunta (String).
Output: Devuelve un número (double).
*/
   public static double pideDouble (String recibido){
        
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    double dato=0;
String numero = "a"; 
 do{      
 try{   System.out.println(recibido);
         numero = br.readLine();
        dato = Double.parseDouble (numero);
        
        if (numero.matches ("[0-9]+")){
            
        }        
    }catch (NumberFormatException e){
        System.out.println("No es un número. Ha introducido unos caracteres.");   
    }catch (IOException ex) {
            Logger.getLogger(Pregunta.class.getName()).log(Level.SEVERE, null, ex);
    }
 }while(numero.matches("[a-z]+"));
 return dato;
}
}
