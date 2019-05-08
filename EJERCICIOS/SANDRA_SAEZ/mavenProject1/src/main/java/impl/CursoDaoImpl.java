package impl;
import com.everis.formacion.mavenProject1.dto.*;
import java.util.List;

import javax.persistence.EntityManager;
import com.everis.formacion.mavenProject1.dto.Curso;



public class CursoDaoImpl {
	private EntityManager em;
	
	private int save(Curso curso)
	{
		em.persist(curso);
		return curso.getIdCurso();
	}
	
//	public List<Curso>  cursos = new List<Curso>();
}
