public class SesionPOO_Carro {

    public static void main(String[] args) {

        Carro c1 = new Carro("Mazda", "3", 2020, "Rojo");
        Carro c2 = new Carro("Toyota", "Corolla", 2019, "Blanco");
        Carro c3 = new Carro("Renault", "Logan", 2021, "Gris");
        Carro c4 = new Carro("Chevrolet", "Spark", 2018, "Azul");

        Carro c5 = new Carro("Ford", "Fiesta", 2017, "Negro");
        Carro c6 = new Carro("Nissan", "Versa", 2022, "Plateado");
        Carro c7 = new Carro("Kia", "Rio", 2021, "Rojo");
        Carro c8 = new Carro("Hyundai", "Accent", 2020, "Blanco");
        Carro c9 = new Carro("Mazda", "CX-30", 2023, "Gris");
        Carro c10 = new Carro("Volkswagen", "Jetta", 2019, "Azul");
        Carro c11 = new Carro("Honda", "Civic", 2021, "Negro");
        Carro c12 = new Carro("BMW", "X1", 2022, "Blanco");
        Carro c13 = new Carro("Mercedes", "Clase A", 2023, "Plateado");
        Carro c14 = new Carro("Audi", "A3", 2024, "Rojo");

        System.out.println("=== PASO 3: Objetos creados ===");

        c1.mostrarInfo();
        c2.mostrarInfo();
        c3.mostrarInfo();
        c4.mostrarInfo();
        c5.mostrarInfo();
        c6.mostrarInfo();
        c7.mostrarInfo();
        c8.mostrarInfo();
        c9.mostrarInfo();
        c10.mostrarInfo();
        c11.mostrarInfo();
        c12.mostrarInfo();
        c13.mostrarInfo();
        c14.mostrarInfo();

        System.out.println("\n=== PASO 4: Referencia vs valor ===");

        Carro copia = c1;
        copia.modelo = "CX-5";

        System.out.println("Que imprime c1.modelo?");
        System.out.println("c1.modelo = " + c1.modelo);

        System.out.println("\n=== PASO 5-6: Enlazando los carros ===");

        c1.siguiente = c2;
        c2.siguiente = c3;
        c3.siguiente = c4;
        c4.siguiente = c5;
        c5.siguiente = c6;
        c6.siguiente = c7;
        c7.siguiente = c8;
        c8.siguiente = c9;
        c9.siguiente = c10;
        c10.siguiente = c11;
        c11.siguiente = c12;
        c12.siguiente = c13;
        c13.siguiente = c14;

        System.out.println("Recorriendo la cadena desde c1:");

        Carro actual = c1;

        while (actual != null) {
            actual.mostrarInfo();
            actual = actual.siguiente;
        }

        System.out.println("Llegamos a 'null': no hay mas carros encadenados.");
    }
}
