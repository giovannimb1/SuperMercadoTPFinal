package Interfaz;

import javax.swing.*;
import java.awt.*;

public class Intro extends JFrame {

    public Intro() {

        setTitle("SuperMercado");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(14, 21, 37));
        add(panel);


        JLabel usuarioT = Metodos.textoDefault(82, 400, "USUARIO");

        JTextField inUsuario = new JTextField();
        inUsuario.setBounds(82, 430, 200, 25);


        JLabel contranaT = Metodos.textoDefault(82, 470, "CONTRASEÑA");

        JPasswordField inContrasena = new JPasswordField();
        inContrasena.setBounds(82, 500, 200, 25);

        JButton registro = new JButton("Registrarse");
        registro.setBounds(82, 610, 200, 40);
        registro.setBackground(new Color(80, 150, 255));
        registro.setForeground(Color.WHITE);
        registro.setFocusPainted(false);

        registro.addActionListener(e -> {
            new Registro().setVisible(true);

        });

        JButton iniciarSecion = new JButton("Iniciar");
        iniciarSecion.setBounds(82, 550, 200, 40);
        iniciarSecion.setBackground(new Color(80, 150, 255));
        iniciarSecion.setForeground(Color.WHITE);
        iniciarSecion.setFocusPainted(false);

        iniciarSecion.addActionListener(e -> {

            boolean flag = true; // verificador

            if(flag){
                new Menu().setVisible(true);
                dispose();

            }

        });


        iniciarSecion.addActionListener(e -> {
            String usuario = inUsuario.getText();
            String contrasena = inContrasena.getText();

            // boolean validacion = validador(usuario, contrasena);
            boolean validacion = true; // momentaneo

            if (validacion == true) {
                // new Menu().setVisible(true);
                dispose();

            } else {
                //  JOptionPane p = new JOptionPane(null, "hola");
            }


        });

        panel.add(usuarioT);
        panel.add(contranaT);
        panel.add(inContrasena);
        panel.add(inUsuario);
        panel.add(registro);
        panel.add(iniciarSecion);
    }

    /*

        public static boolean validador(String us, String p) {
            for(Object usuario : usuarios){
                if (us.compareTo(usuario.getUser()) == 0 && p.compareTo(usuario.getPass()) == 0) {
                    return true;
                }
            }
            return false;


        }
    */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Intro().setVisible(true));
    }
}
