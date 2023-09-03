package pe.edu.tecsup.bibliotecapi.services;

import java.util.List;

import pe.edu.tecsup.bibliotecapi.entities.Libro;


public interface LibroService {
	
	public List<Libro> findAll();

	public Libro findById(Long id);

	public void save(Libro libro);

	public void deleteById(Long id);
	
	public Boolean existsById(Long id);
}
