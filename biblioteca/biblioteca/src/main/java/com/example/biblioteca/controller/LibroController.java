package com.example.biblioteca.controller;

import com.example.biblioteca.dto.LibroCreateRequest;
import com.example.biblioteca.dto.BookResponse;
import com.example.biblioteca.service.LibroService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    private final LibroService service;

    public LibroController(LibroService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BookResponse> crear(@Valid @RequestBody LibroCreateRequest req) {
        return ResponseEntity.status(201).body(service.crear(req));
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> listar() {
        return ResponseEntity.ok(service.listar());
    }
}