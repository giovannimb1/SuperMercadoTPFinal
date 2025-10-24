
public class Cliente extends Usuario{


    /// CONSTRUCTORES

    public Cliente(String nombre, String apellido, String username, String email, String password) {
        super(nombre, apellido, username, email, password);
    }

    public Cliente() {
        super.setPermisos(false);
    }

    /// METODOS


}
