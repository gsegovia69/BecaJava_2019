package manuelAmaya.proyecto1.mavenProject1.dto;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

public class VerAlumnos1 {
	private Clase miclase;
	public VerAlumnos1(Clase miclase) {
		this.miclase = miclase;
	}
	
	
	
	public void listarAlumnos() {
		List<Alumno> listaord = miclase.getListaAlumnos().stream().sorted(Comparator.comparing(Alumno::getNombre)).sorted(Comparator.comparing(Alumno::getApellidos2)).collect(Collectors.toList());
		
		for(Alumno alu : listaord) {
			Fecha fecha = new Fecha();
			System.out.println(fecha.getFechaDiaMes() +
					"-- Nombre: " + alu.getNombre() + " " + alu.getApellidos() + ", Email: " + alu.getEmail() + ", Ciudad: " + alu.getCiudades());
		}
	}
}
