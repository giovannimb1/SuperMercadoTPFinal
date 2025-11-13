package Codigo.Logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Carrito {

    /// ATRIBUTOS
    private List<Producto> productos = new ArrayList<>();
    private double total = 0;
    private boolean finalizado = false;
    private Map<Integer, Producto> archivo = Almacen.getInstancia().getProductos();

    /// CONSTRUCTOR
    public Carrito() {

    }

    /// METODOS

    public boolean agregarProducto(int id){
        boolean flag = false;
        if(archivo.get(id)!=null && archivo.get(id).reducirStock()){
            flag = productos.add(archivo.get(id));
        }
     return flag;
    }

    public boolean eliminarProducto(Producto p){
        p.aumentarStock();
        return productos.remove(p);
    }

}
