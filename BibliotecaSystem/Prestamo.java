package BibliotecaSystem;

import java.time.LocalDate;

/**
 * Clase que representa un Préstamo de un libro.
 */
public class Prestamo {
    private String idMiembro;
    private String isbnLibro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucionEsperada;

    /**
     * Constructor de la clase Prestamo.
     *
     * @param idMiembro ID del miembro que realiza el préstamo.
     * @param isbnLibro ISBN del libro prestado.
     * @param fechaPrestamo Fecha del préstamo.
     * @param fechaDevolucionEsperada Fecha de devolución esperada.
     */
    public Prestamo(String idMiembro, String isbnLibro, LocalDate fechaPrestamo, LocalDate fechaDevolucionEsperada) {
        this.idMiembro = idMiembro;
        this.isbnLibro = isbnLibro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucionEsperada = fechaDevolucionEsperada;
    }

    // Getters y Setters

    public String getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(String idMiembro) {
        this.idMiembro = idMiembro;
    }

    public String getIsbnLibro() {
        return isbnLibro;
    }

    public void setIsbnLibro(String isbnLibro) {
        this.isbnLibro = isbnLibro;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucionEsperada() {
        return fechaDevolucionEsperada;
    }

    public void setFechaDevolucionEsperada(LocalDate fechaDevolucionEsperada) {
        this.fechaDevolucionEsperada = fechaDevolucionEsperada;
    }
}
