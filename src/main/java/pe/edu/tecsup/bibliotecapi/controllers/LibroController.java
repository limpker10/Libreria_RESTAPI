package pe.edu.tecsup.bibliotecapi.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.tecsup.bibliotecapi.entities.Libro;
import pe.edu.tecsup.bibliotecapi.services.LibroService;

@RestController
@RequestMapping("/api")
public class LibroController {
	private static final Logger logger = LoggerFactory.getLogger(LibroController.class);

	@Value("${app.storage.path}")
	private String STORAGEPATH;

	@Autowired
	private LibroService productoService;

	@GetMapping("/libros")
	public List<Libro> libros() {
		logger.info("call productos");
		List<Libro> productos = productoService.findAll();
		logger.info("productos: " + productos);
		return productos;
	}

}
