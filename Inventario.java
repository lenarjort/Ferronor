package ferronor.inventario;

import java.util.ArrayList;
import java.util.Iterator;

public class Inventario {
    private ArrayList<StockItem> listaStockItems;
    private int capacidadMaxima;
    private double presupuestoMensual;

    public Inventario(int capacidadMaxima, double presupuestoMensual) {
        this.listaStockItems = new ArrayList<>();
        this.capacidadMaxima = capacidadMaxima;
        this.presupuestoMensual = presupuestoMensual;
    }

    public void agregarStockItem(StockItem item) {
        if (getTotalCantidad() + item.getCantidad() <= capacidadMaxima &&
            calcularValorTotal() + item.valorTotal() <= presupuestoMensual) {
            listaStockItems.add(item);
            System.out.println("Producto agregado con éxito.");
        } else {
            System.out.println("No se puede agregar. Excede capacidad o presupuesto.");
        }
    }

    public void eliminarVencidos() {
        Iterator<StockItem> iter = listaStockItems.iterator();
        while (iter.hasNext()) {
            StockItem item = iter.next();
            if (item.estaVencido()) {
                System.out.println("Eliminando vencido: " + item.getProducto().getNombre());
                iter.remove();
            }
        }
    }

    public void mostrarInventario() {
        if (listaStockItems.isEmpty()) {
            System.out.println("Inventario vacío.");
        } else {
            for (StockItem item : listaStockItems) {
                item.mostrarDetalle();
            }
        }
    }

    public double calcularValorTotal() {
        double total = 0;
        for (StockItem item : listaStockItems) {
            total += item.valorTotal();
        }
        return total;
    }

    public int getTotalCantidad() {
        int total = 0;
        for (StockItem item : listaStockItems) {
            total += item.getCantidad();
        }
        return total;
    }
}
