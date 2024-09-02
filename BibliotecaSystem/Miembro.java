package BibliotecaSystem;

/**
 * Clase que representa un Miembro de la biblioteca.
 */
public class Miembro {
    private String idMiembro;
    private String nombre;

    /**
     * Constructor de la clase Miembro.
     *
     * @param idMiembro ID del miembro.
     * @param nombre Nombre del miembro.
     */
    public Miembro(String idMiembro, String nombre) {
        this.idMiembro = idMiembro;
        this.nombre = nombre;
    }

    // Getters y Setters

    public String getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(String idMiembro) {
        this.idMiembro = idMiembro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
