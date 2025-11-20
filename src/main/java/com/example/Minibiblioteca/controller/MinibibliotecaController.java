package com.example.Minibiblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;


@Controller
public class MinibibliotecaController {

    @GetMapping("/")
    public String verLibros(Model model){
        List<String> libros = Arrays.asList(
            "El nombre del viento - Patrick Rothfuss",
            "El capitán Alatriste - Pérez Reverte",
            "Berserk - Kentaro Miura"
        );

        model.addAttribute("libros",libros);

        return "listView";
        
    }
}
