package BibliotecaSystem;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Clase que proporciona métodos para calcular estadísticas sobre los préstamos de libros.
 */
public class Estadisticas {

    /**
     * Calcula la cantidad de libros prestados en un período.
     *
     * @param prestamos Lista de préstamos.
     * @param inicio Fecha de inicio del período.
     * @param fin Fecha de fin del período.
     * @return Cantidad de libros prestados en el período.
     */
    public static long librosPrestadosEnPeriodo(List<Prestamo> prestamos, LocalDate inicio, LocalDate fin) {
        return prestamos.stream()
                .filter(prestamo -> !prestamo.getFechaPrestamo().isBefore(inicio) && !prestamo.getFechaPrestamo().isAfter(fin))
                .count();
    }

    /**
     * Calcula los géneros más solicitados.
     *
     * @param prestamos Lista de préstamos.
     * @param libros Lista de libros.
     * @return Mapa con los géneros y su cantidad de préstamos.
     */
    public static Map<String, Long> generosMasSolicitados(List<Prestamo> prestamos, List<Libro> libros) {
        return prestamos.stream()
                .collect(Collectors.groupingBy(prestamo -> {
                    Libro libro = libros.stream()
                            .filter(l -> l.getIsbn().equals(prestamo.getIsbnLibro()))
                            .findFirst()
                            .orElse(null);
                    return libro != null ? libro.getGenero() : "Desconocido";
                }, Collectors.counting()));
    }

    /**
     * Calcula el libro más prestado.
     *
     * @param prestamos Lista de préstamos.
     * @return ISBN del libro más prestado.
     */
    public static String libroMasPrestado(List<Prestamo> prestamos) {
        return prestamos.stream()
                .collect(Collectors.groupingBy(Prestamo::getIsbnLibro, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No hay datos");
    }

    // Otros métodos para calcular tiempo promedio, libros cerca de la fecha de devolución, etc.
}
