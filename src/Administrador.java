import java.time.LocalDate;

public class Administrador extends Usuario{

   /// CONSTRUCTORES
    public Administrador(int id, String nombre, String apellido, String username, String email, String password, LocalDate fechaRegistro) {
        super(id, nombre, apellido, username, email, password, fechaRegistro);
        super.setPermisos(true);
    }

    public Administrador() {
        super.setPermisos(true);
    }

    /// METODOS

}
