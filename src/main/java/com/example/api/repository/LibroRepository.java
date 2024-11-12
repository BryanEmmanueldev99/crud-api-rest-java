package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {

}
