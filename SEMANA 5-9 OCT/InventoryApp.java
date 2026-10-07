import java.util.Scanner;

public class InventoryApp {
    private Scanner sc = new Scanner(System.in);
    private Inventory inventory;

    public static void main(String[] args) {
        InventoryApp app = new InventoryApp();
        app.init();
    }

    public void init() {
        inventory = new Inventory();
        int op;

        do {
            System.out.println("\n\t MENÚ");
            System.out.println("---- MANEJO DE INVENTARIOS ----");
            System.out.println("1. Nuevo producto");
            System.out.println("2. Agregar existencia");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Actualizar precio");
            System.out.println("5. Mostrar productos");
            System.out.println("6. Consultar producto");
            System.out.println("7. Salir");
            System.out.println("\nSeleccione una opción:");

            op = sc.nextInt();

            switch (op) {
                case 1:
                    newProduct();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    updateProduct();
                    break;
                case 5:
                    printProduct();
                    break;
                case 6:
                    findProduct();
                    break;
            }
        } while (op != 7);
    }

    // OPCIÓN 1 - NUEVO PRODUCTO
    private void newProduct() {
        System.out.println("ID del producto:");
        int ID = sc.nextInt();

        System.out.println("Nombre del producto:");
        String name = sc.next();

        System.out.println("Existencia inicial:");
        int existence = sc.nextInt();

        System.out.println("Precio del producto:");
        double price = sc.nextDouble();

        System.out.println("Categoría del producto:");
        String category = sc.next();

        inventory.newProduct(ID, name, existence, price, category);
    }

    // OPCIÓN 2 - AGREGAR EXISTENCIA
    private void addProduct() {
        System.out.println("ID del producto:");
        int ID = sc.nextInt();

        inventory.addProduct(ID);
    }

    // OPCIÓN 3 - ELIMINAR PRODUCTO
    private void deleteProduct() {
        System.out.println("ID del producto:");
        int ID = sc.nextInt();

        inventory.deleteProduct(ID);
    }

    // OPCIÓN 4 - ACTUALIZAR PRECIO
    private void updateProduct() {
        System.out.println("ID del producto:");
        int ID = sc.nextInt();

        System.out.println("Nuevo precio:");
        double price = sc.nextDouble();

        inventory.updateProduct(ID, price);
    }

    // OPCIÓN 5 - MOSTRAR PRODUCTOS
    private void printProduct() {
        inventory.printProducts();
    }

    // OPCIÓN 6 - CONSULTAR PRODUCTO
    private void findProduct() {
        System.out.println("ID del producto:");
        int ID = sc.nextInt();

        inventory.findProduct(ID);
    }
}
