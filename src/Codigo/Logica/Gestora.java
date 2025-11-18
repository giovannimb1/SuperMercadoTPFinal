package Codigo.Logica;

import java.util.Iterator;
import java.util.Set;

public class Gestora implements IGestor<Usuario> {

    /// ATRIBUTOS
    private static Gestora instancia; //singleton
    private Set<Usuario> usuarios = GestoraJSON.archivoAset("usuarios.json");

    /// CONSTRUCTOR
    public Gestora() {
        sincronizarCont();
    }

    //singleton
    // explique el por que y como funciona en la clase almacen
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

    // si el usuario no existia , lo añade y lo mete al json para despues devolver true
    // a la interfaz , sino false
    @Override
    public boolean agregar(Usuario u) {
        boolean flag = false;
        if(usuarios.add(u)){
            flag = true;
            GestoraJSON.setAarchivo("usuarios.json",usuarios);
        }
        return flag;
    }

    // aca busca a ese usuario por id , si no lo encuentra devuelve false a la interfaz
    // pero si esta, lo elimina y actualiza el json (esta hecho con iterator por la concurrencia)
    @Override
    public boolean eliminar(int id) {
       boolean flag = false;
        Iterator<Usuario> it = usuarios.iterator();
        while (it.hasNext()) {
            Usuario u = it.next();
            if (u.getId() == id) {
                it.remove();
                flag = true;
                GestoraJSON.setAarchivo("usuarios.json",usuarios);
                break;
            }
        }
        return flag;
    }


    // chequea que lo que ingresa el usuario en la interfaz grafica coincida
    // con los datos de un usuario en el sistema y retorna ese usuario o excepcion dependiendo
    public Usuario inicioSesion(String us, String pass) throws AutenticacionException {
        for(Usuario u : usuarios){
            if(u.username.equals(us) && u.password.equals(pass)){
                return u;
            }
        }
      throw new AutenticacionException("Usuario y/o contraseña incorrectos");
    }

    //sincronizar cont
    // para que cuando se lea del json, el contador este bien ubicado
    private void sincronizarCont(){
        int idMax=0;
        for(Usuario u : usuarios){
            if(idMax < u.getId()){
                idMax = u.getId();
            }
        }
     Usuario.setCont(idMax+1);
    }
}
