package ferronor.inventario;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario(1000, 5000.0);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menú de Inventario Ferronor ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Eliminar vencidos");
            System.out.println("4. Calcular valor total");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("ID producto: ");
                    String id = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Tipo (Herramienta/Repuesto): ");
                    String tipo = sc.nextLine();
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Precio compra: ");
                    double pc = sc.nextDouble();
                    System.out.print("Precio venta: ");
                    double pv = sc.nextDouble();
                    System.out.print("Cantidad: ");
                    int cant = sc.nextInt();

                    LocalDate venc = null;
                    int garantia = 0;
                    if ("Repuesto".equalsIgnoreCase(tipo)) {
                        System.out.print("Fecha vencimiento (AAAA-MM-DD): ");
                        venc = LocalDate.parse(sc.next());
                    } else {
                        System.out.print("Meses de garantía: ");
                        garantia = sc.nextInt();
                    }

                    Producto prod = new Producto(id, nombre, tipo, marca, pc, pv);
                    StockItem item = new StockItem(prod, cant, venc, garantia);
                    inventario.agregarStockItem(item);
                    break;

                case 2:
                    inventario.mostrarInventario();
                    break;

                case 3:
                    inventario.eliminarVencidos();
                    break;

                case 4:
                    System.out.println("Valor total del inventario: $" + inventario.calcularValorTotal());
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    return;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
