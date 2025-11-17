package Codigo.Interfaz;

import Codigo.Logica.Producto;
import Codigo.Logica.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CarritoInterfaz extends JFrame {

    private JPanel contenedorProductos;
    private static CarritoInterfaz CarritoInterfaz;



    public CarritoInterfaz() {
        CarritoInterfaz = this;

        setIconImage(Toolkit.getDefaultToolkit().getImage(
                getClass().getResource("/img/logos/logo.png")));



        setTitle("SuperMercado");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);


        JPanel panel = new PanelConFondoRepetido("/img/Menu/1.png");
        panel.setLayout(null);

        ImageIcon img2 = new ImageIcon(getClass().getResource("/img/Menu/2.png"));
        JLabel decoracion1 = new JLabel(img2);
        decoracion1.setBounds(0, 0, 1280, 720);

        ImageIcon img4 = new ImageIcon(getClass().getResource("/img/Menu/4.png"));
        JLabel logochiquito = new JLabel(img4);
        logochiquito.setBounds(0, 0, 1280, 720);

        JLabel bienvendo = new JLabel("Bienvenido : " + Sesion.getUsuarioActivo().getUsername());
        bienvendo.setForeground(Color.BLACK);
        bienvendo.setFont(new Font("Segoe UI", Font.PLAIN, 36));
        bienvendo.setBounds(200, 65, 400, 40);

        JScrollPane scroll = new JScrollPane(panel);
        scroll.setBounds(0, 0, 1280, 720);
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        add(scroll);


        //TEST
        if (Sesion.getUsuarioActivo().isPermisos()) {
            JButton registrarProducto = new JButton("Registrar Producto");
            registrarProducto.setBounds(950, 67, 200, 40);
            registrarProducto.setBackground(new Color(80, 150, 255));
            registrarProducto.setForeground(Color.WHITE);
            registrarProducto.setFocusPainted(false);
            registrarProducto.addActionListener(e -> {


                new RegistroProductos().setVisible(true);

            });
            panel.add(registrarProducto);


        } else {

            ImageIcon carrito = new ImageIcon(getClass().getResource("/img/iconos/carrito-de-compras.png"));
            Image imagen = carrito.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
            carrito = new ImageIcon(imagen);
            JButton carritoBoton = new JButton(carrito);
            carritoBoton.setBounds(950, 67, 200, 40);
            carritoBoton.setForeground(Color.WHITE);
            carritoBoton.setFocusPainted(false);
            carritoBoton.addActionListener(e -> {
                new CarritoInterfaz().setVisible(true);
                dispose();

            });
            panel.add(carritoBoton);


        }

        JButton cerrarSesion = new JButton("Cerrar Sesion");
        cerrarSesion.setBounds(720, 67, 200, 40);
        cerrarSesion.setBackground(new Color(255, 49, 49));
        cerrarSesion.setForeground(Color.WHITE);
        cerrarSesion.setFocusPainted(false);
        cerrarSesion.addActionListener(e -> {

            Sesion.cerrarSesion();
            new Intro().setVisible(true);


        });

        contenedorProductos = new JPanel();
        carritoAproductos();

        panel.add(cerrarSesion);

        panel.add(contenedorProductos);
        panel.add(bienvendo);
        panel.add(logochiquito);
        panel.add(decoracion1);



    }

    public void carritoAproductos(){

        contenedorProductos.removeAll();

        ArrayList<JPanel> productos = new ArrayList<>();

        if(Sesion.getUsuarioActivo() instanceof Cliente) {
            for (Producto p : ((Cliente) Sesion.getUsuarioActivo()).getCarrito().getProductos()) {

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

    public static CarritoInterfaz getInstancia() {
        return CarritoInterfaz;
    }

    //creador de productos

    private JPanel productoAvisual(Producto producto) {

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
                img = new ImageIcon(getClass().getResource(producto.getDireccionImg()));
            } else {
                img = new ImageIcon(producto.getDireccionImg());
            }
        } else {
            img = new ImageIcon(getClass().getResource("/img/FotoProductos/0.jpg"));
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

            JButton sacarDelCarrito = new JButton("Sacar");
            sacarDelCarrito.setForeground(Color.BLACK);


            sacarDelCarrito.addActionListener(e -> {

                if (Sesion.getUsuarioActivo() instanceof Cliente){

                    if(((Cliente) Sesion.getUsuarioActivo()).eliminarProducto(producto)){

                    }else {
                        Metodos.excepcionPantallaEmergente("Error");
                    }

                }

            });
            caja.add(sacarDelCarrito);

        }


        return caja;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Menu().setVisible(true));
    }
}
