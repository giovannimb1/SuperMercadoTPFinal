package Codigo.Interfaz;

import Codigo.Logica.Usuario;

public class Sesion {

    private static Usuario usuarioActivo;

    public static Usuario getUsuarioActivo() {
        return usuarioActivo;
    }

    public static void setUsuarioActivo(Usuario usuarioActivo) {
        Sesion.usuarioActivo = usuarioActivo;
    }

    public static void cerrarSesion(){
        usuarioActivo = null;
    }


}
