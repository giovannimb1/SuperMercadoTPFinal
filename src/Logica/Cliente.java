package Logica;

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

    /// METODOS


}
