package Codigo.Logica;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {


            /*
            NO ME BORREn esto q es para probar
            */
        Producto p1 = new Producto(
                "Leche Entera",
                "La Serenisima",
                850.50,
                LocalDate.of(2025, 11, 15),
                25,
                Categoria_Producto.LACTEO,
                null
        );

        Administrador admin = new Administrador(
                "Jorge",
                "Perez",
                "jorgeC",
                "jorge@gmail.com",
                "13579"
        );

        Administrador test = new Administrador(
                "ewew",
                "rfrf",
                "gio",
                "jorge@gmail.com",
                "2468"
        );

        Cliente ctest = new Cliente(
                "holasi",
                "chauno",
                "holachau",
                "holasichauno@gmail.com",
                "jojo"
        );


        // probando
        //al unico Almacen ya le cargue los 30p
        // a la unica Gestora de usuarios le cargue el admin

        System.out.println(Almacen.getInstancia().getProductos().size()); // 30
        System.out.println(Gestora.getInstancia().getUsuarios().size()); // 1

        try {
            System.out.println(Gestora.getInstancia().inicioSesion("jorgeC", "13579")); // usuario toString
            System.out.println(Gestora.getInstancia().inicioSesion("jorgec", "13579")); // excepction
        } catch (AutenticacionException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=======================\n");
        Almacen.getInstancia().listar();
        Gestora.getInstancia().listar();

        System.out.println("\n======PRUEBA======\n");
        System.out.println(Gestora.getInstancia().agregar(test));
        System.out.println(Gestora.getInstancia().agregar(ctest));

        // ya meti todos al json
        ctest.agregarProducto(p1.getId());
        ctest.agregarProducto(p1.getId());
        ctest.agregarProducto(p1.getId());
        System.out.println(ctest.getCarrito().getTotal());
    }
}