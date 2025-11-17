package Codigo.Interfaz;

import Codigo.Interfaz.ClasesAux.Metodos;
import Codigo.Interfaz.ClasesAux.PanelConFondoRepetido;
import Codigo.Interfaz.ClasesAux.ProductoVisual;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {

    private JPanel contenedorProductos;
    private static Menu menu;

    public static Menu getInstancia() {
        return menu;
    }

    public JPanel getContenedorProductos() {
        return contenedorProductos;
    }

    //Menu es la opcion 1 de Producto a visual

    public void setContenedorProductos(JPanel contenedorProductos) {
        this.contenedorProductos = contenedorProductos;
    }

    public Menu() {
        menu = this;

        Metodos.ventanasConfiguracionnTipica(this, "Menu Principal");

        //es un fondo repetido por todox el espacio q se necesite dependiendo a el tamaño de los paneles de productos

        JPanel panel = new PanelConFondoRepetido("/img/Menu/1.png");
        panel.setPreferredSize(new Dimension(1280, 720));
        panel.revalidate();

        //agrego imagenes y el bienvenido de uuario

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

        //Esto permite usar la ruedita del mouse

        JScrollPane scroll = new JScrollPane(panel);
        scroll.setBounds(0, 0, 1280, 720);
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        add(scroll);

        contenedorProductos = new JPanel();


        //Aca en vez de hacer 2 clases distintas para modularizar y mantener algo mas sencillo opte por
        //Dependiendo los permisos del usuarioActivo mostrar un boton o otro

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

        //Boton obligatorio para los 2

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


        //Reinicio los contenedores
        ProductoVisual.cargadorDeContenedores(contenedorProductos,1);

        //en el panel agrego todos los jlabel

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
