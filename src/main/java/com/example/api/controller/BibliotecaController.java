package com.example.api.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.api.model.Biblioteca;
import com.example.api.repository.BibliotecaRepository;


@RestController
@RequestMapping("/api/v1/bibliotecas/")
public class BibliotecaController {

    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    @GetMapping("biblioteca")
    public ResponseEntity<Page<Biblioteca>> obtenerBibliotecas(Pageable pageable) {
        return ResponseEntity.ok(bibliotecaRepository.findAll(pageable));
    }

    @GetMapping("biblioteca/{id}")
    public ResponseEntity<Biblioteca> getBiblioteca(@PathVariable Long id) {
        Optional<Biblioteca> bibliotecaOptional = bibliotecaRepository.findById(id);

        if(!bibliotecaOptional.isPresent()) {
         return ResponseEntity.unprocessableEntity().build();
    }

     return ResponseEntity.ok(bibliotecaOptional.get());

 }

    @PostMapping("biblioteca")
    public ResponseEntity<Biblioteca> storeBiblioteca(@RequestBody Biblioteca biblioteca) {
           Biblioteca saveBiblioteca = bibliotecaRepository.save(biblioteca);
           URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
           .buildAndExpand(saveBiblioteca.getId()).toUri();
           return ResponseEntity.created(ubicacion).body(saveBiblioteca);
    }

    @PutMapping("biblioteca/{id}")
    public ResponseEntity<Biblioteca> updateBiblioteca(@PathVariable Long id, @RequestBody Biblioteca biblioteca) {
                 Optional<Biblioteca> bibliotecaOptional = bibliotecaRepository.findById(id);
                 
                 if(!bibliotecaOptional.isPresent()) {
                      return ResponseEntity.unprocessableEntity().build();
                 }

                 biblioteca.setId(bibliotecaOptional.get().getId());
                 bibliotecaRepository.save(biblioteca);

                 return ResponseEntity.noContent().build();
    }

    @DeleteMapping("biblioteca/{id}")
    public ResponseEntity<Biblioteca> deleteBiblioteca(@PathVariable Long id) {
           Optional<Biblioteca> bibliotecaOptional = bibliotecaRepository.findById(id);

           if(!bibliotecaOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
       }

        bibliotecaRepository.delete(bibliotecaOptional.get());

        return ResponseEntity.noContent().build();

    }



}
