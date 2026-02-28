package com.example.biblioteca.service;

import com.example.biblioteca.dto.LibroCreateRequest;
import com.example.biblioteca.dto.BookResponse;
import com.example.biblioteca.entity.LibroEntity;
import com.example.biblioteca.repository.LibroRepository;
import org.springframework.stereotype.Service;
 
import java.util.List;
 
@Service
public class LibroService {
 
    private final LibroRepository repo;
 
    public LibroService(LibroRepository repo) {
        this.repo = repo;
    }
 
    public BookResponse crear(LibroCreateRequest req) {
 
        if (repo.existsByIsbn(req.getIsbn())) {
            throw new RuntimeException("ISBN ya existe");
        }
 
        LibroEntity entity = new LibroEntity(
                req.getIsbn(),
                req.getTitulo(),
                req.getAutor(),
                req.getAnioPublicacion()
        );
 
        LibroEntity saved = repo.save(entity);
 
        return BookResponse.of(
                saved.getId(),
                saved.getIsbn(),
                saved.getTitulo(),
                saved.getAutor(),
                saved.getAnioPublicacion(),
                saved.getDisponible()
        );
    }
 
    public List<BookResponse> listar() {
        return repo.findAll().stream()
                .map(l -> BookResponse.of(
                        l.getId(),
                        l.getIsbn(),
                        l.getTitulo(),
                        l.getAutor(),
                        l.getAnioPublicacion(),
                        l.getDisponible()
                ))
                .toList();
    }
}