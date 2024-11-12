package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api.model.Biblioteca;

@Repository
public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long> {

}
