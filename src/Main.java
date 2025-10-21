import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Producto p1 = new Producto(
                "Leche Entera",
                "La Serenísima",
                850.50,
                LocalDate.of(2025, 11, 15),
                25,
                Categoria_Producto.LACTEO
        );

        System.out.println(p1);
    }
}