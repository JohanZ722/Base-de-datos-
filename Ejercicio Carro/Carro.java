public class Carro {

    String marca;
    String modelo;
    int anio;
    String color;

    Carro siguiente;

    Carro(String marca, String modelo, int anio, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.color = color;
        this.siguiente = null;
    }

    void mostrarInfo() {
        System.out.println("Marca: " + marca +
                " | Modelo: " + modelo +
                " | Anio: " + anio +
                " | Color: " + color);
    }
}
