package ferronor.inventario;

public class Proveedor {
    private String nombre;
    private int tiempoEntrega;

    public Proveedor(String nombre, int tiempoEntrega) {
        this.nombre = nombre;
        this.tiempoEntrega = tiempoEntrega;
    }

    public String getNombre() { return nombre; }
    public int getTiempoEntrega() { return tiempoEntrega; }
}
