package Logica;

import java.util.Map;

public class Almacen implements IGestor<Producto> {

    /// ATRIBUTOS
    private static Almacen instancia; //singleton
    private Map<Integer, Producto> productos = GestoraJSON.archivoAmap("productos.json");

    /// CONSTRUCTOR
    private Almacen() {
    }

    //singleton
    public static Almacen getInstancia(){
        if(instancia == null){
            instancia = new Almacen();
        }
      return instancia;
    }

    /// GETTER
    public Map<Integer, Producto> getProductos() {
        return productos;
    }

    /// METODOS

    @Override
    public String agregar(Producto p) {
        productos.put(p.getId(), p);
        return "El Producto (" + p.getNombre() + ") ha sido añadido correctamente al almacen";
    }

    @Override
    public String eliminar(int id) {
        String txt = "El ID: " + id + " no corresponde a ningun producto dentro del almacen";
        if (productos.containsKey(id)) {
            productos.remove(id);
            txt = "El Producto correspondiente a ese ID (" + id + ") fue eliminado del almacen";
        }
        return txt;
    }

    @Override
    public String modificar(int id, Producto p) {
        String txt = "El ID: " + id + " no corresponde a ningun producto dentro del almacen";
        if (productos.containsKey(id)) {
            productos.put(id, p);
            txt = "El Producto (" + p.getNombre() + ") ha sido modificado correctamente";
        }
        return txt;
    }

    @Override
    public void listar(){
        for(Producto p : productos.values()){
            System.out.println(p);
        }
    }
}
