package com.example.api.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "biblioteca")
public class Biblioteca {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     private String nombre;

     @OneToMany(mappedBy = "biblioteca", cascade = CascadeType.ALL)
     private Set<Libro> libros = new HashSet<>();


    public Biblioteca() {
    }


    public Biblioteca(Long id, String nombre, Set<Libro> libros) {
        this.id = id;
        this.nombre = nombre;
        this.libros = libros;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Libro> getLibros() {
        return this.libros;
    }

    public void setLibros(Set<Libro> libros) {
        this.libros = libros;

        for(Libro libro : libros) {
                libro.setBiblioteca(this);
        }
    }

}
