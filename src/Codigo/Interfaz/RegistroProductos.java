package Codigo.Interfaz;

import javax.swing.*;
import java.awt.*;

public class RegistroProductos extends JFrame {

    public RegistroProductos() {

        setIconImage(Toolkit.getDefaultToolkit().getImage(
                getClass().getResource("/img/logos/logo.png")));


        setTitle("Registro De Productos :3");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(255, 255, 255));
        add(panel);


        JLabel text1 = Metodos.textoDefault(125, 50, "NOMBRE", Color.WHITE);
        JTextField inNombre = new JTextField();
        inNombre.setBounds(275, 50, 200, 25);

        JLabel text2 = Metodos.textoDefault(125, 100, "MARCA", Color.WHITE);
        JTextField inMarca = new JTextField();
        inMarca.setBounds(275, 100, 200, 25);

        JLabel text3 = Metodos.textoDefault(125, 150, "PRECIO", Color.WHITE);
        JTextField inPrecio = new JTextField();
        inPrecio.setBounds(275, 150, 200, 25);

        JLabel text4 = Metodos.textoDefault(125, 200, "VENCIMIENTO", Color.WHITE);
        JTextField inVencimiento = new JTextField();
        inVencimiento.setBounds(275, 200, 200, 25);


        JLabel text5 = Metodos.textoDefault(125, 250, "STOCK", Color.WHITE);
        JTextField inStock = new JTextField();
        inStock.setBounds(275, 250, 200, 25);


        JLabel text6 = Metodos.textoDefault(125, 300, "CATEGORIA", Color.WHITE);
        JTextField inCategoria = new JTextField();
        inCategoria.setBounds(275, 300, 200, 25);

        ImageIcon img = new ImageIcon(getClass().getResource("/img/MicroMenuProductos/fondo.png"));
        JLabel fondo = new JLabel(img);
        fondo.setBounds(0, 0, 600, 500);


        JButton boton = new JButton("Registrarse");
        boton.setBounds(190, 375, 200, 40);
        boton.setBackground(new Color(80, 150, 255));
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);

        boton.addActionListener(e -> {

            /*aca solo verifiquemos si recibe un usuario y un email autorizado a crearse una cuenta
             * y q no exista*/

            boolean flag = true; // aca el metodo q lo retorne

            if (flag) {
                JOptionPane.showMessageDialog(null, "Creado con exito!");
                dispose();

            } else {
                JOptionPane.showMessageDialog(null, "Error");

            }



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
        panel.add(fondo);

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegistroProductos().setVisible(true));
    }
}



