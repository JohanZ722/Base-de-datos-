import java.util.LinkedList;
import java.util.List;

public class Inventory {
    // Lista donde se guardan los productos
    private List<Product> products;

    // Constructor: crea la lista vacía
    public Inventory() {
        products = new LinkedList<>();
    }

    // ===================================================
    // AGREGAR UN PRODUCTO NUEVO (Incluye Categoría)
    // ===================================================
    public void newProduct(int ID, String name, int existence, double price, String category) {
        // Crea un nuevo objeto Product
        Product newProduct = new Product(ID, name, existence, price, category);

        // Agrega el producto a la lista
        boolean success = products.add(newProduct);

        // Informa si se agregó correctamente
        if (success) {
            System.out.println("El producto " + name + " se añadió satisfactoriamente");
        } else {
            System.out.println("Ocurrió un problema al agregar el producto");
        }
    }

    // ===================================================
    // AUMENTAR LA EXISTENCIA DE UN PRODUCTO
    // ===================================================
    public void addProduct(int ID) {
        int productIndex = products.indexOf(new Product(ID));
        
        // Control de ID inexistente
        if (productIndex == -1) {
            System.out.println("El producto no existe");
            return;
        }

        Product product = products.get(productIndex);
        int newExistence = product.getExistence() + 1;
        product.setExistence(newExistence);

        System.out.println("\nSe agregó una unidad de " + product.getName());
    }

    // ===================================================
    // MOSTRAR TODOS LOS PRODUCTOS
    // ===================================================
    public void printProducts() {
        System.out.println("PRODUCTOS EN EL ALMACÉN");
        products.forEach(System.out::println);
        System.out.println();
    }

    // ===================================================
    // ACTUALIZAR EL PRECIO
    // ===================================================
    public void updateProduct(int ID, double price) {
        int productIndex = products.indexOf(new Product(ID));

        // Control de ID inexistente
        if (productIndex == -1) {
            System.out.println("El producto no existe");
            return;
        }

        Product product = products.get(productIndex);
        product.setPrice(price);

        System.out.println("\nPrecio actualizado correctamente");
    }

    // ===================================================
    // ELIMINAR UN PRODUCTO
    // ===================================================
    public void deleteProduct(int ID) {
        int productIndex = products.indexOf(new Product(ID));

        // Control de ID inexistente
        if (productIndex == -1) {
            System.out.println("El producto no existe");
            return;
        }

        Product deleteProduct = products.remove(productIndex);
        System.out.println("El producto " + deleteProduct.getName() + " se eliminó");
    }

    // ===================================================
    // CONSULTAR UN PRODUCTO POR SU ID
    // ===================================================
    public void findProduct(int ID) {
        int productIndex = products.indexOf(new Product(ID));

        // Control de ID inexistente
        if (productIndex == -1) {
            System.out.println("El producto no existe");
            return;
        }

        System.out.println(products.get(productIndex));
    }
}
