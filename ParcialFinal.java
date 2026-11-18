import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/*
 * ============================================================
 *  SALA DE EMERGENCIAS
 *  Estructura de Datos - UNIMINUTO
 * ============================================================
 *  Nombre completo:Johan Stev Zambrano Preciado
 *
 *  INSTRUCCIONES
 *  1. Ejecuta el programa y mira la salida en la consola.
 *  2. Responde las 8 preguntas (P1 a P8). Escribe tu respuesta
 *     en la línea "// R:" que está debajo de cada pregunta.
 *  3. Respuestas cortas: la respuesta y una frase de por qué.
 *  4. No borres ni cambies el código de este archivo.
 * ============================================================
 */
public class SalaEmergencias {

    // Clase Paciente: el "molde" de cada paciente.
    // Va dentro de SalaEmergencias (por eso lleva static).
    static class Paciente implements Comparable<Paciente> {

        private String nombre;
        private int gravedad;   // 1 Leve, 2 Moderada, 3 Grave, 4 Muy grave

        public Paciente(String nombre, int gravedad) {
            this.nombre = nombre;
            this.gravedad = gravedad;
        }
        // P1. En "this.nombre = nombre", ¿cuál de los dos es el atributo
        //     del paciente y cuál es el dato que llegó entre paréntesis?
        // R: this.nombre = nombre el this sirve para renombrar el atributo, que en este caso es el nombre

        public String getNombre() {
            return nombre;
        }

        public int getGravedad() {
            return gravedad;
        }

        public String getGravedadTexto() {
            switch (gravedad) {
                case 1: return "Leve";
                case 2: return "Moderada";
                case 3: return "Grave";
                case 4: return "Muy grave";
                default: return "Desconocida";
            }
        }
        // P2. Si un paciente tuviera gravedad 7, ¿qué texto mostraría? ¿Por qué?
        // R: si tuviera gravedad 7 el texto que mostraria es "Desconocida" porque no esta en las opciones que son de 1-4

        @Override
        public String toString() {
            return nombre + " (" + getGravedadTexto() + ")";
        }

        @Override
        public int compareTo(Paciente otro) {
            return Integer.compare(otro.gravedad, this.gravedad);
        }
        // P3. compareTo decide quién va primero en el triage.
        //     Si se escribiera Integer.compare(this.gravedad, otro.gravedad),
        //     ¿quién saldría primero: el más grave o el menos grave?
        // R: El mas grave ya que cambia el orden de como sale al poner primero this.gravedad
    }

    public static void main(String[] args) {

        // ---------- 1. SALA DE ESPERA (Queue: orden de llegada) ----------
        Queue<Paciente> salaEspera = new LinkedList<>();
        salaEspera.offer(new Paciente("Juan", 1));
        salaEspera.offer(new Paciente("Raquel", 3));
        salaEspera.offer(new Paciente("Ignacio", 2));
        salaEspera.offer(new Paciente("Omar", 4));
        salaEspera.offer(new Paciente("Beatriz", 3));
        salaEspera.offer(new Paciente("Xochilt", 1));
        System.out.println("Orden de llegada: " + salaEspera);
        // P4. ¿Por qué Juan aparece de primero en la sala de espera?
        // R: porque utiliza una interfaz Queque y esta asociada a una cola y dice "que el primero que entra es el primero que sale"

        // ---------- 2. TRIAGE (PriorityQueue: el más grave primero) ----------
        PriorityQueue<Paciente> triage = new PriorityQueue<>();
        while (!salaEspera.isEmpty()) {
            triage.offer(salaEspera.poll());
        }
        System.out.println("Paciente mas urgente: " + triage.peek());
        System.out.println();
        // P5. Al terminar este while, ¿cuántos pacientes quedan en salaEspera? ¿Por qué?
        // R: Ninguno ya que al ser un bucle mira que la lista quede vacia mientras que este llena

        // ---------- 3. ATENCIÓN E HISTORIAL (Stack: el último queda arriba) ----------
        Stack<Paciente> historial = new Stack<>();
        while (!triage.isEmpty()) {
            Paciente atendido = triage.poll();
            System.out.println("Atendiendo a: " + atendido);
            historial.push(atendido);
        }
        // P6. Juan llegó de primero, pero lo atienden de quinto. ¿Por qué?
        // R: Debido a que utlizamos la interfaz de priorityQueque ordena a los pacientes en la sala en este caso segun su nivel de gravedad, Juan tenia una de las mas bajas pro eso lo atendieron 

        System.out.println();
        System.out.println("Ultimo paciente atendido: " + historial.peek());
        System.out.println("Total atendidos: " + historial.size());
        // P7. ¿Por qué historial.peek() muestra a Xochilt y no a Omar?
        // R: Porque esta en la cima de la pila 

        // P8. ¿Qué diferencia hay entre peek() y poll()? Da un ejemplo de este código.
        // R: peek es el que esta en la cima y poll remueve poll esta en la linea 100 y peek esta en la 108
    }
}
