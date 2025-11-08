package Codigo.Logica;

import java.time.LocalDate;
import java.util.Objects;

public class Producto implements Comparable<Producto> {

    /// ATRIBUTOS
    private int id;
    private static int cont = 1;
    private String nombre;
    private String marca;
    private double precio;
    private LocalDate vencimiento;
    private int stock;
    private Categoria_Producto categoria;

    /// CONSTRUCTORES
    public Producto(String nombre, String marca, double precio, LocalDate vencimiento, int stock, Categoria_Producto categoria) {
        this.id = cont++;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.vencimiento = vencimiento;
        this.stock = stock;
        this.categoria = categoria;
    }

    public Producto() {
        this.id = cont++;
    }

    /// GETTERS AND SETTERS
    public int getId() {
        return id;
    }

    public static int getCont() {
        return cont;
    }

    public static void setCont(int cont) {
        Producto.cont = cont;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDate getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(LocalDate vencimiento) {
        this.vencimiento = vencimiento;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Categoria_Producto getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria_Producto categoria) {
        this.categoria = categoria;
    }

    public void setId(int id) {
        this.id = id;
    }

    /// METODOS
    @Override
    public String toString() {
        return "|------------------------------------------------|\n" +
                "| [PRODUCTO]  ID: " + id + "\n" +
                "|------------------------------------------------|\n" +
                "|  Nombre: " + nombre + "\n" +
                "|  Marca: " + marca + "\n" +
                "|  Precio: $" + precio+ "\n" +
                "|  Vencimiento: " + vencimiento + "\n" +
                "|  Stock: " + stock + "\n" +
                "|  Categoría: " + categoria + "\n" +
                "|------------------------------------------------|";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Producto producto)) return false;
        return id == producto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public int compareTo(Producto aux) {
        return Double.compare(this.precio, aux.precio);
    }
}


