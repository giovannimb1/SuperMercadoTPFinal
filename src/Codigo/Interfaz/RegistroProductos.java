package Codigo.Interfaz;

import Codigo.Interfaz.ClasesAux.ImagenAdministrador;
import Codigo.Interfaz.ClasesAux.Metodos;
import Codigo.Interfaz.ClasesAux.ProductoVisual;
import Codigo.Logica.Administrador;
import Codigo.Logica.Categoria_Producto;
import Codigo.Logica.ProductoInvalidoException;

import javax.swing.*;
import javax.swing.JButton;
import java.awt.*;

public class RegistroProductos extends JFrame {

    private Categoria_Producto x;
    private boolean obligatorio = false;
    private String direccionDeImagen;

    public RegistroProductos() {

        Metodos.ventanasConfiguracionAlternativa(this, "Registro de Productos");

        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(255, 255, 255));
        add(panel);

        JLabel text1 = Metodos.textoDefault(125, 50, "NOMBRE", Color.WHITE);
        JLabel text2 = Metodos.textoDefault(125, 100, "MARCA", Color.WHITE);
        JLabel text3 = Metodos.textoDefault(125, 150, "PRECIO", Color.WHITE);
        JLabel text4 = Metodos.textoDefault(125, 200, "VENCIMIENTO", Color.WHITE);
        JLabel text5 = Metodos.textoDefault(125, 250, "STOCK", Color.WHITE);
        JLabel text6 = Metodos.textoDefault(125, 300, "CATEGORIA", Color.WHITE);

        JTextField inNombre = new JTextField();
        inNombre.setBounds(255, 50, 200, 25);

        JTextField inMarca = new JTextField();
        inMarca.setBounds(255, 100, 200, 25);

        JTextField inPrecio = new JTextField();
        inPrecio.setBounds(255, 150, 200, 25);

        JTextField inVencimiento = new JTextField();
        inVencimiento.setBounds(255, 200, 200, 25);

        JTextField inStock = new JTextField();
        inStock.setBounds(255, 250, 200, 25);


        JButton categoria1 = Metodos.botonesCategorias(255, 300, "1");
        JButton categoria2 = Metodos.botonesCategorias(285, 300, "2");
        JButton categoria3 = Metodos.botonesCategorias(315, 300, "3");
        JButton categoria4 = Metodos.botonesCategorias(345, 300, "4");
        JButton categoria5 = Metodos.botonesCategorias(375, 300, "5");
        JButton categoria6 = Metodos.botonesCategorias(405, 300, "6");
        JButton categoria7 = Metodos.botonesCategorias(435, 300, "7");


        categoria1.addActionListener(e -> {
            obligatorio = true;
            x = Categoria_Producto.CARNE;
        });
        categoria2.addActionListener(e -> {
            obligatorio = true;
            x = Categoria_Producto.LACTEO;
        });
        categoria3.addActionListener(e -> {
            obligatorio = true;
            x = Categoria_Producto.VEGETAL;
        });
        categoria4.addActionListener(e -> {
            obligatorio = true;
            x = Categoria_Producto.BEBIDA;
        });
        categoria5.addActionListener(e -> {
            obligatorio = true;
            x = Categoria_Producto.SNACK;
        });
        categoria6.addActionListener(e -> {
            obligatorio = true;
            x = Categoria_Producto.HIGIENE;
        });
        categoria7.addActionListener(e -> {
            obligatorio = true;
            x = Categoria_Producto.LIMPIEZA;
        });


        ImageIcon img = new ImageIcon(getClass().getResource("/img/MicroMenuProductos/fondo.png"));
        JLabel fondo = new JLabel(img);
        fondo.setBounds(0, 0, 600, 500);

        JButton cargarImagen = new JButton("Imagen");
        cargarImagen.setBounds(200, 340, 200, 40);
        cargarImagen.setBackground(new Color(80, 150, 255));
        cargarImagen.setForeground(Color.WHITE);
        cargarImagen.setFocusPainted(false);



        cargarImagen.addActionListener(e -> {
           direccionDeImagen =  ImagenAdministrador.direccionDeIMG();
          //  System.out.println("PRUEBA FINAL : " + direccionDeImagen);
        });



        JButton boton = new JButton("Registrar");
        boton.setBounds(320, 400, 200, 40);
        boton.setBackground(new Color(80, 150, 255));
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);

        boton.addActionListener(e -> {


            if (obligatorio){
                String nombre = inNombre.getText();                                 //<------------------------------
                String stock = inStock.getText();                                   //<------------------------------
                String vencimiento = inVencimiento.getText();                       //<------------------------------
                String precio = inPrecio.getText();                                 //<------------------------------
                String marca = inMarca.getText();
                String categoria = x.toString();
                String direccion = direccionDeImagen;
                System.out.println("DIRECCION DIFINITVA: "+direccion);



                Administrador admin = (Administrador) Sesion.getUsuarioActivo();

                try {


                    if (admin.crearProducto(nombre, stock, vencimiento, precio, marca, categoria,direccion)) {
                        JOptionPane.showMessageDialog(null, "Creado con exito!");

                        ProductoVisual.productosReutilizable(Menu.getInstancia().getContenedorProductos()); // actualiza la pagina menu :2


                    } else {
                        JOptionPane.showMessageDialog(null, "Error");
                    }

                } catch (ProductoInvalidoException ex) {
                    Metodos.excepcionPantallaEmergente(ex.getMessage());
                }
            }else {
                Metodos.excepcionPantallaEmergente("Elegi Una Categoria");
            }

        });



        JButton cerrar = new JButton("Cerrar");
        cerrar.setBounds(80, 400, 200, 40);
        cerrar.setBackground(new Color(255, 49, 49));
        cerrar.setForeground(Color.WHITE);
        cerrar.setFocusPainted(false);

        cerrar.addActionListener(e -> dispose());



        //categorias:
        panel.add(categoria1);
        panel.add(categoria2);
        panel.add(categoria3);
        panel.add(categoria4);
        panel.add(categoria5);
        panel.add(categoria6);
        panel.add(categoria7);
        panel.add(inNombre);
        panel.add(inMarca);
        panel.add(inVencimiento);
        panel.add(inPrecio);
        panel.add(inStock);
        panel.add(text1);
        panel.add(text2);
        panel.add(text3);
        panel.add(text4);
        panel.add(text5);
        panel.add(text6);
        panel.add(boton);
        panel.add(cerrar);
        panel.add(cargarImagen);
        panel.add(fondo);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegistroProductos().setVisible(true));
    }
}
