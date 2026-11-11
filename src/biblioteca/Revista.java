package biblioteca;

// Revista es un Material concreto: hereda los datos comunes y añade edición y temática.
public class Revista extends Material {
    private int edicion;
    private String tematica;

    // Constructor: super(...) inicializa los datos de Material antes de los propios.
    public Revista(String codigo, String titulo, int anio, boolean disponible,
                   int edicion, String tematica) {
        super(codigo, titulo, anio, disponible);
        this.edicion = edicion;
        this.tematica = tematica;
    }

    public int getEdicion() {
        return edicion;
    }

    public String getTematica() {
        return tematica;
    }

    // Implementa el método abstracto heredado de Material.
    @Override
    public String getTipo() {
        return "Revista";
    }
}
