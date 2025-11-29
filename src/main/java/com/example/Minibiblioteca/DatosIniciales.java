package com.example.Minibiblioteca;

import com.example.Minibiblioteca.service.LibroService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// Marcamos esta clase como componente para que se detecte de forma automática
@Component
public class DatosIniciales implements CommandLineRunner {

    // Referencia al servicio de libros
    private final LibroService libroService;

    // Constructor donde Spring inyecta automáticamente el LibroService
    public DatosIniciales(LibroService libroService) {
        this.libroService = libroService;
    }

    // Método que se ejecuta automáticamente al iniciar la aplicación
    @Override
    public void run(String... args) throws Exception {
        // Añadimos libros de ejemplo al iniciar la aplicación
        libroService.addLibro("El nombre del viento", "Patrick Rothfuss");
        libroService.addLibro("El capitán Alatriste", "Pérez Reverte");
        libroService.addLibro("Berserk", "Kentaro Miura");
    }
}
