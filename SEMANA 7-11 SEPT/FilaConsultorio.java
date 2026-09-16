import java.util.ArrayList;
import java.util.ListIterator;

public class FilaConsultorio {
    public static void main(String[] args) {
        ArrayList<String> fila = new ArrayList<>();
        fila.add("Paciente A (Carlos)");
        fila.add("Paciente B (Lucía)");
        fila.add("Paciente C (Andrés)");
        fila.add("Paciente D (María)");
        fila.add("Paciente E (Jorge)");

        System.out.println("=== REPORTE DE POSICIONES (ORDEN DE LLEGADA) ===");
        ListIterator<String> iterador = fila.listIterator();
        
        while (iterador.hasNext()) {
            int posicion = iterador.nextIndex() + 1; // +1 para que la lista empiece en 1 y no en 0
            String paciente = iterador.next();
            System.out.println("Posición " + posicion + ": " + paciente);
        }

        System.out.println("\n=== REPORTE INVERTIDO (ÚLTIMOS PRIMERO) ===");
        // El iterador ya se encuentra al final tras el recorrido anterior
        while (iterador.hasPrevious()) {
            System.out.println("- " + iterador.previous());
        }

        System.out.println("\n=== INSERTANDO PACIENTE DE URGENCIA ===");
        // En este punto, el cursor regresó al inicio (índice 0). 
        // Vamos a avanzar hasta la posición deseada.
        while (iterador.hasNext()) {
            iterador.next();
            // Queremos insertar justo después de la segunda persona (índice 1 en la lista)
            if (iterador.previousIndex() == 1) { 
                iterador.add("PACIENTE URGENCIA (Roberto)");
                break; // Terminamos la inserción, podemos salir del bucle
            }
        }

        System.out.println("\n=== FILA FINAL === ");
        fila.forEach(paciente -> System.out.println("- " + paciente));
    }
}
