import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {


            /*
            NO ME BORREn esto
            */
        Producto p1 = new Producto(
                "Leche Entera",
                "La Serenisima",
                850.50,
                LocalDate.of(2025, 11, 15),
                25,
                Categoria_Producto.LACTEO
        );

        Administrador admin = new Administrador(
                "Jorge",
                "Perez",
                "jorgeC",
                "jorge@gmail.com",
                "13579"
        );

        /// probando
        Almacen alm = new Almacen();   /// ya le cargue el p1
        Gestora gest = new Gestora();  /// ya le cargue el admin

        System.out.println(alm.getProductos().size());
        System.out.println(gest.getUsuarios().size());

        System.out.println(admin.iniciarSesion("jorgeC","13579"));
        System.out.println(admin.iniciarSesion("jorgec","13579"));
    }
}