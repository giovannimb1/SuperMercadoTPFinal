package Codigo.Logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Carrito {

    /// ATRIBUTOS
    private List<Producto> productos = new ArrayList<>();
    private double total = 0;
    private Map<Integer, Producto> archivo = Almacen.getInstancia().getProductos();

    /// CONSTRUCTOR
    public Carrito() {

    }

    ///GETTER

    public List<Producto> getProductos() {
        return productos;
    }

    public double getTotal() {
        return total;
    }

    /// METODOS

    public boolean agregarProducto(int id){
        boolean flag = false;
        if(archivo.get(id)!=null && archivo.get(id).reducirStock()){
            flag = productos.add(archivo.get(id));
            total+=archivo.get(id).getPrecio();
        }
     return flag;
    }

    public boolean eliminarProducto(Producto p){
        p.aumentarStock();
        total-=p.getPrecio();
        return productos.remove(p);
    }

}
