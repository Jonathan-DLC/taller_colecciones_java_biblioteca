package biblioteca;

// Clase base abstracta: reúne los datos comunes de libros y revistas.
public abstract class Material implements Catalogable {
    // Atributos privados para que se consulten o cambien mediante métodos controlados.
    private String codigo;
    private String titulo;
    private int anio;
    private boolean disponible;

    // Constructor: inicializa los datos comunes de cada material.
    public Material(String codigo, String titulo, int anio, boolean disponible) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.anio = anio;
        this.disponible = disponible;
    }

    // Implementa el método exigido por Catalogable.
    @Override
    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnio() {
        return anio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    // Permite actualizar el estado cuando el material se presta o se devuelve.
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // Cada subclase concreta indicará su tipo: "Libro" o "Revista".
    public abstract String getTipo();

    // Método común: usa getTipo() para mostrar la ficha de cualquier material.
    public void mostrarInfo() {
        String estado = "prestado";
        if (disponible) {
            estado = "disponible";
        }
        System.out.println("[" + getTipo() + "] " + titulo + " (" + anio + ") — " + estado);
    }
}
