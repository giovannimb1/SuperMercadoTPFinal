package Logica;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class GestoraJSON {

    /// METODOS

    /// /////////////// estos son para cargar , leer , serializar y deserializar productos

    public static void mapAarchivo(String nombreArchivo, Map<Integer, Producto> mapa) {
        OpLectEscrit.grabar(nombreArchivo, serializarMap(mapa));
    }

    public static Map<Integer, Producto> archivoAmap(String nombreArchivo) {
        Map<Integer, Producto> mapa = new HashMap<>();
        JSONTokener token = null;
        try {
            token = OpLectEscrit.leer(nombreArchivo);
            mapa = deserializarMap(new JSONArray(token));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mapa;
    }

    private static JSONArray serializarMap(Map<Integer, Producto> ps) {
        JSONArray jarray = new JSONArray();
        for (Producto p : ps.values()) {
            jarray.put(serializarProducto(p));
        }
        return jarray;
    }

    private static JSONObject serializarProducto(Producto p) {
        JSONObject jobj = null;
        try {
            jobj = new JSONObject();
            jobj.put("id", p.getId());
            jobj.put("nombre", p.getNombre());
            jobj.put("marca", p.getMarca());
            jobj.put("precio", p.getPrecio());
            jobj.put("vencimiento", p.getVencimiento().toString());
            jobj.put("stock", p.getStock());
            jobj.put("categoria", p.getCategoria().name());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jobj;
    }

    private static Map<Integer, Producto> deserializarMap(JSONArray jarray) {
        Map<Integer, Producto> ps = new HashMap<>();
        try {
            for (int i = 0; i < jarray.length(); i++) {
                Producto aux = deserializarProducto(jarray.getJSONObject(i));
                ps.put(aux.getId(), aux);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ps;
    }

    private static Producto deserializarProducto(JSONObject jobj) {
        Producto p = new Producto();
        try {
            p.setId(jobj.getInt("id"));
            p.setNombre(jobj.getString("nombre"));
            p.setMarca(jobj.getString("marca"));
            p.setPrecio(jobj.getDouble("precio"));
            p.setVencimiento(LocalDate.parse(jobj.getString("vencimiento")));
            p.setStock(jobj.getInt("stock"));
            p.setCategoria(Categoria_Producto.valueOf(jobj.getString("categoria")));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return p;
    }


    /// /////////////// estos son para cargar , leer , serializar y deserializar usuarios

    public static void setAarchivo(String nombreArchivo, Set<Usuario> usuarios) {
        OpLectEscrit.grabar(nombreArchivo, serializarSet(usuarios));
    }

    public static Set<Usuario> archivoAset(String nombreArchivo) {
        Set<Usuario> usuarios = new HashSet<>();
        JSONTokener token = null;
        try {
            token = OpLectEscrit.leer(nombreArchivo);
            usuarios = deserializarSet(new JSONArray(token));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    private static JSONArray serializarSet(Set<Usuario> ps) {
        JSONArray jarray = new JSONArray();
        for (Usuario u : ps) {
            jarray.put(serializarUsuario(u));
        }
        return jarray;
    }

    private static JSONObject serializarUsuario(Usuario u) {
        JSONObject jobj = null;
        try {
            jobj = new JSONObject();
            jobj.put("id", u.getId());
            jobj.put("nombre", u.getNombre());
            jobj.put("apellido", u.getApellido());
            jobj.put("username", u.getUsername());
            jobj.put("email", u.getEmail());
            jobj.put("password", u.getPassword());
            jobj.put("fecha_registro", u.getFechaRegistro().toString());
            jobj.put("permisos", u.isPermisos());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jobj;
    }

    private static Set<Usuario> deserializarSet(JSONArray jarray) {
        Set<Usuario> us = new HashSet<>();
        try {
            for (int i = 0; i < jarray.length(); i++) {
                us.add(deserializarUsuario(jarray.getJSONObject(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return us;
    }

    private static Usuario deserializarUsuario(JSONObject jobj) {
        Usuario u = null;
        try {
            boolean flag = jobj.getBoolean("permisos");
            if (flag) {
                u = new Administrador();
            } else {
                u = new Cliente();
            }
            u.setId(jobj.getInt("id"));
            u.setNombre(jobj.getString("nombre"));
            u.setApellido(jobj.getString("apellido"));
            u.setUsername(jobj.getString("username"));
            u.setEmail(jobj.getString("email"));
            u.setPassword(jobj.getString("password"));
            u.setFechaRegistro(LocalDate.parse(jobj.getString("fecha_registro")));
            u.setPermisos(jobj.getBoolean("permisos"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return u;
    }
}

