package com.everis.beca.BaseDeDatos;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.everis.beca.BaseDeDatos.dto.Alumno;
import com.everis.beca.BaseDeDatos.dto.Clase;
import com.everis.beca.BaseDeDatos.dto.Profesor;

public class JPA_Persistance {

	public static void main(String[] args) {
	   
	    	
	    }
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*
	public static void main(String[] args) {
	    EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Persistance");
		EntityManager em = emfactory.createEntityManager();

		em.getTransaction().begin();
		Profesor prof = new Profesor();
		prof.setApellidos("apellido1 apellido2");
		prof.setNombre("Nombre");
		em.persist(prof);
		em.getTransaction().commit()
	
		
		List<Clase> lista=em.createQuery("SELECT c FROM Clase c ", Clase.class).getResultList();
	    
	    for(Clase c: lista) {
	    	System.out.println(c.getNombre());

	    	c.getProfesores().stream().forEach(p-> System.out.println("    " + p.getNombre()+ " "+p.getApellidos()));
	    	
	    	c.getAlumnos().stream().forEach(al -> System.out.println("    "+ al.getNombre() + " " + al.getApellidos()));
	    	
	    	c.getAsignaturas().stream().forEach(as -> System.out.println("    "+ as.getNombre()));
	    	
	    	
	    }
		
	}
*/
}
