package Codigo.Interfaz;

import Codigo.Logica.Categoria_Producto;
import Codigo.Logica.Producto;
import Codigo.Logica.*;


import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class Menu extends JFrame {

    public Menu() {

        setIconImage(Toolkit.getDefaultToolkit().getImage(
                getClass().getResource("/img/logos/logo.png")));


        setTitle("SuperMercado");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        //Aca dependiendo el email q cargue los privilegios o no
        boolean admin = true;
        //


        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(14, 21, 37));


        ImageIcon img = new ImageIcon(getClass().getResource("/img/Menu/1.png"));
        JLabel fondo = new JLabel(img);
        fondo.setBounds(0, 0, 1280, 720);

        ImageIcon img2 = new ImageIcon(getClass().getResource("/img/Menu/2.png"));
        JLabel decoracion1 = new JLabel(img2);
        decoracion1.setBounds(0, 0, 1280, 720);

        ImageIcon img3 = new ImageIcon(getClass().getResource("/img/Menu/3.png"));
        JLabel decoracion2 = new JLabel(img3);
        decoracion2.setBounds(0, 0, 1280, 720);

        ImageIcon img4 = new ImageIcon(getClass().getResource("/img/Menu/4.png"));
        JLabel logochiquito = new JLabel(img4);
        logochiquito.setBounds(0, 0, 1280, 720);



        JScrollPane scroll = new JScrollPane(panel);
        scroll.setBounds(0, 0, 1280, 720);
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        add(scroll);


        //TEST
        if (admin) {
            JButton registrarProducto = new JButton("Registrar Producto");
            registrarProducto.setBounds(950, 67, 200, 40);
            registrarProducto.setBackground(new Color(80, 150, 255));
            registrarProducto.setForeground(Color.WHITE);
            registrarProducto.setFocusPainted(false);
            registrarProducto.addActionListener(e -> {

                boolean flag = true; // verificador

                if (flag) {
                    new RegistroProductos().setVisible(true);
                    dispose();
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
                new Carrito().setVisible(true);
                dispose();

            });
            panel.add(carritoBoton);


        }

        Producto x = new Producto("NOSE", "hola", 333, LocalDate.now(), 3, Categoria_Producto.LIMPIEZA);
        JPanel contenedor = new JPanel();
        contenedor.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        contenedor.setBackground(new Color(14, 21, 37));

        // ESPERANDO LISTA DE PRODUCTOS

        panel.add(logochiquito);
        panel.add(decoracion1);
        //panel.add(decoracion2);
        panel.add(fondo);


    }

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

        caja.add(nombre);
        caja.add(marca);
        caja.add(precio);

        return caja;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Menu().setVisible(true));
    }
}
