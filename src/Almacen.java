import java.util.HashMap;
import java.util.Map;

public class Almacen implements IGestor<Producto> {

    /// ATRIBUTOS
    private Map<Integer, Producto> productos = GestoraJSON.archivoAmap("productos.json");

    /// CONSTRUCTOR
    public Almacen() {
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
