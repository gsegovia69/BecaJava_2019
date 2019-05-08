package everis.beca.java.practicas.mavenPrueba;

import java.util.List;

import javax.persistence.EntityManager;

import everis.beca.java.practicas.mavenPrueba.dto.Clase;

public class Pruebas {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		List<Clase> query = em.createQuery("SELECT c FROM Clase c", Clase.class).getResultList();
		for (Clase c: query) {
			System.out.println("CURSO ->"+ c.getNombre().toString().toUpperCase());
			System.out.println("----------------------------------------------------");
			System.out.println("PROFESORES");
			System.out.println("----------------------------------------------------");
			c.getProfesores().stream().forEach(p -> System.out.println("     "+ p.getNombre() + " " + p.getApellidos()));
			System.out.println("----------------------------------------------------");
			System.out.println("ALUMNOS");
			System.out.println("----------------------------------------------------");
			c.getAlumnos().stream().forEach(a -> System.out.println("     "+ a.getNombre() + " " + a.getApellidos()));
			System.out.println("----------------------------------------------------");
			System.out.println("ASIGNATURAS");
			System.out.println("----------------------------------------------------");
			c.getAsignaturas().stream().forEach(as -> System.out.println("     "+ as.getNombre()));
			System.out.println("----------------------------------------------------");
			System.out.println("----------------------------------------------------");
			System.out.println("----------------------------------------------------");
		}
		

	}
}
