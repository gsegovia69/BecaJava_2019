package paramo.de.la.programacion.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import paramo.de.la.programacion.entities.Clase;

public interface ClaseRepository extends Repository<Clase, Integer> {
	void delete(Clase clase);

	List<Clase> findAll();

	Optional<Clase> findById(int id);

	Clase save(Clase clase);
}
