
import java.util.Stack;

public class Pila {

    public static void main(String[] args) {

        Stack<Integer> pila = new Stack<>();

        pila.push(20);
        imprimirPila(pila);

        pila.push(22);
        imprimirPila(pila);

        pila.push(7);
        imprimirPila(pila);

        System.out.println("Posicion de mi numero de lista: " + pila.search(20));

        while (!pila.empty()) {
            int eliminado = pila.pop();
            System.out.println("Se saco " + eliminado);
            imprimirPila(pila);
        }

    }

    private static void imprimirPila(Stack<Integer> pila) {
        if (pila.empty()) {
            System.out.println("La pila esta vacia\n");
        } else {
            System.out.println("Cima: " + pila.peek());
            System.out.println("Contenido: " + pila + "  <- la cima es el de la derecha\n");
        }
    }
}
