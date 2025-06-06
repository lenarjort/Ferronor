package ferronor.inventario;

import java.time.LocalDate;

public class StockItem {
    private Producto producto;
    private int cantidad;
    private LocalDate fechaVencimiento;
    private int mesesGarantia;

    public StockItem(Producto producto, int cantidad, LocalDate fechaVencimiento, int mesesGarantia) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.fechaVencimiento = fechaVencimiento;
        this.mesesGarantia = mesesGarantia;
    }

    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public boolean estaVencido() {
        if ("Repuesto".equalsIgnoreCase(producto.getTipo()) && fechaVencimiento != null) {
            return fechaVencimiento.isBefore(LocalDate.now());
        }
        return false;
    }

    public double valorTotal() {
        return producto.getPrecioCompra() * cantidad;
    }

    public void mostrarDetalle() {
        producto.mostrarInfo();
        System.out.println("Cantidad: " + cantidad);
        if ("Repuesto".equalsIgnoreCase(producto.getTipo())) {
            System.out.println("Vence: " + fechaVencimiento);
        } else {
            System.out.println("Garantía: " + mesesGarantia + " meses");
        }
        System.out.println("--------------------------");
    }
}
