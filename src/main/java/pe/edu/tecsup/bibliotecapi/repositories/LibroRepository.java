package pe.edu.tecsup.bibliotecapi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pe.edu.tecsup.bibliotecapi.entities.Libro;

public interface LibroRepository extends CrudRepository<Libro, Long> {
	@Override
	List<Libro> findAll();
}
