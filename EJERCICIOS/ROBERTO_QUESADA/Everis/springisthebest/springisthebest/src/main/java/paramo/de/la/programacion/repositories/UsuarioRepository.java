package paramo.de.la.programacion.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import paramo.de.la.programacion.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	void delete(Usuario usuario);

	List<Usuario> findAll();

	Optional<Usuario> findById(Long id);

	@SuppressWarnings("unchecked")
	Usuario save(Usuario Usuario);
}
