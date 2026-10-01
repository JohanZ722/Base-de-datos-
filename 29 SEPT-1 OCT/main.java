import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListPractice {
    public static void main(String[] args) {
        
        System.out.println("--- PRÁCTICA DE LINKEDLIST ---\n");

        // 1. Crear varios objetos de la clase Product utilizando constructores
        System.out.println("Paso 1: Creando objetos Product...");
        Product p1 = new Product(101, "Rosas Rojas (Docena)", 15, 25000);
        Product p2 = new Product(102, "Tulipanes Amarillos", 10, 35000);
        Product p3 = new Product(103, "Orquídea Blanca", 5, 45000);
        Product p4 = new Product(104, "Girasol Individual", 30, 8000);

        // 2. Consultar y modificar atributos mediante métodos get y set
        System.out.println("\nPaso 2: Consultando y modificando atributos...");
        System.out.println("Precio original de " + p1.getName() + ": $" + p1.getPrice());
        p1.setPrice(28000); // Modificación mediante set
        System.out.println("Precio modificado de " + p1.getName() + ": $" + p1.getPrice());

        // 3. Crear una lista enlazada para almacenar objetos Product
        // Se declara directamente como LinkedList para usar métodos específicos (addFirst, getLast, etc.)
        System.out.println("\nPaso 3: Creando la LinkedList...");
        LinkedList<Product> inventario = new LinkedList<>();

        // 4. Agregar productos a la lista y practicar inserciones al inicio y al final
        System.out.println("\nPaso 4: Insertando elementos en la lista...");
        inventario.add(p2); // Inserción normal (al final por defecto)
        inventario.add(p3);
        
        inventario.addFirst(p1); // Inserción explícita al INICIO
        inventario.addLast(p4);  // Inserción explícita al FINAL

        // 5. Consultar el primer elemento, el último elemento, una posición determinada y la cantidad
        System.out.println("\nPaso 5: Consultas específicas...");
        System.out.println("Primer elemento: " + inventario.getFirst().getName());
        System.out.println("Último elemento: " + inventario.getLast().getName());
        System.out.println("Elemento en la posición 2 (índice 2): " + inventario.get(2).getName());
        System.out.println("Cantidad total de elementos: " + inventario.size());

        // 6. Recorrer y mostrar los elementos almacenados (utilizando ListIterator)
        System.out.println("\nPaso 6: Recorriendo y mostrando la lista...");
        ListIterator<Product> iterador = inventario.listIterator();
        while (iterador.hasNext()) {
            System.out.println(iterador.next().toString());
        }

        // 7. Buscar un producto utilizando el criterio (por ejemplo, buscar por ID)
        // 8. Modificar información de un producto encontrado
        System.out.println("\nPaso 7 y 8: Buscando y modificando un producto (ID 103)...");
        int idBuscado = 103;
        boolean encontrado = false;
        
        // Reiniciamos el iterador para volver a recorrer la lista desde el principio
        iterador = inventario.listIterator(); 
        while (iterador.hasNext()) {
            Product actual = iterador.next();
            if (actual.getId() == idBuscado) {
                System.out.println("Producto encontrado: " + actual.getName());
                // Paso 8: Modificamos la cantidad
                actual.setQuantity(20); 
                System.out.println("Nueva cantidad actualizada a: " + actual.getQuantity());
                encontrado = true;
                break; // Terminamos la búsqueda tras encontrarlo
            }
        }
        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }

        // 9. Eliminar elementos de la lista al inicio y al final
        System.out.println("\nPaso 9: Eliminando elementos al inicio y al final...");
        Product eliminadoInicio = inventario.removeFirst();
        Product eliminadoFinal = inventario.removeLast();
        
        System.out.println("Se eliminó del inicio: " + eliminadoInicio.getName());
        System.out.println("Se eliminó del final: " + eliminadoFinal.getName());

        System.out.println("\nLista final después de las eliminaciones (Cantidad: " + inventario.size() + "):");
        for (Product p : inventario) {
            System.out.println(p.getName());
        }
    }
}
