package Codigo.Logica;

import java.util.Map;

public class Almacen implements IGestor<Producto> {

    /// ATRIBUTOS
    private static Almacen instancia; //singleton
    private Map<Integer, Producto> productos = GestoraJSON.archivoAmap("productos.json");

    /// CONSTRUCTOR
    private Almacen() {
        sincronizarCont();
    }

    //singleton
    public static Almacen getInstancia() {
        if (instancia == null) {
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
    public boolean agregar(Producto p) {
        productos.put(p.getId(), p);
        GestoraJSON.mapAarchivo("productos.json",productos);
        return true;
    }

    @Override
    public boolean eliminar(int id) {
      boolean flag = false;
        if (productos.containsKey(id)) {
            productos.remove(id);
            GestoraJSON.mapAarchivo("productos.json",productos);
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean modificar(int id, Producto p) {
       boolean flag = false;
        if (productos.containsKey(id)) {
            productos.put(id, p);
            GestoraJSON.mapAarchivo("productos.json",productos);
            flag = true;
        }
        return flag;
    }

    @Override
    public void listar() {
        for (Producto p : productos.values()) {
            System.out.println(p);
        }
    }

    // sincronizar contador
    private void sincronizarCont(){
        int idMax=0;
        for(Producto p : productos.values()){
            if(idMax < p.getId()){
                idMax = p.getId();
            }
        }
     Producto.setCont(idMax+1);
    }
}
