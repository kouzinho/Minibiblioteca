package com.example.Minibiblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Minibiblioteca.model.Libro;

@Controller
public class MinibibliotecaController {

    // Creadión de una lista en memoria para almacenar los libros como un String
    private List<Libro> libros = new ArrayList<>();

    //Creación de un contador para asignar una ID a cada libro
    private int contadorID = 1;

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
        
        // Se agrega el libro a la lista
        libros.add(new Libro(contadorID++, titulo, autor));

        // Se pasa la lista actualizada a la vista
        model.addAttribute("libros", libros);

        //Redireccionamos para ver la vista actualizada sin datos en el navegador
        return "redirect:/";
    }

    @GetMapping("/delete/{ID}")
    public String deleteLibro(@PathVariable int ID) {
        
        //Se elimina el Libro cuyo ID coincida con el indicado
        libros.removeIf(libro -> libro.getID() == ID);

        //Redireccionamos para ver la vista actualizada sin datos en el navegador
        return "redirect:/";
    }
    
}