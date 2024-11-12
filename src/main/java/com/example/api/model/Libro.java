package com.example.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "libros", uniqueConstraints = {@UniqueConstraint(columnNames = {"nombre"})})
public class Libro {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     private String nombre;

     @ManyToOne(fetch = FetchType.LAZY,optional = false)
     @JoinColumn(name = "biblioteca_id")
     @JsonProperty(access = Access.WRITE_ONLY)
     private Biblioteca biblioteca;



    public Libro() {
    }


    public Libro(Long id, String nombre, Biblioteca biblioteca) {
        this.id = id;
        this.nombre = nombre;
        this.biblioteca = biblioteca;
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

    public Biblioteca getBiblioteca() {
        return this.biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

}
