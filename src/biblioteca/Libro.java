package biblioteca;

// Libro es un Material concreto: hereda los datos comunes y añade autor e ISBN.
public class Libro extends Material {
    private String autor;
    private String isbn;

    // Constructor: super(...) inicializa la parte Material antes de guardar lo propio.
    public Libro(String codigo, String titulo, int anio, boolean disponible,
                 String autor, String isbn) {
        super(codigo, titulo, anio, disponible);
        this.autor = autor;
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    // Implementa el método abstracto heredado de Material.
    @Override
    public String getTipo() {
        return "Libro";
    }
}
