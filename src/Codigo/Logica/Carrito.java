package Codigo.Logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Carrito {

    /// ATRIBUTOS
    private List<Producto> productos = new ArrayList<>();
    private double total = 0;
      //este atributo para que dsp no tenga q usar siempre Almacen.getInstancia.getProductos. ....
      //cada que tengo que buscar un producto en el almacen
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

    /// SETTER
    public void setTotal(double total) {
        this.total = total;
    }

    /// METODOS

    // esto corrobora que el id corresponda a un producto valido y que el stock sea mayor a 0
    // cosa de que se pueda reducir en 1 , dsp lo añade al carrito y aumenta el precio total
    public boolean agregarProducto(int id){
        boolean flag = false;
        if(archivo.get(id)!=null && archivo.get(id).reducirStock()){
            flag = productos.add(archivo.get(id));
            total+=archivo.get(id).getPrecio();
        }
     return flag;
    }

    // esto elimina un producto que si o si esta en el carrito y dsp reduce el precio total
    // del carrito segun lo q valia ese producto
    public boolean eliminarProducto(Producto p){
        p.aumentarStock();
        total-=p.getPrecio();
        return productos.remove(p);
    }

}
