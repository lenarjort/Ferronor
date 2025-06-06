package ferronor.inventario;

public class Producto {
    private String id;
    private String nombre;
    private String tipo;
    private String marca;
    private double precioCompra;
    private double precioVenta;

    public Producto(String id, String nombre, String tipo, String marca, double precioCompra, double precioVenta) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.marca = marca;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public String getMarca() { return marca; }
    public double getPrecioCompra() { return precioCompra; }
    public double getPrecioVenta() { return precioVenta; }

    public void mostrarInfo() {
        System.out.println(nombre + " (" + tipo + ") - $" + precioCompra + " / $" + precioVenta);
    }
}
