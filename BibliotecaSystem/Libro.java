package BibliotecaSystem;

/**
 * Clase que representa un Libro.
 */
public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private int anoPublicacion;
    private String genero;

    /**
     * Constructor de la clase Libro.
     *
     * @param isbn ISBN del libro.
     * @param titulo Título del libro.
     * @param autor Autor del libro.
     * @param anoPublicacion Año de publicación del libro.
     * @param genero Género del libro.
     */
    public Libro(String isbn, String titulo, String autor, int anoPublicacion, String genero) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacion = anoPublicacion;
        this.genero = genero;
    }

    // Getters y Setters

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public int getAnoPublicacion() {
        return anoPublicacion;
    }

    public void setAnoPublicacion(int anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
