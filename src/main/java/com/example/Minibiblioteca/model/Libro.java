package com.example.Minibiblioteca.model;

public class Libro {
    private int ID;
    private String titulo;
    private String autor;
      
    public Libro(int ID, String titulo, String autor) {
        this.ID = ID;
        this.titulo = titulo;
        this.autor = autor;
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

    

    
}

