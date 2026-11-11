package biblioteca;

// Contrato: todo material que entre al catálogo debe tener un código identificador.
public interface Catalogable {
    // Devuelve el código del material.
    String getCodigo();
}
