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
    private String direccionImg;

    /// CONSTRUCTORES (los 2 constructores le dan un id a cada producto q se crea)
    public Producto(String nombre, String marca, double precio, LocalDate vencimiento, int stock, Categoria_Producto categoria, String direccionImg) {
        this.id = cont++;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.vencimiento = vencimiento;
        this.stock = stock;
        this.categoria = categoria;
       // if(direccionImg == null || direccionImg.isBlank()){
         //   this.direccionImg = "/img/FotoProductos/0.jpg";
        //}else{
            this.direccionImg = direccionImg;
       // }
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

    public String getDireccionImg() {
        return direccionImg;
    }

    public void setDireccionImg(String direccionImg) {
        this.direccionImg = direccionImg;
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
                "|  Direccion Imagen: " + direccionImg +"\n"+
                "|------------------------------------------------|";
    }

    // un producto es considerado igual a otro si comparten el mismo id
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Producto producto)) return false;
        return id == producto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    // esto era por si mas adelante filtrabamos por precio pero no lo hicimos
    @Override
    public int compareTo(Producto aux) {
        return Double.compare(this.precio, aux.precio);
    }

    // estos 2 reducen o aumentan el stock de un producto x para cuando un cliente
    // agrega o elimina ese producto x de su carrito
    public boolean reducirStock(){
        boolean flag = false;
        if(this.stock > 0){
            this.stock--;
            flag = true;
        }
     return flag;
    }

    public void aumentarStock(){
        this.stock++;
    }
}


