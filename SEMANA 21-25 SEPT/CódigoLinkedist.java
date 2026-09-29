import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        
        // PUNTO DE PARTIDA
        LinkedList<String> materias = new LinkedList<>();

        System.out.println("--- 1. CREAR la colección ---");
        materias.add("Programación");
        materias.add("Matemáticas");
        materias.add("Inglés");
        materias.add("Bases de Datos");
        materias.add("Redes");
        System.out.println("Lista inicial: " + materias);

        System.out.println("\n--- 2. AGREGAR información ---");
        materias.addFirst("Algoritmos");
        System.out.println("Agregar al inicio: " + materias);
        
        materias.addLast("Inteligencia Artificial");
        System.out.println("Agregar al final: " + materias);
        
        materias.add(2, "Estructura de Datos");
        System.out.println("Insertar en posición 2: " + materias);

        System.out.println("\n--- 3. CONSULTAR información ---");
        System.out.println("Elemento en posición 3: " + materias.get(3));
        System.out.println("Primer elemento: " + materias.getFirst());
        System.out.println("Último elemento: " + materias.getLast());
        System.out.println("¿Contiene 'Inglés'?: " + materias.contains("Inglés"));
        System.out.println("Posición de 'Bases de Datos': " + materias.indexOf("Bases de Datos"));

        System.out.println("\n--- 4. MODIFICAR información ---");
        System.out.println("Antes del cambio: " + materias);
        int posicionMatematicas = materias.indexOf("Matemáticas");
        if (posicionMatematicas != -1) { // Verifica que sí se encontró en la lista
            materias.set(posicionMatematicas, "Matemáticas Aplicadas");
        }
        System.out.println("Después del cambio: " + materias);

        System.out.println("\n--- 5. ELIMINAR información ---");
        materias.remove("Inglés");
        System.out.println("Eliminar por nombre ('Inglés'): " + materias);
        
        materias.remove(2); // Elimina "Estructura de Datos" (que quedó en índice 2)
        System.out.println("Eliminar por posición (índice 2): " + materias);
        
        materias.removeFirst();
        System.out.println("Eliminar el primero: " + materias);
        
        materias.removeLast();
        System.out.println("Eliminar el último: " + materias);

        System.out.println("\n--- 6. RECORRER la colección ---");
        System.out.println("Recorrido con ciclo FOR tradicional:");
        for (int i = 0; i < materias.size(); i++) {
            System.out.println("- " + materias.get(i));
        }

        System.out.println("\nRecorrido con ciclo FOR-EACH:");
        for (String materia : materias) {
            System.out.println("- " + materia);
        }

        System.out.println("\n--- 7. CONTAR y verificar ---");
        System.out.println("Cantidad de materias almacenadas: " + materias.size());
        if (materias.isEmpty()) {
            System.out.println("Estado: La lista está vacía.");
        } else {
            System.out.println("Estado: La lista contiene información.");
        }

        System.out.println("\n--- 8. ELIMINAR TODOS los elementos ---");
        materias.clear();
        System.out.println("Lista después de vaciarla: " + materias);
        System.out.println("¿Está vacía ahora?: " + materias.isEmpty());
    }
}
