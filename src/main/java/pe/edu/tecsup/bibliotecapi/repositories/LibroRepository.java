package pe.edu.tecsup.bibliotecapi.repositories;

import org.springframework.data.repository.CrudRepository;

import pe.edu.tecsup.bibliotecapi.entities.Libro;

public interface LibroRepository extends CrudRepository<Libro, Long>{
	
}
