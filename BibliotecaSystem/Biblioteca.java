package BibliotecaSystem;

import java.util.*;

/**
 * Clase que representa una Biblioteca.
 */
public class Biblioteca {
    private String nombre;
    private List<Libro> libros;
    private List<Miembro> miembros;
    private List<Prestamo> prestamos;

    /**
     * Constructor de la clase Biblioteca.
     *
     * @param nombre Nombre de la biblioteca.
     */
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
        this.miembros = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    /**
     * Agrega un libro a la biblioteca.
     *
     * @param libro El libro a agregar.
     */
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    /**
     * Agrega un miembro a la biblioteca.
     *
     * @param miembro El miembro a agregar.
     */
    public void agregarMiembro(Miembro miembro) {
        miembros.add(miembro);
    }

    /**
     * Registra un préstamo en la biblioteca.
     *
     * @param prestamo El préstamo a registrar.
     */
    public void registrarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    /**
     * Obtiene la lista de libros.
     *
     * @return La lista de libros.
     */
    public List<Libro> getLibros() {
        return libros;
    }

    /**
     * Obtiene la lista de miembros.
     *
     * @return La lista de miembros.
     */
    public List<Miembro> getMiembros() {
        return miembros;
    }

    /**
     * Obtiene la lista de préstamos.
     *
     * @return La lista de préstamos.
     */
    public List<Prestamo> getPrestamos() {
        return prestamos;
    }
}
