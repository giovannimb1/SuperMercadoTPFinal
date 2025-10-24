
public class Administrador extends Usuario{

    /// CONSTRUCTORES

    public Administrador(String nombre, String apellido, String username, String email, String password) {
        super(nombre, apellido, username, email, password);
        super.setPermisos(true);
    }

    public Administrador() {
        super.setPermisos(true);
    }

    /// METODOS

}
