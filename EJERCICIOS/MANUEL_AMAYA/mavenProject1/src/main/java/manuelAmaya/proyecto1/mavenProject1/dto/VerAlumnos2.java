package manuelAmaya.proyecto1.mavenProject1.dto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class VerAlumnos2 {
	private Clase miclase;
	public VerAlumnos2(Clase miclase) {
		this.miclase = miclase;
	}
	
	/* Fecha fecha = new Fecha();
	 * clase.getListaAlumnos.stream().filter(alu -> alu.getCiudades().toLowerCase().startsWith("a")).forEach(a -> {System.out.println(fecha.getFechaMesDia() +
	 * "-- Nombre: " + alu.getNombre() + " " + alu.getApellidos() + ", Email: " + alu.getEmail() + ", Ciudad: " + alu.getCiudades())});
	*/
	
	public void listarAlumnos() {
		List<Alumno> listaord = miclase.getListaAlumnos().stream().filter(alu -> alu.getCiudades().toLowerCase().startsWith("a")).collect(Collectors.toList());
		
		for(Alumno alu : listaord) {
			Fecha fecha = new Fecha();
			System.out.println(fecha.getFechaMesDia() +
					" -- Nombre: " + alu.getNombre() + " " + alu.getApellidos() + ", Email: " + alu.getEmail() + ", Ciudad: " + alu.getCiudades());
		}
	}
}
