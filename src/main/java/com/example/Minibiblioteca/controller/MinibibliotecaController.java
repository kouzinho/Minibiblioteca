package com.example.Minibiblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MinibibliotecaController {

    // Creadión de una lista en memoria para almacenar los libros como un String
    private List<String> libros = new ArrayList<>();

    // Ruta principal para mostrar la lista de libros
    @GetMapping("/")
    public String verLibros(Model model){
        // Se agrega la lista al modelo
        model.addAttribute("libros", libros);
        // Se devuelve la plantilla listView.html
        return "listView";
    }

    // Ruta para agregar un libro con título y autor
    @GetMapping("/add")
    public String addLibro(@RequestParam String titulo, @RequestParam String autor, Model model) {
        String libro = titulo + " - " + autor;
        
        // Se agrega el libro a la lista
        libros.add(libro);

        // Se pasa la lista actualizada a la vista
        model.addAttribute("libros", libros);

        return "listView";
    }
}