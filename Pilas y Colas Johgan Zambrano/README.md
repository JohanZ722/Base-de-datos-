# Práctica de pilas y colas

**Nombre:Johan
**Número de lista:**

## Ejercicio 1: Pila
Salida de la consola:

import java.util.Stack;

public class PilaPersonal {

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


- ¿Por qué tu número de lista está en la posición 3?

Porque una pila funciona con el principio LIFO (Last In, First Out), es decir,el último elemento que entra es el primero que sale. El método search() cuenta
las posiciones desde la cima de la pila, empezando por 1. Como mi número de listafue el primero en ingresar y después agregué mi día y mes de cumpleaños, quedó
en la tercera posición.
- ¿Qué pasaría con while(true)?

El ciclo se ejecutaría infinitamente porque la condición while(true) siempre es verdadera. Cuando la pila quedara vacía, el programa intentaría ejecutar pop() 
nuevamente y produciría una excepción llamada EmptyStackException. Por eso es importante comprobar que la pila tenga elementos antes de retirar uno.

## Ejercicio 2: Cola
Salida de la consola:

import java.util.LinkedList;
import java.util.Queue;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;

public class DiferenciasQueue {

    public static void main(String[] args) {

        Queue<Integer> limitada = new ArrayBlockingQueue<>(3);

        limitada.offer(10);
        limitada.offer(20);
        limitada.offer(30);

        System.out.println("Cola llena: " + limitada);

        System.out.println("offer(40) devolvio: " + limitada.offer(40));

        try {
            limitada.add(50);
        } catch (IllegalStateException e) {
            System.out.println("add(50) lanzo: " + e);
        }

        Queue<Integer> vacia = new LinkedList<>();

        Integer r1 = vacia.poll();
        Integer r2 = vacia.peek();

        System.out.println("\npoll() en cola vacia: " + r1);
        System.out.println("peek() en cola vacia: " + r2);

        try {
            vacia.remove();
        } catch (NoSuchElementException e) {
            System.out.println("remove() lanzo: " + e);
        }

        try {
            vacia.element();
        } catch (NoSuchElementException e) {
            System.out.println("element() lanzo: " + e);
        }
    }
}


- ¿Por qué la cabeza siempre es la misma?

Porque una cola funciona con el principio FIFO (First In, First Out), es decir, el primero que entra es el primero que sale.
Cuando agregamos elementos con offer(), estos se colocan al final de la cola, por lo que la cabeza permanece siendo el primer elemento ingresado hasta que 
se atiende o retira.
- ¿Por qué la pila y la cola sacaron los datos en orden contrario?

Porque ambas estructuras trabajan de manera diferente. La pila utiliza LIFO, por lo que el último elemento ingresado sale primero.
En cambio, la cola utiliza FIFO, por lo que el primer elemento ingresado sale primero. Por esta razón, los datos se retiraron en órdenes contrarios.
- ¿add u offer para el banco? ¿Por qué?

Utilizaría offer() porque permite agregar un turno sin generar una excepción cuando la cola alcanza su capacidad máxima.
Si ya no hay espacio, devuelve false, lo que permite mostrar un mensaje indicando que no hay más turnos disponibles y controlar mejor el programa.

## Ejercicio 3: Cola de prioridad
Salida de la consola:

import java.util.PriorityQueue;

public class PrioridadPalabras {

    public static void main(String[] args) {

        PriorityQueue<String> cola = new PriorityQueue<>();

        cola.offer("Johan");
        cola.offer("Bogota");
        cola.offer("Informatica");
        cola.offer("Python");

        System.out.println("Cola completa: " + cola);

        System.out.println("Mi prediccion: Bogota");
        System.out.println("Cabeza: " + cola.peek());

        while (!cola.isEmpty()) {
            System.out.println("Sale: " + cola.poll());
        }

    }
}

- ¿Acertaste tu predicción?

Sí, acerté mi predicción porque la palabra que aparece primero alfabéticamente es Bogota.
La cola de prioridad organiza las palabras según su orden alfabético y el método peek() permite consultar cuál tiene la mayor prioridad sin eliminarla.
- ¿Por qué println salió desordenado y poll en orden?
Porque PriorityQueue internamente utiliza una estructura llamada montículo (Heap), que no necesita mostrar todos los elementos ordenados al imprimir la cola.
Sin embargo, cuando utilizamos poll(), siempre se extrae primero el elemento con mayor prioridad. Por eso las palabras salen en orden alfabético.

## Ejercicio 4: Sala de emergencias
Salida de la consola:

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

class Paciente implements Comparable<Paciente> {

    private String nombre;
    private int gravedad;

    public Paciente(String nombre, int gravedad) {
        this.nombre = nombre;
        this.gravedad = gravedad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getGravedad() {
        return gravedad;
    }

    public String getGravedadTexto() {
        switch (gravedad) {
            case 1:
                return "Leve";
            case 2:
                return "Moderada";
            case 3:
                return "Grave";
            case 4:
                return "Muy grave";
            default:
                return "Desconocida";
        }
    }

    @Override
    public String toString() {
        return nombre + " (" + getGravedadTexto() + ")";
    }

    @Override
    public int compareTo(Paciente otro) {
        return Integer.compare(otro.gravedad, this.gravedad);
    }
}

public class SalaEmergencias {

    public static void main(String[] args) {

        Queue<Paciente> salaEspera = new LinkedList<>();

        salaEspera.offer(new Paciente("Juan", 1));
        salaEspera.offer(new Paciente("Raquel", 3));
        salaEspera.offer(new Paciente("Ignacio", 2));
        salaEspera.offer(new Paciente("Omar", 4));
        salaEspera.offer(new Paciente("Beatriz", 3));
        salaEspera.offer(new Paciente("Xochilt", 1));

        System.out.println("Orden de llegada: " + salaEspera);

        PriorityQueue<Paciente> triage = new PriorityQueue<>();

        while (!salaEspera.isEmpty()) {
            triage.offer(salaEspera.poll());
        }

        System.out.println("Paciente mas urgente: " + triage.peek());

        Stack<Paciente> historial = new Stack<>();

        while (!triage.isEmpty()) {
            Paciente atendido = triage.poll();

            System.out.println("Atendiendo a: " + atendido);

            historial.push(atendido);
        }

        System.out.println();

        System.out.println("Ultimo paciente atendido: " + historial.peek());

        System.out.println("Total atendidos: " + historial.size());

    }
}

- ¿Por qué falló en el paso 4 y no con String?

Porque la clase String ya implementa la interfaz Comparable, por lo que Java sabe cómo comparar y ordenar las palabras alfabéticamente. 
En cambio, la clase Paciente es una clase personalizada y Java no sabe cómo determinar cuál paciente tiene mayor gravedad. Para solucionar esto, 
debemos implementar Comparable y definir el método compareTo().
- Reto: ¿cómo harías que se respete el orden de llegada?

Agregaría un atributo llamado ordenLlegada, de tipo int, que permita registrar el número de llegada de cada paciente. 
Después modificaría el método compareTo() para que primero compare la gravedad y, si dos pacientes tienen la misma gravedad, 
compare su orden de llegada. De esta manera, se atenderá primero al paciente que llegó antes.
Así se garantiza que los pacientes más graves sean atendidos primero y que, cuando tengan la misma gravedad, se respete el orden de llegada.
