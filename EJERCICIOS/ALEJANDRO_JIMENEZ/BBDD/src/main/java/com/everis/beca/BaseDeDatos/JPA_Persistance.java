package com.everis.beca.BaseDeDatos;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPA_Persistance {

	public static void main(String[] args) {
	    EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Persistance");
		EntityManager entitymanager = emfactory.createEntityManager();
		Query query = entitymanager.createQuery("SELECT nombre FROM Alumno");
	    List<String> lista=query.getResultList();
	    
	    for(String e:lista) {
	    	System.out.println(e);
	    }
		
	}

}
