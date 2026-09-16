import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
 
public class Materiasyproveedor {
    public static void main(String[] args){
        ArrayList<String> materiasBase = new ArrayList<> ();
        materiasBase.add("Piloto - Base de datos");
        materiasBase.add("Programacion");
        materiasBase.add("Piloto - Calculo");
        materiasBase.add("Programacion orientada a objetos");
        
        List<String> materiasAñadidas = Arrays.asList ("Precalculo","Diseño web","Filosofia");
        
        ArrayList<String> materiasConsolidadas = new ArrayList<>();
        materiasConsolidadas.addAll(materiasBase);
        materiasConsolidadas.addAll(materiasAñadidas);
        
        System.out.println("MATERIAS BASE");
        materiasBase.forEach(materia -> System.out.println("- " + materia));
        
        System.out.println("MATERIAS AÑADIDAS");
        materiasAñadidas.forEach(materia -> System.out.println("- " + materia));
        
        System.out.println("MATERIAS CONSOLIDADAS");
        materiasConsolidadas.forEach(materia -> System.out.println("- " + materia));
        
        ListIterator<String> iterador = materiasBase.listIterator();
        
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
        materiasBase.forEach(materia -> System.out.println("- " + materia));
    }  
}
