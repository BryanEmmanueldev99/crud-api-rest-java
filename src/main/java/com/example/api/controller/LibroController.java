package com.example.api.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.example.api.model.Libro;
import com.example.api.repository.LibroRepository;

@RestController
@RequestMapping("/api/v1/libros/")
public class LibroController {

    @Autowired
    private LibroRepository libroRepository;


    @GetMapping("libro")
    public ResponseEntity<Page<Libro>> getLibros(Pageable pageable) {
            return ResponseEntity.ok(libroRepository.findAll(pageable));
    }

    @GetMapping("libro/{id}")
    public ResponseEntity<Libro> getLibro(@PathVariable Long id) {
            Optional<Libro> libroOptional = libroRepository.findById(id);

                if(!libroOptional.isPresent()) {
                    return ResponseEntity.unprocessableEntity().build();
                }

            return ResponseEntity.ok(libroOptional.get());
    }


    @PostMapping("libro")
    public String storeLibro(@RequestBody Libro libro) {
        // iTaskRepository.save(task);
        libroRepository.save(libro);
        return "¡Servicio agreado desde Spring Boot!";
    }


    @DeleteMapping("libro/{id}")
    public ResponseEntity<Libro> deleteLibro(@PathVariable Long id) {
            Optional<Libro> libroOptional = libroRepository.findById(id);

                if(!libroOptional.isPresent()) {
                    return ResponseEntity.unprocessableEntity().build();
                }

            libroRepository.delete(libroOptional.get());
            return ResponseEntity.noContent().build();
    }

}
