/**
 * Clase Libro: Define los atributos y métodos básicos de los libros.
 */
public class Libro {
    private String codigo;
    private String titulo;
    private String autor;
    private double precio;

    // Constructor para inicializar los atributos del libro
    public Libro(String codigo, String titulo, String autor, double precio) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
    }

    // Getters y Setters para consultar y modificar la información
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    // Método toString para visualizar el libro fácilmente en consola
    @Override
    public String toString() {
        return "Código: " + codigo + " | Título: " + titulo + " | Autor: " + autor + " | Precio: $" + precio;
    }
}
