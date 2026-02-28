package com.example.biblioteca.repository;

import com.example.biblioteca.entity.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<LibroEntity, Long> {
    boolean existsByIsbn(String isbn);
}