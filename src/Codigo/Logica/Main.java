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

        Administrador test = new Administrador(
                "ewew",
                "rfrf",
                "gio",
                "jorge@gmail.com",
                "2468"
        );

        // probando
        //al unico Almacen ya le cargue el p1
        // a la unica Gestora de usuarios le cargue el admin

        System.out.println(Almacen.getInstancia().getProductos().size()); // 30
        System.out.println(Gestora.getInstancia().getUsuarios().size()); // 1

        try {
            System.out.println(Gestora.getInstancia().inicioSesion("jorgeC", "13579")); // usuario toString
            System.out.println(Gestora.getInstancia().inicioSesion("jorgec", "13579")); // null
        } catch (AutenticacionException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=======================\n");
        Almacen.getInstancia().listar();
        Gestora.getInstancia().listar();

        System.out.println("\n======PRUEBA======\n");
        System.out.println(Gestora.getInstancia().agregar(test));

        Producto[] productos = {
                new Producto("Queso Crema", "Casancrem", 1800, LocalDate.of(2025, 4, 2), 25, Categoria_Producto.LACTEO),
                new Producto("Yogur Frutado", "Ilolay", 720, LocalDate.of(2025, 3, 18), 30, Categoria_Producto.LACTEO),

                new Producto("Carne Molida", "Friar", 3500, LocalDate.of(2025, 2, 20), 15, Categoria_Producto.CARNE),
                new Producto("Pechuga de Pollo", "Granja Tres Arroyos", 2800, LocalDate.of(2025, 2, 15), 20, Categoria_Producto.CARNE),
                new Producto("Milanesa Vacuna", "Swift", 4200, LocalDate.of(2025, 3, 1), 18, Categoria_Producto.CARNE),

                new Producto("Manzanas Rojas", "El Trébol", 1100, LocalDate.of(2025, 2, 5), 50, Categoria_Producto.VEGETAL),
                new Producto("Papas", "CampoFresco", 900, LocalDate.of(2025, 2, 8), 60, Categoria_Producto.VEGETAL),
                new Producto("Zanahorias", "Hortalizas SA", 750, LocalDate.of(2025, 2, 12), 45, Categoria_Producto.VEGETAL),

                new Producto("Coca Cola", "Coca Cola", 1600, LocalDate.of(2026, 1, 1), 70, Categoria_Producto.BEBIDA),
                new Producto("Agua sin gas", "Villavicencio", 700, LocalDate.of(2026, 6, 1), 100, Categoria_Producto.BEBIDA),
                new Producto("Jugo de Naranja", "Cepita", 950, LocalDate.of(2025, 11, 12), 40, Categoria_Producto.BEBIDA),
                new Producto("Cerveza Rubia", "Quilmes", 1300, LocalDate.of(2025, 12, 1), 50, Categoria_Producto.BEBIDA),

                new Producto("Papas Fritas Clásicas", "Lays", 1250, LocalDate.of(2025, 10, 10), 60, Categoria_Producto.SNACK),
                new Producto("Bizcochitos", "Don Satur", 850, LocalDate.of(2025, 8, 1), 80, Categoria_Producto.SNACK),
                new Producto("Galletitas de Chocolate", "Pepitos", 900, LocalDate.of(2025, 7, 20), 90, Categoria_Producto.SNACK),
                new Producto("Alfajor Triple", "Havanna", 1500, LocalDate.of(2025, 9, 5), 70, Categoria_Producto.SNACK),

                new Producto("Shampoo Anticaspa", "Head & Shoulders", 2300, LocalDate.of(2027, 3, 10), 40, Categoria_Producto.HIGIENE),
                new Producto("Jabón Líquido", "Dove", 1900, LocalDate.of(2027, 4, 1), 35, Categoria_Producto.HIGIENE),
                new Producto("Pasta Dental", "Colgate", 1100, LocalDate.of(2027, 6, 15), 60, Categoria_Producto.HIGIENE),
                new Producto("Desodorante", "Rexona", 1600, LocalDate.of(2027, 5, 12), 50, Categoria_Producto.HIGIENE),

                new Producto("Lavandina", "Ayudín", 900, LocalDate.of(2026, 7, 1), 55, Categoria_Producto.LIMPIEZA),
                new Producto("Detergente", "Magistral", 1400, LocalDate.of(2026, 5, 22), 70, Categoria_Producto.LIMPIEZA),
                new Producto("Limpiador Multiuso", "Mr. Músculo", 1800, LocalDate.of(2026, 8, 13), 35, Categoria_Producto.LIMPIEZA),
                new Producto("Jabón en Polvo", "Ala", 2500, LocalDate.of(2026, 9, 1), 40, Categoria_Producto.LIMPIEZA),

                new Producto("Tomate Perita", "La Huerta", 920, LocalDate.of(2025, 2, 9), 55, Categoria_Producto.VEGETAL),
                new Producto("Bananas", "TropiRico", 1000, LocalDate.of(2025, 2, 6), 65, Categoria_Producto.VEGETAL),
                new Producto("Nuggets de Pollo", "Paty", 2000, LocalDate.of(2025, 9, 1), 30, Categoria_Producto.CARNE),
                new Producto("Queso Rallado", "La Paulina", 1400, LocalDate.of(2025, 4, 14), 50, Categoria_Producto.LACTEO),
                new Producto("Gaseosa de Lima", "Sprite", 1500, LocalDate.of(2026, 2, 1), 75, Categoria_Producto.BEBIDA)
        };

        // ya meti todos al json

    }
}