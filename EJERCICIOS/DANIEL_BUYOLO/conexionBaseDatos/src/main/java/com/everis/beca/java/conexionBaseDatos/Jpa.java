package com.everis.beca.java.conexionBaseDatos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.everis.beca.java.conexionBaseDatos.dto.Clase;

public class Jpa {
	public static void main(String[] args) {

		EntityManagerFactory cursoFactory = Persistence.createEntityManagerFactory("becaJava");

		EntityManager cursoManager = cursoFactory.createEntityManager();

		List<Clase> listaCursos = cursoManager.createQuery("select c from Clase c",Clase.class).getResultList();
		
		for (Clase c : listaCursos) {
			System.out.println("---------------------------");
			System.out.println("---------------------------");
			System.out.println("---------------------------");
			System.out.println("Curso ---> "+ c.getNombreClase());
			c.getAlumnos().stream().forEach(s -> System.out.println(s.getNombreAlumno() + " " + s.getApellidosAlumno()));
		}
			
		
	}
}
