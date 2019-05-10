package com.everis.java.formacion.jpa.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.everis.java.formacion.jpa.dto.Curso;

@Transactional
public class CursoDaoImpl {

	@PersistenceContext
	private EntityManager em;
	
	
	public int save(Curso curso) {
		em.persist(curso);
		return curso.getIdClase();
	}
	
	public List<Curso> getAll() {
		return em.createQuery("SELECT c FROM Curso c", Curso.class).getResultList();
	}
	
}
