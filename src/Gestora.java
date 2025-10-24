import java.util.HashSet;
import java.util.Set;

public class Gestora implements IGestor<Usuario> {

    /// ATRIBUTOS
    private Set<Usuario> usuarios = new HashSet<>();

    /// CONSTRUCTOR
    public Gestora() {
    }

    /// GETTER
    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    /// METODOS

    @Override
    public String agregar(Usuario u){
        usuarios.add(u);
        return "El Usuario ("+u.getUsername()+") ha sido creado correctamente";
    }

    @Override
    public String eliminar(int id){
        String txt = "El ID no corresponde a ningun usuario en el sistema";
        return txt;    ///LO DEJE ACA INCOMPLETO,  NO LO TOQUEN
    }

    @Override
    public String modificar(int id, Usuario u){
        return "";        ///LO DEJE ACA INCOMPLETO,  NO LO TOQUEN
    }

    @Override
    public void listar(){
        ///LO DEJE ACA INCOMPLETO,  NO LO TOQUEN
    }
}
