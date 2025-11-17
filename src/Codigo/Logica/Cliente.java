package Codigo.Logica;

public class Cliente extends Usuario {

    /// ATRIBUTO
    private Carrito carrito = new Carrito();

    /// CONSTRUCTORES

    public Cliente(String nombre, String apellido, String username, String email, String password) {
        super(nombre, apellido, username, email, password);
        super.setPermisos(false);
    }

    public Cliente() {
        super.setPermisos(false);
    }

    /// GETTER
    public Carrito getCarrito() {
        return carrito;
    }

    /// METODOS
    public boolean agregarProducto(int id){
        return carrito.agregarProducto(id);
    }

    public boolean eliminarProducto(Producto p){
        return carrito.eliminarProducto(p);
    }

    public boolean tieneProductos(){
        return !carrito.getProductos().isEmpty();
    }
}
