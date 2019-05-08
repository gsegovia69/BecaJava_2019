package everis.beca.java.practicas.mavenPrueba;

import javax.persistence.EntityManager;

import everis.beca.java.practicas.mavenPrueba.dto.Alumno;

public class DAOalumno {
	public static Alumno find(int id){
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		Alumno alumno = null;
		try{
		alumno = em.find(Alumno.class, id);
		System.out.println(alumno);
		}catch(Exception ex){
		System.out.println("upss!! ha ocurrido un error");
		ex.printStackTrace();
		}
		finally{
		em.close();
		}
		return alumno;
		}
}
