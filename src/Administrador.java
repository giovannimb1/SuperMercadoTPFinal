import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Administrador extends Usuario {

    /// CONSTRUCTORES

    public Administrador(String nombre, String apellido, String username, String email, String password) {
        super(nombre, apellido, username, email, password);
        super.setPermisos(true);
    }

    public Administrador() {
        super.setPermisos(true);
    }

    /// METODOS

    public void agregarProductos() {
        Scanner sc = new Scanner(System.in);

        // le pedimos todos los datos por teclado
        System.out.println("-----CREACION DEL PRODUCTO-----");

        // NOMBRE y MARCA
        String nombre = cargarTexto(sc, "Nombre: ");
        String marca = cargarTexto(sc, "Marca: ");

        // PRECIO
        double precio = cargarPrecio(sc);

        //VENCIMIENTO
        LocalDate fecha = cargarFecha(sc);

        //STOCK
        int stock = cargarStock(sc);

        //CATEGORIA
        Categoria_Producto categoria = cargarCategoria(sc);

        // creo el producto con los datos ingresados
        Producto p = new Producto(nombre, marca, precio, fecha, stock, categoria);

        // lo añadimos al almacen (map)
        System.out.println(Almacen.getInstancia().agregar(p));
    }

    public void eliminarProducto() {
        Scanner sc = new Scanner(System.in);

        int opcion = elegirProducto(sc, "Ingrese el ID del producto a eliminar");

        // lo borramos del almacen (map)
        System.out.println(Almacen.getInstancia().eliminar(opcion));
    }

    public void modificarProducto() {
        Scanner sc = new Scanner(System.in);
        char sino;

        int opcion = elegirProducto(sc, "Ingrese el ID del producto a modificar");
        Producto p = Almacen.getInstancia().getProductos().get(opcion);

        // NOMBRE
        if (check(sc, "NOMBRE")) {
            p.setNombre(cargarTexto(sc, "Nombre: "));
        }

        // MARCA
        if (check(sc, "MARCA")) {
            p.setMarca(cargarTexto(sc, "Marca: "));
        }

        // PRECIO
        if (check(sc, "PRECIO")) {
            p.setPrecio(cargarPrecio(sc));
        }

        // VENCIMIENTO
        if (check(sc, "VENCIMIENTO")) {
            p.setVencimiento(cargarFecha(sc));
        }

        // STOCK
        if (check(sc, "STOCK")) {
            p.setStock(cargarStock(sc));
        }

        // CATEGORIA
        if (check(sc, "CATEGORIA")) {
            p.setCategoria(cargarCategoria(sc));
        }

        // lo añadimos al almacen
        System.out.println(Almacen.getInstancia().modificar(p.getId(),p));
    }

    /// metodos para MODULARIZAR

    private String cargarTexto(Scanner sc, String texto) {
        System.out.print(texto);
        return sc.nextLine();
    }

    private double cargarPrecio(Scanner sc) {
        double precio = 0;
        do {
            try {
                System.out.print("Precio: ");
                precio = sc.nextDouble();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.err.println("Error: Precio invalido");
                sc.nextLine();
            }
        } while (precio <= 0);
        return precio;
    }

    private LocalDate cargarFecha(Scanner sc) {
        LocalDate fecha = null;
        String vencimiento;
        boolean flag;
        do {
            try {
                System.out.print("Vencimiento (aaaa-MM-dd) : ");
                vencimiento = sc.nextLine();
                fecha = LocalDate.parse(vencimiento);
                if (fecha.isBefore(LocalDate.now())) {
                    System.err.println("Error: Fecha invalida");
                    flag = false;
                } else {
                    flag = true;
                }
            } catch (DateTimeParseException e) {
                System.err.println("Error: Fecha mal ingresada");
                flag = false;
            }
        } while (!flag);
        return fecha;
    }

    private int cargarStock(Scanner sc) {
        int stock = 0;
        do {
            try {
                System.out.print("Stock: ");
                stock = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.err.println("Error: Stock invalido");
                sc.nextLine();
            }
        } while (stock <= 0);
        return stock;
    }

    private Categoria_Producto cargarCategoria(Scanner sc) {
        int opcion = -1;
        System.out.println("---CATEGORIAS---");
        Categoria_Producto[] cat = Categoria_Producto.values();
        for (int i = 0; i < cat.length; i++) {
            System.out.println((i + 1) + " - " + cat[i]);
        }

        do {
            try {
                System.out.println("Elegi una categoria: ");
                opcion = sc.nextInt();
                sc.nextLine();
                opcion--;
            } catch (InputMismatchException e) {
                System.err.println("Error: Categoria invalida");
                opcion = -1;
            }
        } while (opcion < 0 || opcion >= cat.length);
        return cat[opcion];
    }

    private int elegirProducto(Scanner sc, String texto) {
        int opcion;

        // mostramos todos los productos en el almacen
        System.out.println("-------PRODUCTOS EN EL ALMACEN-------\n");
        Almacen.getInstancia().listar();

        // y aca pedimos por teclado un id valido
        do {
            try {
                System.out.print(texto);
                opcion = sc.nextInt();
                sc.nextLine();
                if (!Almacen.getInstancia().getProductos().containsKey(opcion)) {
                    System.err.println("Error: ID inexistente");
                    opcion = -1;
                }
            } catch (InputMismatchException e) {
                System.err.println("Error: ID invalido");
                sc.nextLine();
                opcion = -1;
            }
        } while (opcion == -1);
        return opcion;
    }

    private boolean check(Scanner sc, String atributo) {
        System.out.println("Queres modificar el " + atributo + "? (s/n): ");
        char sino = sc.next().charAt(0);
        return sino == 's';
    }
}
