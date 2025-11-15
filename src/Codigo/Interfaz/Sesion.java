package Codigo.Interfaz;
import Codigo.Logica.*;

public class Sesion {
    private static Usuario usuarioActivo;

    public static Usuario getUsuarioActivo() {
        return usuarioActivo;
    }

    public static void setUsuarioActivo(Usuario usua) {
       usuarioActivo = usua;
    }

    public static void cerrarSesion(){
        usuarioActivo = null;
    }


}

