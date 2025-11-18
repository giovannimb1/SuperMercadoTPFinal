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
    // esto lo tuve q investigar pq necesitaba que solo haya UN almacen en tod el sistema
    // y asi los administradores operaban todos en el mismo almacen, lo que hace, al ser static
    // es que cuando se llama desde fuera, devuelve el UNICO almacen en el sistema , pero si no lo hay
    // lo crea en ese momento y dsp lo devuelve
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

    // esto solo añade el producto al map , si no esta lo añade y si ya esta lo sobreescribe
    // para dsp actualizar el json
    @Override
    public boolean agregar(Producto p) {
        productos.put(p.getId(), p);
        GestoraJSON.mapAarchivo("productos.json",productos);
        return true;
    }

    // este se fija que el id recibido pertenezca a un producto dentro del almacen
    // si existe , lo elimina y dsp actualiza el json
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


    //sincronizar cont
    // para que cuando se lea del json, el contador este bien ubicado
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
