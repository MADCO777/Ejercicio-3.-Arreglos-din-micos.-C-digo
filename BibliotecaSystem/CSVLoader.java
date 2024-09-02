package BibliotecaSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase que proporciona métodos para cargar datos desde archivos CSV.
 */
public class CSVLoader {

    /**
     * Carga libros desde un archivo CSV.
     *
     * @param biblioteca La biblioteca donde se agregarán los libros.
     * @param rutaArchivo Ruta del archivo CSV.
     * @throws IOException Si ocurre un error de E/S.
     */
    public static void cargarLibrosDesdeCSV(Biblioteca biblioteca, String rutaArchivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                Libro libro = new Libro(datos[0], datos[1], datos[2], Integer.parseInt(datos[3]), datos[4]);
                biblioteca.agregarLibro(libro);
            }
        }
    }

    /**
     * Carga miembros desde un archivo CSV.
     *
     * @param biblioteca La biblioteca donde se agregarán los miembros.
     * @param rutaArchivo Ruta del archivo CSV.
     * @throws IOException Si ocurre un error de E/S.
     */
    public static void cargarMiembrosDesdeCSV(Biblioteca biblioteca, String rutaArchivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                Miembro miembro = new Miembro(datos[0], datos[1]);
                biblioteca.agregarMiembro(miembro);
            }
        }
    }
}
