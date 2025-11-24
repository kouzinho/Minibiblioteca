package com.example.Minibiblioteca.model;

public class Libro {
    private int ID;
    private String titulo;
    private String autor;
    private boolean disponible;
      
    public Libro(int ID, String titulo, String autor) {
        this.ID = ID;
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    

    
}

