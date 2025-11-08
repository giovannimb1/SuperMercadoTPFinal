package Codigo.Logica;

import java.util.Iterator;
import java.util.Set;

public class Gestora implements IGestor<Usuario> {

    /// ATRIBUTOS
    private static Gestora instancia;
    private Set<Usuario> usuarios = GestoraJSON.archivoAset("usuarios.json");

    /// CONSTRUCTOR
    public Gestora() {
    }

    //singleton
    public static Gestora getInstancia() {
        if (instancia == null) {
            instancia = new Gestora();
        }
        return instancia;
    }

    /// GETTER
    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    /// METODOS

    @Override
    public String agregar(Usuario u) {
        usuarios.add(u);
        return "El Usuario (" + u.getUsername() + ") ha sido creado correctamente";
    }

    @Override
    public String eliminar(int id) {
        String txt = "El ID no corresponde a ningun usuario en el sistema";
        Iterator<Usuario> it = usuarios.iterator();
        while (it.hasNext()) {
            Usuario u = it.next();
            if (u.getId() == id) {
                it.remove();
                txt = "El Usuario (" + u.getUsername() + ") ha sido eliminado del sistema correctamente";
                break;
            }
        }
        return txt;
    }

    @Override
    public String modificar(int id, Usuario u) {
        String txt = "El ID no corresponde a ningun usuario en el sistema";
        Iterator<Usuario> it = usuarios.iterator();
        while (it.hasNext()) {
            Usuario us = it.next();
            if (us.getId() == id) {
                it.remove();
                usuarios.add(u);
                txt = "El Usuario (" + u.getUsername() + ") ha sido modificado del sistema correctamente";
                break;
            }
        }
        return txt;
    }

    @Override
    public void listar() {
        for (Usuario u : usuarios) {
            System.out.println(u);
        }
    }
}
