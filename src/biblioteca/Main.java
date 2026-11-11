package biblioteca;

// Crea objetos y llama al sistema para demostrar cada parte del taller.
public class Main {
    public static void main(String[] args) {
        SistemaBiblioteca biblioteca = new SistemaBiblioteca();

        // 1. Catálogo: registramos dos libros y dos revistas.
        Libro libro1 = new Libro("BK-001", "Fundamentos de Java", 2024, true,
                "Kevin Escalante", "ISBN-DEMO-001");
        Libro libro2 = new Libro("BK-002", "Introducción a algoritmos", 2023, true,
                "Jonathan Lozano", "ISBN-DEMO-002");
        Revista revista1 = new Revista("RV-001", "Tecnología universitaria", 2025, true,
                12, "Tecnología");
        Revista revista2 = new Revista("RV-002", "Ciencia en el campus", 2024, true,
                8, "Ciencia");

        biblioteca.registrarMaterial(libro1);
        biblioteca.registrarMaterial(libro2);
        biblioteca.registrarMaterial(revista1);
        biblioteca.registrarMaterial(revista2);

        // get() devuelve un Material o null. Verificamos antes de usarlo.
        System.out.println("=== Búsqueda por código ===");
        Material encontrado = biblioteca.buscarMaterial("BK-001");
        if (encontrado != null) {
            encontrado.mostrarInfo();
        }
        Material inexistente = biblioteca.buscarMaterial("NO-EXISTE");
        if (inexistente == null) {
            System.out.println("El código NO-EXISTE no está en el catálogo.");
        }

        // 2. Lista de espera: el libro está prestado y los usuarios llegan en este orden.
        libro1.setDisponible(false);
        biblioteca.agregarEspera("BK-001", "Ana");
        biblioteca.agregarEspera("BK-001", "Luis");
        biblioteca.agregarEspera("BK-001", "Marta");

        System.out.println("\n=== Orden de la lista de espera ===");
        System.out.println("Primero: " + biblioteca.siguienteEnEspera("BK-001"));
        System.out.println("Segundo: " + biblioteca.siguienteEnEspera("BK-001"));

        // 3. Membresías: HashSet rechaza el segundo registro del mismo usuario.
        System.out.println("\n=== Registro de membresías ===");
        System.out.println("Registrar Ana: " + biblioteca.registrarMiembro("Ana"));
        System.out.println("Registrar Luis: " + biblioteca.registrarMiembro("Luis"));
        System.out.println("Registrar Marta: " + biblioteca.registrarMiembro("Marta"));
        System.out.println("Registrar Ana otra vez: " + biblioteca.registrarMiembro("Ana"));
        System.out.println("¿Ana tiene membresía?: " + biblioteca.tieneMembresia("Ana"));
        System.out.println("¿Pedro tiene membresía?: " + biblioteca.tieneMembresia("Pedro"));

        // 4. Polimorfismo: cada objeto responde con su propio getTipo().
        System.out.println("\n=== Catálogo completo ===");
        biblioteca.mostrarCatalogo();
    }
}
