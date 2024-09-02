package BibliotecaSystem;

/**
 * Clase que representa una Sucursal de la biblioteca.
 */
public class Sucursal {
    private String nombre;
    private Biblioteca biblioteca;

    /**
     * Constructor de la clase Sucursal.
     *
     * @param nombre Nombre de la sucursal.
     */
    public Sucursal(String nombre) {
        this.nombre = nombre;
        this.biblioteca = new Biblioteca(nombre);
    }

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
}
