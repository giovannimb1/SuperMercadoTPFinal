package Interfaz;

import javax.swing.*;
import java.awt.*;

public class Registro extends JFrame {

    public Registro() {

        setTitle("Registro");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(14, 21, 37));
        add(panel);

        JLabel text1 = Metodos.textoDefault(125 ,100, "NOMBRE");
        JLabel text2 = Metodos.textoDefault(125 ,150, "APELLIDO");
        JLabel text3 = Metodos.textoDefault(125 ,200, "CONTRASEÑA");
        JLabel text4 = Metodos.textoDefault(125 ,250, "USUARIO");
        JLabel text5 = Metodos.textoDefault(125 ,300, "EMAIL");


        JTextField inNombre = new JTextField();
        inNombre.setBounds(275, 100, 200, 25);


        JTextField inApellido = new JTextField();
        inApellido.setBounds(275, 150, 200, 25);


        JTextField inEmail = new JTextField();
        inEmail.setBounds(275, 200, 200, 25);


        JTextField inUsername = new JTextField();
        inUsername.setBounds(275, 250, 200, 25);


        JTextField inPassword = new JTextField();
        inPassword.setBounds(275, 300, 200, 25);


        JButton boton = new JButton("Registrarse");
        boton.setBounds(190, 375, 200, 40);
        boton.setBackground(new Color(80, 150, 255));
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);

        boton.addActionListener(e -> {

            /*aca solo verifiquemos si recibe un usuario y un email autorizado a crearse una cuenta
             * y q no exista*/

            boolean flag = true; // aca el metodo q lo retorne

            if(flag){
                JOptionPane.showMessageDialog(null, "Creado con exito!");

            }
            else{
                JOptionPane.showMessageDialog(null, "Error");

            }
            dispose();



        });






        panel.add(inNombre);
        panel.add(inApellido);
        panel.add(inPassword);
        panel.add(inUsername);
        panel.add(inEmail);
        panel.add(text1);
        panel.add(text2);
        panel.add(text3);
        panel.add(text4);
        panel.add(text5);
        panel.add(boton);

    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Intro().setVisible(true));
    }
}



