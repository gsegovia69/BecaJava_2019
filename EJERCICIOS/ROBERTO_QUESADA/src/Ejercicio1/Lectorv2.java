package Ejercicio1;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Lectorv2 {

	public static void main(String[] args) throws IOException {
		Files.lines(Paths.get("../alumnos.xml"),StandardCharsets.ISO_8859_1).forEach(System.out::println);
	}
	
}
