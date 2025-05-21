import java.util.ArrayList;
import java.util.Scanner;

public class Supermercado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Producto> inventario = new ArrayList<>();

        int opcion;

        do {
            System.out.println("\n--- SUPERMERCADO ---");
            System.out.println("1. Adicionar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Vender producto");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del producto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();
                    inventario.add(new Producto(nombre, precio));
                    System.out.println("Producto agregado.");
                    break;

                case 2:
                    System.out.println("\n--- Productos Disponibles ---");
                    if (inventario.isEmpty()) {
                        System.out.println("No hay productos.");
                    } else {
                        for (int i = 0; i < inventario.size(); i++) {
                            System.out.println((i + 1) + ". " + inventario.get(i));
                        }
                    }
                    break;

                case 3:
                    if (inventario.isEmpty()) {
                        System.out.println("No hay productos para vender.");
                        break;
                    }

                    System.out.println("¿Qué producto desea vender?");
                    for (int i = 0; i < inventario.size(); i++) {
                        System.out.println((i + 1) + ". " + inventario.get(i));
                    }

                    System.out.print("Ingrese número del producto: ");
                    int venta = scanner.nextInt();
                    if (venta > 0 && venta <= inventario.size()) {
                        Producto vendido = inventario.remove(venta - 1);
                        System.out.println("Producto vendido: " + vendido.getNombre());
                    } else {
                        System.out.println("Opción inválida.");
                    }
                    break;

                case 4:
                    System.out.println("Gracias por usar el sistema.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 4);
    }
}
