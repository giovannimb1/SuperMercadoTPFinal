package Codigo.Logica;

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


    public boolean crearProducto(String nombreP, String stockP, String vencimientoP,
                                 String precioP, String marcaP, String categoriaP, String direccionImg)
            throws ProductoInvalidoException {

        int stock, precio;
        Categoria_Producto categoria;
        LocalDate vencimiento;

        try {
            if(nombreP == null || nombreP.isBlank() || marcaP == null || marcaP.isBlank()){
                throw new ProductoInvalidoException("Nombre y/o Marca invalidos");
            }
            stock = Integer.parseInt(stockP);
            precio = Integer.parseInt(precioP);
            if(stock < 1 || precio < 1){
                throw new ProductoInvalidoException("Precio y Stock deben ser mayores a 0");
            }
            categoria = Categoria_Producto.valueOf(categoriaP);
            vencimiento = LocalDate.parse(vencimientoP);
            if (vencimiento.isBefore(LocalDate.now())) {
                throw new ProductoInvalidoException("El producto ya esta vencido");
            }
        } catch (NumberFormatException e1) {
            throw new ProductoInvalidoException("Stock y/o Precio invalidos");
        } catch (DateTimeParseException e2){
            throw new ProductoInvalidoException("Fecha de vencimiento invalida\n  Formato: (aaa-mm-dd)");
        } catch (IllegalArgumentException e3){
            throw new ProductoInvalidoException("Categoria invalida");
        }
        return Almacen.getInstancia().agregar(new Producto(nombreP,marcaP,precio,vencimiento,stock,categoria,direccionImg));
    }

    public boolean modificarProducto(Producto p){
        return Almacen.getInstancia().modificar(p.getId(),p);
    }

    public boolean eliminarProducto(Producto p){
        return Almacen.getInstancia().eliminar(p.getId());
    }
}
