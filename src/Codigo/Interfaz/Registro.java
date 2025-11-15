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

        JLabel text1 = Metodos.textoDefault(125, 80, "NOMBRE", Color.BLACK);
        JLabel text2 = Metodos.textoDefault(125, 130, "APELLIDO", Color.BLACK);
        JLabel text3 = Metodos.textoDefault(125, 180, "EMAIL", Color.BLACK);
        JLabel text4 = Metodos.textoDefault(125, 230, "USUARIO", Color.BLACK);
        JLabel text5 = Metodos.textoDefault(125, 280, "CONTRASEÑA", Color.BLACK);
        JLabel text6 = Metodos.textoDefault(125, 330, "REPETIR", Color.BLACK);


        JTextField inNombre = new JTextField();
        inNombre.setBounds(275, 80, 200, 25);

        JTextField inApellido = new JTextField();
        inApellido.setBounds(275, 130, 200, 25);

        JTextField inEmail = new JTextField();
        inEmail.setBounds(275, 180, 200, 25);

        JTextField inUsername = new JTextField();
        inUsername.setBounds(275, 230, 200, 25);

        JPasswordField inPassword = new JPasswordField();
        inPassword.setBounds(275, 280, 200, 25);

        JPasswordField inPasswordRepeticion = new JPasswordField();
        inPasswordRepeticion.setBounds(275, 330, 200, 25);

        ImageIcon img = new ImageIcon(getClass().getResource("/img/MicroMenu/fondoM.png"));
        JLabel fondo = new JLabel(img);
        fondo.setBounds(0, 0, 600, 500);

        JButton cancelarBoton = new JButton("Cancelar");
        cancelarBoton.setBounds(80, 400, 200, 40);
        cancelarBoton.setBackground(new Color(80, 150, 255));
        cancelarBoton.setForeground(Color.WHITE);
        cancelarBoton.setFocusPainted(false);

        cancelarBoton.addActionListener(e -> {
            dispose();
        });

        JButton boton = new JButton("Registrarse");
        boton.setBounds(320, 400, 200, 40);
        boton.setBackground(new Color(80, 150, 255));
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);

        boton.addActionListener(e -> {

                    String email = inEmail.getText();
                    String apellido = inApellido.getText();
                    String nombre = inNombre.getText();
                    String pass = inPassword.getText();
                    String pass2 = inPasswordRepeticion.getText();
                    String user = inUsername.getText();

                    //falta comprobacion para ver si existe el email y el usuario
                    if (pass.compareTo(pass2) == 0 && nombre != null && apellido != null) {
                        JOptionPane.showMessageDialog(null, "Creado con exito!");

                    } else {
                        JOptionPane.showMessageDialog(null, "Error");

                    }


                });


            //aca hace el creador de usuario



            //


            dispose();





        panel.add(inNombre);
        panel.add(inApellido);
        panel.add(inPassword);
        panel.add(inUsername);
        panel.add(inEmail);
        panel.add(inPasswordRepeticion);
        panel.add(text1);
        panel.add(text2);
        panel.add(text3);
        panel.add(text4);
        panel.add(text5);
        panel.add(text6);
        panel.add(boton);
        panel.add(cancelarBoton);
        panel.add(fondo);

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Registro().setVisible(true));
    }
}



