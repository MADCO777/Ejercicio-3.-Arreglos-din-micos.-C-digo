package BibliotecaSystem;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;

/**
 * Clase principal que contiene el método main para interactuar con el sistema de biblioteca.
 */
public class Main {

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Central");
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Sistema de Gestión de Biblioteca");
            System.out.println("1. Agregar Libro");
            System.out.println("2. Agregar Miembro");
            System.out.println("3. Registrar Préstamo");
            System.out.println("4. Ver Estadísticas");
            System.out.println("5. Cargar Libros desde CSV");
            System.out.println("6. Cargar Miembros desde CSV");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir nueva línea

            switch (opcion) {
                case 1:
                    agregarLibro(biblioteca, scanner);
                    break;
                case 2:
                    agregarMiembro(biblioteca, scanner);
                    break;
                case 3:
                    registrarPrestamo(biblioteca, scanner);
                    break;
                case 4:
                    verEstadisticas(biblioteca, scanner);
                    break;
                case 5:
                    cargarLibrosDesdeCSV(biblioteca, scanner);
                    break;
                case 6:
                    cargarMiembrosDesdeCSV(biblioteca, scanner);
                    break;
                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        } while (opcion != 7);

        scanner.close();
    }

    /**
     * Agrega un libro a la biblioteca.
     *
     * @param biblioteca La biblioteca donde se agregará el libro.
     * @param scanner El escáner para leer la entrada del usuario.
     */
    private static void agregarLibro(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Ingrese ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Ingrese Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese Año de Publicación: ");
        int anoPublicacion = scanner.nextInt();
        scanner.nextLine();  // Consumir nueva línea
        System.out.print("Ingrese Género: ");
        String genero = scanner.nextLine();

        Libro libro = new Libro(isbn, titulo, autor, anoPublicacion, genero);
        biblioteca.agregarLibro(libro);
        System.out.println("Libro agregado exitosamente.");
    }

    /**
     * Agrega un miembro a la biblioteca.
     *
     * @param biblioteca La biblioteca donde se agregará el miembro.
     * @param scanner El escáner para leer la entrada del usuario.
     */
    private static void agregarMiembro(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Ingrese ID del Miembro: ");
        String idMiembro = scanner.nextLine();
        System.out.print("Ingrese Nombre del Miembro: ");
        String nombre = scanner.nextLine();

        Miembro miembro = new Miembro(idMiembro, nombre);
        biblioteca.agregarMiembro(miembro);
        System.out.println("Miembro agregado exitosamente.");
    }

    /**
     * Registra un préstamo en la biblioteca.
     *
     * @param biblioteca La biblioteca donde se registrará el préstamo.
     * @param scanner El escáner para leer la entrada del usuario.
     */
    private static void registrarPrestamo(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Ingrese ID del Miembro: ");
        String idMiembro = scanner.nextLine();
        System.out.print("Ingrese ISBN del Libro: ");
        String isbnLibro = scanner.nextLine();
        System.out.print("Ingrese Fecha de Préstamo (yyyy-MM-dd): ");
        LocalDate fechaPrestamo = LocalDate.parse(scanner.nextLine(), dateFormatter);
        System.out.print("Ingrese Fecha de Devolución Esperada (yyyy-MM-dd): ");
        LocalDate fechaDevolucionEsperada = LocalDate.parse(scanner.nextLine(), dateFormatter);

        Prestamo prestamo = new Prestamo(idMiembro, isbnLibro, fechaPrestamo, fechaDevolucionEsperada);
        biblioteca.registrarPrestamo(prestamo);
        System.out.println("Préstamo registrado exitosamente.");
    }

    /**
     * Muestra las estadísticas de la biblioteca.
     *
     * @param biblioteca La biblioteca de la cual se mostrarán las estadísticas.
     * @param scanner El escáner para leer la entrada del usuario.
     */
    private static void verEstadisticas(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Ingrese Fecha de Inicio (yyyy-MM-dd): ");
        LocalDate inicio = LocalDate.parse(scanner.nextLine(), dateFormatter);
        System.out.print("Ingrese Fecha de Fin (yyyy-MM-dd): ");
        LocalDate fin = LocalDate.parse(scanner.nextLine(), dateFormatter);

        long librosPrestados = Estadisticas.librosPrestadosEnPeriodo(biblioteca.getPrestamos(), inicio, fin);
        System.out.println("Cantidad de libros prestados en el período: " + librosPrestados);

        Map<String, Long> generosMasSolicitados = Estadisticas.generosMasSolicitados(biblioteca.getPrestamos(), biblioteca.getLibros());
        System.out.println("Géneros más solicitados:");
        ((java.util.Map<?, ?>) generosMasSolicitados).forEach((genero, cantidad) -> System.out.println(genero + ": " + cantidad + " préstamos"));

        String libroMasPrestado = Estadisticas.libroMasPrestado(biblioteca.getPrestamos());
        System.out.println("Libro más prestado: " + libroMasPrestado);
    }

    /**
     * Carga libros desde un archivo CSV.
     *
     * @param biblioteca La biblioteca donde se cargarán los libros.
     * @param scanner El escáner para leer la entrada del usuario.
     */
    private static void cargarLibrosDesdeCSV(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Ingrese la ruta del archivo CSV de libros: ");
        String rutaArchivo = scanner.nextLine();

        try {
            CSVLoader.cargarLibrosDesdeCSV(biblioteca, rutaArchivo);
            System.out.println("Libros cargados exitosamente desde el archivo CSV.");
        } catch (IOException e) {
            System.err.println("Error al cargar libros desde el archivo CSV: " + e.getMessage());
        }
    }

    /**
     * Carga miembros desde un archivo CSV.
     *
     * @param biblioteca La biblioteca donde se cargarán los miembros.
     * @param scanner El escáner para leer la entrada del usuario.
     */
    private static void cargarMiembrosDesdeCSV(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Ingrese la ruta del archivo CSV de miembros: ");
        String rutaArchivo = scanner.nextLine();

        try {
            CSVLoader.cargarMiembrosDesdeCSV(biblioteca, rutaArchivo);
            System.out.println("Miembros cargados exitosamente desde el archivo CSV.");
        } catch (IOException e) {
            System.err.println("Error al cargar miembros desde el archivo CSV: " + e.getMessage());
        }
    }
}
