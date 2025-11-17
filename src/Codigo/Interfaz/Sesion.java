package Codigo.Interfaz;
import Codigo.Logica.*;

public class Sesion {

    //Esto es para poder mantener el mismo Usuario en todos las clases

    private static Usuario usuarioActivo;

    private static Carrito carrito = new Carrito();

    public static Usuario getUsuarioActivo() {
        return usuarioActivo;
    }

    public static void setUsuarioActivo(Usuario usua) {
       usuarioActivo = usua;
    }

    public static void cerrarSesion(){
        usuarioActivo = null;
    }

    public static Carrito getCarrito() {
        return carrito;
    }

    public static void setCarrito(Carrito carrito) {
        Sesion.carrito = carrito;
    }

}

