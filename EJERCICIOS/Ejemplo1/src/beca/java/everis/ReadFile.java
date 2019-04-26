package beca.java.everis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReadFile {

	public static void main(String[] args) {
		String fileName = "C:\\beca_java_2019\\EJERCICIOS\\alumnos.xml";
//		read1(fileName);
//		read2(fileName);
//		read3(fileName);
//		read4(fileName);
//		read5(fileName);
//		read6(fileName);
		listaProfesor(fileName);
	}

	private static void read1(String fileName) {
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------");
		System.out.println("                 READ1                 ");
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------");
		List<String> list = new ArrayList<>();
		try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName), StandardCharsets.ISO_8859_1)) {
			list = br.lines().collect(Collectors.toList());
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		list.forEach(System.out::println);
	}

	private static void read2(String fileName) {
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------");
		System.out.println("                 READ2                 ");
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------");
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}

	private static void read3(String fileName) {
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------");
		System.out.println("                 READ3                 ");
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------");
		try (Scanner scanner = new Scanner(new File(fileName))) {
			while (scanner.hasNext()) {
				System.out.println(scanner.nextLine());
			}
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}

	private static void read4(String fileName) {
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------");
		System.out.println("                 READ4                 ");
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------");
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName), StandardCharsets.ISO_8859_1)) {
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		System.out.println(sb);
	}

	private static void read5(String fileName) {
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------");
		System.out.println("                 READ5                 ");
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------");
		try (FileReader reader = new FileReader(fileName); BufferedReader br = new BufferedReader(reader)) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}
	}

	private static void read6(String fileName) {
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------");
		System.out.println("                 READ6                 ");
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------");
		BufferedReader br = null;
		FileReader fr = null;
		//List<String> lista = new ArrayList<String>();
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			String line;
			List<String> lista = br.lines().collect(Collectors.toList());
			List<String> lista2 = new ArrayList<>();
			while ((line = br.readLine()) != null) {
				lista2.add(line);
			}
		
		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				System.err.format("IOException: %s%n", ex);
			}
		}
	}
	

	
	public static void listaProfesor(String fileName) {
		FileReader leer = null;
		BufferedReader temp = null;
		try {
			leer = new FileReader(fileName);
			temp = new BufferedReader(leer);
			String linea = "";
			boolean newRow = false;
			List<Profesor> lista = new ArrayList<Profesor>();
			Profesor p = null;
			while ((linea = temp.readLine()) != null) {
				if(linea.trim().equalsIgnoreCase(ConstantUtils.INICIO_ITERACION_PROFESOR)) {
					p = new Profesor();
					newRow = true;
				}
				if(newRow && linea.trim().contains(ConstantUtils.INICIO_ITERACION_NOMBRE)) {
					p.setNombre(linea);
				}
				if(newRow && linea.trim().contains(ConstantUtils.INICIO_ITERACION_APELLIDOS)) {
					p.setApellidos(linea);
				}
				if(newRow && linea.trim().contains(ConstantUtils.INICIO_ITERACION_EMAIL)) {
					p.setEmail(linea);
				}
				if(newRow && linea.trim().contains(ConstantUtils.INICIO_ITERACION_CIUDAD)) {
					p.setCiudad(linea);
				}
				if(newRow && linea.trim().contains(ConstantUtils.FIN_ITERACION_PROFESOR)) {
					lista.add(p);
					newRow = false;
				}
			}
			lista.forEach(System.out::println);
			//lista.stream().filter(profe -> profe.getCiudad().contains("Alicante")).forEach(System.out::println);
//			for(Profesor pr : lista) {
//				System.out.println(pr.toString());
//			}
		} catch (Exception e) {
		} finally {
			if(temp != null) {
				try {
					temp.close();
				} catch (IOException e) {}
			}
			if(leer != null) {
				try {
					leer.close();
				} catch (IOException e) {}
			}
		}
	}


}
