package Codigo.Interfaz;

import Codigo.Interfaz.ClasesAux.Metodos;
import Codigo.Interfaz.ClasesAux.PanelConFondoRepetido;
import Codigo.Interfaz.ClasesAux.ProductoVisual;
import Codigo.Logica.Producto;
import Codigo.Logica.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Menu extends JFrame {

    private JPanel contenedorProductos;
    private static Menu menu;

    public static Menu getInstancia() {
        return menu;
    }

    public JPanel getContenedorProductos() {
        return contenedorProductos;
    }

    public void setContenedorProductos(JPanel contenedorProductos) {
        this.contenedorProductos = contenedorProductos;
    }

    public Menu() {
        menu = this;

        Metodos.ventanasConfiguracionnTipica(this, "Menu Principal");


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

        contenedorProductos = new JPanel();

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
            dispose();

        });

        ProductoVisual.productosReutilizable(contenedorProductos);

        panel.add(cerrarSesion);

        panel.add(contenedorProductos);
        panel.add(bienvendo);
        panel.add(logochiquito);
        panel.add(decoracion1);



    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Menu().setVisible(true));
    }
}
