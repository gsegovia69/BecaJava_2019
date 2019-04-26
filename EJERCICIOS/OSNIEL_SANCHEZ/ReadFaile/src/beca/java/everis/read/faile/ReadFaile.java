package beca.java.everis.read.faile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class ReadFaile {

	public static void main(String[] args) throws FileNotFoundException,IOException{
		
		System.out.println("---------------------ReadFile-----------------------");
		System.out.println(args[0]);
		System.out.println("--------------------------------------------");
		
		while (true) {
			
			Scanner inmput = new Scanner(System.in);
			System.out.println("Entre la ruta del archivo :");
			String nameRuta = inmput.next();
			
			File file = new File(nameRuta);
			File afile;

			
			if (file.listFiles() != null) {

				if ((afile = findFile(file.listFiles())) != null) {
					
					printContent(afile);
					System.out.println(addFlieListAlumno(afile).size());
					System.out.println(addFlieList(afile).size());
					System.out.println((addFlieList(afile).get(4)));
					System.out.println(addFlieMap(afile).size());
					System.out.println((addFlieMap(afile).get(4)));
					
					System.out.println("---------------------------List Estudent--------------------");
					
					addFlieListAlumno(afile).stream().forEach((e)-> {
						System.out.println(String.format("%s %s", e.getaNombre(),e.getaApellidos()));
						System.out.println(e.getaEmail());
						System.out.println(e.getaCiudad());
						System.out.println("--------------------------------------------");

						});
					


					
					break;
					
				}else {
					
					System.out.println("ruta no valida o no existe");

					
				}
				
			}else {
				
				System.out.println("ruta no valida o no existe");

				
			}
			
		}
		

	

	}
	
	public static boolean isA() {
	    return true;
	  }
	
    public static File findFile(File[] fileList) {
    	
    	File file = null;
    	
    	
        for (File files : fileList) {
			
			if (files.isFile() && files.getName().equals("alumnos.xml")) {
				
				file = files;
                break;						
				
			}
			
			
		}
    	
    	return file;
		
	}
    
    public static Map<Integer,String> addFlieMap(File file)throws FileNotFoundException,IOException{
		
		String linea;
		boolean bucle = true;
		BufferedReader br;
		FileReader fr;
		Map<Integer, String> mapLine = new HashMap<Integer,String>();
		int count = 0;
		
		fr = new FileReader (file);
		br = new BufferedReader(fr);
		
		while (bucle) {
			
			linea = br.readLine();
			
			if (linea != null) {
				
				mapLine.put(count, linea);
				count ++;
				
			}else {
				
				bucle = false;
				
			}

		}
		
		fr.close();
		
		return mapLine;
	}
    
    
    
public static List<Alumno> addFlieListAlumno(File file)throws FileNotFoundException,IOException{

		String linea;
		String nlinea;
		boolean bucle = true;
		BufferedReader br;
		FileReader fr;
		List<Alumno> listLineAlumno = new ArrayList<Alumno>();
		
		fr = new FileReader (file);
		br = new BufferedReader(fr);
		
		while (bucle) {
			
			linea = br.readLine(); 
			
			if (linea != null) {
				
				if(linea.contains("<alumno>")) {
					
					
					Alumno alumno = new Alumno();

					
					while (! (nlinea = br.readLine()).contains("</alumno>")) {
						
						
						if(nlinea.contains("<nombre>")) {
							
							alumno.setaNombre(nlinea.substring(nlinea.indexOf(ConstantUtils.INICIO_ITERACION_NOMBRE) + 8,nlinea.indexOf(ConstantUtils.FIN_ITERACION_NOMBRE)));

												
						}else if(nlinea.contains("<apellidos>")) {
							
							alumno.setaApellidos(nlinea.substring(nlinea.indexOf("<apellidos>") + 11,nlinea.indexOf("</apellidos>")));

												
						}else if(nlinea.contains("<email>")) {
							
							alumno.setaEmail(nlinea.substring(nlinea.indexOf("<email>") + 7,nlinea.indexOf("</email>")));

												
						}else if(nlinea.contains("<ciudad>")) {
							
							alumno.setaCiudad(nlinea.substring(nlinea.indexOf("<ciudad>") + 8,nlinea.indexOf("</ciudad>")));

												
						}
						

						
					}
					
					
					listLineAlumno.add(alumno);
					

					
				}
				
				
			}else {
				
				bucle = false;
				
			}

		}
		
		fr.close();
		
		return listLineAlumno;
	}
	
	public static List<String> addFlieList(File file)throws FileNotFoundException,IOException{
		
		String linea;
		boolean bucle = true;
		BufferedReader br;
		FileReader fr;
		List<String> listLine = new ArrayList<String>();
		
		fr = new FileReader (file);
		br = new BufferedReader(fr);
		
		while (bucle) {
			
			linea = br.readLine();
			
			if (linea != null) {
				
				listLine.add(linea);
				
			}else {
				
				bucle = false;
				
			}

		}
		
		fr.close();
		
		return listLine;
	}
	
	public static void printContent(File file)throws FileNotFoundException,IOException{
		
		String linea;
		boolean bucle = true;
		BufferedReader br;
		FileReader fr;		
		System.out.println("---------------------Ready-----------------------");

		
		fr = new FileReader (file);
		br = new BufferedReader(fr);
		
		while (bucle) {
			
			linea = br.readLine();
			
			if (linea != null) {
				
				System.out.println(linea);
				System.gc();
				
			}else {
				
				bucle = false;
				
			}

		}
		
		fr.close();
		
		System.out.println("----------------------------------");

		/*Arrays.asList(fileList)
		.stream()
		.filter(fichero -> fichero.isFile())
		.forEach(fichero -> System.out.println(fichero.getName()));*/	
			
		}

}
