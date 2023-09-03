package pe.edu.tecsup.bibliotecapi.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.tecsup.bibliotecapi.entities.Libro;
import pe.edu.tecsup.bibliotecapi.repositories.LibroRepository;

@Service
@Transactional
public class LibroServiceImpl implements LibroService{
	
	@Autowired
	private LibroRepository libroRepository;

	@Override
	public List<Libro> findAll() {
		return libroRepository.findAll();
	}

	@Override
	public Libro findById(Long id) {
		return libroRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No existe registro"));
	}
	
	@Override
	public void save(Libro libro) {
		libroRepository.save(libro);
	}

	@Override
	public void deleteById(Long id) {
		libroRepository.deleteById(id);
	}

	@Override
	public Boolean existsById(Long id) {
		return libroRepository.existsById(id);
	}

}
