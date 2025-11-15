package Codigo.Interfaz;

import Codigo.Logica.Categoria_Producto;
import Codigo.Logica.Producto;
import Codigo.Logica.*;


import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Menu extends JFrame {

    public Menu() {

        setIconImage(Toolkit.getDefaultToolkit().getImage(
                getClass().getResource("/img/logos/logo.png")));


        setTitle("SuperMercado");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(14, 21, 37));


        //esto funciona como una minipantalla
        JPanel contenedorProductos = new JPanel();
        contenedorProductos.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        contenedorProductos.setBackground(new Color(87, 112, 144));
        contenedorProductos.setBounds(50, 150, 1180, 500); // área donde se acomodarán



        ImageIcon img = new ImageIcon(getClass().getResource("/img/Menu/1.png"));
        JLabel fondo = new JLabel(img);
        fondo.setBounds(0, 0, 1280, 720);

        ImageIcon img2 = new ImageIcon(getClass().getResource("/img/Menu/2.png"));
        JLabel decoracion1 = new JLabel(img2);
        decoracion1.setBounds(0, 0, 1280, 720);

        ImageIcon img4 = new ImageIcon(getClass().getResource("/img/Menu/4.png"));
        JLabel logochiquito = new JLabel(img4);
        logochiquito.setBounds(0, 0, 1280, 720);

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

                boolean flag = true; // verificador

                if (flag) {
                    new RegistroProductos().setVisible(true);
                }

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


        // ESPERANDO LISTA DE PRODUCTOS

        Producto p1 = new Producto(
                "Leche Entera",
                "La Serenisima",
                850.50,
                LocalDate.of(2025, 11, 15),
                25,
                Categoria_Producto.LACTEO
        );

        ArrayList<JPanel> productos = new ArrayList<>();

        for(Producto p: Almacen.getInstancia().getProductos().values()){

            productos.add(productoAvisual(p,null));
        }


        panel.add(logochiquito);
        panel.add(decoracion1);

//se muestra
        for(JPanel p: productos){
            contenedorProductos.add(p);

        }



        panel.add(contenedorProductos);

        //Jbutton CerrarSesion = new

        panel.add(fondo);


    }

    //creador de productos

    private JPanel productoAvisual(Producto producto, String dirImg) {

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

        if(dirImg != null){

            ImageIcon img = new ImageIcon(getClass().getResource(dirImg));
            Image imagen = img.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
            img = new ImageIcon(imagen);

            foto = new JLabel (img);
            foto.setForeground(Color.WHITE);

        }else {

            ImageIcon img = new ImageIcon(getClass().getResource("/img/FotoProductos/0.jpg"));
            Image imagen = img.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            img = new ImageIcon(imagen);

            foto = new JLabel (img);
            foto.setForeground(Color.WHITE);



        }
        caja.add(nombre);
        caja.add(marca);
        caja.add(precio);
        caja.add(foto);

        if(!Sesion.getUsuarioActivo().isPermisos()){

            JButton mandarAlCarrito = new JButton("C:"+ producto.getStock());
            mandarAlCarrito.setForeground(Color.BLACK);


            mandarAlCarrito.addActionListener(e -> {
                if(Sesion.getCarrito().agregarProducto(producto.getId())){
                    //esto cambia el texto del boton
                    mandarAlCarrito.setText("C:" + producto.getStock());


                }else {
                    mandarAlCarrito.setText("Sin Stock");
                    Metodos.excepcionPantallaEmergente("No hay mas Productos");

                }

            });
            caja.add(mandarAlCarrito);

        }else {
            JButton modificar = new JButton("Modificar");
            modificar.setForeground(Color.WHITE);
            modificar.addActionListener(e->{
                ModificarProducto.setProducto(producto);
                new ModificarProducto().setVisible(true);


            });
            caja.add(modificar);


        }


        return caja;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Menu().setVisible(true));
    }
}
