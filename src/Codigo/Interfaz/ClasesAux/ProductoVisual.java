package Codigo.Interfaz.ClasesAux;

import Codigo.Interfaz.CarritoInterfaz;
import Codigo.Interfaz.Menu;
import Codigo.Interfaz.ModificarProducto;
import Codigo.Interfaz.Sesion;
import Codigo.Logica.Almacen;
import Codigo.Logica.Cliente;
import Codigo.Logica.Producto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ProductoVisual extends JPanel {


    //creador de productos

    //Unificar
    public static JPanel productoAvisual(Producto producto, int opcion, JPanel contenedorProductos) {

        JPanel caja = new JPanel();
        caja.setPreferredSize(new Dimension(200, 200));
        caja.setBackground(new Color(50, 60, 80));
        caja.setLayout(new BoxLayout(caja, BoxLayout.Y_AXIS));
        caja.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel nombre = new JLabel(producto.getNombre());
        nombre.setForeground(Color.WHITE);

        JLabel marca = new JLabel("Marca: " + producto.getMarca());
        marca.setForeground(Color.WHITE);

        JLabel precio = new JLabel("$" + producto.getPrecio());
        precio.setForeground(Color.WHITE);


        JLabel foto = null;

        ImageIcon img;

        // aca busca la imagen en el json

        if (producto.getDireccionImg() != null) {
            if (producto.getDireccionImg().startsWith("/")) {

                img = new ImageIcon(
                        ProductoVisual.class.getResource("/" + producto.getDireccionImg())
                );

            } else {
                img = new ImageIcon(
                        ProductoVisual.class.getResource("/" + producto.getDireccionImg())

                );

            }
        } else {
            img = new ImageIcon(ProductoVisual.class.getResource("/img/FotoProductos/0.jpg"));
        }

        Image imagenEscalada = img.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        img = new ImageIcon(imagenEscalada);

        foto = new JLabel(img);
        foto.setForeground(Color.WHITE);

        caja.add(nombre);
        caja.add(marca);
        caja.add(precio);
        caja.add(foto);

        //
        if (opcion == 2) {

            JButton sacarDelCarrito = new JButton("Sacar");
            sacarDelCarrito.setForeground(Color.WHITE);
            sacarDelCarrito.setBackground(new Color(255, 35, 35));

            sacarDelCarrito.addActionListener(e -> {

                if (((Cliente) Sesion.getUsuarioActivo()).eliminarProducto(producto)) {
                    Menu.getInstancia().refrescadorDeMonto();
                    CarritoInterfaz.getInstancia().refrescadorDeMonto();

                    ProductoVisual.cargadorDeContenedores(contenedorProductos, 2);
                    contenedorProductos.revalidate();// refresco el contenedor nomas :"v
                    contenedorProductos.repaint();



                } else {
                    Metodos.excepcionPantallaEmergente("Error");
                }



            });
            caja.add(sacarDelCarrito);
        } else if (opcion == 1) {
            if (!Sesion.getUsuarioActivo().isPermisos()) {

                JButton mandarAlCarritoBoton = new JButton("C:" + producto.getStock());
                mandarAlCarritoBoton.setForeground(Color.BLACK);


                mandarAlCarritoBoton.addActionListener(e -> {

                    //Pasar producto
                    if (((Cliente) Sesion.getUsuarioActivo()).agregarProducto(producto.getId())) {

                        //esto cambia el texto del boton
                        mandarAlCarritoBoton.setText("C:" + producto.getStock());
                        Menu.getInstancia().refrescadorDeMonto();


                    } else {
                        mandarAlCarritoBoton.setText("Sin Stock");
                        Metodos.excepcionPantallaEmergente("No hay mas Productos");

                    }

                });
                caja.add(mandarAlCarritoBoton);

            } else {
                JButton modificar = new JButton("Modificar");
                modificar.setForeground(Color.BLACK);

                modificar.addActionListener(e -> {

                    new ModificarProducto(producto).setVisible(true);


                });
                caja.add(modificar);


            }
        }


        return caja;
    }

    //Unificarlo

    public static void cargadorDeContenedores(JPanel contenedorProductos, int opcion) {

        contenedorProductos.removeAll();

        ArrayList<JPanel> productos = new ArrayList<>();

        //opcion 1 menu //opcion 2 carrito
        if (opcion == 1) {


            for (Producto p : Almacen.getInstancia().getProductos().values()) {

                productos.add(productoAvisual(p,1,contenedorProductos));
            }
        } else if (opcion == 2) {
            for (Producto p : ((Cliente) Sesion.getUsuarioActivo()).getCarrito().getProductos()) {
                productos.add(productoAvisual(p,2, contenedorProductos));
            }
        }


        contenedorProductos.setPreferredSize(new Dimension(1180, productos.size() * 220));
        contenedorProductos.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        contenedorProductos.setBackground(new Color(87, 112, 144));
        contenedorProductos.setOpaque(false);


        for (JPanel p : productos) {
            contenedorProductos.add(p);
        }


        int altoTotal = productos.size() * 220;

        contenedorProductos.setBounds(40, 150, 1180, altoTotal);
        contenedorProductos.revalidate();
        contenedorProductos.repaint();

    }


}
