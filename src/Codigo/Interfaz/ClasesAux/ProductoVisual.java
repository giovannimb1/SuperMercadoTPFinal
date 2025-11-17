package Codigo.Interfaz.ClasesAux;

import Codigo.Interfaz.Menu;
import Codigo.Interfaz.ModificarProducto;
import Codigo.Interfaz.Sesion;
import Codigo.Logica.Almacen;
import Codigo.Logica.Producto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ProductoVisual extends JPanel{




    //creador de productos

    public static JPanel productoAvisual(Producto producto) {

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
                img = new ImageIcon(ProductoVisual.class.getResource(producto.getDireccionImg()));
            } else {
                img = new ImageIcon(producto.getDireccionImg());
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

        if (!Sesion.getUsuarioActivo().isPermisos()) {

            JButton mandarAlCarrito = new JButton("C:" + producto.getStock());
            mandarAlCarrito.setForeground(Color.BLACK);


            mandarAlCarrito.addActionListener(e -> {
                if (Sesion.getCarrito().agregarProducto(producto.getId())) {
                    //esto cambia el texto del boton
                    mandarAlCarrito.setText("C:" + producto.getStock());


                } else {
                    mandarAlCarrito.setText("Sin Stock");
                    Metodos.excepcionPantallaEmergente("No hay mas Productos");

                }

            });
            caja.add(mandarAlCarrito);

        } else {
            JButton modificar = new JButton("Modificar");
            modificar.setForeground(Color.BLACK);

            modificar.addActionListener(e -> {

                new ModificarProducto(producto).setVisible(true);


            });
            caja.add(modificar);


        }


        return caja;
    }

    public static void productosReutilizable(JPanel contenedorProductos){

        contenedorProductos.removeAll();

        ArrayList<JPanel> productos = new ArrayList<>();

        for (Producto p : Almacen.getInstancia().getProductos().values()) {

            productos.add(productoAvisual(p));
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
