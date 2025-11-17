package Codigo.Interfaz;

import Codigo.Interfaz.ClasesAux.Metodos;
import Codigo.Interfaz.ClasesAux.ProductoVisual;
import Codigo.Logica.Almacen;
import Codigo.Logica.Cliente;
import Codigo.Logica.GestoraJSON;

import javax.swing.*;

public class MetodosDePago extends JFrame {


    //esta clase es medio fachada para poder tener un metodo de pago en un futuro,
    //faltan comprobaciones que no podemos verificar con lo que sabemos actualmente
    //entonces simplemente lo q hace es cubrir 2 botones con una imagen redimensionada
    //y cuando se presione una actualizar el menu y el carrito haciendo q se vean los cambios en el json

    private CarritoInterfaz carrito;

    public MetodosDePago() {

        Metodos.ventanasConfiguracionnTipica(this, "Metodos De Pago");

        JPanel panel = new JPanel(null);
        add(panel);


        //dos imagenes de metodos de pago
        ImageIcon img = new ImageIcon(getClass().getResource("/img/MetodosDePago/fondo.png"));
        JLabel fondo = new JLabel(img);
        fondo.setBounds(0, 0, 1280, 720);


        ImageIcon imge = new ImageIcon(getClass().getResource("/img/MetodosDePago/mp.png"));
        JButton metodo1 = new JButton(imge);
        metodo1.setBounds(200, 140, 373, 392);
        metodo1.setBorderPainted(false);
        metodo1.setContentAreaFilled(false);
        metodo1.setFocusPainted(false);

        metodo1.addActionListener(e -> {

            Metodos.excepcionPantallaEmergente("Pago Realizado");

            ((Cliente) Sesion.getUsuarioActivo()).getCarrito().getProductos().clear();

            GestoraJSON.mapAarchivo("productos.json", Almacen.getInstancia().getProductos());

            //reinica el menu
            ProductoVisual.cargadorDeContenedores(Menu.getInstancia().getContenedorProductos(), 2);

            //aca instancio la clase interfaz carrito para poder acceder a ella
            CarritoInterfaz carrito = CarritoInterfaz.getInstancia();

            //aca verifica q alla algo en el carrito por las dudas aunque ya fue previamente verificado
            //para evitar errores

            if (carrito != null) {
                ProductoVisual.cargadorDeContenedores(carrito.getContenedorProductos(), 2);  // borra y lo vuelve a poner
                carrito.revalidate();         //y esto simplemente agarra y vuelve a generar el layout y el panel
                carrito.repaint();
            }


            dispose();
        });

        ImageIcon img2 = new ImageIcon(getClass().getResource("/img/MetodosDePago/tarjetas.png"));
        JButton metodo2 = new JButton(img2);
        metodo2.setBounds(700, 140, 389, 395);

        metodo2.setBorderPainted(false);
        metodo2.setContentAreaFilled(false);
        metodo2.setFocusPainted(false);

        metodo2.addActionListener(e -> {


            Metodos.excepcionPantallaEmergente("Pago Realizado");

            ((Cliente) Sesion.getUsuarioActivo()).getCarrito().getProductos().clear();

            GestoraJSON.mapAarchivo("productos.json", Almacen.getInstancia().getProductos());

            //reinica el menu
            ProductoVisual.cargadorDeContenedores(Menu.getInstancia().getContenedorProductos(), 2);

            //instancio carrito
            CarritoInterfaz carrito = CarritoInterfaz.getInstancia();

            //aca verifica q alla algo en el carrito por las dudas aunque ya fue previamente verificado
            //para evitar errores



            if (carrito != null) {
                ProductoVisual.cargadorDeContenedores(carrito.getContenedorProductos(), 2);  // borra y lo vuelve a poner
                carrito.revalidate();         //y esto simplemente agarra y vuelve a generar el layout y el panel
                carrito.repaint();
            }


            dispose();

            //
        });

        //pongo en el panel los label

        panel.add(metodo1);
        panel.add(metodo2);
        panel.add(fondo);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MetodosDePago().setVisible(true));
    }


}
