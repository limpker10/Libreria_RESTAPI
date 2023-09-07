package pe.edu.tecsup.bibliotecapi.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.tecsup.bibliotecapi.entities.Libro;
import pe.edu.tecsup.bibliotecapi.services.LibroService;

@RestController
@RequestMapping("/api")
public class LibroController {
	private static final Logger logger = LoggerFactory.getLogger(LibroController.class);

	@Autowired
	private LibroService libroService;

	@GetMapping("/libros")
	public ResponseEntity<List<Libro>> obtenerLibros() {
		try {
			List<Libro> libros = libroService.findAll();
			logger.info("Libros encontrados: " + libros.size());

			if (libros.isEmpty()) {
				return ResponseEntity.noContent().build();
			} else {
				return ResponseEntity.ok(libros);
			}
		} catch (Exception e) {
			logger.error("Error al obtener libros", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/libros/{id}")
    public ResponseEntity<Libro> obtenerLibroPorId(@PathVariable Long id) {
        try {
            
            Libro libro = libroService.findById(id);
            
            if (libro != null) {
                return ResponseEntity.status(HttpStatus.OK).body(libro);
            } else {
            	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

	@PostMapping("/libros")
	public ResponseEntity<Libro> crearLibro(@RequestBody Libro nuevoLibro) {
		try {
			libroService.save(nuevoLibro);
			logger.info("Libro creado: " + nuevoLibro);
			return ResponseEntity.status(HttpStatus.CREATED).body(nuevoLibro);
		} catch (Exception e) {
			logger.error("Error al crear libros", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/libro/{id}")
	public ResponseEntity<String> eliminarLibro(@PathVariable Long id) {
		try {
			if (!libroService.existsById(id)) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("El libro con ID " + id + " no se encuentra.");
			}

			libroService.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK)
					.body("El libro con ID " + id + " ha sido eliminado correctamente.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el libro.");
		}
	}

}
