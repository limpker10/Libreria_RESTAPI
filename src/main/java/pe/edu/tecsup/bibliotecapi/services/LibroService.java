package pe.edu.tecsup.bibliotecapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.tecsup.bibliotecapi.entities.Libro;

@Service
public interface LibroService {
	
	public List<Libro> findAll();

	public Libro findById(Long id);

	public void save(Libro libro);

	public void deleteById(Long id);
}
