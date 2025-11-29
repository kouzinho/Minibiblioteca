package com.example.Minibiblioteca.service;

import com.example.Minibiblioteca.model.Libro;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class LibroService {

    private List<Libro> libros = new ArrayList<>();
    private int contadorID = 1;

    public List<Libro> getAll() {
        return libros;
    }

    public void addLibro(String titulo, String autor) {
        libros.add(new Libro(contadorID++, titulo, autor));
    }

    public void deleteLibro(int id) {
        libros.removeIf(libro -> libro.getID() == id);
    }

    public void toggleEstado(int id) {
        for (Libro libro : libros) {
            if (libro.getID() == id) {
                libro.setDisponible(!libro.isDisponible());
                break;
            }
        }
    }

    // MÉTODO UNIFICADO: filtrar + buscar todo en uno
    public List<Libro> filtrarYBuscar(String filtro, String q) {

        List<Libro> resultado = new ArrayList<>();

        String query = (q == null) ? "" : q.toLowerCase();
        boolean hayBusqueda = !query.isEmpty();

        for (Libro libro : libros) {

            // FILTRO POR ESTADO
            boolean pasaFiltro =
                    filtro.equals("disponibles") ? libro.isDisponible() :
                    filtro.equals("prestados")   ? !libro.isDisponible() :
                                                   true; // all

            if (!pasaFiltro) continue;

            // FILTRO POR BÚSQUEDA (si aplica)
            if (hayBusqueda) {
                String titulo = libro.getTitulo().toLowerCase();
                String autor  = libro.getAutor().toLowerCase();

                if (!titulo.contains(query) && !autor.contains(query)) {
                    continue;
                }
            }

            // Si pasa ambos filtros, lo añadimos
            resultado.add(libro);
        }

        return resultado;
    }
}
