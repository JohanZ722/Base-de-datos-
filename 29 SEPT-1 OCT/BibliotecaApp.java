import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Clase BibliotecaApp: Contiene el método main y ejecuta todas las 
 * operaciones requeridas sobre la lista enlazada de libros.
 */
public class BibliotecaApp {
    public static void main(String[] args) {
        
        // 1. Crear mínimo cinco objetos de la clase Libro
        Libro libro1 = new Libro("L001", "Cien Años de Soledad", "Gabriel García Márquez", 45000);
        Libro libro2 = new Libro("L002", "El Principito", "Antoine de Saint-Exupéry", 25000);
        Libro libro3 = new Libro("L003", "1984", "George Orwell", 38000);
        Libro libro4 = new Libro("L004", "Don Quijote de la Mancha", "Miguel de Cervantes", 55000);
        Libro libro5 = new Libro("L005", "Fahrenheit 451", "Ray Bradbury", 32000);

        // Crear la lista enlazada (LinkedList) para almacenar los libros
        LinkedList<Libro> listaLibros = new LinkedList<>();

        System.out.println("--- 1. AGREGAR LIBROS A LA LISTA ---");
        // Agregar libros de forma estándar (al final por defecto)
        listaLibros.add(libro2);
        listaLibros.add(libro3);
        
        // Practicar inserciones explícitas al inicio y al final
        listaLibros.addFirst(libro1); // Se inserta al principio de la lista
        listaLibros.addLast(libro4);  // Se inserta al final de la lista
        listaLibros.add(libro5);      // Se inserta al final

        System.out.println("Libros agregados exitosamente.\n");


        System.out.println("--- 2. CONSULTAR ELEMENTOS Y TAMAÑO ---");
        // Consultar el tamaño de la lista
        System.out.println("Total de libros en la lista: " + listaLibros.size());
        // Consultar el primer y último elemento usando métodos propios de LinkedList
        System.out.println("Primer libro: " + listaLibros.getFirst().getTitulo());
        System.out.println("Último libro: " + listaLibros.getLast().getTitulo());
        // Consultar una posición específica (índice 2)
        System.out.println("Libro en la posición 3 (índice 2): " + listaLibros.get(2).getTitulo() + "\n");


        System.out.println("--- 3. RECORRER Y MOSTRAR TODOS LOS LIBROS ---");
        // Usamos ListIterator para recorrer la lista enlazada de forma óptima
        ListIterator<Libro> iterador = listaLibros.listIterator();
        while (iterador.hasNext()) {
            System.out.println(iterador.next().toString());
        }
        System.out.println();


        System.out.println("--- 4 y 5. BUSCAR UN LIBRO Y MODIFICAR SUS DATOS ---");
        String codigoBuscar = "L003"; // Vamos a buscar "1984"
        boolean encontrado = false;
        
        // Reiniciamos el iterador para buscar desde el principio
        iterador = listaLibros.listIterator();
        while (iterador.hasNext()) {
            Libro libroActual = iterador.next();
            
            if (libroActual.getCodigo().equals(codigoBuscar)) {
                System.out.println("Libro encontrado: " + libroActual.getTitulo());
                
                // 5. Modificar uno de sus datos (el precio)
                System.out.println("Precio anterior: $" + libroActual.getPrecio());
                libroActual.setPrecio(42000); 
                System.out.println("Precio nuevo actualizado: $" + libroActual.getPrecio());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("El libro con código " + codigoBuscar + " no fue encontrado.");
        }
        System.out.println();


        System.out.println("--- 6. ELIMINAR ELEMENTOS DE LA LISTA ---");
        // Eliminar al inicio y al final usando métodos de LinkedList
        Libro eliminadoInicio = listaLibros.removeFirst();
        Libro eliminadoFinal = listaLibros.removeLast();
        
        System.out.println("Se eliminó el primer libro: " + eliminadoInicio.getTitulo());
        System.out.println("Se eliminó el último libro: " + eliminadoFinal.getTitulo());
        System.out.println("Total de libros restantes: " + listaLibros.size());
    }
}
