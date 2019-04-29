<<<<<<< HEAD
package beca.java.everis.read.faile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class ReadFaile{
	
	static int countStudent = 0;
	public static void main(String[] args) throws FileNotFoundException,IOException{
		
		System.out.println("---------------------ReadFile-----------------------");
		System.out.println(args[0]);
		System.out.println("--------------------------------------------");
		
		boolean bucle = true;
		
		while (bucle) {
			
			Scanner inmput = new Scanner(System.in);
			System.out.println("Entre la ruta del archivo :");
			String nameRuta = inmput.next();
			
			File file = new File(nameRuta);
			File afile;

			
			if (file.listFiles() != null) {

				if ((afile = findFile(file.listFiles())) != null) {
					
					List<Alumno> alumnos = addFlieListAlumno(afile);
					
					System.out.println("1-Ordenar por apellido y pintar el resultado");
					System.out.println("2-Ordenar por ciudad y pintar el resultado");
					System.out.println("3-Recorrer con stream y pintar el resultado");
					System.out.println("4-Recorrer con for tradicional y pintar el resultado");
					System.out.println("5-Filtrar por nombre Alejandro y pintar resultado");
					System.out.println("6-Filtrar cuyo nombre empice por A o por S y pintar resultado");
					System.out.println("7-Filtrar cuyo nombre contenga una A y pintar resultado");
					System.out.println("8-Rellenar una lista con los profesores y otra lista con los alumnos.Pintar los resultados");
                    System.out.println("9-Salir");


					System.out.println("Elija una opcion:");
					int opcion = inmput.nextInt();
					if(opcion != 0) {
						
						switch (opcion) {
						case 1:
							ordenaListApellidos(alumnos);
							countStudent= 0;
							alumnos.stream().forEach((e)-> {
								countStudent++;
								System.out.println("-------------------" + countStudent + "-------------------------");
								System.out.println(e.getaApellidos());
								});
						
	 						break;
	                     case 2:
							ordenaListCiudad(alumnos);
							countStudent= 0;
							alumnos.stream().forEach((e)-> {
								countStudent++;
								System.out.println("-------------------" + countStudent + "-------------------------");
								System.out.println(e.getaCiudad());
								});
	 						break;
	                     case 3:
							 countStudent= 0;

	                    	 ordenaListApellidos(alumnos);
	                    	 alumnos.stream().forEach((e)-> {
	     						countStudent++;
	     						System.out.println("-------------------" + countStudent + "-------------------------");
	     						System.out.println(String.format("%s %s", e.getaNombre(),e.getaApellidos()));
	     						System.out.println(e.getaEmail());
	     						System.out.println(e.getaCiudad());
	     						});
	 						break;
	                     case 4:
							countStudent= 0;
	                    	 ordenaListApellidos(alumnos);
	                    	 for (Alumno alumno : alumnos) {
	                    		 countStudent++;
	      						System.out.println("-------------------" + countStudent + "-------------------------");
	      						System.out.println(String.format("%s %s", alumno.getaNombre(),alumno.getaApellidos()));
	      						System.out.println(alumno.getaEmail());
	      						System.out.println(alumno.getaCiudad());
	                    	 }
	 						break;
	                      case 5:
	                    	 ordenaListApellidos(alumnos);
	                    	 alumnos
	                         .stream()
	                         .filter(Alumno::isAlejandro)
	                         .map(Alumno::getaAlumnos)
	                         .forEach(System.out::println);
	 						break;
	                      case 6:
	                     	 ordenaListApellidos(alumnos);
	                     	 alumnos
	                          .stream()
	                          .filter(Alumno::getNameAandS)
	                          .map(Alumno::getaAlumnos)
	                          .forEach(System.out::println);
	  						break;
	  						
	                      case 7:
	                      	 ordenaListApellidos(alumnos);
	                      	 alumnos
	                           .stream()
	                           .filter(Alumno::getNameContainsA)
	                           .map(Alumno::getaAlumnos)
	                           .forEach(System.out::println);
	   						break;
	                      case 8:
	                    	  countStudent = 0;
	    				      System.out.println("-------------------Lista de profesores-------------------------");
	    				      
	    				      addFlieListProfesor(afile).stream().forEach((e)-> {
	        						countStudent++;
	        						System.out.println("-------------------" + countStudent + "-------------------------");
	        						System.out.println(String.format("%s %s", e.getaNombre(),e.getaApellidos()));
	        						System.out.println(e.getaEmail());
	        						System.out.println(e.getaCiudad());

	        						});
	                    	  countStudent = 0;
	    				      System.out.println("-------------------Lista de alumnos-------------------------");

	                    	  addFlieListAlumno(afile).stream().forEach((e)-> {
	      						countStudent++;
	      						System.out.println("-------------------" + countStudent + "-------------------------");
	      						System.out.println(String.format("%s %s", e.getaNombre(),e.getaApellidos()));
	      						System.out.println(e.getaEmail());
	      						System.out.println(e.getaCiudad());

	      						});
	    						break;
	                      case 9:
	  						System.exit(1);
	 						break;
						default:
							break;
						}
						
					}
					
				}else {
					System.out.println("ruta no valida o no existe");
				}
				
			}else {
				
				System.out.println("ruta no valida o no existe");

				
			}
			
		}
	
	}
		
	public static void ordenaListApellidos(List<Alumno> listAlumnos) {
		Collections.sort(listAlumnos, new Comparator<Alumno>() {
			@Override
			public int compare(Alumno a1, Alumno a2) {
				return a1.getaApellidos().compareTo(a2.getaApellidos());
			}
		});
	  }
	public static void ordenaListCiudad(List<Alumno> listAlumnos) {
		Collections.sort(listAlumnos, new Comparator<Alumno>() {
			@Override
			public int compare(Alumno a1, Alumno a2) {
				return a1.getaCiudad().compareToIgnoreCase(a2.getaCiudad());
			}
		});
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
	
	public static List<Profesor> addFlieListProfesor(File file)throws FileNotFoundException,IOException{
		String linea;
		String nlinea;
		boolean bucle = true;
		BufferedReader br;
		FileReader fr;
		List<Profesor> listLineProfesor = new ArrayList<Profesor>();
		fr = new FileReader (file);
		br = new BufferedReader(fr);
		
		
		
		while (bucle) {
			linea = br.readLine(); 
			if (linea != null) {
				if(linea.contains("<profesor>")) {
					Profesor profesor = new Profesor();
					while (! (nlinea = br.readLine()).contains("</profesor>")) {
						if(nlinea.contains("<nombre>")) {
							profesor.setaNombre(nlinea.substring(nlinea.indexOf(ConstantUtils.INICIO_ITERACION_NOMBRE) + 8,nlinea.indexOf(ConstantUtils.FIN_ITERACION_NOMBRE)));
						}else if(nlinea.contains("<apellidos>")) {
							profesor.setaApellidos(nlinea.substring(nlinea.indexOf("<apellidos>") + 11,nlinea.indexOf("</apellidos>")));
						}else if(nlinea.contains("<email>")) {
							profesor.setaEmail(nlinea.substring(nlinea.indexOf("<email>") + 7,nlinea.indexOf("</email>")));
						}else if(nlinea.contains("<ciudad>")) {
							profesor.setaCiudad(nlinea.substring(nlinea.indexOf("<ciudad>") + 8,nlinea.indexOf("</ciudad>")));
						}
					}
					listLineProfesor.add(profesor);
				}
			}else {
				bucle = false;
			}
		}
		fr.close();
		return listLineProfesor;
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
	}
}
=======
package beca.java.everis.read.faile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class ReadFaile{
	
	static int countStudent = 0;
	public static void main(String[] args) throws FileNotFoundException,IOException{
		
		System.out.println("---------------------ReadFile-----------------------");
		System.out.println(args[0]);
		System.out.println("--------------------------------------------");
		
		boolean bucle = true;
		
		while (bucle) {
			
			Scanner inmput = new Scanner(System.in);
			System.out.println("Entre la ruta del archivo :");
			String nameRuta = inmput.next();
			
			File file = new File(nameRuta);
			File afile;

			
			if (file.listFiles() != null) {

				if ((afile = findFile(file.listFiles())) != null) {
					
					List<Alumno> alumnos = addFlieListAlumno(afile);
					
					System.out.println("1-Ordenar por apellido y pintar el resultado");
					System.out.println("2-Ordenar por ciudad y pintar el resultado");
					System.out.println("3-Recorrer con stream y pintar el resultado");
					System.out.println("4-Recorrer con for tradicional y pintar el resultado");
					System.out.println("5-Filtrar por nombre Alejandro y pintar resultado");
					System.out.println("6-Filtrar cuyo nombre empice por A o por S y pintar resultado");
					System.out.println("7-Filtrar cuyo nombre contenga una A y pintar resultado");
					System.out.println("8-Rellenar una lista con los profesores y otra lista con los alumnos.Pintar los resultados");
                    System.out.println("9-Salir");


					System.out.println("Elija una opcion:");
					int opcion = inmput.nextInt();
					if(opcion != 0) {
						
						switch (opcion) {
						case 1:
							ordenaListApellidos(alumnos);
							countStudent= 0;
							alumnos.stream().forEach((e)-> {
								countStudent++;
								System.out.println("-------------------" + countStudent + "-------------------------");
								System.out.println(e.getaApellidos());
								});
						
	 						break;
	                     case 2:
							ordenaListCiudad(alumnos);
							countStudent= 0;
							alumnos.stream().forEach((e)-> {
								countStudent++;
								System.out.println("-------------------" + countStudent + "-------------------------");
								System.out.println(e.getaCiudad());
								});
	 						break;
	                     case 3:
	                    	 ordenaListApellidos(alumnos);
	                    	 alumnos.stream().forEach((e)-> {
	     						countStudent++;
	     						System.out.println("-------------------" + countStudent + "-------------------------");
	     						System.out.println(String.format("%s %s", e.getaNombre(),e.getaApellidos()));
	     						System.out.println(e.getaEmail());
	     						System.out.println(e.getaCiudad());
	     						});
	 						break;
	                     case 4:
	                    	 ordenaListApellidos(alumnos);
	                    	 for (Alumno alumno : alumnos) {
	                    		 countStudent++;
	      						System.out.println("-------------------" + countStudent + "-------------------------");
	      						System.out.println(String.format("%s %s", alumno.getaNombre(),alumno.getaApellidos()));
	      						System.out.println(alumno.getaEmail());
	      						System.out.println(alumno.getaCiudad());
	                    	 }
	 						break;
	                      case 5:
	                    	 ordenaListApellidos(alumnos);
	                    	 alumnos
	                         .stream()
	                         .filter(Alumno::isAlejandro)
	                         .map(Alumno::getaAlumnos)
	                         .forEach(System.out::println);
	 						break;
	                      case 6:
	                     	 ordenaListApellidos(alumnos);
	                     	 alumnos
	                          .stream()
	                          .filter(Alumno::getNameAandS)
	                          .map(Alumno::getaAlumnos)
	                          .forEach(System.out::println);
	  						break;
	  						
	                      case 7:
	                      	 ordenaListApellidos(alumnos);
	                      	 alumnos
	                           .stream()
	                           .filter(Alumno::getNameContainsA)
	                           .map(Alumno::getaAlumnos)
	                           .forEach(System.out::println);
	   						break;
	   						
	                      case 8:
	                    	  countStudent = 0;
	    				      System.out.println("-------------------Lista de profesores-------------------------");
	    				      
	    				      addFlieListProfesor(afile).stream().forEach((e)-> {
	        						countStudent++;
	        						System.out.println("-------------------" + countStudent + "-------------------------");
	        						System.out.println(String.format("%s %s", e.getaNombre(),e.getaApellidos()));
	        						System.out.println(e.getaEmail());
	        						System.out.println(e.getaCiudad());

	        						});
	                    	  countStudent = 0;
	    				      System.out.println("-------------------Lista de alumnos-------------------------");

	                    	  addFlieListAlumno(afile).stream().forEach((e)-> {
	      						countStudent++;
	      						System.out.println("-------------------" + countStudent + "-------------------------");
	      						System.out.println(String.format("%s %s", e.getaNombre(),e.getaApellidos()));
	      						System.out.println(e.getaEmail());
	      						System.out.println(e.getaCiudad());

	      						});
	    						break;
	                      case 9:
	  						System.exit(1);
	 						break;
						default:
							break;
						}
						
					}
					
					
					//printContent(afile);
					//System.out.println(addFlieListAlumno(afile).size());
					//System.out.println(addFlieList(afile).size());
					//System.out.println((addFlieList(afile).get(4)));
					//System.out.println(addFlieMap(afile).size());
					//System.out.println((addFlieMap(afile).get(4)));
					
					/*System.out.println("---------------------------List Estudent--------------------");
					addFlieListAlumno(afile).stream().forEach((e)-> {
						countStudent++;
						System.out.println("-------------------" + countStudent + "-------------------------");
						System.out.println(String.format("%s %s", e.getaNombre(),e.getaApellidos()));
						System.out.println(e.getaEmail());
						System.out.println(e.getaCiudad());

						});*/					
					
					/*ordenaListCiudad(alumnos);
					countStudent= 0;
					alumnos.stream().forEach((e)-> {
						countStudent++;
						System.out.println("-------------------" + countStudent + "-------------------------");
						System.out.println(e.getaCiudad());
						});*/
					
					//break;
				}else {
					System.out.println("ruta no valida o no existe");
				}
				
			}else {
				
				System.out.println("ruta no valida o no existe");

				
			}
			
		}
	
	}
		
	public static void ordenaListApellidos(List<Alumno> listAlumnos) {
		Collections.sort(listAlumnos, new Comparator<Alumno>() {

			@Override
			public int compare(Alumno a1, Alumno a2) {
				return a1.getaApellidos().compareTo(a2.getaApellidos());

			}
		});
	  }
	
	public static void ordenaListCiudad(List<Alumno> listAlumnos) {
		Collections.sort(listAlumnos, new Comparator<Alumno>() {

			@Override
			public int compare(Alumno a1, Alumno a2) {
				return a1.getaCiudad().compareToIgnoreCase(a2.getaCiudad());

			}
		});
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

public static List<Profesor> addFlieListProfesor(File file)throws FileNotFoundException,IOException{

	String linea;
	String nlinea;
	boolean bucle = true;
	BufferedReader br;
	FileReader fr;
	List<Profesor> listLineProfesor = new ArrayList<Profesor>();
	
	fr = new FileReader (file);
	br = new BufferedReader(fr);
	
	while (bucle) {
		
		linea = br.readLine(); 
		
		if (linea != null) {
			
			if(linea.contains("<profesor>")) {
				
				
				Profesor profesor = new Profesor();

				
				while (! (nlinea = br.readLine()).contains("</profesor>")) {
					
					
					if(nlinea.contains("<nombre>")) {
						
						profesor.setaNombre(nlinea.substring(nlinea.indexOf(ConstantUtils.INICIO_ITERACION_NOMBRE) + 8,nlinea.indexOf(ConstantUtils.FIN_ITERACION_NOMBRE)));

											
					}else if(nlinea.contains("<apellidos>")) {
						
						profesor.setaApellidos(nlinea.substring(nlinea.indexOf("<apellidos>") + 11,nlinea.indexOf("</apellidos>")));

											
					}else if(nlinea.contains("<email>")) {
						
						profesor.setaEmail(nlinea.substring(nlinea.indexOf("<email>") + 7,nlinea.indexOf("</email>")));

											
					}else if(nlinea.contains("<ciudad>")) {
						
						profesor.setaCiudad(nlinea.substring(nlinea.indexOf("<ciudad>") + 8,nlinea.indexOf("</ciudad>")));

											
					}
					

					
				}
				
				
				listLineProfesor.add(profesor);
				

				
			}
			
			
		}else {
			
			bucle = false;
			
		}

	}
	
	fr.close();
	
	return listLineProfesor;
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
>>>>>>> bb33ac3045357297ed8a4f4c6003548bad2901f4
