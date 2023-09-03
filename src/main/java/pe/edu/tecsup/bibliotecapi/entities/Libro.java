package pe.edu.tecsup.bibliotecapi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Libros")
@Data
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "Titulo", nullable = false)
    private String titulo;

    @Column(name = "Autor")
    private String autor;

    @Column(name = "ISBN")
    private String isbn;

    @Column(name = "Genero")
    private String genero;

    @Column(name = "AnioPublicacion")
    private int anioPublicacion;

    @Column(name = "Editorial")
    private String editorial;

    @Column(name = "CantidadDisponible")
    private int cantidadDisponible;
}