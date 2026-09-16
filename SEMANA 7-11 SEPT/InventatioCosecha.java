
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InventarioCosecha {
    public static void main(String[] args) {
        // 1. Inventario base (lista dinámica)
        ArrayList<String> inventarioBase = new ArrayList<>();
        inventarioBase.add("Manzana");
        inventarioBase.add("Banano");
        inventarioBase.add("Pera");
        inventarioBase.add("Lulo");

        // 2. Lista del proveedor (arreglo fijo convertido a lista)
        List<String> inventarioProveedor = Arrays.asList("Mango", "Fresa", "Uva");

      
        // 3. Inventario consolidado
        ArrayList<String> inventarioConsolidado = new ArrayList<>();
        inventarioConsolidado.addAll(inventarioBase);
        inventarioConsolidado.addAll(inventarioProveedor);

        // 4. Mostrar las tres listas usando forEach
        System.out.println("=== INVENTARIO BASE ===");
        inventarioBase.forEach(fruta -> System.out.println("- " + fruta));

        System.out.println("\n=== INVENTARIO PROVEEDOR ===");
        inventarioProveedor.forEach(fruta -> System.out.println("- " + fruta));

        System.out.println("\n=== INVENTARIO CONSOLIDADO ===");
        inventarioConsolidado.forEach(fruta -> System.out.println("- " + fruta));
    }
}
