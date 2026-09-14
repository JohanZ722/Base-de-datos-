import java.util.ArrayList;
import java.util.ListIterator;

public class DepuracionMaterias {
    public static void main(String[] args) {
        ArrayList<String> materias = new ArrayList<>();
        materias.add("Bases de Datos");
        materias.add("Piloto - Realidad Virtual");
        materias.add("Programación Orientada a Objetos");
        materias.add("Piloto - Desarrollo Móvil");
        materias.add("Cálculo Diferencial");

        System.out.println("=== REVISIÓN DE MATERIAS ===");
        
        // Usamos ListIterator para recorrer y modificar de forma segura
        ListIterator<String> iterador = materias.listIterator();
        
        while (iterador.hasNext()) {
            String materia = iterador.next();
            System.out.print("Evaluando: " + materia);
            
            if (materia.startsWith("Piloto")) {
                iterador.remove(); // Se elimina la materia sin causar ConcurrentModificationException
                System.out.println(" -> [ELIMINADA]");
            } else {
                System.out.println(" -> [MANTENIDA]");
            }
        }

        System.out.println("\n=== LISTA FINAL DEPURADA ===");
        materias.forEach(materia -> System.out.println("- " + materia));
    }
}