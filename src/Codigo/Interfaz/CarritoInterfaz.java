package Codigo.Interfaz;

import Codigo.Interfaz.ClasesAux.Metodos;
import Codigo.Interfaz.ClasesAux.PanelConFondoRepetido;
import Codigo.Interfaz.ClasesAux.ProductoVisual;
import Codigo.Logica.Producto;
import Codigo.Logica.*;

import javax.swing.*;
import java.awt.*;

public class CarritoInterfaz extends JFrame {

    //CarritoInterfaz es la opcion 2 de productosReutilizable


    //atributos

    private JPanel contenedorProductos;

    //creo un atributo carrito para poder acceder desde Metodos de pago a carrito y lo instancio

    private static CarritoInterfaz carrito;

    public JPanel getContenedorProductos() {
        return contenedorProductos;
    }

    public void setContenedorProductos(JPanel contenedorProductos) {
        this.contenedorProductos = contenedorProductos;
    }

    public static CarritoInterfaz getInstancia() {
        return carrito;
    }


    public CarritoInterfaz() {

        //aca pongo this para instanciarlo
        carrito = this;

        //config
        Metodos.ventanasConfiguracionnTipica(this, "Carrito");

        JPanel panel = new PanelConFondoRepetido("/img/Menu/1.png");
        panel.setLayout(null);

        //esto permite q  se pueda scrolear en el panel

        JScrollPane scroll = new JScrollPane(panel);
        scroll.setBounds(0, 0, 1280, 720);
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        add(scroll);

        //agrego las imagenes y un texto bienvenido con el usuario actual

        ImageIcon img2 = new ImageIcon(getClass().getResource("/img/Menu/2.png"));
        JLabel decoracion1 = new JLabel(img2);
        decoracion1.setBounds(0, 0, 1280, 720);

        ImageIcon img4 = new ImageIcon(getClass().getResource("/img/Menu/4.png"));
        JLabel logochiquito = new JLabel(img4);
        logochiquito.setBounds(0, 0, 1280, 720);

        JLabel bienvendo = new JLabel("Bienvenido : " + Sesion.getUsuarioActivo().getUsername());
        bienvendo.setForeground(Color.BLACK);
        bienvendo.setFont(new Font("Segoe UI", Font.PLAIN, 36));
        bienvendo.setBounds(200, 65, 700, 40);

        //botones

        JButton finalizarCompra = new JButton("Finalizar Compra");
        finalizarCompra.setBounds(720, 67, 200, 40);
        finalizarCompra.setBackground(new Color(34, 164, 55));
        finalizarCompra.setForeground(Color.WHITE);
        finalizarCompra.setFocusPainted(false);


        finalizarCompra.addActionListener(e -> {



            //si tiene productos agarra y nos permite abrir el metodos
            // de pago sino nos rebota y pone q nose selecciono ningun producto

            if (((Cliente) Sesion.getUsuarioActivo()).tieneProductos()) {
                // hacer con metodo de gio
                new MetodosDePago().setVisible(true);
            } else {
                Metodos.excepcionPantallaEmergente("No tocaste ningun producto");
            }
        });


        JButton volverAlMenu = new JButton("Menu");
        volverAlMenu.setBounds(950, 67, 200, 40);
        volverAlMenu.setBackground(new Color(80, 150, 255));
        volverAlMenu.setForeground(Color.WHITE);
        volverAlMenu.setFocusPainted(false);
        volverAlMenu.addActionListener(e -> {


            new Menu().setVisible(true);
            dispose();

        });

        // y agrego al contenedor y al panel todos los jlabel
        contenedorProductos = new JPanel();

        ProductoVisual.cargadorDeContenedores(contenedorProductos,2); // esto refresca lo visual
        panel.add(finalizarCompra);
        panel.add(volverAlMenu);
        panel.add(contenedorProductos);
        panel.add(bienvendo);
        panel.add(logochiquito);
        panel.add(decoracion1);


    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CarritoInterfaz().setVisible(true));
    }
}
