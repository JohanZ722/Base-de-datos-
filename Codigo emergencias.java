
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
