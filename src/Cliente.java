import java.time.LocalDate;

public class Cliente extends Usuario{


    /// CONSTRUCTORES
    public Cliente(int id, String nombre, String apellido, String username, String email, String password, LocalDate fechaRegistro) {
        super(id, nombre, apellido, username, email, password, fechaRegistro);
        super.setPermisos(false);
    }

    public Cliente() {
        super.setPermisos(false);
    }

    /// METODOS


}
