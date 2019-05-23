package paramo.de.la.programacion.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import paramo.de.la.programacion.entities.Profesor;

public interface ProfesorRepository extends CrudRepository<Profesor, Integer> {
	void delete(Profesor profresor);

	List<Profesor> findAll();

	Optional<Profesor> findById(Long id);

	@SuppressWarnings("unchecked")
	Profesor save(Profesor profesor);

	@Query(value = "Select * from Profesor a where a.email = :email and a.ciudad = :ciudad order by a.nombre, a.ciudad desc", nativeQuery = true)
	public List<Profesor> obtenerProfesoresFiltrandoPorEmailOrdenadoPorCiudadDescNombreAsc(@Param("email") String email,
			@Param("ciudad") String ciudad);

}

/*
 * 1. Método con consulta JPQL para obtener un listado de alumnos filtrando por
 * Nombre y ordenando por Apellidos de forma descendente 2. Método con consulta
 * SQL para obtener un listado de Profesores filtrando por Email y ordenando por
 * Nombre de forma ascendente y por Ciudad de forma descendente 3. En ambos
 * casos, en sus respectivos Manager, hacer llamadas a esos métodos creados en
 * sus repositorios para realizar el mágico y curioso enlace entre Vista y
 * Modelo
 */