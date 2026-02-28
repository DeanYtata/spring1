package com.example.biblioteca.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "libro", uniqueConstraints = {
        @UniqueConstraint(name = "uk_libro_isbn", columnNames = "isbn")
})
public class LibroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20, unique = true)
    private String isbn;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(nullable = false, length = 120)
    private String autor;

    private Integer anioPublicacion;

    @Column(nullable = false)
    private Boolean disponible = true;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public LibroEntity() {}

    public LibroEntity(String isbn, String titulo, String autor, Integer anioPublicacion) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.disponible = true;
    }

    public Long getId() { return id; }
    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public Integer getAnioPublicacion() { return anioPublicacion; }
    public Boolean getDisponible() { return disponible; }
}
