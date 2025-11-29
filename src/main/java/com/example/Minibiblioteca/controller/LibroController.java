package com.example.Minibiblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Minibiblioteca.model.Libro;
import com.example.Minibiblioteca.service.LibroService;

import java.util.List;

@Controller
public class LibroController {

    private final LibroService servicio;

    public LibroController(LibroService servicio) {
        this.servicio = servicio;
    }

    // RUTA PRINCIPAL CON FILTRO + BÚSQUEDA
    @GetMapping("/")
    public String verLibros(
            @RequestParam(defaultValue = "all") String filtro,
            @RequestParam(required = false) String q,
            Model model) {

        List<Libro> resultado = servicio.filtrarYBuscar(filtro, q);

        model.addAttribute("libros", resultado);
        model.addAttribute("filtro", filtro);
        model.addAttribute("q", q);

        return "listView";
    }

    // AÑADIR LIBRO
    @GetMapping("/add")
    public String addLibro(@RequestParam String titulo, @RequestParam String autor) {
        servicio.addLibro(titulo, autor);
        return "redirect:/";
    }

    // ELIMINAR LIBRO
    @GetMapping("/delete/{ID}")
    public String deleteLibro(@PathVariable int ID) {
        servicio.deleteLibro(ID);
        return "redirect:/";
    }

    // CAMBIAR ESTADO
    @GetMapping("/toggle/{ID}")
    public String toggledisponible(@PathVariable int ID) {
        servicio.toggleEstado(ID);
        return "redirect:/";
    }
}