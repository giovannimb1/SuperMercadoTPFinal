package Codigo.Interfaz;

import Codigo.Interfaz.ClasesAux.Metodos;
import Codigo.Interfaz.ClasesAux.PanelConFondoRepetido;
import Codigo.Logica.Producto;
import Codigo.Logica.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CarritoInterfaz extends JFrame {


    //atributos
    private JPanel contenedorProductos;


    public CarritoInterfaz() {

        Metodos.ventanasConfiguracionnTipica(this, "Carrito");

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

        JButton finalizarCompra = new JButton("Finalizar Compra");
        finalizarCompra.setBounds(720, 67, 200, 40);
        finalizarCompra.setBackground(new Color(34, 164, 55));
        finalizarCompra.setForeground(Color.WHITE);
        finalizarCompra.setFocusPainted(false);

        panel.add(finalizarCompra);

        finalizarCompra.addActionListener( e -> {
            new MetodosDePago().setVisible(true);
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

        contenedorProductos = new JPanel();
        carritoAproductos();

        panel.add(volverAlMenu);

        panel.add(contenedorProductos);
        panel.add(bienvendo);
        panel.add(logochiquito);
        panel.add(decoracion1);


    }

    public void carritoAproductos() {

        contenedorProductos.removeAll();

        ArrayList<JPanel> productos = new ArrayList<>();

        ((Cliente) Sesion.getUsuarioActivo()).agregarProducto(30);

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


        JButton sacarDelCarrito = new JButton("Sacar");
        sacarDelCarrito.setForeground(Color.WHITE);
        sacarDelCarrito.setBackground(new Color(255, 35, 35));


        sacarDelCarrito.addActionListener(e -> {

            if (((Cliente) Sesion.getUsuarioActivo()).eliminarProducto(producto)) {

            } else {
                Metodos.excepcionPantallaEmergente("Error");
            }


        });
        caja.add(sacarDelCarrito);


        return caja;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CarritoInterfaz().setVisible(true));
    }
}
