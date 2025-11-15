package Codigo.Interfaz;

import javax.swing.*;
import java.awt.*;

public class Intro extends JFrame {

    public Intro() {

        setIconImage(Toolkit.getDefaultToolkit().getImage(
                getClass().getResource("/img/logos/logo.png")));

        setTitle("SuperMercado");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);




        JPanel panel = new JPanel(null);
        add(panel);

        ImageIcon img = new ImageIcon(getClass().getResource("/img/Intro/fondo.png"));
        JLabel fondo = new JLabel(img);
        fondo.setBounds(0, 0, 1280, 720);

        ImageIcon img2 = new ImageIcon(getClass().getResource("/img/Intro/panel412421.png"));
        JLabel inicio = new JLabel(img2);
        inicio.setBounds(0, 0, 1280, 720);

        JLabel usuarioT = Metodos.textoDefault(110, 350, "USUARIO", Color.BLACK);

        JTextField inUsuario = new JTextField();
        inUsuario.setBounds(110, 380, 200, 25);


        JLabel contranaT = Metodos.textoDefault(110, 420, "CONTRASEÑA", Color.BLACK);

        JPasswordField inContrasena = new JPasswordField();
        inContrasena.setBounds(110, 450, 200, 25);

        JButton registro = new JButton("Registrarse");
        registro.setBounds(110, 560, 200, 40);
        registro.setBackground(new Color(80, 150, 255));
        registro.setForeground(Color.WHITE);
        registro.setFocusPainted(false);

        registro.addActionListener(e -> {
            new Registro().setVisible(true);
        });

        JButton iniciarSecion = new JButton("Iniciar");
        iniciarSecion.setBounds(110, 500, 200, 40);
        iniciarSecion.setBackground(new Color(80, 150, 255));
        iniciarSecion.setForeground(Color.WHITE);
        iniciarSecion.setFocusPainted(false);


        // ACA VERIFICAR
        iniciarSecion.addActionListener(e -> {

            boolean flag = true; // verificador

            String nombre  = inUsuario.getText();
            String contrasenia =inContrasena.getText();


            if (flag) {
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
        panel.add(inicio);
        panel.add(fondo);


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
