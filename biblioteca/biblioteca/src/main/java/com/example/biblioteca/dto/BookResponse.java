package com.example.biblioteca.dto;

public class BookResponse {
 
    private Long id;
    private String isbn;
    private String titulo;
    private String autor;
    private Integer anioPublicacion;
    private Boolean disponible;
 
    public static BookResponse of(Long id, String isbn, String titulo,
                                   String autor, Integer anio, Boolean disponible) {
        BookResponse r = new BookResponse();
        r.id = id;
        r.isbn = isbn;
        r.titulo = titulo;
        r.autor = autor;
        r.anioPublicacion = anio;
        r.disponible = disponible;
        return r;
    }
 
    public Long getId() { return id; }
    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public Integer getAnioPublicacion() { return anioPublicacion; }
    public Boolean getDisponible() { return disponible; }
}