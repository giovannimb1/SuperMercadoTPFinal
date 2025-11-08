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
                Categoria_Producto.LACTEO
        );

        Administrador admin = new Administrador(
                "Jorge",
                "Perez",
                "jorgeC",
                "jorge@gmail.com",
                "13579"
        );

        // probando
                                        //al unico Almacen ya le cargue el p1
                                       // a la unica Gestora de usuarios le cargue el admin

        System.out.println(Almacen.getInstancia().getProductos().size()); // 1
        System.out.println(Gestora.getInstancia().getUsuarios().size()); // 1

        System.out.println(admin.iniciarSesion("jorgeC","13579")); // true
        System.out.println(admin.iniciarSesion("jorgec","13579")); // false

        Almacen.getInstancia().listar();
        Gestora.getInstancia().listar();

    }
}