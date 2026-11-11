package biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Reúne las operaciones de catálogo, listas de espera y membresías.
public class SistemaBiblioteca {
    // La clave es el código único, el valor es un Libro o una Revista.
    private Map<String, Material> catalogo;
    // Cada código de material tiene su propia lista ordenada de usuarios en espera.
    private Map<String, ArrayList<String>> listaEspera;
    // Usuarios con membresía activa: cada nombre aparece como máximo una vez.
    private Set<String> miembros;

    // Constructor: crea las colecciones vacías al iniciar el sistema.
    public SistemaBiblioteca() {
        this.catalogo = new HashMap<>();
        this.listaEspera = new HashMap<>();
        this.miembros = new HashSet<>();
    }

    // Guarda un material usando su código como clave.
    public void registrarMaterial(Material material) {
        catalogo.put(material.getCodigo(), material);
    }

    // Busca directamente por código, devuelve null si no existe.
    public Material buscarMaterial(String codigo) {
        return catalogo.get(codigo);
    }

    // Recorre los pares clave-valor.
    public void mostrarCatalogo() {
        for (Map.Entry<String, Material> entrada : catalogo.entrySet()) {
            System.out.print("Código " + entrada.getKey() + ": ");
            entrada.getValue().mostrarInfo();
        }
    }

    // Agrega un usuario al final de la lista del material indicado.
    public void agregarEspera(String codigoMaterial, String usuario) {
        ArrayList<String> usuarios = listaEspera.get(codigoMaterial);
        if (usuarios == null) {
            usuarios = new ArrayList<>();
            listaEspera.put(codigoMaterial, usuarios);
        }
        usuarios.add(usuario);
    }

    // Retira y devuelve al primero de la fila, devuelve null si no hay nadie.
    public String siguienteEnEspera(String codigoMaterial) {
        ArrayList<String> usuarios = listaEspera.get(codigoMaterial);
        if (usuarios == null) {
            return null;
        }
        if (usuarios.isEmpty()) {
            return null;
        }
        return usuarios.remove(0);
    }

    // Devuelve true si el usuario es nuevo y false si ya estaba registrado.
    public boolean registrarMiembro(String usuario) {
        return miembros.add(usuario);
    }

    // Consulta si el usuario pertenece al conjunto de miembros activos.
    public boolean tieneMembresia(String usuario) {
        return miembros.contains(usuario);
    }
}
