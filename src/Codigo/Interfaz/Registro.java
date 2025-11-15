package Codigo.Interfaz;

import javax.swing.*;
import java.awt.*;

public class Registro extends JFrame {

    public Registro() {

        setIconImage(Toolkit.getDefaultToolkit().getImage(
                getClass().getResource("/img/logos/logo.png")));


        setTitle("Registro");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(255, 255, 255));
        add(panel);

        JLabel text1 = Metodos.textoDefault(125 ,100, "NOMBRE",Color.BLACK);
        JLabel text2 = Metodos.textoDefault(125 ,150, "APELLIDO",Color.BLACK);
        JLabel text3 = Metodos.textoDefault(125 ,200, "CONTRASEÑA",Color.BLACK);
        JLabel text4 = Metodos.textoDefault(125 ,250, "USUARIO",Color.BLACK);
        JLabel text5 = Metodos.textoDefault(125 ,300, "EMAIL",Color.BLACK);


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

        ImageIcon img = new ImageIcon(getClass().getResource("/img/MicroMenu/fondoM.png"));
        JLabel fondo = new JLabel(img);
        fondo.setBounds(0, 0, 600, 500);

        JButton boton = new JButton("Registrarse");
        boton.setBounds(190, 400, 200, 40);
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
        panel.add(fondo);

    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Registro().setVisible(true));
    }
}



