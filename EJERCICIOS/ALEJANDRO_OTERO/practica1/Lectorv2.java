package Ejercicio1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Lectorv2 {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("../alumnos.xml");
		BufferedReader br = new BufferedReader(fr);
		Files.lines(Paths.get("../alumnos.xml"), StandardCharsets.ISO_8859_1);// .forEach(System.out::println);
		List<String> lista = br.lines().collect(Collectors.toList());
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}

		// System.out.println(lista2);

		br.close();
	}

}
