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

    // agrega un producto x por el id que llega desde la interfaz grafica
    // y dependiendo de si se pudo agregar o no tira true/false
    public boolean agregarProducto(int id){
        return carrito.agregarProducto(id);
    }

    // elimina un producto que llega por la interfaz grafica y q
    // si o si esta en el carrito
    public boolean eliminarProducto(Producto p){
        return carrito.eliminarProducto(p);
    }

    // metodo para usAr en la interfaz grafica
    public boolean tieneProductos(){
        return !carrito.getProductos().isEmpty();
    }


}
