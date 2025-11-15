package Codigo.Logica;

import java.util.Iterator;
import java.util.Set;

public class Gestora implements IGestor<Usuario> {

    /// ATRIBUTOS
    private static Gestora instancia; //singleton
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
    public boolean agregar(Usuario u) {
        return usuarios.add(u);
    }

    @Override
    public boolean eliminar(int id) {
       boolean flag = false;
        Iterator<Usuario> it = usuarios.iterator();
        while (it.hasNext()) {
            Usuario u = it.next();
            if (u.getId() == id) {
                it.remove();
                flag = true;
                break;
            }
        }
        return flag;
    }

    @Override
    public boolean modificar(int id, Usuario u) {
       boolean flag = false;
        Iterator<Usuario> it = usuarios.iterator();
        while (it.hasNext()) {
            Usuario us = it.next();
            if (us.getId() == id) {
                it.remove();
                flag = usuarios.add(u);
                break;
            }
        }
        return flag;
    }

    @Override
    public void listar() {
        for (Usuario u : usuarios) {
            System.out.println(u);
        }
    }

    public Usuario inicioSesion(String us, String pass) throws AutenticacionException {
        for(Usuario u : usuarios){
            if(u.username.equals(us) && u.password.equals(pass)){
                return u;
            }
        }
      throw new AutenticacionException("Usuario y/o contraseña incorrectos");
    }
}
