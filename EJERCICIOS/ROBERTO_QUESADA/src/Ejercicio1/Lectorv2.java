package Ejercicio1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Lectorv2 {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("../alumnos.xml");
		BufferedReader bf = new BufferedReader(fr);
		Files.lines(Paths.get("../alumnos.xml")).forEach(System.out::println);
		bf.close();
	}
	
}
