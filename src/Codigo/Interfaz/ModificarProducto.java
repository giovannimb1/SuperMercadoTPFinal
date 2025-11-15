package Codigo.Interfaz;


import Codigo.Logica.Categoria_Producto;
import Codigo.Logica.Producto;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.time.LocalDate;

public class ModificarProducto extends JFrame {

    private static Producto producto ;

    public static void setProducto(Producto producto) {
        ModificarProducto.producto = producto;
    }

    public ModificarProducto() {

        // borrar
        Producto p1 = new Producto(
                "Leche Entera",
                "La Serenisima",
                850.50,
                LocalDate.of(2025, 11, 15),
                25,
                Categoria_Producto.LACTEO
        );
        setProducto(p1);
//
        setIconImage(Toolkit.getDefaultToolkit().getImage(
                getClass().getResource("/img/logos/logo.png")));

        setTitle("Modificador De Productos");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

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
        inNombre.setText(producto.getNombre());
        inNombre.setBounds(275, 50, 200, 25);

        JTextField inMarca = new JTextField();
        inMarca.setText(producto.getMarca());
        inMarca.setBounds(275, 100, 200, 25);

        JTextField inPrecio = new JTextField();
        inPrecio.setText(""+producto.getPrecio());
        inPrecio.setBounds(275, 150, 200, 25);

        JTextField inVencimiento = new JTextField();
        inVencimiento.setText(""+producto.getVencimiento());
        inVencimiento.setBounds(275, 200, 200, 25);

        JTextField inStock = new JTextField();
        inStock.setText(""+producto.getStock());
        inStock.setBounds(275, 250, 200, 25);

        JTextField inCategoria = new JTextField();
        inCategoria.setText(""+producto.getCategoria());
        inCategoria.setBounds(275, 300, 200, 25);

        ImageIcon img = new ImageIcon(getClass().getResource("/img/MicroMenuProductos/fondo.png"));
        JLabel fondo = new JLabel(img);
        fondo.setBounds(0, 0, 600, 500);

        JButton boton = new JButton("Modificar");
        boton.setBounds(80, 400, 200, 40);
        boton.setBackground(new Color(80, 150, 255));
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);

        boton.addActionListener(e -> {

            String nombre = inNombre.getText();
            String categoria = inCategoria.getText();
            String stock = inStock.getText();
            String vencimiento = inVencimiento.getText();
            String precio = inPrecio.getText();
            String marca = inMarca.getText();

            boolean flag = true;

            if (flag) {
                JOptionPane.showMessageDialog(null, "Modificado con exito!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
        });

        JButton cancelar = new JButton("Cancelar");
        cancelar.setBounds(320, 400, 200, 40);
        cancelar.setBackground(new Color(80, 150, 255));
        cancelar.setForeground(Color.WHITE);
        cancelar.setFocusPainted(false);

        cancelar.addActionListener(e -> dispose());

        JButton cargarImagen = new JButton("Imagen");
        cargarImagen.setBounds(200, 340, 200, 40);
        cargarImagen.setBackground(new Color(80, 150, 255));
        cargarImagen.setForeground(Color.WHITE);
        cargarImagen.setFocusPainted(false);

        cargarImagen.addActionListener(e -> {
            ImagenAdministrador.subirImagen(100, 100);
        });

        panel.add(inNombre);
        panel.add(inMarca);
        panel.add(inCategoria);
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
        panel.add(cancelar);
        panel.add(cargarImagen);
        panel.add(fondo);
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ModificarProducto().setVisible(true));
    }
}
